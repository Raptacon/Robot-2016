package org.usfirst.frc.team3200.robot.subsystems;

import org.usfirst.frc.team3200.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;


public class BallPusher extends Subsystem {
    
	CANTalon ballPusher;
	
	public BallPusher(){
		super("BallPusher");
    	ballPusher = RobotMap.PUSHER_TALON;
    }
     
     public void set(double speed) {
    	ballPusher.set(speed);
	}

    public void initDefaultCommand() {
    	
    }
}


