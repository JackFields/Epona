package org.usfirst.frc.team5472.robot.autonomous.commands.paths;

import org.usfirst.frc.team5472.robot.autonomous.commands.Forward;
import org.usfirst.frc.team5472.robot.commands.GripClose;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PassAutoLine extends CommandGroup {

	public PassAutoLine() {
		addParallel(new GripClose());
		
		addSequential(new Forward(3.6), 4);
	}
}
