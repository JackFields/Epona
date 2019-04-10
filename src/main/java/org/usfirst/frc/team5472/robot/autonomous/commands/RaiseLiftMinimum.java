package org.usfirst.frc.team5472.robot.autonomous.commands;

import org.usfirst.frc.team5472.robot.Robot;
import org.usfirst.frc.team5472.robot.subsystems.LiftSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class RaiseLiftMinimum extends Command{
	
	private LiftSubsystem lift;

	@Override
	public void initialize() {
		lift = Robot.lift;
		lift.setSetpoint(4000);
	}
	
	@Override
	public void execute() {
	}
	
	
	@Override
	protected boolean isFinished() {
		return lift.getPosition() > 3000;
	}
	
}
