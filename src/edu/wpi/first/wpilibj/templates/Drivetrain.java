package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.*;

public class Drivetrain {
	private Jaguar frontLeft, frontRight, rearLeft, rearRight;

	private Joystick joystick;
	private Joystick joystickKiddy;
	

	private double robotX, robotY, robotZ;
	private double speed;

	/**
	 * Constructor for Drivetrain class
	 * @param frontLeftN
	 * @param frontRightN
	 * @param rearLeftN
	 * @param rearRightN
	 * @param speed
	 */
	public Drivetrain(int frontLeft, int rearLeft, int frontRight, int rearRight, final double speed) {
		this.frontLeft = new Jaguar(frontLeft);
		this.rearLeft = new Jaguar(rearLeft);
		this.frontRight = new Jaguar(frontRight);
		this.rearRight = new Jaguar(rearRight);

		this.speed = speed;
	}

	public void setJoystick(Joystick joystick) {
		this.joystick = joystick;
	}

	public void setJoystickKiddy(Joystick joystickKiddy) {
		this.joystickKiddy = joystickKiddy;
	}

	/**
	 * Getter function for front left motor speed
	 */
	public double getFrontLeft() {
		return this.frontLeft.get();
	}

	/**
	 * Getter function for front right motor speed
	 */
	public double getRearLeft() {
		return this.rearLeft.get();
	}

	/**
	 * Getter function for rear left motor speed
	 */
	public double getFrontRight() {
		return this.frontRight.get();
	}

	/**
	 * Getter function for rear right motor speed
	 */
	public double getRearRight() {
		return this.rearRight.get();
	}

	/**
	 * Continuously called function to drive
	 */
	public void drive() {
		double speedMod = this.speed;
		if (joystick.getRawButton(2)) {
			speedMod = 0.5;
		}

		robotX = joystick.getX();
		robotY = joystick.getY();
		robotZ = joystick.getTwist();

		frontLeft.set(  (robotZ + robotY - robotX) * speedMod);
		rearLeft.set(   (robotZ + robotY + robotX) * speedMod);
		frontRight.set( (robotZ - robotY - robotX) * speedMod);
		rearRight.set(  (robotZ - robotY + robotX) * speedMod);
	}

	//For driving at Dream FIRST events.
	
	public void driveKiddy() {
		double speedMod = this.speed;

		if (joystick.getTrigger()) {
			if (!joystick.getRawButton(2)) {
				speedMod = 0.5;
			}

			robotX = joystick.getRawAxis(1);
			robotY = joystick.getRawAxis(2);
			robotZ = joystick.getRawAxis(4);
		} else {
			speedMod = this.speed / 2;

			robotX = joystickKiddy.getX();
			robotY = joystickKiddy.getY();
			robotZ = joystickKiddy.getTwist();
		}
	

		frontLeft.set(  (robotZ + robotY - robotX) * speedMod);
		rearLeft.set(   (robotZ + robotY + robotX) * speedMod);
		frontRight.set( (robotZ - robotY - robotX) * speedMod);
		rearRight.set(  (robotZ - robotY + robotX) * speedMod);
	}

	/**
	 * Set front left victor speed
	 */
	public void frontLeftSet(double value) {
		frontLeft.set(value);
	}

	/**
	 * Set front right victor speed
	 */
	public void rearLeftSet(double value) {
		rearLeft.set(value);
	}

	/**
	 * Set rear left victor speed
	 */
	public void frontRightSet(double value) {
		frontRight.set(value);
	}

	/**
	 * Set rear right victor speed
	 */
	public void rearRightSet(double value) {
		rearRight.set(value);
	}

	/**
	 * Sets the diminished robot speed
	 */
	public void setDiminishedSpeed(double fraction) {
		frontLeft.set(getFrontLeft() * fraction);
		rearLeft.set(getRearLeft() * fraction);
		frontRight.set(getFrontRight() * fraction);
		rearRight.set(getRearRight() * fraction);
	}
}