package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.hardware.TalonFX;
import frc.robot.Constants;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix6.controls.VoltageOut;

public class Shooter extends SubsystemBase {

  PIDController right_PidController = new PIDController(Constants.Shooter.RIGHT_FLYWHEEL_P, 0, 0);
  PIDController left_PidController = new PIDController(Constants.Shooter.LEFT_FLYWHEEL_P, 0, 0);
  
  private final SimpleMotorFeedforward m_RightFeedForward = new SimpleMotorFeedforward(0.1, Constants.Shooter.k_RightFeedForward, 0.001);
  private final SimpleMotorFeedforward m_LeftFeedForward = new SimpleMotorFeedforward(0.1, Constants.Shooter.k_LeftFeedForward, 0.001);


  private TalonFX m_RightMotor;
  private TalonFX m_LeftMotor; 

  private VoltageOut m_RightMotorRequest;
  private VoltageOut m_LeftMotorRequest;

  public Shooter(){
    m_RightMotor = new TalonFX(Constants.Shooter.RIGHT_MOTOR_ID);
    m_LeftMotor = new TalonFX(Constants.Shooter.LEFT_MOTOR_ID);

    m_RightMotorRequest = new VoltageOut(0.0);
    m_LeftMotorRequest = new VoltageOut(0.0);
  }

  public double getRightMotorRPM(){
    return m_RightMotor.getVelocity().getValueAsDouble() * 60;
  } 

  public double getLeftMotorRPM(){
    return m_LeftMotor.getVelocity().getValueAsDouble() * 60;
  } 

  public void setMotorsRPM(double rightVelocityRequest, double leftVelocityRequest) {
    m_RightMotor.setControl(m_RightMotorRequest.withOutput(
            right_PidController.calculate(getRightMotorRPM(), rightVelocityRequest) +
                m_RightFeedForward.calculate(rightVelocityRequest)
        ));

        m_LeftMotor.setControl(m_LeftMotorRequest.withOutput(
            left_PidController.calculate(getLeftMotorRPM(), leftVelocityRequest) +
                m_LeftFeedForward.calculate(leftVelocityRequest)
        ));
  }

  @Override
  public void periodic(){
    super.periodic();
    
}

}
