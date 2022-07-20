package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.RobotMap;

public class Flicker extends SubsystemBase {
    private final DoubleSolenoid flicker = new DoubleSolenoid(RobotMap.PCM, PneumaticsModuleType.CTREPCM, RobotMap.FLICKER2, RobotMap.FLICKER1);
    private Value prevState = flicker.get();
    private Value currentState;

    public Flicker() {
        CommandScheduler.getInstance().registerSubsystem(this);
    }

    @Override
    public void periodic() {
        currentState = flicker.get();
        if (currentState != prevState){
            System.out.println("Flicker: " + prevState.toString() + " -> " + currentState.toString());
            prevState = currentState;
        }
    }

    public void fire() {
        flicker.set(Value.kForward);
    }

    public void retract() {
        flicker.set(Value.kReverse);
    }

    public void setState(Boolean state) {
        if (state) {
            fire();
        } else {
            retract();
        }
    }
}
