package org.usfirst.frc.team3200.robot.subsystems;
import org.usfirst.frc.team3200.robot.RobotMap;
import org.usfirst.frc.team3200.robot.commands.drivetrain.DriveControlled;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
	
	private RobotDrive drive;
	
	public PIDRotate pidRotate;
	public PIDDistance pidDistance;
	
	public DriveTrain(){
		super("DriveTrain");
		
		drive = new RobotDrive(
				RobotMap.FRONT_LEFT_TALON,
				RobotMap.BACK_LEFT_TALON,
				RobotMap.FRONT_RIGHT_TALON,
				RobotMap.BACK_RIGHT_TALON
		);
		
		drive.setSafetyEnabled(false);
		
		
		pidRotate   = new PIDRotate();
		pidDistance = new PIDDistance();
	}
	
	public void set(double x, double rot) {
		drive.arcadeDrive(x, rot);
	}
	
	public void drive(Joystick controller){
		double x   = controller.getRawAxis(RobotMap.LEFT_STICK_Y)  * 0.6;
		double rot = controller.getRawAxis(RobotMap.RIGHT_STICK_X) * 0.6;
		double turbo = controller.getRawAxis(RobotMap.RIGHT_TRIGGER);
		
		if(Math.abs(x) <= 0.1) x = 0;
		if(Math.abs(rot) <= 0.1) rot = 0;
		
		x = x * (1 + 0.66 * turbo);
		
		set(x,rot);
	}
	
    public void initDefaultCommand() {
       setDefaultCommand(new DriveControlled());
    }

    private class PIDRotate implements PIDOutput {
        public void pidWrite(double output) {
            set(0, output);
        }
    }
    
    private class PIDDistance implements PIDOutput {
        public void pidWrite(double output) {
            set(output, 0);
        }
        
    }
}

