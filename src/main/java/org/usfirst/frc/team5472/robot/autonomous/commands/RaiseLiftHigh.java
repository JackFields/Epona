package org.usfirst.frc.team5472.robot.autonomous.commands;

import org.usfirst.frc.team5472.robot.Robot;
import org.usfirst.frc.team5472.robot.subsystems.LiftSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class RaiseLiftHigh extends Command{
	
	private LiftSubsystem lift;
	
	
	@Override
	public void initialize() {
		lift = Robot.lift;
		lift.enableClosedLoop();
		lift.setSetpoint(31000);
	}
	
	@Override
	public void execute() {
	}
	
	@Override
	protected boolean isFinished() {
		return lift.getPosition() > 31000;
	}
}
