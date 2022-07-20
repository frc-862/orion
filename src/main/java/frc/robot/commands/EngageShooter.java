package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class EngageShooter extends CommandBase {
    private Shooter shooter;
    private DoubleSupplier power;

    public EngageShooter(Shooter shooter, DoubleSupplier power) {
        this.shooter = shooter;
        this.power = power;
        addRequirements(shooter);
    }

    @Override
    public void execute() {
        shooter.setPower(power.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        shooter.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
