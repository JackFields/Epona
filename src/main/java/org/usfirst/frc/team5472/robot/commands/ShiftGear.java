package org.usfirst.frc.team5472.robot.commands;

import org.usfirst.frc.team5472.robot.Robot;
import org.usfirst.frc.team5472.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class ShiftGear extends Command {

	private boolean finished = false;
	private DriveSubsystem drive;

	@Override
	public void initialize() {
		this.drive = Robot.drive;
	}

	@Override
	public void execute() {
		drive.shiftGear();
		finished = true;
	}

	@Override
	protected boolean isFinished() {
		return finished;
	}

}
