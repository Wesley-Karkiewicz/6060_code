package org.usfirst.frc.team6060.robot;
import java.lang.System.currentTimeMillis();
public class PID {
    //This will tell the PID loop what to aim for
    public double setpoint = 0;
    //Internal math 
    unsigned long lastTime = 0;
    private double Input, Output;
    private double P, I, D;
    private double errSum, lastErr;
    
  
    private double[] tuneing_values = {0,0,0};
    
  void Caluclate() {
    //find what time it is now and how long it has been since the loop was last called
    unsigned long now = millis();
    unsigned long timechanged = (now - lastTime);
    
    //error varibles
    double error = (setpoint - lastErr);
    double errSum += (error * timechanged);
    double Derr = (error - lastErr)/ Timechanged;
    
    //compute output
    Output = (P * error) + (I * errSum) + (D * Derr)
  }
  
  // Update the tuning_values of a PID loop using the Tuneing value table
    public void tune(double[][] tuneing_table, int whichPID) {
      for(int eachPID = 0; eachPID < 3; eachPID++) {
        tuneing_values[eachPID] = tuneing_table[whichPID][eachPID];
    }
    
      //update the current setpoint for the PIDloop
    public void Set_point(double new_set_point) {
        setpoint = new_setpoint;
    }
      
}
