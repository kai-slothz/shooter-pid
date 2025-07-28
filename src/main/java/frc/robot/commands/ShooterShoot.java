package frc.robot.commands;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.Shooter.ShooterMode;

public class ShooterShoot extends Command {

    private final Shooter m_shooter;
    private ShooterMode shooterMode;

    public ShooterShoot(Shooter shooter) {
        m_shooter = shooter;
        addRequirements(m_shooter);
    }

    @Override
    public void initialize() {
        shooterMode = ShooterMode.HIGH;
    }

    @Override
    public void execute() {
        m_shooter.setMotorsRPM(shooterMode.rightRpm, shooterMode.leftRpm);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}

