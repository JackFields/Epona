package org.usfirst.frc.team5472.robot.commands;

import org.usfirst.frc.team5472.robot.Controls;
import org.usfirst.frc.team5472.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ReportIntakeLimit extends Command{
	
	private Controls controls;
	private boolean finished;
	
	public ReportIntakeLimit() {
		controls = Robot.controls;
		finished = false;
	}
	
	@Override
	protected void execute() {
//		SmartDashboard.putBoolean("Intake Limit Switch", controls.intakeLimit.get());
		finished = true;
	}
	
	@Override
	protected boolean isFinished() {
		return finished;
	}
}
