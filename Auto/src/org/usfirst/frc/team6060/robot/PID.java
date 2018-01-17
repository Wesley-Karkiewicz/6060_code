package org.usfirst.frc.team6060.robot;
import java.lang.System.*;
import java.util.Date;
public class PID {
    //This will tell the PID loop what to aim for
    public double setpoint = 0;
    //Internal math 
     long lastTime = 0;
    private double Input, Output;
    private double P, I, D;
    private double errSum, lastInput;
    private int sampleTime = 5; //5 ms sample time
 
  public void Caluclate() {
    //find what time it is now and how long it has been since the loop was last called
     long now = System.currentTimeMillis();
     long timechanged = (now - lastTime);
     if(timeChange>=sampletime) {
    
    //error variables
    double error = (setpoint - lastErr);
    double errSum =+ error;
    double dInput = (Input - lastInput);
    
    //compute output
    Output = (P * error) + (I * errSum) + (D * dInput);
      
    //Save varibles for next loop
     lastInput = Input;
     lastTime = now;
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
      
}
