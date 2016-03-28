package org.usfirst.frc.team3200.robot.commands.drivetrain;

import org.usfirst.frc.team3200.robot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Rotate extends Command {

	private double goalHeading;
	
	private PIDController pid;

    public Rotate(double rotation) {
       requires(Robot.driveTrain);
       
       goalHeading = rotation;
       
       pid = new PIDController(0.1, 0, 0, Robot.imu.pidHeading, Robot.driveTrain.pidRotate);
       pid.setInputRange(0, 360);
       pid.setOutputRange(-1, 1);
       pid.setContinuous(true);
       pid.setAbsoluteTolerance(2);
       
       SmartDashboard.putData("Rotate PID", pid);
       
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        pid.setSetpoint((goalHeading + Robot.imu.getHeading() + 360) % 360);
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
