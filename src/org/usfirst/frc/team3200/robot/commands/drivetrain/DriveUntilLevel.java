package org.usfirst.frc.team3200.robot.commands.drivetrain;

import org.usfirst.frc.team3200.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveUntilLevel extends Command {
    private double speed;

    private boolean inclineComplete; 
    private boolean declineComplete;

    public DriveUntilLevel(double speed) {
       requires(Robot.driveTrain);
       this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        inclineComplete = false;
        declineComplete = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double pitch = Robot.imu.getPitch();
        if(!inclineComplete && pitch > 5) {
            inclineComplete = true;
        } else if(!declineComplete && pitch < -5) {
            declineComplete = true;
        }
        
        Robot.driveTrain.set(-speed, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        double pitch = Robot.imu.getPitch();
        return (inclineComplete && declineComplete && pitch < 2 && pitch > -2);
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
