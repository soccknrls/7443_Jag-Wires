package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.LEDSubsystem;

public class AutoDrive extends CommandBase {

    private final DriveSubsystem m_drive;
    private final LEDSubsystem m_led;

    public AutoDrive(DriveSubsystem drive, LEDSubsystem led) {
        m_led = led;
        m_drive = drive;
        addRequirements(m_drive, m_led);
    }

    @Override
    public void initialize() {
        m_led.setColor(Constants.LED.red_shot);
        m_drive.arcadeDrive(0.5, 0.0);
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}