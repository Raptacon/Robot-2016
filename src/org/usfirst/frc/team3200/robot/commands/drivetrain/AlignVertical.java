package org.usfirst.frc.team3200.robot.commands.drivetrain;

import org.usfirst.frc.team3200.robot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;

public class AlignVertical extends Command {
    
    PIDController pid;
    
    public AlignVertical() {
       requires(Robot.driveTrain);
       
       pid = new PIDController(0.1, 0, 0, Robot.imu.pidHeading, Robot.driveTrain.pidRotate);
       pid.setInputRange(0, 360);
       pid.setOutputRange(-1, 1);
       pid.setContinuous(true);
       pid.setAbsoluteTolerance(1);
       
       setTimeout(2);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        double heading = Robot.imu.getHeading();
        if(heading <= 90 || heading >= 270) {
            pid.setSetpoint(0);
        } else {
            pid.setSetpoint(180);
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return pid.onTarget() || isTimedOut();
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
