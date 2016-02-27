package org.usfirst.frc.team3200.robot.commands;

import org.usfirst.frc.team3200.robot.Robot;
import org.usfirst.frc.team3200.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class DriveControlled extends Command {

    public DriveControlled() {
    	super("DriveControlled");
        requires(Robot.driveTrain);
    }

    protected void initialize() {
    	//Not needed
    }

    
    protected void execute() {
    	switch (Robot.driverMode) {
    		case RobotMap.SINGLE_DRIVER:
    			Robot.driveTrain.drive(Robot.oi.getController1());
    			break;
    		case RobotMap.DOUBLE_DRIVER:
    			Robot.driveTrain.drive(Robot.oi.getController1());
    			break;
    	}
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	//Stops motors 
    	Robot.driveTrain.set(0,0);
    }

    protected void interrupted() {
    	//Stops motors
    	Robot.driveTrain.set(0,0);
    }
}
