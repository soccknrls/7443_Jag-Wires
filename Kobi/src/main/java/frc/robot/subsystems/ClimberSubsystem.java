package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.AnalogInput;

public class ClimberSubsystem extends SubsystemBase {

    TalonSRX climberMotor = new TalonSRX(Constants.AuxConstants.kClimberMotorPort);
    DoubleSolenoid climbPiston;
    AnalogInput pressureSensor;

    public ClimberSubsystem() {
        climberMotor.configFactoryDefault();
        climbPiston = new DoubleSolenoid(Constants.PneumaticConstants.kPistonForwardPort, Constants.PneumaticConstants.kPistonReversePort);
        pressureSensor = new AnalogInput(Constants.AuxConstants.kPressureSensorPort);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("PSI", getAirPressure());
        
    }

    
    public void runClimber(double speed) {
        climberMotor.set(ControlMode.PercentOutput, speed);
    }

    public void stopClimber() {
        climberMotor.set(ControlMode.PercentOutput, 0);
    }

    public void liftClimber() {
        climbPiston.set(Value.kReverse);
    }

    public void lowerClimber() {
        climbPiston.set(Value.kForward);
    }

    public double getAirPressure() {
        return 250.0 * pressureSensor.getVoltage() / 5.0 - 25.0;
    }
}
