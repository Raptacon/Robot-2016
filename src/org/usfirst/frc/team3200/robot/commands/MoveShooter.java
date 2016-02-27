package org.usfirst.frc.team3200.robot.commands;

import org.usfirst.frc.team3200.robot.Robot;
import org.usfirst.frc.team3200.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveShooter extends Command {

    public MoveShooter() {
        super("MoveShooter");
        requires(Robot.variableShooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	switch (Robot.driverMode) {
    	case RobotMap.SINGLE_DRIVER:
    		Robot.variableShooter.moveControlled(Robot.oi.getController1());
    		break;
    	case RobotMap.DOUBLE_DRIVER:
    		Robot.variableShooter.moveControlled(Robot.oi.getController1());
    		break;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
