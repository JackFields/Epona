package org.usfirst.frc.team5472.robot.autonomous.commands.paths;

import org.usfirst.frc.team5472.robot.Constants;
import org.usfirst.frc.team5472.robot.autonomous.commands.Delay;
import org.usfirst.frc.team5472.robot.autonomous.commands.Forward;
import org.usfirst.frc.team5472.robot.autonomous.commands.RaiseLiftHigh;
import org.usfirst.frc.team5472.robot.autonomous.commands.RaiseLiftLow;
import org.usfirst.frc.team5472.robot.autonomous.commands.Turn;
import org.usfirst.frc.team5472.robot.commands.GripClose;
import org.usfirst.frc.team5472.robot.commands.IntakePush;
import org.usfirst.frc.team5472.robot.commands.IntakeStop;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CSCXL extends CommandGroup {

	public CSCXL() {
		addParallel(new GripClose());
		
		addSequential(new Forward(1.78 - Constants.ROBOT_LENGTH));
		addSequential(new Turn(90));
		addSequential(new Forward(3.66));
		addSequential(new Turn(0));
		addParallel(new RaiseLiftLow(), 3);
		addSequential(new Forward(5.54 + Constants.ROBOT_LENGTH));
		addParallel(new RaiseLiftHigh(), 3);
		addSequential(new Turn(-90));
		addSequential(new Forward(0.5));
		addSequential(new IntakePush());
		addSequential(new Delay(1));
		addSequential(new IntakeStop());
		addSequential(new Forward(-0.75));
		addSequential(new RaiseLiftLow());
	}
}
