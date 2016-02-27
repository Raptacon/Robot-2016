package org.usfirst.frc.team3200.robot;

import org.usfirst.frc.team3200.robot.commands.AdjustSpeedCoefficient;
import org.usfirst.frc.team3200.robot.commands.SpinIntake;
import org.usfirst.frc.team3200.robot.commands.ToggleLeft;
//import org.usfirst.frc.team3200.robot.commands.TogglePush;
import org.usfirst.frc.team3200.robot.commands.ToggleRight;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	private Joystick controller1;
	private Joystick controller2;
	
	private JoystickButton buttonA1;
	private JoystickButton buttonB1;
	private JoystickButton bumperR1;
	private JoystickButton bumperL1;
	private JoystickButton buttonY1;
	private JoystickButton buttonX1;
	
	private JoystickButton buttonA2;
	private JoystickButton buttonB2;
	public OI() {
		controller1 = new Joystick(RobotMap.CONTROLLER1);
		controller2 = new Joystick(RobotMap.CONTROLLER2);
		
		if(controller1 == null)
		{
			System.out.println("contoller 1 null");
		}
		
		if(controller2 == null)
		{
			System.out.println("contoller 2 null");
		}	
		
		switch (Robot.driverMode) {
			case RobotMap.SINGLE_DRIVER:
				bumperR1 = new JoystickButton(controller1, RobotMap.RIGHT_BUMPER);
				bumperL1 = new JoystickButton(controller1, RobotMap.LEFT_BUMPER);
				
				buttonY1 = new JoystickButton(controller1, RobotMap.BUTTON_Y);
				buttonX1 = new JoystickButton(controller1, RobotMap.BUTTON_X);
				
				buttonA1 = new JoystickButton(controller1, RobotMap.BUTTON_A);
				buttonB1 = new JoystickButton(controller1, RobotMap.BUTTON_B);
				
				buttonA1.whileHeld(new SpinIntake(0.25));
				buttonB1.whileHeld(new SpinIntake(-1));
				
				bumperR1.whenPressed(new ToggleRight());
				bumperL1.whenPressed(new ToggleLeft());
				
				buttonY1.whenPressed(new AdjustSpeedCoefficient(0.25));
				buttonX1.whenPressed(new AdjustSpeedCoefficient(-0.25));
				break;
			case RobotMap.DOUBLE_DRIVER:
				bumperR1 = new JoystickButton(controller1, RobotMap.RIGHT_BUMPER);
				bumperL1 = new JoystickButton(controller1, RobotMap.LEFT_BUMPER);
				
				buttonA1 = new JoystickButton(controller1, RobotMap.BUTTON_Y);
				buttonA1 = new JoystickButton(controller1, RobotMap.BUTTON_X);
				
				buttonA2 = new JoystickButton(controller2, RobotMap.BUTTON_A);
				buttonB2 = new JoystickButton(controller2, RobotMap.BUTTON_B);
				
				buttonA2.whileHeld(new SpinIntake(0.25));
				buttonB2.whileHeld(new SpinIntake(-1));
				
				bumperR1.whenPressed(new ToggleRight());
				bumperL1.whenPressed(new ToggleLeft());
				
				buttonA1.whenPressed(new AdjustSpeedCoefficient(0.25));
				buttonB1.whenPressed(new AdjustSpeedCoefficient(-0.25));
				break;
		}
	}
	
	
	public Joystick getController1() {
		return controller1;
	}

	public Joystick getController2() {
		return controller2;
	}
}

