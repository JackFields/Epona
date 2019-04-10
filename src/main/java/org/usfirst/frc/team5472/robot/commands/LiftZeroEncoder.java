package org.usfirst.frc.team5472.robot.commands;

import org.usfirst.frc.team5472.robot.Robot;
import org.usfirst.frc.team5472.robot.subsystems.LiftSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class LiftZeroEncoder extends Command{
	
	private LiftSubsystem lift;
	private boolean finished;
	
	@Override
	public void initialize() {
		lift = Robot.lift;
	}
	
	@Override
	public void execute() {
//		lift.zeroEncoder();
		finished = true;
	}
		
	
	@Override
	protected boolean isFinished() {
		return finished;
	}
}
