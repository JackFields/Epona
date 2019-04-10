/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5472.robot;

import java.util.HashMap;

import org.usfirst.frc.team5472.robot.autonomous.Autonomous;
import org.usfirst.frc.team5472.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team5472.robot.subsystems.IntakeSubsystem;
import org.usfirst.frc.team5472.robot.subsystems.LedSubsystem;
import org.usfirst.frc.team5472.robot.subsystems.LiftSubsystem;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot implements DataProvider{

	private Autonomous auto;

	public static Controls controls;
	public static DriveSubsystem drive;
	public static IntakeSubsystem intake;
	public static LiftSubsystem lift;
	public static LedSubsystem led;
	public static Limelight limelight;
	public static Cameras cameras;
	private static DataLogger logger;
	
	private AnalogInput pressureSensor;
	
	@Override
	public void robotInit() {
		drive = new DriveSubsystem();
		intake = new IntakeSubsystem();
		lift = new LiftSubsystem();
		led = new LedSubsystem();
		limelight = new Limelight();
		cameras = new Cameras();
		auto = new Autonomous();
		controls = new Controls();
		logger = new DataLogger();
		
		pressureSensor = new AnalogInput(0);
		
	}

	@Override
	public void disabledInit() {
		auto.end();
		drive.resetEncoders();
		drive.resetHeading();
		drive.drive(0.0, 0.0);
		lift.resetEncoder();
		lift.disableClosedLoop();
		intake.stop();
		logger.end();
		
		limelight.setLed(false);
	}

	@Override
	public void disabledPeriodic() {
		if (auto != null)
			auto.checkGameSpecificData();
		
		SmartDashboard.putNumber("Pressure", getPressure());
		SmartDashboard.putBoolean("Upper Lift Limit", controls.highLimit.get());
		SmartDashboard.putBoolean("Lower Lift Limit", controls.lowLimit.get());
		
		limelight.setLed(false);
	}

	@Override
	public void autonomousInit() {
		drive.resetEncoders();
		drive.resetHeading();
		drive.drive(0.0, 0.0);
		lift.resetEncoder();
		lift.autoPeakOutput();
		lift.enableClosedLoop();
		logger.start();
		auto.start();
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		logger.appendData(drive);
		logger.appendData(lift);
		logger.appendData(intake);
		logger.appendData(limelight);
		logger.appendData(led);
		logger.appendData(this);
		logger.writeFrame();
		
		SmartDashboard.putNumber("Lift Closed-Loop Error", lift.getError());
		
		SmartDashboard.putNumber("Pressure", getPressure());
		SmartDashboard.putBoolean("Upper Lift Limit", controls.highLimit.get());
		SmartDashboard.putBoolean("Lower Lift Limit", controls.lowLimit.get());
		
		SmartDashboard.putNumber("Left Encoder", drive.getLeftPosition());
		SmartDashboard.putNumber("Right Encoder", drive.getRightPosition());
	}

	@Override
	public void teleopInit() {
		auto.end();
		limelight.setLed(false);
		drive.resetEncoders();
		drive.resetHeading();
		drive.drive(0.0, 0.0);
		lift.disableClosedLoop();
		lift.teleopPeakOutput();
		drive.highGear();
		logger.start();
		
	}
	
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		logger.appendData(drive);
		logger.appendData(lift);
		logger.appendData(intake);
		logger.appendData(limelight);
		logger.appendData(led);
		logger.appendData(this);
		logger.writeFrame();
		
		SmartDashboard.putNumber("Pressure", getPressure());
		SmartDashboard.putBoolean("Upper Lift Limit", controls.highLimit.get());
		SmartDashboard.putBoolean("Lower Lift Limit", controls.lowLimit.get());
		SmartDashboard.putNumber("Heading", Robot.drive.getHeading());
	}
	
	@Override
	public void testInit() {
	}
	
	@Override
	public void testPeriodic() {
		Scheduler.getInstance().run();
	}
	
	public double getPressure() {
		return (250 * (pressureSensor.getVoltage() / 4.95));
	}
	
	public HashMap<String, double[]> getData(){
		HashMap<String, double[]> toReturn = new HashMap<>();
		toReturn.put("Battery Voltage", new double[] {
				RobotController.getBatteryVoltage()
		});
		toReturn.put("CAN Bus Utilization", new double[] {
				RobotController.getCANStatus().percentBusUtilization
		});
		toReturn.put("Brown Out", new double[] {
				RobotController.isBrownedOut() ? 1.0 : 0.0
		});
		toReturn.put("Pressure", new double[] {
				getPressure()
		});
		toReturn.put("Low Limit Switch", new double[] {
				controls.lowLimit.get() ? 1.0 : 0.0
		});
		toReturn.put("Low Limit Switch", new double[] {
				controls.highLimit.get() ? 1.0 : 0.0
		});
		return toReturn;
	}
}