package org.usfirst.frc.team3200.robot.commands.autonomous.scoreauto;

import org.usfirst.frc.team3200.robot.Robot;
import org.usfirst.frc.team3200.robot.commands.drivetrain.DriveDistance;
import org.usfirst.frc.team3200.robot.commands.drivetrain.Rotate;
import org.usfirst.frc.team3200.robot.commands.variableshooter.SetShooterAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Position2HighAuto extends CommandGroup {
    
    public  Position2HighAuto() {
        addParallel(new SetShooterAngle(Robot.variableShooter.UPPER_LIMIT));
        addSequential(new Rotate(-149));
        addSequential(new DriveDistance(-12));
    }
}
