package org.usfirst.frc.team3200.robot.commands.autonomous.defenseauto;

import org.usfirst.frc.team3200.robot.commands.drivetrain.DriveDistance;
import org.usfirst.frc.team3200.robot.commands.drivetrain.DriveUntilLevel;
import org.usfirst.frc.team3200.robot.commands.lifters.ToggleLeft;
import org.usfirst.frc.team3200.robot.commands.lifters.ToggleRight;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class RockWallAuto extends CommandGroup {
    
    public RockWallAuto() {
        addParallel(new WaitCommand(5));
        addParallel(new ToggleRight());
        addSequential(new ToggleLeft());
        addSequential(new DriveUntilLevel(0.75));
        addSequential(new DriveDistance(5));
        addParallel(new ToggleRight());
        addSequential(new ToggleLeft());
    }
}
