package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class TankDrive extends CommandBase {

    private final Drivetrain drivetrain;
    private DoubleSupplier leftPower;
    private DoubleSupplier rightPower;

    public TankDrive(Drivetrain drivetrain, DoubleSupplier leftPower, DoubleSupplier rightPower) {
        this.drivetrain = drivetrain;
        this.leftPower = leftPower;
        this.rightPower = rightPower;

        addRequirements(drivetrain);
    }

    @Override
    public void execute() {
        drivetrain.setLeftPower(leftPower.getAsDouble());
        drivetrain.setRightPower(rightPower.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
