package org.usfirst.frc.team3200.robot.subsystems;

import org.usfirst.frc.team3200.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LeftLifter extends Subsystem {
	Solenoid leftLifter;
    
    public LeftLifter(){
    	super("LeftLifter");
    	leftLifter = RobotMap.LEFT_LIFTER;
    }
    
    public void lift(){
    	leftLifter.set(false);// DoubleSolenoid.Value.kReverse);
    }
    
    public void lower(){
    	leftLifter.set(true);//DoubleSolenoid.Value.kForward);	
    }
    
    public int get(){
    	if(leftLifter.get() == false) {//DoubleSolenoid.Value.kReverse) {
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

