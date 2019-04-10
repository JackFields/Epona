package org.usfirst.frc.team5472.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;

public class TriggerButton extends Button{
	
	private static double DEFAULT_THRESHOLD = 0.8;
	
	private Joystick stick;
	private int axis;
	private double threshold;
	
	
	public TriggerButton(Joystick stick, int axis) {
		this(stick, axis, DEFAULT_THRESHOLD);
	}
	
	public TriggerButton(Joystick stick, int axis, double threshold) {
		this.stick = stick;
		this.axis = axis;
		this.threshold = threshold;
	}
	
	
	public boolean get() {
		return Math.abs(stick.getRawAxis(this.axis)) > threshold;
	}
	
}
