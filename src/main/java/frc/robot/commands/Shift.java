package frc.robot.commands;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shifty;

public class Shift extends CommandBase {
    private final Shifty shifty;
    private BooleanSupplier shifterState;

    public Shift(Shifty shifty, BooleanSupplier shifterState) {
        this.shifty = shifty;
        this.shifterState = shifterState;
        addRequirements(shifty);
    }

    @Override
    public void initialize() {
        if (shifterState.getAsBoolean()) {
            shifty.shiftUp();
        } else {
            shifty.shiftDown();
        }
    }

    @Override
    public void end(boolean interrupted){
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
