package org.usfirst.frc.team5472.robot.autonomous.commands;

import org.usfirst.frc.team5472.robot.Limelight;
import org.usfirst.frc.team5472.robot.Robot;
import org.usfirst.frc.team5472.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class LookForBox extends Command{
	
	private static final double TURN_SPEED = 0.40;
	private static final double TARGET_LIFETIME = 0.4;
	
	private boolean finished = false;
	private double maxAngle = 60;
	private boolean turningLeft = true;
	private DriveSubsystem drive;
	private Limelight limelight;
	private double targetAppeared;
	
	public LookForBox() {
		requires(Robot.drive);
	}
	
	@Override
	public void initialize() {
		drive = Robot.drive;
		limelight = Robot.limelight;
		drive.resetHeading();
	}
	
	@Override
	public void execute() {
		if(limelight.targetExists()) {
			if(targetAppeared == 0.0) {
				targetAppeared = Timer.getFPGATimestamp();
			} else if(Timer.getFPGATimestamp() - targetAppeared > TARGET_LIFETIME) {
				finished = true;
				return;
			}
		} else {
			targetAppeared = 0.0;
			if(turningLeft) {
				drive.drive(-TURN_SPEED, TURN_SPEED);
				if(drive.getHeading() < -maxAngle)
					turningLeft = false;
			} else {
				drive.drive(TURN_SPEED,  -TURN_SPEED);
				if(drive.getHeading() > maxAngle)
					turningLeft = true;
			}
		}
	}
	
	@Override
	protected boolean isFinished() {
		return finished;
	}
	
}
