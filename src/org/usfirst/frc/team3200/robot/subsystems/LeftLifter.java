package org.usfirst.frc.team3200.robot.subsystems;

import org.usfirst.frc.team3200.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LeftLifter extends Subsystem {
	DoubleSolenoid leftLifter;
    
    public LeftLifter(){
    	super("LeftLifter");
    	leftLifter = RobotMap.LEFT_LIFTER;
    }
    
    public void lift(){
    	leftLifter.set(DoubleSolenoid.Value.kReverse);;
    }
    
    public void lower(){
    	leftLifter.set(DoubleSolenoid.Value.kForward);	
    }
    
    public int get(){
    	if(leftLifter.get() == DoubleSolenoid.Value.kReverse) {
    		return RobotMap.LIFTER_UP;
    	} else {
    		return RobotMap.LIFTER_DOWN;
    	}
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

