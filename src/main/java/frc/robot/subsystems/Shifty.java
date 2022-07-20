package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.RobotMap;

public class Shifty extends SubsystemBase {
    private DoubleSolenoid shifter = new DoubleSolenoid(RobotMap.PCM, PneumaticsModuleType.CTREPCM, RobotMap.SHIFTER1, RobotMap.SHIFTER2);
    private Value prevState = shifter.get();
    private Value currentState;

    public Shifty() {
        CommandScheduler.getInstance().registerSubsystem(this);
        shiftDown();
    }

    @Override
    public void periodic() {
        currentState = shifter.get();
        if (currentState != prevState){
            System.out.println("Shifter: " + prevState.toString() + " -> " + currentState.toString());
            prevState = currentState;
        }
    }

    public void shiftUp() {
        shifter.set(Value.kForward);
    }

    public void shiftDown() {
        shifter.set(Value.kReverse);
    }
}
