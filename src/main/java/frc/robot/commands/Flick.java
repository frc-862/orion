package frc.robot.commands;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Flicker;

public class Flick extends CommandBase {
    
    private final Flicker flicker;
    private final BooleanSupplier flickState;
    
    public Flick(Flicker flicker, BooleanSupplier flickState) {
        this.flicker = flicker;
        this.flickState = flickState;
        addRequirements(flicker);
    }

    @Override
    public void execute() {
        flicker.setState(flickState.getAsBoolean());
    }

    @Override
    public void end(boolean interrupted) {
        flicker.setState(false);
    }

    @Override
    public boolean isFinished() { return false; }
}
