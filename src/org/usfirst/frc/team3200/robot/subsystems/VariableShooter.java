package org.usfirst.frc.team3200.robot.subsystems;

import org.usfirst.frc.team3200.robot.RobotMap;
import org.usfirst.frc.team3200.robot.commands.variableshooter.MoveShooter;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Subsystem;


public class VariableShooter extends Subsystem implements PIDOutput, PIDSource {
    
    public final int UPPER_LIMIT = -900;
    public final int LOWER_LIMIT = -275;

    private CANTalon vShooter;
    
    PIDSourceType sourceType = PIDSourceType.kDisplacement;
    
    public VariableShooter() {
        super("VariableShooter");
        vShooter = RobotMap.VARIABLE_SHOOTER;
        vShooter.changeControlMode(TalonControlMode.PercentVbus);
//        vShooter.changeControlMode(TalonControlMode.Speed);
//        vShooter.setFeedbackDevice(FeedbackDevice.AnalogPot);
//        vShooter.setPID(1.0, 0, 0);
//        vShooter.setF(0);
//        vShooter.reverseSensor(true);
        
//        vShooter.setForwardSoftLimit(LOWER_LIMIT);
//        vShooter.enableForwardSoftLimit(true);
//        vShooter.setReverseSoftLimit(UPPER_LIMIT);
//        vShooter.enableReverseSoftLimit(true);
    }

    public void set(double speed) {
        if(Math.abs(speed) > 0.1) {
            vShooter.set(-speed);
            //vShooter.set(speed * 1024 * -2.5);
        } else {
            vShooter.set(0);
        }
    }
    
    public boolean getUpperLimit() {
        return (vShooter.getReverseSoftLimit() == 1);
    }
    
    public boolean getLowerLimit() {
        return (vShooter.getForwardSoftLimit() == 1);
    }
    
    public double getAngle() {
        return vShooter.getPosition();
    }
    
    public double getSpeed() {
        return vShooter.getSpeed();
    }
    
    public double getVoltage() {
        return vShooter.getBusVoltage();
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new MoveShooter());
    }

    
    public void pidWrite(double output) {
        vShooter.set(output);
    }

    public void setPIDSourceType(PIDSourceType pidSource) {
        sourceType = pidSource;
    }

    public PIDSourceType getPIDSourceType() {
        return sourceType;
    }

    public double pidGet() {
        return vShooter.getPosition();
    }
}