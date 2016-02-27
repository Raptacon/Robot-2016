package org.usfirst.frc.team3200.robot.sensors;

import org.usfirst.frc.team3200.robot.RobotMap;
import edu.wpi.first.wpilibj.AnalogGyro;


public class Gyro {
	private AnalogGyro gyro;
	public Gyro() {
		gyro = new AnalogGyro(RobotMap.GYRO);
	}
	
	public void calibrate(){
		gyro.calibrate();
	}
	
	public double getRot(){
		return gyro.getAngle();
	}
}
