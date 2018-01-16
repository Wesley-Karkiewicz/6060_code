package org.usfirst.frc.team6060.robot;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.Encoder;


public class AutoDrive extends Robot {
	//These objects store the Motors SpeedControllers when AutoDrive Is first declared
	private SpeedControllerGroup LeftSide_motors; 
	private SpeedControllerGroup RightSide_motors;
	private AnalogGyro Gyro;
	private Encoder Left_Encoder;
	private Encoder Right_Encoder;
	
	//each PID loop that the sensors will use, they are given values when AutoDrive is first declared
	//First two are for the motors
	private PIDController PID_1;
	private PIDController PID_2;
	private PIDController PID_3;

	
	//A PIDController array to store only PIDControllers 
	private PIDController[] PIDContollers = { PID_1 , PID_2, PID_3};
	

	//When AutoDrive is created all the internal objects get their values 
	public AutoDrive(SpeedControllerGroup left,SpeedControllerGroup right, double[][] tuneing_values)  {
		LeftSide_motors = left;
		RightSide_motors = right; 
		tune(tuneing_values);
	}

	//Tell the autoDrive Class what sensors the robot has
	public void Initialize(int gyro_port, int left_port, int right_port) {
		Gyro = new AnalogGyro(gyro_port);
		Left_Encoder = new Encoder(left_port, (1 + left_port));
		Right_Encoder = new Encoder(right_port, (1 + right_port));
		
	}
	
	//if they want to update the tuning values for all the PID loops
	public void tune(double[][] tuneing_values) {
		for(int eachPID = 0 ; eachPID < PIDContollers.length; eachPID++) {
			PIDContollers[eachPID].setPID(tuneing_values[eachPID][0],tuneing_values[eachPID][1] ,tuneing_values[eachPID][2]);
		}
	}
	
	public void Start() {
		
	}
	public void restart() {
		
	}
	public void DriveFeet(int feet) {
		
	}
	
	public void TurnAngle(int Angle) {
		
	}
}
