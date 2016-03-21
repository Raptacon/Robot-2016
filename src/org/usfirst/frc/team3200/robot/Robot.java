
package org.usfirst.frc.team3200.robot;

import org.usfirst.frc.team3200.robot.commands.DriveDistance;
import org.usfirst.frc.team3200.robot.commands.Rotate;
import org.usfirst.frc.team3200.robot.sensors.Cameras;
import org.usfirst.frc.team3200.robot.sensors.DriveEncoders;
import org.usfirst.frc.team3200.robot.sensors.IMU;
import org.usfirst.frc.team3200.robot.subsystems.BallPusher;
import org.usfirst.frc.team3200.robot.subsystems.DriveTrain;
import org.usfirst.frc.team3200.robot.subsystems.LeftLifter;
import org.usfirst.frc.team3200.robot.subsystems.RightLifter;
import org.usfirst.frc.team3200.robot.subsystems.VariableShooter;
import org.usfirst.frc.team3200.robot.subsystems.WheelIntake;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	public static OI oi;
	
    public static CameraServer camServer;

    private Command autoCommand;
    
    private SendableChooser autoChooser;
    
    public static int driverMode = RobotMap.DOUBLE_DRIVER;
    
    public static AnalogInput pot;
    public static DriveTrain driveTrain;
    public static WheelIntake intake;
    public static LeftLifter lifterL;
    public static RightLifter lifterR;
    public static VariableShooter variableShooter;
    public static BallPusher ballPusher;
    
    public static DriveEncoders driveEncoders;
    public static IMU imu;
    public static Cameras cameras;
    
    
    public void robotInit() {
        camServer = CameraServer.getInstance();

	    ballPusher      = new BallPusher();
    	variableShooter = new VariableShooter();
		intake          = new WheelIntake();
		lifterL         = new LeftLifter();
		lifterR         = new RightLifter();
		driveTrain      = new DriveTrain();	
		imu             = new IMU();
		driveEncoders   = new DriveEncoders();
		cameras         = new Cameras();
		pot             = new AnalogInput(1);
		
		autoChooser = new SendableChooser();
		autoChooser.addDefault("Do Nothing", new CommandGroup(){/* It does nothing! */});
		autoChooser.addObject("Rotate 90 degrees Clockwise ", new Rotate(90, 1));
		autoChooser.addObject("Drive 10 feet", new DriveDistance(10));
		
		SmartDashboard.putData("Auto Mode", autoChooser);
		
		oi = new OI();
    }
    
    public void disabledInit(){
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		updateDashboard();
	}

    public void autonomousInit() {
    	autoCommand = (Command) autoChooser.getSelected();
        if (autoCommand != null) autoCommand.start();
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        updateDashboard();
    }

    public void teleopInit() {
        if (autoCommand != null) autoCommand.cancel();
    }


    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        updateDashboard();
    }

    public void testPeriodic() {
    	LiveWindow.run();
    }
    
    public void updateDashboard() {
        SmartDashboard.putNumber("Left Encoder Count", driveEncoders.getLeft());
        SmartDashboard.putNumber("Right Encoder Count", driveEncoders.getRight());
        SmartDashboard.putNumber("Encoder Distance", driveEncoders.getMeanDistance());
        SmartDashboard.putNumber("Heading", imu.getHeading());
        SmartDashboard.putNumber("Pitch", imu.getPitch());
        SmartDashboard.putNumber("Roll", imu.getRoll());
        SmartDashboard.putNumber("Acceleration X", imu.getAccelX());
        SmartDashboard.putNumber("Acceleration Y", imu.getAccelY());
        SmartDashboard.putBoolean("Left Lifter Up", lifterL.get() == RobotMap.LIFTER_UP);
        SmartDashboard.putBoolean("Right Lifter Up", lifterR.get() == RobotMap.LIFTER_UP);
        SmartDashboard.putNumber("Shooter Angle", variableShooter.getAngle());
        SmartDashboard.putNumber("Shooter Speed", variableShooter.getSpeed());
        SmartDashboard.putNumber("Shooter Current", variableShooter.getCurrent());
        SmartDashboard.putNumber("Shooter Angle", variableShooter.getAngle());
        SmartDashboard.putBoolean("IMU Visible", imu.addressIMU());
        
        camServer.setImage(cameras.getImage());
    }
}
