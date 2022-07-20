package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.*;

public class Shooter extends SubsystemBase {
        private TalonSRX topMotor;
        private TalonSRX bottomMotor;

        public Shooter() {
            topMotor = new TalonSRX(RobotMap.SHOOTER_TOP);
            bottomMotor = new TalonSRX(RobotMap.SHOOTER_BOTTOM);

            topMotor.configFactoryDefault();
            bottomMotor.configFactoryDefault();

            topMotor.setInverted(Constants.SHOOTER_TOP_INVERT);
            bottomMotor.setInverted(Constants.SHOOTER_BOTTOM_INVERT);

            topMotor.setNeutralMode(NeutralMode.Coast);
            bottomMotor.setNeutralMode(NeutralMode.Coast);

            bottomMotor.follow(topMotor);

            CommandScheduler.getInstance().registerSubsystem(this);
        }

        public void setPower(double power) {
            topMotor.set(TalonSRXControlMode.PercentOutput, power);
        }

        public void stop() {
            setPower(0d);
        }
}
