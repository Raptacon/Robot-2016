package org.usfirst.frc.team3200.robot.commands.Autonomous;

import org.usfirst.frc.team3200.robot.commands.DriveDistance;
import org.usfirst.frc.team3200.robot.commands.PushBall;
import org.usfirst.frc.team3200.robot.commands.Rotate;
import org.usfirst.frc.team3200.robot.commands.SpinIntake;
import org.usfirst.frc.team3200.robot.commands.Wait;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LowBarAutonomous extends CommandGroup {
    
    public  LowBarAutonomous() {
      addSequential(new DriveDistance(3));
      addSequential(new TraverseSimple());
      addSequential(new Rotate(90,1));
      addSequential(new DriveDistance(7));
      addSequential(new Rotate(-90,1));
//      addSequential(new SetShooterAngle(60,1));
      addSequential(new SpinIntake(0.75));
      addSequential(new Wait(1));
      addSequential(new PushBall());
//      addsequential(new )
      
     // addSequential(new DriveDistance(5,0.5));
    }
}
