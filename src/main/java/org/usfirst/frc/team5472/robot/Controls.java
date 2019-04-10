package org.usfirst.frc.team5472.robot;

import org.usfirst.frc.team5472.robot.commands.GripToggle;
import org.usfirst.frc.team5472.robot.commands.HighGear;
import org.usfirst.frc.team5472.robot.commands.IntakePull;
import org.usfirst.frc.team5472.robot.commands.IntakePullSlow;
import org.usfirst.frc.team5472.robot.commands.IntakePush;
import org.usfirst.frc.team5472.robot.commands.IntakePushSlow;
import org.usfirst.frc.team5472.robot.commands.IntakeStop;
import org.usfirst.frc.team5472.robot.commands.LiftStop;
import org.usfirst.frc.team5472.robot.commands.LiftZeroEncoder;
import org.usfirst.frc.team5472.robot.commands.ReportIntakeLimit;
import org.usfirst.frc.team5472.robot.commands.ShiftGear;
import org.usfirst.frc.team5472.robot.commands.TakeSnapshot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class Controls {

	private Joystick playerOne = new Joystick(0);
	private Joystick playerTwo = new Joystick(1);

	private JoystickButton shiftGear = new JoystickButton(playerOne, 3); // X Button

	private JoystickButton intakeLowSpeedIn = new JoystickButton(playerOne, 5); // Left Shoulder
	private JoystickButton intakeLowSpeedOut = new JoystickButton(playerOne, 6); // Right Shoulder
	private TriggerButton intakeHighSpeedIn = new TriggerButton(playerOne, 2); // Left Bottom
	private TriggerButton intakeHighSpeedOut = new TriggerButton(playerOne, 3); // Right Bottom
	
	private JoystickButton toggleGrip = new JoystickButton(playerOne, 1); // A Button
	
	private JoystickButton highButton = new JoystickButton(playerOne, 4); // Y Button
	
	//temporary
	private JoystickButton takeSnapshot = new JoystickButton(playerTwo, 4); // Y Button
	//temporary
	
	
	public LimitSwitch highLimit = new LimitSwitch(Constants.LIMIT_SWITCH_HIGH, true);
	public LimitSwitch lowLimit = new LimitSwitch(Constants.LIMIT_SWITCH_LOW, false);
	public LimitSwitch intakeLimit = new LimitSwitch(Constants.LIMIT_SWITCH_INTAKE, true);
	
	public Controls() {
		shiftGear.whenPressed(new ShiftGear());
		shiftGear.whenReleased(new ShiftGear());
		highButton.whenPressed(new HighGear());
		
		intakeHighSpeedIn.whenPressed(new IntakePull());
		intakeHighSpeedIn.whenReleased(new IntakeStop());
		intakeHighSpeedOut.whenPressed(new IntakePush());
		intakeHighSpeedOut.whenReleased(new IntakeStop());
		
		intakeLowSpeedIn.whenPressed(new IntakePullSlow());
		intakeLowSpeedIn.whenReleased(new IntakeStop());
		intakeLowSpeedOut.whenPressed(new IntakePushSlow());
		intakeLowSpeedOut.whenReleased(new IntakeStop());

		toggleGrip.whenPressed(new GripToggle());
		
		takeSnapshot.whenPressed(new TakeSnapshot());
		
		highLimit.whileActive(new LiftStop());
		lowLimit.whileActive(new LiftZeroEncoder());
		intakeLimit.whenPressed(new ReportIntakeLimit());
		intakeLimit.whenReleased(new ReportIntakeLimit());
	}

	public Joystick getPlayerOne() {
		return playerOne;
	}
	
	public Joystick getPlayerTwo() {
		return playerTwo;
	}
	
	public double getLiftUpAxis() {
		return playerTwo.getRawAxis(3);
	}
	
	public double getLiftDownAxis() {
		return playerTwo.getRawAxis(2);
	}
	
	public double getDriveVerticalAxis() {
		return playerOne.getRawAxis(1);
	}
	
	public double getDriveHorizontalAxis() {
		return playerOne.getRawAxis(0);
	}
}
