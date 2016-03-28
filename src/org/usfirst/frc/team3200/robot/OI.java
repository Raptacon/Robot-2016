package org.usfirst.frc.team3200.robot;

import org.usfirst.frc.team3200.robot.commands.SwitchCamera;
import org.usfirst.frc.team3200.robot.commands.lifters.ToggleLeft;
import org.usfirst.frc.team3200.robot.commands.lifters.ToggleRight;
import org.usfirst.frc.team3200.robot.commands.pusher.PushAndRetract;
import org.usfirst.frc.team3200.robot.commands.pusher.RetractPusher;
import org.usfirst.frc.team3200.robot.commands.wheelintake.SpinIntake;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
//import org.usfirst.frc.team3200.robot.commands.TogglePush;

public class OI {
	private Joystick controller1;
	private Joystick controller2;
	
	private JoystickButton buttonRetrieve;
	private JoystickButton buttonShoot;
	private JoystickButton buttonRightLifter;
	private JoystickButton buttonLeftLifter;
//	private JoystickButton buttonAlign;
	private JoystickButton buttonPush;
	private JoystickButton buttonCamera;
	
	public OI() {
		controller1 = RobotMap.CONTROLLER1;
		controller2 = RobotMap.CONTROLLER2;	
		
		switch (Robot.driverMode) {
			case RobotMap.SINGLE_DRIVER:
				buttonRightLifter = new JoystickButton(controller1, RobotMap.RIGHT_BUMPER);
				buttonLeftLifter  = new JoystickButton(controller1, RobotMap.LEFT_BUMPER);
				buttonRetrieve    = new JoystickButton(controller1, RobotMap.BUTTON_A);
				buttonShoot       = new JoystickButton(controller1, RobotMap.BUTTON_B);
				buttonPush        = new JoystickButton(controller1, RobotMap.BUTTON_SELECT);
				break;
				
			case RobotMap.DOUBLE_DRIVER:
				buttonRightLifter = new JoystickButton(controller1, RobotMap.RIGHT_BUMPER);
				buttonLeftLifter  = new JoystickButton(controller1, RobotMap.LEFT_BUMPER);
				buttonRetrieve    = new JoystickButton(controller2, RobotMap.BUTTON_A);
				buttonShoot       = new JoystickButton(controller2, RobotMap.BUTTON_B);
				buttonPush        = new JoystickButton(controller2, RobotMap.LEFT_BUMPER);
//				buttonAlign       = new JoystickButton(controller1, RobotMap.BUTTON_Y);
				buttonCamera      = new JoystickButton(controller1, RobotMap.BUTTON_X);
				break;
		}
		
		buttonRetrieve.whileHeld(new SpinIntake(0.75));
		buttonRetrieve.whenReleased(new RetractPusher());
		buttonShoot.whileHeld(new SpinIntake(-0.5));
		buttonRightLifter.whenPressed(new ToggleRight());
		buttonLeftLifter.whenPressed(new ToggleLeft());
		buttonPush.whenPressed(new PushAndRetract());
		//buttonAlign.whenPressed(new AlignVertical());
		buttonCamera.whenPressed(new SwitchCamera());
	}
	
	
	public Joystick getController1() {
		return controller1;
	}

	public Joystick getController2() {
		return controller2;
	}
}

