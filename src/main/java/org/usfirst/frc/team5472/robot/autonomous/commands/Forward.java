package org.usfirst.frc.team5472.robot.autonomous.commands;

import org.usfirst.frc.team5472.robot.Constants;
import org.usfirst.frc.team5472.robot.Robot;
import org.usfirst.frc.team5472.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class Forward extends Command{
	
	private double distance;
	private double angle;
	private boolean givenAngle;
	
	private DriveSubsystem drive;
	private PIDController controller;
	
	public Forward(double distance) {
		this.givenAngle = false;
		this.distance = distance;
		requires(Robot.drive);
	}
	
	public Forward(double distance, double angle) {
		this.givenAngle = true;
		this.distance = distance;
		this.angle = angle;
		requires(Robot.drive);
	}
	
	@Override
	public void initialize() {
		drive = Robot.drive;
		controller = drive.drivePositionController;
		
		drive.resetEncoders();
		controller.reset();
		controller.setSetpoint(distance);
		controller.setAbsoluteTolerance(0.02);
		controller.setInputRange(-10, 10);
		controller.setOutputRange(-Constants.DRIVE_AUTO_OUTPUT_LIMIT, Constants.DRIVE_AUTO_OUTPUT_LIMIT);
		controller.enable();
		
		if(!givenAngle)
			angle = drive.getHeading();
	}
	
	@Override
	public void execute() {
		double error = angle - drive.getHeading();
		double output = (drive.getLeftPercent() + drive.getRightPercent()) / 2.0;
		drive.drive(output - 0.1 * error, output + 0.1 * error);
	}
	
	@Override
	public void end() {
		controller.disable();
		drive.drive(-0.1, -0.1);
		Timer.delay(0.05);
		drive.drive(0.0, 0.0);
	}
	
	@Override
	public boolean isFinished() {
		return controller.onTarget();
	}

}
