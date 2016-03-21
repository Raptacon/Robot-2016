package org.usfirst.frc.team3200.robot.commands;

import org.usfirst.frc.team3200.robot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Rotate extends Command {
	double startHeading;

	double goalRotation;
	double speed;
	
	PIDController pid;

    public Rotate(double rotation, double speed) {
       requires(Robot.driveTrain);
       
       goalRotation = rotation;
       
       pid = new PIDController(0.1, 0, 0, Robot.imu.pidHeading, Robot.driveTrain.pidRotate);
       pid.setInputRange(0, 360);
       pid.setOutputRange(-speed, speed);
       pid.setContinuous(true);
       pid.setAbsoluteTolerance(5);
       
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        pid.setSetpoint((goalRotation + Robot.imu.getHeading() + 360) % 360);
    	pid.enable();
    	SmartDashboard.putData("Rotate PID", pid);
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
