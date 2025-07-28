package frc.robot;

import frc.robot.commands.Autos;
import frc.robot.commands.ShooterShoot;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RobotContainer {
  private final Shooter m_shooter = new Shooter();
  private final CommandXboxController m_controller = new CommandXboxController(0);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    // Bind the shoot command to the A button
    m_controller.a().onTrue(new ShooterShoot(m_shooter));
  }

  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_shooter);
  }
}