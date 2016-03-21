package org.usfirst.frc.team3200.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;


public class RobotMap {
	
	//Driver Mode
	public static final int SINGLE_DRIVER = 0;
	public static final int DOUBLE_DRIVER = 1;
	
	//Controllers
	public static final Joystick CONTROLLER1 = new Joystick(0);
	public static final Joystick CONTROLLER2 = new Joystick(1);
	
	//Controller Axes
	public static final int LEFT_STICK_X  = 0;
	public static final int LEFT_STICK_Y  = 1;
	public static final int LEFT_TRIGGER  = 2;
	public static final int RIGHT_TRIGGER = 3;
	public static final int RIGHT_STICK_X = 4;
	public static final int RIGHT_STICK_Y = 5;
	
	//Controller Buttons
	public static final int BUTTON_A              = 1;
	public static final int BUTTON_B              = 2;
	public static final int BUTTON_X              = 3;
	public static final int BUTTON_Y              = 4;
	public static final int LEFT_BUMPER           = 5;
	public static final int RIGHT_BUMPER          = 6;
	public static final int BUTTON_SELECT         = 7;
	public static final int BUTTON_START          = 8;
	public static final int BUTTON_LEFT_JOYSTICK  = 9;
	public static final int BUTTON_RIGHT_JOYSTICK = 10;
	
	//Motors
	public static final Talon FRONT_LEFT_TALON  = new Talon(1);
	public static final Talon FRONT_RIGHT_TALON = new Talon(3);
    public static final Talon BACK_RIGHT_TALON  = new Talon(5);
	public static final Talon BACK_LEFT_TALON   = new Talon(2);
	
	//Variable Shooter
	public static final CANTalon VARIABLE_SHOOTER = new CANTalon(0);
	
	//Solenoids
	public static final DoubleSolenoid LEFT_LIFTER  = new DoubleSolenoid(0, 1);
	public static final DoubleSolenoid RIGHT_LIFTER = new DoubleSolenoid(2, 3);
	
	//Ball Shooter
	public static final Talon SHOOTER_TALON = new Talon(8);
	public static final CANTalon PUSHER_TALON = new CANTalon(1);
	
	//Encoders
	public static final Encoder LEFT_ENCODER  = new Encoder(2, 3);
	public static final Encoder RIGHT_ENCODER = new Encoder(4, 5);
	
	//Camera States
	public static final int CAMERA_REAR  = 0;
	public static final int CAMERA_FRONT = 1;
	
	//Lifter States
    public static final int LIFTER_DOWN = 0;
    public static final int LIFTER_UP   = 1;
}
