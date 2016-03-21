package org.usfirst.frc.team3200.robot.commands;

/*import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
/*public class SetShooterAngle extends Command {
    
    private double goalAngle;
    private PIDController pid;
   // private AnalogInput pot;
    
    public SetShooterAngle(double angle, double speed) {
      pid = new PIDController(0.0,0.0,0.0, Robot.pot, Robot.variableShooter.pidDistance);
      pid.setInputRange(-1023, 1204);
      pid.setOutputRange(-1, 1);
      pid.setAbsoluteTolerance(0.1);
      goalAngle = angle;
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
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }

    @Override
    protected double returnPIDInput() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    protected void usePIDOutput(double output) {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected void initDefaultCommand() {
        // TODO Auto-generated method stub
        
    } 
}*/
