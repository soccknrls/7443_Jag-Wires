package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class IntakeSubsystem extends SubsystemBase {

    TalonSRX intakeMotor = new TalonSRX(Constants.AuxConstants.kIntakeMotorPort);
    TalonSRX topFeederMotor = new TalonSRX(Constants.AuxConstants.kTopFeederMotorPort);
    TalonSRX bottomFeederMotor = new TalonSRX(Constants.AuxConstants.kBottomFeederMotorPort);

    public IntakeSubsystem() {
        intakeMotor.configFactoryDefault();
        topFeederMotor.configFactoryDefault();
        bottomFeederMotor.configFactoryDefault();

        bottomFeederMotor.follow(topFeederMotor);
    }
    
    public void runIntake(double speed) {
        intakeMotor.set(ControlMode.PercentOutput, speed);
    }

    public void stopIntake() {
        intakeMotor.set(ControlMode.PercentOutput, 0);
    }

    public void runFeeder(double speed) {
        topFeederMotor.set(ControlMode.PercentOutput, speed);
    }

    public void stopFeeder() {
        topFeederMotor.set(ControlMode.PercentOutput, 0);
    }
}
