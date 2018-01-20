package org.usfirst.frc.team6060.robot;
import java.lang.System.*;
import java.util.Date;
public class PID {
    //This will tell the PID loop what to aim for
    public double setpoint = 0;
    //Internal math 
     long lastTime = 0;
    public double Input, Output;
    private double P, I, D;

    private double ITerm, lastInput, errSum;
    private int sampleTime1 = 5; //5 ms sample time

    private int sampleTime = 5; //5 ms sample time
    private double outMin, outMax;

 
  public void Caluclate() {
    //find what time it is now and how long it has been since the loop was last called
     long now = System.currentTimeMillis();
     long timechanged = (now - lastTime);

     if(timechanged>=sampleTime1) {

     
//update PID loop at the sampleTime interval
     if(timechanged>=sampleTime1) {    
    	 double error = (setpoint - lastInput);
    	 ITerm += (I * error);
    	 double dInput = (Input - lastInput);

    //error variables
    error = (setpoint - lastInput);
     errSum =+ error;
     dInput = (Input - lastInput);
    
    //compute output
    Output = (P * error) + (I * errSum) + (D * dInput);
      
    //Save varibles for next loop
     lastInput = Input;
     lastTime = now;

    	 //compute output
    	 Output = (P * error) + ITerm - (D * dInput);
      
    	 //Save variables for next loop
    	 lastInput = Input;
    	 lastTime = now;

     }
  }
  }

  // Update the tuning_values of a PID loop using the Tuning value table
    public void tune(double[][] tuneing_table, int whichPID) {
      
       P = tuneing_table[whichPID][0];
       I = tuneing_table[whichPID][1];
       D = tuneing_table[whichPID][2];
    
    }
    
      //update the current setpoint for the PIDloop
    public void Set_point(double new_setpoint) {
        setpoint = new_setpoint;
    }
   //sets the Min and Max values of the PID loops 
    public void SetOutPutlimits(double Min, double Max) {
    	if(Min > Max) return;
    	outMax = Max;
    	outMin = Min;
    	
    	if(Output > outMax) Output = outMax;
    	else if(Output < outMin) Output = outMin;
    	
    	if(ITerm > outMax) ITerm = outMax;
    	else if(ITerm < outMin) ITerm = outMin;
    	
    }    
}
