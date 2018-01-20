package org.usfirst.frc.team6060.robot;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.Encoder;
/*
* This is class provides methods to allow the robot to drive 
* a fixed distance in feet foward or backwards or turn to a 
* set angle. This uses sensors onboard the robot to make sure 
* everything is done accurently. The PID loops must be tuned,
* the tuneing values will come from a double array with another 
* nested array. the set up should be like this 
*
* double [][]Tuning values = {
*	{ kP, kI, kD} - left side PIDcontroller
*	{ kP, kI, kD} - right side PIDcontroller
*	{ kP, kI, kD} - ADXRS450_Gyro PIDcontroller
*	}
*
* DriveFeet(double feet) drive the robot foward or backwards a fixed distance in feet as quickly as 
* possible. You can input a range between -50 to 50 feet where negitve is drive backwards
*
* TurnAngle(double angle) gets its reference from where ever the front of the robot is facing 
* at the time the command is called. You can input a range between -180 to 180
* negitve values has the robot turn to the left, Postive values to the right 
*
* In normal opertion, you will only need to create the Autodrive 
* object with the necessary parameters, then call AutoDrive.Initialize(port, port)
* in the robotinit() method. In the autonomous method you will only need to use 
* AutoDrive.DriveFeet(number of feet) and AutoDrive.TurnAngle(some angle) 
* To move the robot.
*
*
* For example if You want the robot to drive in a U shaped path you would write
*
* Autodrive.DriveFeet(5); 
* Autodrive.Turnangle(90); 
* Autodrive.DriveFeet(3);
* Autodrive.Turnangle(90);
* Autodrive.DriveFeet(5);
*
* AutoDrive.Tune() and AutoDrive.Reset should only be used if you are trying to tune 
* The PID loops. I recommend doing this in the TEST method in the main code.
*/
public class AutoDrive extends Robot {
	//These objects store the Motors SpeedControllers when AutoDrive Is first declared
	private SpeedControllerGroup LeftSide_motors; 
	private SpeedControllerGroup RightSide_motors;
	private Encoder Left_Encoder;
	private Encoder Right_Encoder;
	private ADXRS450_Gyro Gyro;
	
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

	//Tell the autoDrive Class what sensors the robot has, takes the seneros objects 
	//already declared in the main Robot class
	public void Initialize(Encoder left_Encoder, Encoder right_Encoder, ADXRS450_Gyro gyro) {
		
		Left_Encoder = left_Encoder;
		Right_Encoder = right_Encoder;
		Gyro = gyro;
		
	}
	
	//if they want to update the tuning values for all the PID loops
	public void tune(double[][] tuneing_values) {
		for(int eachPID = 0 ; eachPID < PIDContollers.length; eachPID++) {
			PIDContollers[eachPID].setPID(tuneing_values[eachPID][0],tuneing_values[eachPID][1] ,tuneing_values[eachPID][2]);
		}
	}
	//begin reading sensors and start time keeping,
	//I may remove this since I dont think it will be useful
	public void Start() {
		
	}
	//Restarts all the sensors and PID loops
	//Will need this for tuning but not in normal use 
	public void restart() {
		
	}
	//Run a while loop for the deration of the command
	//The robot will drive the definded amount of feet before running another command 
	public void DriveFeet(int feet) {
		//ignore command if they place to big a distance for the robot to travel 
		if(feet > 50 || feet < -50) return;
		
		//This will run a loop untill the command is finished
		boolean IsJobDone = false; 
		while(!IsJobDone) {
			
		}
	}
	
	//Run a while loop for the deration of the command
	//The robot will turn to a definded angle between -180 to 180 before running another command 
	public void TurnAngle(int Angle) {
		if(angle >180 || angle < -180) return;
		//This will run the loop untill the command is finished
		boolean IsJobDone = false; 
		while(!IsJobDone) {
			
		}
		
	}
}
