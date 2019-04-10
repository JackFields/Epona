package org.usfirst.frc.team5472.robot.commands;

import org.usfirst.frc.team5472.robot.Robot;
import org.usfirst.frc.team5472.robot.subsystems.LiftSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class LiftBrake extends Command{
	
	private boolean finished;
	private LiftSubsystem lift;
	
	public LiftBrake() {
		lift = Robot.lift;
	}
	
	@Override
	public void execute() {
		lift.enableBrake();
		finished = true;
	}
	
	@Override
	protected boolean isFinished() {
		return finished;
	}

}
