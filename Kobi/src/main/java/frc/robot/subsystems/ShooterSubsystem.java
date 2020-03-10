package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANEncoder;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
// import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants.ShooterConstants;

public class ShooterSubsystem extends PIDSubsystem {

    private final CANSparkMax leftShooterMotor = new CANSparkMax(ShooterConstants.kLeftShooterPort, MotorType.kBrushless);
    private final CANSparkMax rightShooterMotor = new CANSparkMax(ShooterConstants.kRightShooterPort, MotorType.kBrushless);

    private final CANEncoder leftShooterEncoder = new CANEncoder(leftShooterMotor);
    private final CANEncoder rightShooterEncoder = new CANEncoder(rightShooterMotor);

    private final SimpleMotorFeedforward feedForward = new SimpleMotorFeedforward(ShooterConstants.kSVolts, ShooterConstants.kVVoltSecondsPerRotation);

    public ShooterSubsystem() {
        super(new PIDController(ShooterConstants.kShooterP, ShooterConstants.kShooterI, ShooterConstants.kShooterD));
        getController().setTolerance(ShooterConstants.kShooterToleranceRPS);
        setSetpoint(ShooterConstants.kShooterTargetRPS);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Left Encoder", leftShooterEncoder.getVelocity());
        SmartDashboard.putNumber("Right Encoder", -rightShooterEncoder.getVelocity());
    }

    @Override
    public void useOutput(double output, double setpoint) {
        leftShooterMotor.setVoltage(output + feedForward.calculate(setpoint));
        rightShooterMotor.setVoltage(output + feedForward.calculate(setpoint));
    }

    public void runMotors(double speed) {
        leftShooterMotor.set(speed);
        rightShooterMotor.set(-speed);
    }

    public boolean atSetpoint() {
        return m_controller.atSetpoint();
    }

    @Override
    protected double getMeasurement() {
        return 0;
    }
}