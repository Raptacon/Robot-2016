package org.usfirst.frc.team3200.robot.subsystems;

import org.usfirst.frc.team3200.robot.RobotMap;
import org.usfirst.frc.team3200.robot.commands.wheelintake.SpinControlled;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class WheelIntake extends Subsystem {
	
	Talon shooter;
	 
    public WheelIntake(){
    	super("WheelIntake");
    	shooter = RobotMap.SHOOTER_TALON;
    }
     
     public void set(double speed) {
    	shooter.set(speed);
	}

    public void initDefaultCommand() {
        setDefaultCommand(new SpinControlled());
    }
}

