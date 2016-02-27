package org.usfirst.frc.team3200.robot.subsystems;
import org.usfirst.frc.team3200.robot.RobotMap;
import org.usfirst.frc.team3200.robot.commands.DriveControlled;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
	
	private RobotDrive drive;
	
	private double speedCoefficient = 0.75;
	
	public DriveTrain(){
		super("DriveTrain");
		
		drive = new RobotDrive(
				new Talon(RobotMap.FRONT_LEFT_TALON),
				new Talon(RobotMap.BACK_LEFT_TALON),
				new Talon(RobotMap.FRONT_RIGHT_TALON),
				new Talon(RobotMap.BACK_RIGHT_TALON)
		);
	}
	
	public void set(double x, double rot) {
		drive.arcadeDrive(x, rot);
	}
	
	public void drive(Joystick controller){
		//
		double x = controller.getRawAxis(RobotMap.LEFT_STICK_Y) * speedCoefficient;
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
    
}

