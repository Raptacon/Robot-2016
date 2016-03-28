package org.usfirst.frc.team3200.robot.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.communication.FRCNetworkCommunicationsLibrary.tInstances;
import edu.wpi.first.wpilibj.communication.FRCNetworkCommunicationsLibrary.tResourceType;
import edu.wpi.first.wpilibj.communication.UsageReporting;

public class RobotDrive2 extends RobotDrive {

    public RobotDrive2(SpeedController frontLeftMotor,
    SpeedController rearLeftMotor, SpeedController frontRightMotor,
    SpeedController rearRightMotor) {
        super(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
    }
    
    public void arcadeDrive(double moveValue, double rotateValue, boolean squaredInputs) {
        // local variables to hold the computed PWM values for the motors
        if (!kArcadeStandard_Reported) {
          UsageReporting.report(tResourceType.kResourceType_RobotDrive, getNumMotors(),
              tInstances.kRobotDrive_ArcadeStandard);
          kArcadeStandard_Reported = true;
        }

        double leftMotorSpeed;
        double rightMotorSpeed;

        moveValue = limit(moveValue);
        rotateValue = limit(rotateValue);

        if (squaredInputs) {
          // square the inputs (while preserving the sign) to increase fine control
          // while permitting full power
          if (moveValue >= 0.0) {
            moveValue = (moveValue * moveValue);
          } else {
            moveValue = -(moveValue * moveValue);
          }
          if (rotateValue >= 0.0) {
            rotateValue = (rotateValue * rotateValue);
          } else {
            rotateValue = -(rotateValue * rotateValue);
          }
        }

        if (moveValue > 0.0) {
          if (rotateValue > 0.0) {
            leftMotorSpeed = moveValue;
            rightMotorSpeed = Math.max(moveValue, rotateValue);
          } else {
            leftMotorSpeed = Math.max(moveValue, -rotateValue);
            rightMotorSpeed = moveValue;
          }
        } else {
          if (rotateValue > 0.0) {
            leftMotorSpeed = -Math.max(-moveValue, rotateValue);
            rightMotorSpeed = moveValue + rotateValue;
          } else {
            leftMotorSpeed = moveValue - rotateValue;
            rightMotorSpeed = -Math.max(-moveValue, -rotateValue);
          }
        }

        setLeftRightMotorOutputs(leftMotorSpeed, rightMotorSpeed);
    }
    

}
