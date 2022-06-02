package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {

    private PWMTalonSRX left1 = new PWMTalonSRX(0);
    private PWMTalonSRX left2 = new PWMTalonSRX(1);
    private PWMTalonSRX right1 = new PWMTalonSRX(2);
    private PWMTalonSRX right2 = new PWMTalonSRX(3);

    public Drivetrain() {
        CommandScheduler.getInstance().registerSubsystem(this);
    }

    @Override
    public void periodic() {}

    public void setLeftPower(double speed) {
        left1.set(speed);
        left2.set(speed);
    }

    public void setRightPower(double speed) {
        right1.set(speed);
        right2.set(speed);
    }

    public void stop(){
        left1.set(0);
        left2.set(0);
        right1.set(0);
        right2.set(0);
    }
}
