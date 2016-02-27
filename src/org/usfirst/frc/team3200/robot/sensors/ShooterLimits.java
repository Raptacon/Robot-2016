package org.usfirst.frc.team3200.robot.sensors;

import org.usfirst.frc.team3200.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;

public class ShooterLimits {
	
	DigitalInput upperLimit;
	DigitalInput lowerLimit;
	
	public ShooterLimits(){
		upperLimit = new DigitalInput(RobotMap.UPPER_LIMIT);
		lowerLimit = new DigitalInput(RobotMap.LOWER_LIMIT);
	}
	
	public boolean getUpper(){
		return upperLimit.get();
	}
	
	public boolean getLower(){
		return lowerLimit.get();
	}	

}
