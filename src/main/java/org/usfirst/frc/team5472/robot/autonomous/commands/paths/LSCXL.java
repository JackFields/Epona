package org.usfirst.frc.team5472.robot.autonomous.commands.paths;

import org.usfirst.frc.team5472.robot.autonomous.commands.Delay;
import org.usfirst.frc.team5472.robot.autonomous.commands.EnableBrake;
import org.usfirst.frc.team5472.robot.autonomous.commands.EnableCoast;
import org.usfirst.frc.team5472.robot.autonomous.commands.Forward;
import org.usfirst.frc.team5472.robot.autonomous.commands.LiftZero;
import org.usfirst.frc.team5472.robot.autonomous.commands.RaiseLiftHigh;
import org.usfirst.frc.team5472.robot.autonomous.commands.RaiseLiftMinimum;
import org.usfirst.frc.team5472.robot.autonomous.commands.Turn;
import org.usfirst.frc.team5472.robot.commands.GripClose;
import org.usfirst.frc.team5472.robot.commands.GripOpen;
import org.usfirst.frc.team5472.robot.commands.HighGear;
import org.usfirst.frc.team5472.robot.commands.IntakePull;
import org.usfirst.frc.team5472.robot.commands.IntakePullSlow;
import org.usfirst.frc.team5472.robot.commands.IntakePushAuto;
import org.usfirst.frc.team5472.robot.commands.IntakeStop;
import org.usfirst.frc.team5472.robot.commands.LowGear;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LSCXL extends CommandGroup {

	public LSCXL() {
		addParallel(new GripClose());
		addParallel(new HighGear());
		
		addParallel(new EnableBrake());
		addParallel(new RaiseLiftMinimum(), 4);
		addSequential(new Forward(5.30), 3);
		addSequential(new EnableCoast());
		addSequential(new Turn(-28), 2);
		
		addSequential(new RaiseLiftHigh(), 4);
		addSequential(new LowGear());
		addSequential(new Forward(2.0, -28), 1);
		addSequential(new IntakePushAuto());
		addSequential(new Delay(1));
		addSequential(new IntakeStop());
		
		addSequential(new Forward(-0.400), 0.4);
		addSequential(new LiftZero(), 2);
		
		addSequential(new Turn(-160), 1.5);
		addSequential(new HighGear());
		
		addParallel(new IntakePull());
//		addSequential(new EnableVision());
//		addSequential(new BoxPipeline());
		addParallel(new GripOpen());
		addSequential(new Forward(1.30), 1.5);
//		addSequential(new ApproachBox(), 1.5);
//		addSequential(new IntakeStop());
		addSequential(new GripClose());
		addSequential(new IntakePullSlow());
		addSequential(new Forward(-0.600), 0.5);
		addSequential(new Turn(0));
		addParallel(new LowGear());
		addSequential(new RaiseLiftHigh(), 4.00);
		addSequential(new Forward(0.8), 1);
		addSequential(new IntakePushAuto());
		addSequential(new Delay(1));
		addSequential(new Forward(-0.5), 1);
		addSequential(new LiftZero());
		addSequential(new IntakeStop());
	}
}
