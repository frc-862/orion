package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.constants.*;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

public class RobotContainer {

    private final Drivetrain drivetrain = new Drivetrain();
    private final Shooter shooter = new Shooter();
    private final Flicker flicker = new Flicker();
    private final Shifty shifty = new Shifty();

    private final Joystick leftDrive = new Joystick(JoystickConstants.Ports.DRIVER_LEFT);
    private final Joystick rightDrive = new Joystick(JoystickConstants.Ports.DRIVER_RIGHT);

    Compressor pcmCompressor = new Compressor(RobotMap.PCM, PneumaticsModuleType.CTREPCM);

    public RobotContainer() {
        configureButtonBindings();
        configureDefaultCommands();
        pcmCompressor.enableDigital();
    }

    private void configureDefaultCommands() {
        //Standard tank drive controls
        drivetrain.setDefaultCommand(new TankDrive(
            drivetrain,
            () -> MathUtil.applyDeadband(-leftDrive.getY(),  Constants.DRIVE_DEADBAND),
            () -> MathUtil.applyDeadband(-rightDrive.getY(), Constants.DRIVE_DEADBAND)
        ));

        //Trigger: enable flicker
        flicker.setDefaultCommand(new Flick(flicker, () -> rightDrive.getTrigger()));
    }

    private void configureButtonBindings() {
        //Left:
        //Thumb: shift down
        (new JoystickButton(leftDrive, JoystickConstants.FlightStick.THUMB)).whenPressed(new Shift(shifty, () -> false));
        //Trigger: shift up
        (new JoystickButton(leftDrive, JoystickConstants.FlightStick.TRIGGER)).whenPressed(new Shift(shifty, () -> true));
        //Right:
        //Thumb: enable flywheels
        //Slider: set flywheel speed
        (new JoystickButton(rightDrive, JoystickConstants.FlightStick.THUMB)).whileActiveContinuous(
            new EngageShooter(shooter, () -> (-0.5 * rightDrive.getThrottle() + 0.5))
        );
    }

    public Command getAutonomousCommand() { return null; }
}
