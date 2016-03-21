package org.usfirst.frc.team3200.robot.commands;

import org.usfirst.frc.team3200.robot.Robot;
import org.usfirst.frc.team3200.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
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
		if (Robot.driverMode == RobotMap.SINGLE_DRIVER) {
			Joystick controller = Robot.oi.getController1();
			double up = controller.getRawAxis(RobotMap.LEFT_TRIGGER);
			double down = controller.getRawAxis(RobotMap.RIGHT_TRIGGER);
			Robot.variableShooter.set(-0.5 * (up - down));
		} else if (Robot.driverMode == RobotMap.DOUBLE_DRIVER) {
			Joystick controller = Robot.oi.getController2();
			double speed = controller.getRawAxis(RobotMap.LEFT_STICK_Y);
			Robot.variableShooter.set(-0.5 * speed);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	    Robot.variableShooter.set(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	    Robot.variableShooter.set(0);}
}
