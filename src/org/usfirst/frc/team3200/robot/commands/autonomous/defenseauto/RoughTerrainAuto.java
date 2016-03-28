package org.usfirst.frc.team3200.robot.commands.autonomous.defenseauto;

import org.usfirst.frc.team3200.robot.commands.drivetrain.DriveDistance;
import org.usfirst.frc.team3200.robot.commands.drivetrain.DriveUntilLevel;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RoughTerrainAuto extends CommandGroup {
    public RoughTerrainAuto() {
        addSequential(new DriveUntilLevel(0.6));
        addSequential(new DriveDistance(5));
    }
}
