package org.usfirst.frc.team3200.robot.subsystems;

import org.usfirst.frc.team3200.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class WheelIntake extends Subsystem {
	 Talon shooter;
     public WheelIntake(){
    	 super("ObtainBall");
    	 shooter = new Talon(RobotMap.SHOOTER_TALON);
    	 
     }
	 public void setSpeed(double speed) {
	    	shooter.set(speed);
	    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

