package org.usfirst.frc.team5472.robot.commands;

import org.usfirst.frc.team5472.robot.Robot;
import org.usfirst.frc.team5472.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class HighGear extends Command {
	
	private boolean finished = false;
	private DriveSubsystem drive;
	
	@Override
	public void initialize() {
		drive = Robot.drive;
	}
	
	@Override
	public void execute() {
		drive.highGear();
		finished = true;
	}
	
	@Override
	protected boolean isFinished() {
		return finished;
	}
	
}
