package org.usfirst.frc.team5472.robot;

public class Constants {
	
	public static final double WHEEL_DIAMETER = 0.1016;
	public static final double ROBOT_WIDTH = 0.7112;
	public static final double ROBOT_LENGTH = 0.8382;
	public static final double V_CONSTANT = 1.20;
	public static final double ROBOT_WHEELBASE_WIDTH = 0.6731;
	
	public static final double LEFT_ENCODER_TICKS_PER_METER = 12833;
	public static final double RIGHT_ENCODER_TICKS_PER_METER = 12833;
	public static final int TICKS_PER_REV = 4096;
	public static final double LEFT_ENCODER_TICKS_PER_REV = LEFT_ENCODER_TICKS_PER_METER * 2 * Math.PI * WHEEL_DIAMETER;
	public static final double RIGHT_ENCODER_TICKS_PER_REV = RIGHT_ENCODER_TICKS_PER_METER * 2 * Math.PI * WHEEL_DIAMETER;
	
	public static final double DRIVE_FOLLOWER_P = 1.2;
	public static final double DRIVE_FOLLOWER_I = 0.0;
	public static final double DRIVE_FOLLOWER_D = 6.0;
	public static final double DRIVE_FOLLOWER_F = 0.5;

	public static final int DRIVE_LEFT_TALON_CAN = 4;
	public static final int DRIVE_LEFT_FOLLOWER_CAN = 3;
	public static final int DRIVE_RIGHT_TALON_CAN = 7;
	public static final int DRIVE_RIGHT_FOLLOWER_CAN = 8;
	public static final int DRIVE_SHIFT_SOLENOID = 0;
	
	public static final double DRIVE_AUTO_OUTPUT_LIMIT = 1.0;
	public static final double DRIVE_AUTO_TURN_P = 2.0 / 45.0;
	public static final double DRIVE_AUTO_TURN_I = 0.0000;
	public static final double DRIVE_AUTO_TURN_D = 6.0 / 45.0;
	public static final double LIMELIGHT_APPROACH_BOX_KP = 0.015;
 
	public static final int INTAKE_LEFT_MOTOR_CAN = 6;
	public static final int INTAKE_RIGHT_MOTOR_CAN = 7;
	public static final int INTAKE_SOLENOID_ID_FORW = 1;
	public static final int INTAKE_SOLENOID_ID_BACK = 2;
	public static final double INTAKE_INPUT_SPEED = 1.00;
	public static final double INTAKE_INPUT_SLOW_SPEED = 0.40;
	public static final double INTAKE_OUTPUT_SPEED = 1.00;
	public static final double INTAKE_OUTPUT_SLOW_SPEED = 0.40;

	
	public static final int LIFT_TALON_CAN_LEFT = 5;
	public static final int LIFT_TALON_CAN_RIGHT = 6;
	public static final double LIFT_REVERSE_OUTPUT_LIMIT = -0.5;
	
	public static final double LIFT_PIDF_P = 0.00040;
	public static final double LIFT_PIDF_I = 0.00000;
	public static final double LIFT_PIDF_D = 0.00000;
	public static final double LIFT_PIDF_F = 0.00000;
	public static final int LIFT_PIDF_INTZONE = 40;
	
	public static final int LIMIT_SWITCH_HIGH = 3;
	public static final int LIMIT_SWITCH_LOW = 4;
	public static final int LIMIT_SWITCH_INTAKE = 5;
	
	public static final int LED_RED_DIO = 0;
	public static final int LED_GREEN_DIO = 1;
	public static final int LED_BLUE_DIO = 2;
	
}
