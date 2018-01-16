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
    private double errSum, lastErr;
    
  
    private double[] tuneing_values = {0,0,0};
    
  void Caluclate() {
    //find what time it is now and how long it has been since the loop was last called
     long now = System.currentTimeMillis();
     long timechanged = (now - lastTime);
    
    //error variables
    double error = (setpoint - lastErr);
    double errSum =+ (error * timechanged);
    double Derr = (error - lastErr)/ timechanged;
    
    //compute output
    Output = (P * error) + (I * errSum) + (D * Derr);
  }
  
  // Update the tuning_values of a PID loop using the Tuning value table
    public void tune(double[][] tuneing_table, int whichPID) {
      for(int eachPID = 0; eachPID < 3; eachPID++) {
        tuneing_values[eachPID] = tuneing_table[whichPID][eachPID];
    }
    }
    
      //update the current setpoint for the PIDloop
    public void Set_point(double new_setpoint) {
        setpoint = new_setpoint;
    }
      
}
