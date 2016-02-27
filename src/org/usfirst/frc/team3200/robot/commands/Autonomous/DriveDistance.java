package org.usfirst.frc.team3200.robot.commands.Autonomous;

import org.usfirst.frc.team3200.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveDistance extends Command {
	
	private double initialDist;
	private double goalDist;
	private double speed;
    public DriveDistance(double goal, double speed) {
    	this.goalDist = goal;
    	this.speed = speed;
    	this.speed *= Math.signum(goalDist);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	initialDist = Robot.driveEncoders.getDistance();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.set(speed, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return Math.abs(Robot.driveEncoders.getDistance()-initialDist) >=goalDist;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.set(0,0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.driveTrain.set(0,0);
    }
}
