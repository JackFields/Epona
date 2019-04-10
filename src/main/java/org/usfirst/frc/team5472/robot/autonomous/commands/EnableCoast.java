package org.usfirst.frc.team5472.robot.autonomous.commands;

import org.usfirst.frc.team5472.robot.Robot;
import org.usfirst.frc.team5472.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class EnableCoast extends Command{
	
	private boolean finished;
	private DriveSubsystem drive;
	
	public EnableCoast() {
		drive = Robot.drive;
	}
	
	@Override
	public void execute() {
		drive.setCoast();
		finished = true;
	}
	
	
	@Override
	protected boolean isFinished() {
		return finished;
	}
}
