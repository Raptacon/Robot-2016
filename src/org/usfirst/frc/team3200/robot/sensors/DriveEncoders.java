package org.usfirst.frc.team3200.robot.sensors;

import org.usfirst.frc.team3200.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;

public class DriveEncoders {
	
	public Encoder encoderFR;
	public Encoder encoderFL;
	public Encoder encoderBR;
	public Encoder encoderBL;
	
	private double initialDist;
	private double finalDist;
	
	
	private double distPerPulse =.0283514;
	private double normalDist = 24;
	
	public DriveEncoders(){
		encoderBL = new Encoder(RobotMap.BL_ENCODER_A,RobotMap.BL_ENCODER_B);
		encoderFL = new Encoder(RobotMap.FL_ENCODER_A,RobotMap.FL_ENCODER_B);
		encoderBR = new Encoder(RobotMap.BR_ENCODER_A,RobotMap.BR_ENCODER_B);
		encoderFR = new Encoder(RobotMap.FR_ENCODER_A,RobotMap.FR_ENCODER_B);
		
		encoderBL.setDistancePerPulse(distPerPulse);
		encoderFL.setDistancePerPulse(distPerPulse);
		encoderBR.setDistancePerPulse(distPerPulse);
		encoderFR.setDistancePerPulse(distPerPulse);
	}
	
	public double getDistance(){
		return (encoderBL.getDistance() + encoderFL.getDistance() + encoderBR.getDistance() + encoderFR.getDistance())/4;
	}
	
	public double WheelSlippage(){
		//When returns certain angle which indicates robot is passing obstacle:
		initialDist = getDistance(); //after loop
		finalDist = getDistance();
		return (finalDist - initialDist) - normalDist;
	}
	
	public void printAll(){
		System.out.println(this.encoderBL.get());
		System.out.println(this.encoderFL.get());
		System.out.println(this.encoderBR.get());
		System.out.println(this.encoderFR.get());
	}
	
	

}
