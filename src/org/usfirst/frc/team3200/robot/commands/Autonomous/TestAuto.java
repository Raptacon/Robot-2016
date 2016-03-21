package org.usfirst.frc.team3200.robot.commands.Autonomous;

import org.usfirst.frc.team3200.robot.commands.Rotate;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TestAuto extends CommandGroup {
    public  TestAuto() {
        addSequential(new Rotate(90, 1));
        addSequential(new Rotate(270, 1));
    }
}
