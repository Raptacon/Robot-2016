package org.usfirst.frc.team3200.robot.commands;

import org.usfirst.frc.team3200.robot.Robot;

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
    	Robot.driveTrain.drive(Robot.oi.getController1());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.driveTrain.drive(0,0);
    }

    protected void interrupted() {
    	Robot.driveTrain.drive(0,0);
    }
}
