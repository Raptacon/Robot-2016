package org.usfirst.frc.team3200.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PushAndRetract extends CommandGroup {
    
    public  PushAndRetract() {
        addSequential(new PushBall());
        addSequential(new RetractPusher());
    }
}
