package org.usfirst.frc.team5472.robot.autonomous.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class Delay extends Command{
	
	private boolean finished;
	private double time;
	
	public Delay(double time) {
		this.time = time;
	}
	
	@Override
	public void execute() {
		Timer.delay(time);
		finished = true;
	}
	
	@Override
	protected boolean isFinished() {
		return finished;
	}
	
}
