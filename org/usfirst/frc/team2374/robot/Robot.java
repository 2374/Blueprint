package org.usfirst.frc.team2374.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2374.robot.commands.TimedAuto;
import org.usfirst.frc.team2374.robot.subsystems.Drivetrain;

public class Robot extends TimedRobot {
	
	private static Drivetrain drivetrain;
	private static OI oi;

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	@Override
	public void robotInit() {
		drivetrain = new Drivetrain();
		oi = new OI();
		SmartDashboard.putData("Auto mode", chooser);
		chooser.addDefault("Default Auto", new TimedAuto(10));
	}
	
	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}
	
	@Override
	public void disabledInit() { }

	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();
		if (autonomousCommand != null) {
			autonomousCommand.start();
		}
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		getDrivetrain().move(getInput().getJoystickLeftY(), getInput().getJoystickRightY());
	}

	@Override
	public void teleopInit() {
		if (autonomousCommand != null) {
			autonomousCommand.cancel();
		}
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void testPeriodic() {
		// LiveWindow.run();
	}
	
	public static Drivetrain getDrivetrain() { return drivetrain; }
	
	public static OI getInput() { return oi; }
	
}
