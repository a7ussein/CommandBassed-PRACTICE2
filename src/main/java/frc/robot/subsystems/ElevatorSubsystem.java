package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ElevatorSubsystem extends SubsystemBase {
    // Intake Motors 
  private final WPI_VictorSPX elevatorMotor = new WPI_VictorSPX(6);

  // make sure to identify sourceA and sourceB for the elvatorEncoder
  private final Encoder elevatorEncoder = new Encoder(null, null);
  private final double kEncoderTick2Meter = 1.0/4096*6*Math.PI/12;

  public double getEncoderMeters(){
    return elevatorEncoder.get() * kEncoderTick2Meter;
  }

  public ElevatorSubsystem(){

  }
  @Override
  public void periodic(){
    SmartDashboard.putNumber("Elevator encoder value", getEncoderMeters());
  }

  public void setMotor(double speed){
    elevatorMotor.set(speed);
  }


}
