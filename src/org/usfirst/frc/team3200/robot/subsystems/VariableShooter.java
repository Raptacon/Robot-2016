package org.usfirst.frc.team3200.robot.subsystems;

import org.usfirst.frc.team3200.robot.RobotMap;
import org.usfirst.frc.team3200.robot.commands.MoveShooter;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class VariableShooter extends Subsystem {

    private CANTalon vShooter;
    public PIDDistance pidDistance;
    public VariableShooter() {
        super("VariableShooter");
        vShooter = RobotMap.VARIABLE_SHOOTER;
        vShooter.changeControlMode(TalonControlMode.Speed);
        vShooter.setFeedbackDevice(FeedbackDevice.AnalogPot);
        vShooter.setPID(1.0, 0, 0);
        vShooter.setF(2);
        vShooter.reverseSensor(true);
        pidDistance = new PIDDistance();
        
        //vShooter.setReverseSoftLimit(-425);
        //vShooter.enableReverseSoftLimit(true);
    }

    public void set(double speed) {
        vShooter.set(speed * 1024 * 0.5);
    }
    
    public double getAngle() {
        return vShooter.getPosition();
    }
    
    public double getSpeed() {
        return vShooter.getSpeed();
    }
    
    public double getCurrent() {
        return vShooter.getOutputCurrent();
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new MoveShooter());
    }
    
    private class PIDDistance implements PIDOutput {
        public void pidWrite(double output) {
            set(output);
        }
    }    
}