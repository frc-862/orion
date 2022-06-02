// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
    private TalonFX topMotor;
    private TalonFX bottomMotor;

    /** Creates a new Shooter. */
    public Shooter() {
      // TODO: get motor numbers
      topMotor = new TalonFX(6);
      bottomMotor = new TalonFX(5);

      CommandScheduler.getInstance().registerSubsystem(this);
    }

    @Override
    public void periodic() {}

    public void setPower(double power) {
        topMotor.set(TalonFXControlMode.PercentOutput, power);
        bottomMotor.set(TalonFXControlMode.PercentOutput, power);
    }
    
    public void stop() {
      setPower(0d);
    }
}
