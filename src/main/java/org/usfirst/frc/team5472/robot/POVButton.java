package org.usfirst.frc.team5472.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;

public class POVButton extends Button{
	
	public static enum POVAngle{
		TOP(0), TOPLEFT(315), LEFT(270), BOTTOMLEFT(215), BOTTOM(180), BOTTOMRIGHT(135), RIGHT(90), TOPRIGHT(45);
		
		private int angle;
		
		private POVAngle(int a) {
			angle = a;
		}
		
		public double getAngle() {
			return angle;
		}
	}
	
	private Joystick stick;
	private POVAngle angle;
	
	public POVButton(Joystick stick, POVAngle angle) {
		this.stick = stick;
		this.angle = angle;
	}
	
	@Override
	public boolean get() {
		return stick.getPOV() == angle.getAngle();
	}
}
