package org.usfirst.frc.team3200.robot.commands;

import org.usfirst.frc.team3200.robot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveDistance extends Command {
    
	private double goalDist;
	
	private PIDController pid;
	
    public DriveDistance(double goal) {
        goalDist = goal;
    	
    	pid = new PIDController(0.1, 0, 0, Robot.driveEncoders, Robot.driveTrain.pidDistance);
    	pid.setOutputRange(-0.5, 0.5);
    	pid.setAbsoluteTolerance(1);
    	
    	SmartDashboard.putData("Distance PID", pid);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.driveEncoders.reset();
        pid.setSetpoint(goalDist);
    	pid.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return pid.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	pid.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	pid.disable();
    }
}
