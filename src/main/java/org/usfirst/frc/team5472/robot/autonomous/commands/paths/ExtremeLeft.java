package org.usfirst.frc.team5472.robot.autonomous.commands.paths;

import org.usfirst.frc.team5472.robot.autonomous.commands.Delay;
import org.usfirst.frc.team5472.robot.autonomous.commands.Forward;
import org.usfirst.frc.team5472.robot.autonomous.commands.LiftZero;
import org.usfirst.frc.team5472.robot.autonomous.commands.RaiseLiftHigh;
import org.usfirst.frc.team5472.robot.autonomous.commands.RaiseLiftMinimum;
import org.usfirst.frc.team5472.robot.autonomous.commands.Turn;
import org.usfirst.frc.team5472.robot.commands.GripClose;
import org.usfirst.frc.team5472.robot.commands.HighGear;
import org.usfirst.frc.team5472.robot.commands.IntakePushSlow;
import org.usfirst.frc.team5472.robot.commands.IntakeStop;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ExtremeLeft extends CommandGroup{
	
	public ExtremeLeft() {
		addParallel(new HighGear());
		addParallel(new GripClose());
		
		addParallel(new RaiseLiftMinimum());
		addSequential(new Forward(7.00));
		addSequential(new Turn(-90), 1.0);
		addSequential(new Forward(-0.8), 1);
		addSequential(new RaiseLiftHigh());
//		addSequential()
		addSequential(new Forward(0.8), 1.0);
		addSequential(new IntakePushSlow());
		addSequential(new Delay(1.0));
		addSequential(new IntakeStop());
		addSequential(new Forward(-0.8), 1);
		addSequential(new LiftZero(), 2);
		addSequential(new Forward(0.2));
		addSequential(new Turn(0));
	}
	
}
