package org.usfirst.frc.team3200.robot.subsystems;

import org.usfirst.frc.team3200.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RightLifter extends Subsystem {
   	DoubleSolenoid rightLifter;
    
    public RightLifter(){
    	super("RightLifter");
    	rightLifter = new DoubleSolenoid(RobotMap.RIGHT_LIFTER_A, RobotMap.RIGHT_LIFTER_B);
    }
    
    public void raiseRight(){
    	rightLifter.set(DoubleSolenoid.Value.kForward);
    }

    public void lowerRight(){
    	rightLifter.set(DoubleSolenoid.Value.kReverse);
    }
    
    public int get(){
    	if(rightLifter.get() == DoubleSolenoid.Value.kForward) {
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

