
package org.usfirst.frc.team3200.robot;

import org.usfirst.frc.team3200.robot.commands.autonomous.CombinedAuto;
import org.usfirst.frc.team3200.robot.commands.autonomous.defenseauto.LowBarAuto;
import org.usfirst.frc.team3200.robot.commands.autonomous.defenseauto.RockWallAuto;
import org.usfirst.frc.team3200.robot.commands.autonomous.defenseauto.RoughTerrainAuto;
import org.usfirst.frc.team3200.robot.commands.autonomous.scoreauto.Position1HighAuto;
import org.usfirst.frc.team3200.robot.commands.autonomous.scoreauto.Position2HighAuto;
import org.usfirst.frc.team3200.robot.commands.autonomous.scoreauto.Position3HighAuto;
import org.usfirst.frc.team3200.robot.commands.autonomous.scoreauto.Position4HighAuto;
import org.usfirst.frc.team3200.robot.commands.autonomous.scoreauto.Position5HighAuto;
import org.usfirst.frc.team3200.robot.sensors.Cameras;
import org.usfirst.frc.team3200.robot.sensors.DriveEncoders;
import org.usfirst.frc.team3200.robot.sensors.IMU;
import org.usfirst.frc.team3200.robot.subsystems.BallPusher;
import org.usfirst.frc.team3200.robot.subsystems.DriveTrain;
import org.usfirst.frc.team3200.robot.subsystems.LeftLifter;
import org.usfirst.frc.team3200.robot.subsystems.RightLifter;
import org.usfirst.frc.team3200.robot.subsystems.VariableShooter;
import org.usfirst.frc.team3200.robot.subsystems.WheelIntake;

import com.ni.vision.VisionException;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	public static OI oi;
	
	PowerDistributionPanel PDU;
	
    public static CameraServer camServer;

    private Command defenseAuto;
    private Command scoreAuto;
    private CommandGroup combinedAuto;
    
    private SendableChooser defenseAutoChooser;
    private SendableChooser scoreAutoChooser;
    
    public static int driverMode = RobotMap.DOUBLE_DRIVER;
    
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
		
		defenseAutoChooser = new SendableChooser();
		defenseAutoChooser.addDefault("Do Nothing", new CommandGroup(){/* It does nothing! */});
		defenseAutoChooser.addObject("Low Bar", new LowBarAuto());
//		defenseAutoChooser.addObject("Portcullis", new PortcullisAuto());
//		defenseAutoChooser.addObject("Cheval de Frise", new ChevalDeFriseAuto());
//		defenseAutoChooser.addObject("Moat", new MoatAuto());
//		defenseAutoChooser.addObject("Ramparts", new RampartAuto());
//		defenseAutoChooser.addObject("Drawbridge", new DrawbridgeAuto());
//		defenseAutoChooser.addObject("Sally Port", new SallyPortAuto());
		defenseAutoChooser.addObject("Rock Wall", new RockWallAuto());
		defenseAutoChooser.addObject("Rough Terrain", new RoughTerrainAuto());
		
		SmartDashboard.putData("Defense Auto", defenseAutoChooser);
		
		scoreAutoChooser = new SendableChooser();
		scoreAutoChooser.addDefault("Do Nothing", new CommandGroup() {/* As useful as a two-party government! */});
		scoreAutoChooser.addObject("Position 1 High", new Position1HighAuto());
		scoreAutoChooser.addObject("Position 2 High", new Position2HighAuto());
		scoreAutoChooser.addObject("Position 3 High", new Position3HighAuto());
		scoreAutoChooser.addObject("Position 4 High", new Position4HighAuto());
		scoreAutoChooser.addObject("Position 5 High", new Position5HighAuto());
		
		SmartDashboard.putData("Scoring Auto", scoreAutoChooser);
		
		PDU = new PowerDistributionPanel();
		SmartDashboard.putData("PDU", PDU);
		
		oi = new OI();
		
		SmartDashboard.putData(Scheduler.getInstance());
    }
    
    public void disabledInit(){
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		updateDashboard();
	}

    public void autonomousInit() {
    	defenseAuto = (Command) defenseAutoChooser.getSelected();
    	scoreAuto   = (Command) scoreAutoChooser.getSelected();
    	
    	combinedAuto = new CombinedAuto(defenseAuto, scoreAuto);
    	combinedAuto.start();
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        updateDashboard();
    }

    public void teleopInit() {
        if (combinedAuto != null) combinedAuto.cancel();
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
        SmartDashboard.putBoolean("Left Lifter Up", lifterL.get() == RobotMap.LIFTER_DOWN);
        SmartDashboard.putBoolean("Right Lifter Up", lifterR.get() == RobotMap.LIFTER_DOWN);
        SmartDashboard.putNumber("Shooter Angle", variableShooter.getAngle());
        SmartDashboard.putNumber("Shooter Speed", variableShooter.getSpeed());
        SmartDashboard.putNumber("Shooter Current", variableShooter.getVoltage());
        SmartDashboard.putNumber("Shooter Angle", variableShooter.getAngle());
        SmartDashboard.putBoolean("IMU Visible", imu.addressIMU());
        SmartDashboard.putBoolean("Cameras Found", cameras.getCamerasFound());
        
        try {
            camServer.setImage(cameras.getImage());
        } catch(VisionException e) {
            
        }
    }
}
