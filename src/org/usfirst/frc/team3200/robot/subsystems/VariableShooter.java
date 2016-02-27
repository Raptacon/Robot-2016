package org.usfirst.frc.team3200.robot.subsystems;

import org.usfirst.frc.team3200.robot.Robot;
import org.usfirst.frc.team3200.robot.RobotMap;
import org.usfirst.frc.team3200.robot.commands.MoveShooter;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class VariableShooter extends Subsystem {																																																																																																																																											
    
	private Talon vShooter;
	
    public VariableShooter(){
    	super("VariableShooter");
    	vShooter = new Talon(RobotMap.VARIABLE_SHOOTER);
    }
    
    public void set(double speed){
    	if((speed < 0 && !Robot.shooterLimit.getUpper()) ||
    	   (speed > 0 && !Robot.shooterLimit.getLower())) {
    		vShooter.set(speed);
    	} else {
    		vShooter.set(0);
    	}
    }
    
    public void moveControlled(Joystick controller){
		double up = controller.getRawAxis(RobotMap.LEFT_TRIGGER);
		double down = controller.getRawAxis(RobotMap.RIGHT_TRIGGER);
		set(-0.5 * (up-down));
	}

    public void initDefaultCommand() {
        setDefaultCommand(new MoveShooter());
    }
}

