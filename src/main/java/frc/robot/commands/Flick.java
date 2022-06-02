package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Flicker;

public class Flick extends CommandBase {
    
    private final Flicker flicker;
    
    public Flick(Flicker flicker) {
        this.flicker = flicker;

        addRequirements(flicker);
    }

    @Override
    public void initialize() {
        flicker.setOpen();
    }

    @Override
    public void execute() {}

    @Override
    public void end(boolean interrupted) {
        flicker.setClosed();
    }

    @Override
    public boolean isFinished() {
    return false;
    }
}
