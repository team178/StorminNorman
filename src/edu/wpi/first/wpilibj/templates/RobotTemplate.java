/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends IterativeRobot {
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */

	private Joystick joystick;
	private Joystick joystickKiddy;
	private Compressor compressor;
	private Solenoid kickerSolenoid;
	private Drivetrain drivetrain;

	private Watchdog watchdog;
	
	public void robotInit() {
		watchdog = Watchdog.getInstance();

		joystick = new Joystick(1);
		joystickKiddy = new Joystick(2);
		drivetrain = new Drivetrain(4, 3, 1, 2, 1.0);
		//drivetrain = new Drivetrain(7, 3, 1, 2, 1.0);
		drivetrain.setJoystick(joystick);
		drivetrain.setJoystickKiddy(joystickKiddy);

		compressor = new Compressor(2, 2);
		compressor.start();

		kickerSolenoid = new Solenoid(2);
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {

	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {

		/*if (joystick.getRawButton(6)) {
			robotX = -joystick.getX();
			robotY = -joystick.getY();
			//robotZ = -joystick.getTwist();
			robotZ = -joystick.getRawAxis(4);

			speed = 0.8;

			if (joystick.getRawButton(5)) {
				kickerSolenoid.set(true);
			} else {
				kickerSolenoid.set(false);
			}
		} else {
			robotX = -joystick.getX();
			robotY = -joystick.getY();
			robotZ = -joystick.getTwist();

			speed = 0.8;

			if (joystick.getTrigger()) {
				kickerSolenoid.set(true);
			} else {
				kickerSolenoid.set(false);
			}
		}*/
		drivetrain.driveKiddy();

		watchdog.feed();
	}
}
