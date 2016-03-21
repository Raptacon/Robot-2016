package org.usfirst.frc.team3200.robot.commands;

import org.usfirst.frc.team3200.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AlignVertical extends Command {
    double startHeading;

    double goalRotation;
    double direction;

    public AlignVertical() {
       requires(Robot.driveTrain);
       
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        startHeading = Robot.imu.getHeading();
        if(startHeading <= 90) {
            direction = -1;
            goalRotation = -startHeading;
        } else if(startHeading <= 180) {
            direction = 1;
            goalRotation = 180 - startHeading;
        } else if(startHeading <= 270) {
            direction = -1;
            goalRotation = 180 - startHeading;
        } else {
            direction = 1;
            goalRotation = 360 - startHeading;
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
         Robot.driveTrain.set(0, direction * 0.6);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(direction == 1) {
            double rotation = (Robot.imu.getHeading() - startHeading + 360) % 360;
            return rotation >= goalRotation;
        } else if(direction == -1) {
            double rotation = (Robot.imu.getHeading() - startHeading - 360) % 360;
            return rotation <= goalRotation;
        } else {
            return true;
        }
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
