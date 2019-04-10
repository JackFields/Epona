package org.usfirst.frc.team5472.robot;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Map.Entry;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
public class DataLogger {
	
	
	private static DecimalFormat fmt = new DecimalFormat("#.##");
	private static String DIRECTORY = "/home/lvuser/data/";
	static {
		Paths.get(DIRECTORY).toFile().mkdirs();
	}
	
	
	private StringBuilder currentFrame;
	private PrintWriter output;
	private double startTime = 0.0;
	
	public DataLogger() {
		currentFrame = new StringBuilder();
	}
	
	public void writeFrame() {
		if(output != null) {
			output.append(currentFrame.toString());
			output.append("\n");
			currentFrame.delete(0, currentFrame.length());
			currentFrame.append("Timestamp: " + (Timer.getFPGATimestamp() - startTime) + "\n");
		}
	}
	
	public void start() {
		startTime = Timer.getFPGATimestamp();
		currentFrame.append("Timestamp: " + 0.0 + "\n");
		
		boolean auto = DriverStation.getInstance().isAutonomous();
		boolean disabled = DriverStation.getInstance().isDisabled();
		boolean teleop = DriverStation.getInstance().isOperatorControl();
		
		int matchnumber = DriverStation.getInstance().getMatchNumber();
		
		String fileName = auto ? "Autonomous " : disabled ? "Disabled " : teleop ? "Teleop " : "Test ";

		if(matchnumber == 0)
			fileName += LocalDateTime.now().toString() + ".log";
		else
			fileName += "Match " + matchnumber + ".log";
		
		try {
			this.output = new PrintWriter(new FileOutputStream(Paths.get(DIRECTORY + fileName).toFile()));
		} catch (IOException e) {
			for(int i = 0; i < 5; i++)
				System.err.println("Failed to open print stream for logging.");
		}
	}
	
	public void end() {
		if(output != null) {
			output.close();
			currentFrame = new StringBuilder();
			output = null;
		}
	}
	
	public void appendData(DataProvider provider) {
		for(Entry<String, double[]> entry : provider.getData().entrySet()) {
			currentFrame.append("\t" + entry.getKey());
			double[] val = entry.getValue();
//			for(int idx = 0; idx < val.length; idx++) {
//				SmartDashboard.putNumber(entry.getKey() + "[" + idx + "]", val[idx]);
//			}
			currentFrame.append(": [");
			for(int i = 0; i < val.length - 1; i++) {
				currentFrame.append(fmt.format(val[i]) + ", ");
			}
			currentFrame.append(fmt.format(val[val.length - 1]));
			currentFrame.append("]\n");
		}
	}
}