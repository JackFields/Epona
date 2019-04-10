package org.usfirst.frc.team5472.robot.commands;

import org.usfirst.frc.team5472.robot.Constants;
import org.usfirst.frc.team5472.robot.Controls;
import org.usfirst.frc.team5472.robot.LimitSwitch;
import org.usfirst.frc.team5472.robot.Robot;
import org.usfirst.frc.team5472.robot.subsystems.LiftSubsystem;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

public class LiftDefault extends Command {

	private LiftSubsystem lift;
	private Controls controls = Robot.controls;
	private LimitSwitch liftBottom;
	
	public LiftDefault() {
		requires(Robot.lift);
	}

	@Override
	public void initialize() {
		lift = Robot.lift;
		lift.enableBrake();
		liftBottom = Robot.controls.lowLimit;
	}

	@Override
	public void execute() {
		if(DriverStation.getInstance().isAutonomous())
			return;
		
		
		double up = controls.getLiftUpAxis();
		double down = controls.getLiftDownAxis() * Constants.LIFT_REVERSE_OUTPUT_LIMIT;
		double absdown = Math.abs(down);
		
//		if (lift.getPosition() < 3000 && absdown > 0.05) {
//			//The lift is near the bottom and the operator wishes to lower it
//			lift.enableBrake();
////			lift.setPercent(0);
//		}
		if(absdown > 0.1)
			//The lift is not near the bottom and the operator wishes to lower it
			lift.enableCoast();
		else
			lift.enableBrake();
//		
		if(liftBottom.get() && (up + down) < 0.00)
			//The lift is at the bottom and the operator does not wish to raise it
			lift.setPercent(0);
		else
			//Normal operation procedure
			lift.setPercent(up + down);
	}
	

	@Override
	protected boolean isFinished() {
		return false;
	}
}