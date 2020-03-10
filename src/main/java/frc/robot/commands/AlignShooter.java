package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.VisionSubsystem;

public class AlignShooter extends CommandBase {
    private final DriveSubsystem m_drivetrain;
    private final VisionSubsystem m_vision;
    private double steeringKP = 0.0;
    private double driveKP = 0.0;
    private double targetArea = 0.0;

    NetworkTableEntry kpSteer, minTa, kpDrive;

    public AlignShooter(DriveSubsystem drivetrain, VisionSubsystem vision) {
        m_drivetrain = drivetrain;
        m_vision = vision;
        addRequirements(m_drivetrain, m_vision);

        kpSteer = Shuffleboard.getTab("Align").add("Steer KP", steeringKP).getEntry();
        minTa = Shuffleboard.getTab("Align").add("Minmum TA", targetArea).getEntry();
        kpDrive = Shuffleboard.getTab("Align").add("Drive KP", driveKP).getEntry();
    }

    @Override
    public void initialize() {
        steeringKP = kpSteer.getDouble(0);
        targetArea = minTa.getDouble(0);
        driveKP = kpDrive.getDouble(0);
    }

    @Override
    public void execute() {
        double steer = m_vision.getTx() * steeringKP;
        double drive = (targetArea - m_vision.getTa()) * driveKP;

        Shuffleboard.getTab("Align").add("Steer", steer).getEntry().forceSetDouble(steer);
        Shuffleboard.getTab("Align").add("Drive", drive).getEntry().forceSetDouble(drive);
        Shuffleboard.getTab("Align").add("Target Area", m_vision.getTa()).getEntry();

        if(m_vision.hasValidTarget()) {
            if(m_vision.getTa() >= targetArea) {
                steer = 0.0;
                drive = 0.0;
            } 
        } else {
            steer = 0.0;
            drive = 0.0;
        }
        m_drivetrain.arcadeDrive(drive, steer);
    }

    @Override
    public void end(boolean interrupted) {
        m_drivetrain.arcadeDrive(0.0, 0.0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}