package org.usfirst.frc.team3200.robot.subsystems;

import org.usfirst.frc.team3200.robot.RobotMap;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;


public class BallPusher extends Subsystem {
	Talon ballPusher;
	public BallPusher(){
		super("BallPusher");
    	ballPusher = new Talon(RobotMap.PUSHER_TALON);
    }
     
     public void set(double speed) {
    	ballPusher.set(speed);
	}

    public void initDefaultCommand() {
    	
    }
}


