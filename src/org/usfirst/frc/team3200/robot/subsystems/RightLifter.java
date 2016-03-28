package org.usfirst.frc.team3200.robot.subsystems;

import org.usfirst.frc.team3200.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RightLifter extends Subsystem {
   	Solenoid rightLifter;
    
    public RightLifter(){
    	super("RightLifter");
    	rightLifter = RobotMap.RIGHT_LIFTER;
    }
    
    public void lift(){
    	rightLifter.set(false);//DoubleSolenoid.Value.kReverse);
    }

    public void lower(){
    	rightLifter.set(true);//DoubleSolenoid.Value.kForward);
    }
    
    public int get(){
    	if(rightLifter.get() == false) {//DoubleSolenoid.Value.kReverse) {
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

