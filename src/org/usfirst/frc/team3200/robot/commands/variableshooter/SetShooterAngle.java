package org.usfirst.frc.team3200.robot.commands.variableshooter;

import org.usfirst.frc.team3200.robot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class SetShooterAngle extends Command {
    private double goalAngle;
    
    private PIDController pid;

    public SetShooterAngle(double goal) {
        requires(Robot.variableShooter);
        
        goalAngle = goal;
        
        pid = new PIDController(1, 0, 0, Robot.variableShooter, Robot.variableShooter);
        pid.setInputRange(Robot.variableShooter.UPPER_LIMIT, Robot.variableShooter.LOWER_LIMIT);
        pid.setOutputRange(-0.5, 0.5);
        pid.setAbsoluteTolerance(5);
        
        SmartDashboard.putData("Shooter PID", pid);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        pid.setSetpoint(goalAngle);
        pid.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return pid.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
        pid.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        pid.disable();
    }
}
