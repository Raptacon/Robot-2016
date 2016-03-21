package org.usfirst.frc.team3200.robot.commands.Autonomous;

import org.usfirst.frc.team3200.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TraverseRockWall extends Command {
    
    private boolean wallComplete;
    private boolean declineComplete;

    public TraverseRockWall() {
       requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        wallComplete = false;
        declineComplete = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double pitch = Robot.imu.getPitch();
        double acceleration = Robot.imu.getAccelY();
        
        if(!wallComplete && acceleration < -5) {
            Robot.lifterL.lift();
            Robot.lifterR.lower();
            wallComplete = true;
        } else if(!declineComplete && pitch < -5) {
            declineComplete = true;
        }
        
        Robot.driveTrain.set(0.75, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        double pitch = Robot.imu.getPitch();
        return (declineComplete && pitch < 2 && pitch > -2);
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.driveTrain.set(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        Robot.driveTrain.set(0, 0);
    }
}
