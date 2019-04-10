package org.usfirst.frc.team5472.robot.commands;

import org.usfirst.frc.team5472.robot.Controls;
import org.usfirst.frc.team5472.robot.Robot;
import org.usfirst.frc.team5472.robot.subsystems.LiftSubsystem;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

public class LiftStop extends Command{
	
	private LiftSubsystem lift;
	private Controls controls;
	private boolean finished;
	
	@Override
	public void initialize() {
		lift = Robot.lift;
		controls = Robot.controls;
	}
	
	@Override
	public void execute() {
		if(DriverStation.getInstance().isAutonomous()) {
			finished = true;
			return;
		}
		if (controls.getLiftUpAxis() > 0.05)
			lift.hold();
		finished = true;
	}
	
	@Override
	protected boolean isFinished() {
		return finished;
	}
}
