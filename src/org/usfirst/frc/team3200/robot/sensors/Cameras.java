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
    
    boolean camerasFound = false;
    
    public Cameras() {
        findCameras();
        
        if(camerasFound) {
            cameraRear.startCapture();
        }
    }
    
    private void findCameras() {
        try {
            cameraRear = new USBCamera("cam0");
            cameraFront = new USBCamera("cam1");
            camerasFound = true;
        } catch (VisionException e) {
            System.out.println("Cameras not found!");
            cameraRear = null;
            cameraFront = null;
        }
    }
    
    public Image getImage() {
        if(!camerasFound) {
            findCameras();
        }
        
        if(camerasFound) {
            if(cameraMode == RobotMap.CAMERA_REAR) {
                cameraRear.getImage(cameraImg);
            } else {
                cameraFront.getImage(cameraImg);
            }
        }
        
        return cameraImg;
    }
    
    public void setCameraMode(int mode) {
        if(camerasFound) {
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
    
    public boolean getCamerasFound() {
        return camerasFound;
    }
}
