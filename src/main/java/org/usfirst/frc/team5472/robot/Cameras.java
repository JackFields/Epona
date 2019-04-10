package org.usfirst.frc.team5472.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;

public class Cameras {
	
	private UsbCamera cam0;
	
	public Cameras() {
		cam0 = CameraServer.getInstance().startAutomaticCapture(0);
		cam0.setResolution(320, 240);
	}
	
}
