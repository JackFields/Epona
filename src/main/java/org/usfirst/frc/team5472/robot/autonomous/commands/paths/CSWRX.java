package org.usfirst.frc.team5472.robot.autonomous.commands.paths;

import org.usfirst.frc.team5472.robot.autonomous.commands.Delay;
import org.usfirst.frc.team5472.robot.autonomous.commands.Forward;
import org.usfirst.frc.team5472.robot.autonomous.commands.LiftZero;
import org.usfirst.frc.team5472.robot.autonomous.commands.RaiseLiftLow;
import org.usfirst.frc.team5472.robot.autonomous.commands.Turn;
import org.usfirst.frc.team5472.robot.commands.GripClose;
import org.usfirst.frc.team5472.robot.commands.GripOpen;
import org.usfirst.frc.team5472.robot.commands.IntakePull;
import org.usfirst.frc.team5472.robot.commands.IntakePullAuto;
import org.usfirst.frc.team5472.robot.commands.IntakePushAuto;
import org.usfirst.frc.team5472.robot.commands.IntakeStop;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CSWRX extends CommandGroup{
	
	public CSWRX() {
		addParallel(new GripClose());
		addSequential(new Forward(0.66), 0.5);
		addSequential(new Turn(-45), 0.8);
		addParallel(new RaiseLiftLow());
		addSequential(new Forward(1.45), 1.0);
		addSequential(new Turn(0), 1);
		addSequential(new Forward(0.8), 1);
		addSequential(new IntakePushAuto());
		addSequential(new Delay(0.5));
		addSequential(new IntakeStop());
		
		addSequential(new Forward(-0.5), 0.6);
		addSequential(new Turn(-45), 0.8);
		addParallel(new LiftZero(), 1);
		addSequential(new Forward(-1.75), 2);
		addSequential(new Turn(0), 1);
		
		
		addParallel(new GripOpen());
		addParallel(new IntakePull());
		addSequential(new Forward(1.2), 1.0);
		addSequential(new GripClose());
		addSequential(new IntakePullAuto());
		addSequential(new Forward(-1.2), 1.0);
		addSequential(new IntakeStop());
		
		addParallel(new RaiseLiftLow(), 2);
		addSequential(new Turn(-45), 1);
		addSequential(new Forward(1.65), 1.0);
		addSequential(new Turn(0), 1);
		addSequential(new Forward(0.8), 0.8);
		addSequential(new IntakePushAuto());
		addSequential(new Delay(0.5));
		addSequential(new IntakeStop());
		addSequential(new Forward(-1.2), 0.6);
		
		
		
		
		
		
//		addParallel(new GripClose());
//		addSequential(new Forward(0.66), 1);
//		addSequential(new Turn(-45), 1);
//		addParallel(new RaiseLiftLow());
//		addSequential(new Forward(1.45), 1.5);
//		addSequential(new Turn(0), 1);
//		addSequential(new Forward(1.0), 1);
//		addSequential(new IntakePushAuto());
//		addSequential(new Delay(1.0));
//		addSequential(new IntakeStop());
//		
//		addSequential(new Forward(-1.0), 1.0);
//		addSequential(new Turn(-50), 1);
//		addParallel(new LiftZero(), 1);
//		addSequential(new Forward(-1.45), 2);
//		addSequential(new Turn(0), 1);
//		
//		
//		addParallel(new GripOpen());
//		addParallel(new IntakePull());
//		addSequential(new Forward(1.2), 1.5);
//		addSequential(new GripClose());
//		addSequential(new IntakePullAuto());
//		addSequential(new Forward(-1.2), 1.5);
//		addSequential(new IntakeStop());
//		
//		addParallel(new RaiseLiftLow(), 2);
//		addSequential(new Turn(-45), 2);
//		addSequential(new Forward(1.45), 1.5);
//		addSequential(new Turn(0), 2);
//		addSequential(new Forward(0.8), 1);
//		addSequential(new IntakePushAuto());
//		addSequential(new Delay(1.0));
//		addSequential(new IntakeStop());
//		addSequential(new Forward(-0.8));
		
		
		
		
		
		
		
		
//		addParallel(new GripClose());
//		addSequential(new Forward(1.50 - Constants.ROBOT_LENGTH), 1);
//		addSequential(new Turn(-45), 1);
//		addParallel(new RaiseLiftLow());
//		addSequential(new Forward(1.45), 1.5); // From 1.65
//		addSequential(new Turn(-10), 1);
//		addSequential(new Forward(0.7), 1); // From 0.5
//		addSequential(new IntakePushAuto());
//		addSequential(new Delay(1.0));
//		addSequential(new IntakeStop());
//		addSequential(new Forward(-1.3), 1.5);
//		
//		addSequential(new Turn(35), 2);
//		addSequential(new LiftZero(), 2);
//		addParallel(new GripOpen());
//		addParallel(new IntakePull());
//		addSequential(new EnableVision());
//		addSequential(new BoxPipeline());
//		addSequential(new ApproachBox(), 1.5);
//		addSequential(new GripClose());
//		addSequential(new IntakePullAuto());
//		addSequential(new Forward(-0.8), 1);
//		addSequential(new IntakeStop());
//
//		addParallel(new RaiseLiftLow(), 3);
//		addSequential(new Turn(0), 1);
//		addSequential(new Forward(0.8), 1);
//		addSequential(new IntakePushAuto());
//		addSequential(new Delay(1));
//		addSequential(new IntakeStop());
//		addSequential(new Forward(-0.8), 1);
	}
	
}
