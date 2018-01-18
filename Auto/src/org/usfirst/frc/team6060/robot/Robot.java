/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6060.robot;

import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Encoder; 

/**

 *
 * <p>The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SampleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 *
 */
@SuppressWarnings("deprecation")
public class Robot extends SampleRobot {
	private double[][] Tuneing_values =
		{
		 {0,0,0}, 
		 {0,0,0},
		 {0,0,0},
		 {0,0,0},
		};

	private Joystick stick = new Joystick(0);
	private SpeedController Motor0 = new VictorSP(0);
	private SpeedController Motor1 = new VictorSP(1);
	private SpeedController Motor2 = new VictorSP(2);
	private SpeedController Motor3 = new VictorSP(3);
	
	private SpeedControllerGroup Left = new SpeedControllerGroup(Motor0, Motor1);
	private SpeedControllerGroup Right = new SpeedControllerGroup(Motor2, Motor3);

	private AutoDrive Auto = new AutoDrive(Left, Right,Tuneing_values);

	public Robot() {
	}
	@Override
	public void robotInit() {
		Auto.Initialize(0, 0, 2);
	}

	/**
	 * 
	 */
	@Override
	public void autonomous() {
		
	}

	
	@Override
	public void operatorControl() {
		
		while (isOperatorControl() && isEnabled()) {
			double Y = -stick.getRawAxis(1);
			double X = stick.getRawAxis(0);
			
			Timer.delay(0.005);
		}
	}

	/**
	 * Runs during test mode.
	 */
	@Override
	public void test() {
	}
}
