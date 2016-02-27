package org.usfirst.frc.team3200.robot.commands.Autonomous;

import org.usfirst.frc.team3200.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Rotate extends Command {
	double startRot;

	double goalRotation;
	double speed;

    public Rotate(double rot, double speed) {
       requires(Robot.driveTrain);
       this.goalRotation = rot;
       this.speed = speed;
       this.speed *= Math.signum(goalRotation);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	startRot = Robot.gyro.getRot();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	 Robot.driveTrain.set(0, speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return Math.abs(Robot.gyro.getRot()-startRot) >= Math.abs(goalRotation);
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
