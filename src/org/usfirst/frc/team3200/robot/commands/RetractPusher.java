package org.usfirst.frc.team3200.robot.commands;

import org.usfirst.frc.team3200.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RetractPusher extends Command {

    public RetractPusher() {
        requires(Robot.ballPusher);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        setTimeout(0.1);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.ballPusher.set(0.25);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	 return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.ballPusher.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        Robot.ballPusher.set(0);
    }
}
