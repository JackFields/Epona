package org.usfirst.frc.team5472.robot.commands;

import org.usfirst.frc.team5472.robot.Limelight;
import org.usfirst.frc.team5472.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ToggleLights extends Command {
	
	private boolean finished = false;
	private Limelight instance;
	
	public ToggleLights() {
	}
	
	@Override
	public void initialize() {
		instance = Robot.limelight;
	}
	
	@Override
	public void execute() {
		System.out.println("Attempting Command");
		instance.setLed(!instance.getLed());
		finished = true;
	}

	@Override
	protected boolean isFinished() {
		return finished;
	}

}
