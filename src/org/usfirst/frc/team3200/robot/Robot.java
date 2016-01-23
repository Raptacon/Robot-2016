
package org.usfirst.frc.team3200.robot;

import org.usfirst.frc.team3200.robot.subsystems.DriveTrain;
import org.usfirst.frc.team3200.robot.subsystems.WheelIntake;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Robot extends IterativeRobot {

	public static OI oi;

    Command autonomousCommand;
    
    public static DriveTrain driveTrain;
    public static WheelIntake intake;
    
    public void robotInit() {
		oi = new OI();
		
		driveTrain = new DriveTrain();
		intake = new WheelIntake();
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
    }

    public void disabledInit(){

    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    public void testPeriodic() {
        LiveWindow.run();
    }
}
