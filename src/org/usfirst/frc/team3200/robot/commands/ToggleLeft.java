package org.usfirst.frc.team3200.robot.commands;

import org.usfirst.frc.team3200.robot.Robot;
import org.usfirst.frc.team3200.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleLeft extends Command {

    public ToggleLeft() {
        requires(Robot.lifterL);
    }

    protected void initialize() {
    	//Inverts lifter state depending on current lifter state
    	if(Robot.lifterL.get() == RobotMap.LIFTER_UP){
    		Robot.lifterL.lowerLeft();
    	} else {
    		Robot.lifterL.raiseLeft();
    	}
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }
    
    protected void interrupted() {
    }
}
