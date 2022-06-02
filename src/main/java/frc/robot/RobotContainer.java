// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import org.ejml.dense.row.decompose.TriangularSolver_CDRM;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.Drive;
import frc.robot.commands.EngageShooter;
import frc.robot.commands.Flick;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Flicker;
import frc.robot.subsystems.Shooter;

public class RobotContainer {

    private final Drivetrain drivetrain = new Drivetrain();
    private final Shooter shooter = new Shooter();
    private final Flicker flicker = new Flicker();

    private final Joystick leftDrive = new Joystick(0);
    private final Joystick rightDrive = new Joystick(1);
    private final XboxController operator = new XboxController(2);

    Compressor pcmCompressor = new Compressor(11, PneumaticsModuleType.CTREPCM);

    public RobotContainer() {
        configureButtonBindings();
        configureDefaultCommands();
        
        pcmCompressor.enableDigital();
    }

    private void configureDefaultCommands() {
        drivetrain.setDefaultCommand(new Drive(drivetrain, () -> MathUtil.applyDeadband(leftDrive.getY(), 0.2),  () -> MathUtil.applyDeadband(rightDrive.getY(), 0.2)));
    }

    private void configureButtonBindings() {
        (new Trigger(() -> operator.getRightTriggerAxis() > 0.05)).whenActive(new EngageShooter(shooter, () -> operator.getRightTriggerAxis()));
        (new JoystickButton(operator, 4)).whileHeld(new Flick(flicker));

    }

    public Command getAutonomousCommand() {
        return null;
    }
}
