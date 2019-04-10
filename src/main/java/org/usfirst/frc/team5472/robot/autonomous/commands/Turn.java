package org.usfirst.frc.team5472.robot.autonomous.commands;

import org.usfirst.frc.team5472.robot.Robot;
import org.usfirst.frc.team5472.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;

public class Turn extends Command{
	
	private PIDController turnController;
	private boolean wasHigh;
	private double setpoint;
	
	private DriveSubsystem drive;
	
	public Turn(double target) {
		setpoint = target;
		drive = Robot.drive;
		turnController = drive.turnAngleController;
	}
	
	@Override
	public void initialize() {
		wasHigh = drive.isHighGear();
		drive.lowGear();
		turnController.reset();
		turnController.setSetpoint(setpoint);
		turnController.enable();
	}

	@Override
	public void execute() {
		
	}
	
	@Override
	public boolean isFinished() {
		return turnController.onTarget();
	}
	
	@Override
	public void end() {
		if(wasHigh)
			drive.highGear();
		turnController.reset();
	}
}
