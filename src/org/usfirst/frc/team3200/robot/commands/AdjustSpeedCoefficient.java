package org.usfirst.frc.team3200.robot.commands;

import org.usfirst.frc.team3200.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AdjustSpeedCoefficient extends Command {
	
	private double value;

    public AdjustSpeedCoefficient(double value) {
       this.value = value;
    }

    
    protected void initialize() {
    	//adjusts coefficient by value
    	double current = Robot.driveTrain.getSpeedCoefficient();
    	//makes sure that result isn't less than zero or greater than one
    	if(current + value > 0 && current + value <= 1){
    		Robot.driveTrain.setSpeedCoefficient(current + value);
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
