
package org.usfirst.frc.team3200.robot;

import org.usfirst.frc.team3200.robot.sensors.DriveEncoders;
import org.usfirst.frc.team3200.robot.sensors.Gyro;
import org.usfirst.frc.team3200.robot.sensors.IMU;
import org.usfirst.frc.team3200.robot.sensors.ShooterLimits;
import org.usfirst.frc.team3200.robot.subsystems.BallPusher;
import org.usfirst.frc.team3200.robot.subsystems.DriveTrain;
import org.usfirst.frc.team3200.robot.subsystems.LeftLifter;
import org.usfirst.frc.team3200.robot.subsystems.RightLifter;
import org.usfirst.frc.team3200.robot.subsystems.VariableShooter;
import org.usfirst.frc.team3200.robot.subsystems.WheelIntake;

import edu.wpi.first.wpilibj.CameraServer;
//import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
//import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	public static OI oi;
	
	CameraServer camServer;

    Command autonomousCommand;
    
    public static int driverMode = RobotMap.SINGLE_DRIVER;
       
    public static ShooterLimits shooterLimit;
    public static DriveTrain driveTrain;
    public static WheelIntake intake;
    public static LeftLifter lifterL;
    public static RightLifter lifterR;
    public static VariableShooter variableShooter;
    public static BallPusher ballPusher;
    
    public static DriveEncoders driveEncoders;
    public static Gyro gyro;
    
    public void robotInit() {
    	camServer = CameraServer.getInstance();
    	if(camServer != null) {
    		camServer.setQuality(50);
    		camServer.startAutomaticCapture("cam0");
    	}

//	    ballPusher = new BallPusher();
    	shooterLimit = new ShooterLimits();
    	variableShooter = new VariableShooter();
		intake = new WheelIntake();
		lifterL = new LeftLifter();
		lifterR = new RightLifter();
		driveTrain = new DriveTrain();	
		
		gyro = new Gyro();
		driveEncoders = new DriveEncoders();
		
		oi = new OI();
		
		gyro.calibrate();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        if (autonomousCommand != null) autonomousCommand.start();
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        if (autonomousCommand != null) autonomousCommand.cancel();
        driveEncoders.printAll();
    }

    public void disabledInit(){

    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putNumber("Orientation", gyro.getRot());
        SmartDashboard.putBoolean("Left Lifter Up", lifterL.get() == RobotMap.LIFTER_UP);
        SmartDashboard.putBoolean("Right Lifter Up", lifterR.get() == RobotMap.LIFTER_UP);
    }

    public void testPeriodic() {
        LiveWindow.run();
    }
}
