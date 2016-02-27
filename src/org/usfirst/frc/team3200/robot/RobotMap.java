package org.usfirst.frc.team3200.robot;

public class RobotMap {
	
	//ControllerMode
	public static final int SINGLE_DRIVER = 0;
	public static final int DOUBLE_DRIVER = 1;
	
	//Controllers
	public static final int CONTROLLER1 = 0;
	public static final int CONTROLLER2 = 1;  
	
	//Controller Axes
	public static final int LEFT_STICK_X = 0;
	public static final int LEFT_STICK_Y = 1;
	public static final int LEFT_TRIGGER = 2;
	public static final int RIGHT_TRIGGER = 3;
	public static final int RIGHT_STICK_X = 4;
	public static final int RIGHT_STICK_Y = 5;
	
	//Controller Buttons
	public static final int BUTTON_A = 1;
	public static final int BUTTON_B = 2;
	public static final int BUTTON_X = 3;
	public static final int BUTTON_Y = 4;
	public static final int RIGHT_BUMPER = 5;
	public static final int LEFT_BUMPER = 6;
	public static final int BUTTON_SELECT = 7;
	public static final int BUTTON_START = 8;
	public static final int BUTTON_LEFT_JOYSTICK = 9;
	public static final int BUTTON_RIGHT_JOYSTICK = 10;
	public static final int BUTTON_L3 = 11;
	
	//Motors
	public static final int FRONT_LEFT_TALON = 3;
	public static final int FRONT_RIGHT_TALON = 2;
	public static final int BACK_RIGHT_TALON = 0;
	public static final int BACK_LEFT_TALON = 1;
	
	//VariableShooter
	public static final int VARIABLE_SHOOTER = 7;
	
	//Solenoids
	public static final int LEFT_LIFTER_A = 2;
	public static final int LEFT_LIFTER_B = 3;
	public static final int RIGHT_LIFTER_A = 0;
	public static final int RIGHT_LIFTER_B = 1;
	
	//Ball Shooter
	public static final int SHOOTER_TALON = 8;
	public static final int PUSHER_TALON = 0;
	
	//Lifter States
	public static final int LIFTER_DOWN = 0;
	public static final int LIFTER_UP = 1;
	
	//Encoders
	public static final int FL_ENCODER_A = 6;
	public static final int FL_ENCODER_B = 7;
	public static final int BL_ENCODER_A = 2;
	public static final int BL_ENCODER_B = 3;
	public static final int FR_ENCODER_A = 4;
	public static final int FR_ENCODER_B = 5;
	public static final int BR_ENCODER_A = 0;
	public static final int BR_ENCODER_B = 1;
	
	//Sensors
	public static final int GYRO = 0;
	public static final int UPPER_LIMIT = 8;
	public static final int LOWER_LIMIT = 9;
}
