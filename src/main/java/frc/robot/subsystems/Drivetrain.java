package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.*;

public class Drivetrain extends SubsystemBase {

    private Talon left1 = new Talon(RobotMap.LEFT1);
    private Talon left2 = new Talon(RobotMap.LEFT2);
    private Talon right1 = new Talon(RobotMap.RIGHT1);
    private Talon right2 = new Talon(RobotMap.RIGHT2);

    private ShuffleboardTab demoTab = Shuffleboard.getTab("Demo");
    private NetworkTableEntry demoSpeedEntry = demoTab.add("demo speed %", Constants.DEFAULT_DEMO_SPEED).getEntry();
    private double demoSpeed;

    public Drivetrain() {
        left1.setInverted(Constants.LEFT1_INVERT);
        left2.setInverted(Constants.LEFT2_INVERT);
        right1.setInverted(Constants.RIGHT1_INVERT);
        right2.setInverted(Constants.RIGHT2_INVERT);

        CommandScheduler.getInstance().registerSubsystem(this);
    }

    @Override
    public void periodic() {
        demoSpeed = demoSpeedEntry.getDouble(Constants.DEFAULT_DEMO_SPEED);
    }

    public void setLeftPower(double speed) {
        left1.set(speed * demoSpeed);
        left2.set(speed * demoSpeed);
    }

    public void setRightPower(double speed) {
        right1.set(speed * demoSpeed);
        right2.set(speed * demoSpeed);
    }

    public void stop(){
        setLeftPower(0);
        setRightPower(0);
    }
}
