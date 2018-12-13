package org.usfirst.frc.team2374.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI {
	
	private Joystick joystick;
	
	public OI() {
		joystick = new Joystick(RobotMap.joystick);
	}
	
	public double getJoystickLeftY() { return deadZone(joystick.getRawAxis(RobotMap.rsLeftAxisY), 0.5); }

	public double getJoystickRightY() { return deadZone(joystick.getRawAxis(RobotMap.rsRightAxisY), 0.5); }

	public double getLeftTrigger() { return deadZone(joystick.getRawAxis(RobotMap.rsLeftTrigger), 0.5); }

	public double getRightTrigger() { return deadZone(joystick.getRawAxis(RobotMap.rsRightTrigger), 0.5); }

	public boolean getButtonA() { return joystick.getRawButton(RobotMap.rsButtonA); }
	
	public boolean getButtonB() { return joystick.getRawButton(RobotMap.rsButtonB); }

	public boolean getButtonX() { return joystick.getRawButton(RobotMap.rsButtonX); }

	public boolean getButtonY() { return joystick.getRawButton(RobotMap.rsButtonY); }

	public boolean getLeftBumper() { return joystick.getRawButton(RobotMap.rsLeftBumper); }

	public boolean getRightBumper() { return joystick.getRawButton(RobotMap.rsRightBumper); }
	
	public boolean getBackButton() { return joystick.getRawButton(RobotMap.rsButtonBack); }
	
	public boolean getStartButton() { return joystick.getRawButton(RobotMap.rsButtonStart); }
	
	public static double deadZone(double axisValue, double deadValue) {
		if (Math.abs(axisValue) < deadValue) {
			return 0;
		} else if (1 - axisValue < deadValue) {
			return 1;
		} else if (-1 - axisValue > -deadValue) {
			return -1;
		} else {
			return axisValue;
		}
	}
	
}
