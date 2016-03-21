package org.usfirst.frc.team3200.robot.commands;

import org.usfirst.frc.team3200.robot.Robot;
import org.usfirst.frc.team3200.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SwitchCamera extends Command {

    public SwitchCamera() {
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        if(Robot.cameras.cameraMode == RobotMap.CAMERA_FRONT) {
            Robot.cameras.setCameraMode(RobotMap.CAMERA_REAR);
        } else {
            Robot.cameras.setCameraMode(RobotMap.CAMERA_FRONT);
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
