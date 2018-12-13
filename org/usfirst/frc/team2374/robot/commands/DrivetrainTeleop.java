package org.usfirst.frc.team2374.robot.commands;

import org.usfirst.frc.team2374.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DrivetrainTeleop extends Command {

	public DrivetrainTeleop() {
		requires (Robot.getDrivetrain());
	}
	
	@Override
	public void initialize() {
		
	}
	
	@Override
	protected void execute() {
		boolean leftBumper = Robot.getInput().getLeftBumper();
		boolean rightBumper = Robot.getInput().getRightBumper();
		double leftJoy = Robot.getInput().getJoystickLeftY();
		double rightJoy = Robot.getInput().getJoystickRightY();
		
		if (rightBumper) {
			Robot.getDrivetrain().move(1.0, 1.0);
		} else if (leftBumper) {
			Robot.getDrivetrain().move(-1.0, -1.0);
		} else {
			Robot.getDrivetrain().move(leftJoy, rightJoy);
		}
	}
	
	@Override
	protected void interrupted() {
		end();
	}
	
	@Override
	protected boolean isFinished() {
		return false;	
	}
	
	@Override
	protected void end() {
		Robot.getDrivetrain().move(0, 0);	
	}
	
}
