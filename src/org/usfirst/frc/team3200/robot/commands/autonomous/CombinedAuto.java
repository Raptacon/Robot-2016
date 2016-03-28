package org.usfirst.frc.team3200.robot.commands.autonomous;

import org.usfirst.frc.team3200.robot.commands.drivetrain.AlignVertical;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CombinedAuto extends CommandGroup {
    
    public  CombinedAuto(Command defenseAuto, Command scoreAuto) {
        addSequential(defenseAuto);
        addSequential(new AlignVertical());
        addSequential(scoreAuto);
    }
}
