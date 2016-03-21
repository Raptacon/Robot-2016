package org.usfirst.frc.team3200.robot.subsystems;
import org.usfirst.frc.team3200.robot.RobotMap;
import org.usfirst.frc.team3200.robot.commands.DriveControlled;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
	
	private RobotDrive drive;
	
	private double speedCoefficient = 0.75;
	
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
		
		pidRotate   = new PIDRotate();
		pidDistance = new PIDDistance();
	}
	
	public void set(double x, double rot) {
		drive.arcadeDrive(x, rot);
	}
	
	public void drive(Joystick controller){
		double x   = controller.getRawAxis(RobotMap.LEFT_STICK_Y)  * speedCoefficient;
		double rot = controller.getRawAxis(RobotMap.RIGHT_STICK_X) * speedCoefficient;
		set(x,rot);
	}
	
	public void setSpeedCoefficient(double value) {
		speedCoefficient = value;
	}
	
	public double getSpeedCoefficient(){
		return speedCoefficient;
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

