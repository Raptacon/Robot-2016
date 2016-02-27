package org.usfirst.frc.team3200.robot.commands;

import org.usfirst.frc.team3200.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SpinIntake extends Command {
	
	private double speed;
	
    public SpinIntake(double speed) {
    	super("SpinIntake");
    	this.speed = speed;
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.intake.set(speed);
    }

    protected boolean isFinished() {
        return false;
    }

    
    protected void end() {
    	//Stops motors
    	Robot.intake.set(0);
    }

    
    protected void interrupted() {
    	//Stops motors
    	Robot.intake.set(0);
    }
}
