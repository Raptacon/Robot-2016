package org.usfirst.frc.team3200.robot.sensors;

import org.usfirst.frc.team3200.robot.RobotMap;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;
import com.ni.vision.VisionException;

import edu.wpi.first.wpilibj.vision.USBCamera;

public class Cameras {
    public USBCamera cameraRear;
    public USBCamera cameraFront;
    public Image cameraImg = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
    
    public int cameraMode = RobotMap.CAMERA_REAR;
    
    public Cameras() {
        try {
            cameraRear = new USBCamera("cam4");
        } catch (VisionException e) {
            System.out.println("Rear camera not found!");
            cameraRear = null;
        }
        try {
            cameraFront = new USBCamera("cam5");
        } catch (VisionException E) {
            cameraFront = null;
            System.out.println("Front camera not found!");
        }
        
        if(cameraRear != null) {
            cameraRear.startCapture();
        }
    }
    
    public Image getImage() {
        if(cameraMode == RobotMap.CAMERA_REAR) {
            if(cameraRear != null) cameraRear.getImage(cameraImg);
        } else {
            if(cameraFront != null) cameraFront.getImage(cameraImg);
        }
        return cameraImg;
    }
    
    public void setCameraMode(int mode) {
        if(cameraRear != null && cameraFront != null) {
            if(mode == RobotMap.CAMERA_REAR) {
                cameraFront.stopCapture();
                cameraRear.startCapture();
                cameraMode = mode;
            } else {
                cameraRear.stopCapture();
                cameraFront.startCapture();
                cameraMode = mode;
            }
        }
    }
}
