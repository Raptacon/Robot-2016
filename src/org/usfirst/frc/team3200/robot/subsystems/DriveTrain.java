package org.usfirst.frc.team3200.robot.subsystems;
import org.usfirst.frc.team3200.robot.RobotMap;
import org.usfirst.frc.team3200.robot.commands.DriveControlled;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
	
	private RobotDrive drive; 
	public double x;
	public double rot;
	
	public DriveTrain() {
		super("DriveTrain");
		drive = new RobotDrive(
				new Talon(RobotMap.BACK_LEFT_TALON),
				new Talon(RobotMap.FRONT_LEFT_TALON),
				new Talon(RobotMap.BACK_RIGHT_TALON),
				new Talon(RobotMap.FRONT_RIGHT_TALON)
		);
	}
	
	public void drive(double x, double rot) {
		drive.arcadeDrive(x, rot);
	}
	
	public void drive(Joystick controller){
		x = controller.getRawAxis(RobotMap.LEFT_STICK_Y);
		rot = controller.getRawAxis(RobotMap.RIGHT_STICK_X);
		drive(x,rot);
	}
	
    
    

    public void initDefaultCommand() {
       setDefaultCommand(new DriveControlled());
    }
}

