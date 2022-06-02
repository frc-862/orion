package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Flicker extends SubsystemBase {

    private final Solenoid FLICKER = new Solenoid(PneumaticsModuleType.CTREPCM, 2);

    public Flicker() {
        CommandScheduler.getInstance().registerSubsystem(this);
    }

    @Override
    public void periodic() {
    }

    public void setOpen() {
        FLICKER.set(true);
    }

    public void setClosed() {
        FLICKER.set(false);
    }

}
