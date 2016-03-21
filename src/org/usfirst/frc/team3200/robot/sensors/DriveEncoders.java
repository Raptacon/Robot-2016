package org.usfirst.frc.team3200.robot.sensors;

import org.usfirst.frc.team3200.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class DriveEncoders implements PIDSource {
	
	public Encoder encoderLeft;
	public Encoder encoderRight;
	
	private PIDSourceType sourceType = PIDSourceType.kDisplacement;
	
	//when driving on carpet at 0.5 speed
	private double distPerPulse = 0.0042149631 * 1.1583333333; //feet
	
	public DriveEncoders(){
		encoderLeft  = RobotMap.LEFT_ENCODER;
		encoderRight = RobotMap.RIGHT_ENCODER;
		
		encoderLeft.setDistancePerPulse(-distPerPulse);
		encoderRight.setDistancePerPulse(distPerPulse);
		
		encoderLeft.reset();
		encoderRight.reset();
	}
	
	public double getMeanDistance(){
		return ((encoderLeft.getDistance() + encoderRight.getDistance()) / 2.0);
	}
	
	public double getLeft() {
		return encoderLeft.getDistance();
	}
	
	public double getRight() {
		return encoderRight.getDistance();
	}
	
	public void reset() {
	    encoderLeft.reset();
        encoderRight.reset();
	}

    public void setPIDSourceType(PIDSourceType pidSource) {
        sourceType = pidSource;
        
    }

    public PIDSourceType getPIDSourceType() {
        return sourceType;
    }

    public double pidGet() {
        return getMeanDistance();
    }
}
