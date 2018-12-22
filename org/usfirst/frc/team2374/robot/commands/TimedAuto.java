package org.usfirst.frc.team2374.robot.commands;

import org.usfirst.frc.team2374.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

public class TimedAuto extends TimedCommand {

	public TimedAuto(double timeout) {
		super(timeout);
		requires(Robot.getDrivetrain());
	}
	
	@Override
	protected void initialize() {
		
	}
	
	@Override
	protected void execute() {
		Robot.getDrivetrain().move(1.0, 1);
	}

	@Override
	protected void interrupted() {
		end();
	}
	
	@Override
	protected boolean isFinished() {
		return super.isTimedOut();
	}
	
	@Override
	protected void end() {
		Robot.getDrivetrain().move(1.0, 1);
	}
	
}
