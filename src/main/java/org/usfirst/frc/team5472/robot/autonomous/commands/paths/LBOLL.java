package org.usfirst.frc.team5472.robot.autonomous.commands.paths;

import org.usfirst.frc.team5472.robot.autonomous.commands.Delay;
import org.usfirst.frc.team5472.robot.autonomous.commands.Forward;
import org.usfirst.frc.team5472.robot.autonomous.commands.LiftZero;
import org.usfirst.frc.team5472.robot.autonomous.commands.RaiseLiftLow;
import org.usfirst.frc.team5472.robot.autonomous.commands.Turn;
import org.usfirst.frc.team5472.robot.commands.IntakePushAuto;
import org.usfirst.frc.team5472.robot.commands.IntakeStop;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LBOLL extends CommandGroup{
	
	public LBOLL() {
		addSequential(new LSCXL());
		
		addParallel(new RaiseLiftLow(), 3);
		addSequential(new Delay(1));
		addSequential(new IntakeStop());
		addSequential(new Turn(-135), 1);
		addSequential(new Forward(0.9), 2);
		addSequential(new IntakePushAuto());
		addSequential(new Delay(1));
		addSequential(new IntakeStop());
		addSequential(new Forward(-0.6), 1);
		addSequential(new LiftZero());
	}
	
}
