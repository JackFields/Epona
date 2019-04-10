package org.usfirst.frc.team5472.robot.autonomous.commands.paths;

import org.usfirst.frc.team5472.robot.Constants;
import org.usfirst.frc.team5472.robot.autonomous.commands.Delay;
import org.usfirst.frc.team5472.robot.autonomous.commands.Forward;
import org.usfirst.frc.team5472.robot.autonomous.commands.RaiseLiftLow;
import org.usfirst.frc.team5472.robot.autonomous.commands.Turn;
import org.usfirst.frc.team5472.robot.commands.GripClose;
import org.usfirst.frc.team5472.robot.commands.IntakePushSlow;
import org.usfirst.frc.team5472.robot.commands.IntakeStop;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LSWLX extends CommandGroup {

	public LSWLX() {
		addParallel(new GripClose());
		
		addSequential(new Forward(3.6), 4);
		addParallel(new RaiseLiftLow(), 2);
		addSequential(new Turn(-85), 2);
		addSequential(new Forward(Constants.V_CONSTANT), 0.5);
		addSequential(new IntakePushSlow());
		addSequential(new Delay(1));
		addSequential(new IntakeStop());
		addSequential(new Forward(-1.00), 0.5);
	}
}
