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
    	leftLifter = new DoubleSolenoid(RobotMap.LEFT_LIFTER_A, RobotMap.LEFT_LIFTER_B);
    }
    
    public void raiseLeft(){
    	leftLifter.set(DoubleSolenoid.Value.kForward);;
    }
    
    public void lowerLeft(){
    	leftLifter.set(DoubleSolenoid.Value.kReverse);	
    }
    
    public int get(){
    	if(leftLifter.get() == DoubleSolenoid.Value.kForward) {
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

