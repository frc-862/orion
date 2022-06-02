package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shifty;

public class Shift extends CommandBase {
  private final Shifty shifty;

  public Shift(Shifty shifty) {
    this.shifty = shifty;

    addRequirements(shifty);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
