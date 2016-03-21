package org.usfirst.frc.team3200.robot;

import org.usfirst.frc.team3200.robot.commands.AdjustSpeedCoefficient;
import org.usfirst.frc.team3200.robot.commands.AlignVertical;
import org.usfirst.frc.team3200.robot.commands.PushAndRetract;
import org.usfirst.frc.team3200.robot.commands.RetractPusher;
import org.usfirst.frc.team3200.robot.commands.SpinIntake;
import org.usfirst.frc.team3200.robot.commands.SwitchCamera;
import org.usfirst.frc.team3200.robot.commands.ToggleLeft;
//import org.usfirst.frc.team3200.robot.commands.TogglePush;
import org.usfirst.frc.team3200.robot.commands.ToggleRight;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	private Joystick controller1;
	private Joystick controller2;
	
	private JoystickButton buttonRetrieve;
	private JoystickButton buttonShoot;
	private JoystickButton buttonRightLifter;
	private JoystickButton buttonLeftLifter;
	private JoystickButton buttonSpeedUp;
	private JoystickButton buttonSpeedDown;
	private JoystickButton buttonAlign;
	private JoystickButton buttonPush;
	private JoystickButton buttonCamera;
	
	public OI() {
		controller1 = RobotMap.CONTROLLER1;
		controller2 = RobotMap.CONTROLLER2;	
		
		switch (Robot.driverMode) {
			case RobotMap.SINGLE_DRIVER:
				buttonRightLifter = new JoystickButton(controller1, RobotMap.RIGHT_BUMPER);
				buttonLeftLifter  = new JoystickButton(controller1, RobotMap.LEFT_BUMPER);
				buttonSpeedUp     = new JoystickButton(controller1, RobotMap.BUTTON_Y);
				buttonSpeedDown   = new JoystickButton(controller1, RobotMap.BUTTON_X);
				buttonRetrieve    = new JoystickButton(controller1, RobotMap.BUTTON_A);
				buttonShoot       = new JoystickButton(controller1, RobotMap.BUTTON_B);
				buttonPush        = new JoystickButton(controller1, RobotMap.BUTTON_SELECT);
				break;
				
			case RobotMap.DOUBLE_DRIVER:
				buttonRightLifter = new JoystickButton(controller1, RobotMap.RIGHT_BUMPER);
				buttonLeftLifter  = new JoystickButton(controller1, RobotMap.LEFT_BUMPER);
				buttonSpeedUp     = new JoystickButton(controller1, RobotMap.BUTTON_A);
				buttonSpeedDown   = new JoystickButton(controller1, RobotMap.BUTTON_B);
				buttonRetrieve    = new JoystickButton(controller2, RobotMap.BUTTON_A);
				buttonShoot       = new JoystickButton(controller2, RobotMap.BUTTON_B);
				buttonPush        = new JoystickButton(controller2, RobotMap.LEFT_BUMPER);
				buttonAlign       = new JoystickButton(controller1, RobotMap.BUTTON_Y);
				buttonCamera      = new JoystickButton(controller1, RobotMap.BUTTON_X);
				break;
		}
		
		buttonRetrieve.whileHeld(new SpinIntake(0.25));
		buttonRetrieve.whenReleased(new RetractPusher());
		buttonShoot.whileHeld(new SpinIntake(-0.4));
		buttonRightLifter.whenPressed(new ToggleRight());
		buttonLeftLifter.whenPressed(new ToggleLeft());
		buttonSpeedUp.whenPressed(new AdjustSpeedCoefficient(0.25));
		buttonSpeedDown.whenPressed(new AdjustSpeedCoefficient(-0.25));
		buttonPush.whenPressed(new PushAndRetract());
		buttonAlign.whenPressed(new AlignVertical());
		buttonCamera.whenPressed(new SwitchCamera());
	}
	
	
	public Joystick getController1() {
		return controller1;
	}

	public Joystick getController2() {
		return controller2;
	}
}

