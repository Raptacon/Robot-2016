package org.usfirst.frc.team3200.robot.commands.lifters;

import org.usfirst.frc.team3200.robot.Robot;
import org.usfirst.frc.team3200.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleRight extends Command {

    public ToggleRight() {
        requires(Robot.lifterR);
    }

    protected void initialize() {
    	//Inverts lifter state depending on current lifter state
    	if(Robot.lifterR.get() == RobotMap.LIFTER_UP){
    		Robot.lifterR.lower();
    	} else {
    		Robot.lifterR.lift();
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
