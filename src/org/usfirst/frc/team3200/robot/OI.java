package org.usfirst.frc.team3200.robot;

import org.usfirst.frc.team3200.robot.commands.SpinIntake;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	private Joystick controller1;
	private Joystick controller2;
	
	private JoystickButton buttonA;
	private JoystickButton buttonB;
	
	public OI() {
		controller1 = new Joystick(RobotMap.CONTROLLER1);
		controller2 = new Joystick(RobotMap.CONTROLLER2);
		
		buttonA = new JoystickButton(controller1, RobotMap.BUTTON_A);
		buttonB = new JoystickButton(controller1, RobotMap.BUTTON_B);
		
		buttonA.whileHeld(new SpinIntake(-1));
		buttonB.whileHeld(new SpinIntake(1));
	}
	
	public Joystick getController1() {
		return controller1;
	}

	public Joystick getController2() {
		return controller2;
	}
}

