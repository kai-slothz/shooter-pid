package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.hardware.TalonFX;
import frc.robot.Constants;
import com.ctre.phoenix6.controls.Follower;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import com.ctre.phoenix6.controls.VoltageOut;

public class Shooter extends SubsystemBase {

  PIDController lead_Controller = new PIDController(Constants.Shooter.RIGHT_FLYWHEEL_P, 0, 0);
  PIDController follower_Controller = new PIDController(Constants.Shooter.LEFT_FLYWHEEL_P, 0, 0);
  
  private final SimpleMotorFeedforward m_RightFeedFoward = new SimpleMotorFeedforward(0.1, Constants.Shooter.k_RightFeedForward, 0.001);

  private TalonFX m_RightMotor;
  private TalonFX m_LeftMotor; 

  private VoltageOut m_RightMotorRequest;


  public void follow() {
    Follower followRequest = new Follower(m_RightMotor.getDeviceID(), false);
    m_LeftMotor.setControl(followRequest);
  }


  public Shooter(){
    m_RightMotor = new TalonFX(Constants.Shooter.RIGHT_MOTOR_ID);
    m_LeftMotor= new TalonFX(Constants.Shooter.LEFT_MOTOR_ID);

    m_RightMotorRequest = new VoltageOut(0.0);

    follow();
  }


  public double getMotorRPM(){
    return m_RightMotor.getVelocity().getValueAsDouble() * 60;
  } 

  public void setMotorRPM(){
    double currentRPM = getMotorRPM();
    double pidOutput = lead_Controller.calculate(currentRPM, Constants.Shooter.rpmSpeed);
    m_RightMotorRequest = new VoltageOut(pidOutput + m_RightFeedFoward.calculate(Constants.Shooter.rpmSpeed));
  }

  @Override
  public void periodic(){
    super.periodic();
    m_RightMotor.setControl(m_RightMotorRequest);
  }

}
