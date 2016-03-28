package org.usfirst.frc.team3200.robot.commands.autonomous.defenseauto;

import org.usfirst.frc.team3200.robot.commands.drivetrain.DriveDistance;
import org.usfirst.frc.team3200.robot.commands.drivetrain.DriveUntilLevel;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LowBarAuto extends CommandGroup {
	public LowBarAuto() {
	    addSequential(new DriveUntilLevel(0.5));
	    addSequential(new DriveDistance(5));
	}
}
