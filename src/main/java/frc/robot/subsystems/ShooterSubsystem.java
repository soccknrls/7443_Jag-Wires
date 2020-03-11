package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMaxLowLevel.PeriodicFrame;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import frc.robot.Constants.ShooterConstants;

public class ShooterSubsystem extends SubsystemBase {

    private final CANSparkMax leftShooterMotor, rightShooterMotor;
    private CANEncoder leftShooterEncoder, rightShooterEncoder;
    private CANPIDController leftPIDController, rightPIDController;
    public double setPoint;


    public ShooterSubsystem() {
        leftShooterMotor = new CANSparkMax(ShooterConstants.kLeftShooterPort, MotorType.kBrushless);
        leftShooterMotor.restoreFactoryDefaults();
        leftShooterMotor.setIdleMode(IdleMode.kCoast);
        leftShooterMotor.setSmartCurrentLimit(60);
        leftShooterMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus0, 5);
        leftShooterMotor.burnFlash();
        leftShooterEncoder = leftShooterMotor.getEncoder();
        leftPIDController = leftShooterMotor.getPIDController();
        leftPIDController.setP(Constants.ShooterConstants.kleftP);
        leftPIDController.setI(Constants.ShooterConstants.kleftI);
        leftPIDController.setD(Constants.ShooterConstants.kleftD);
        leftPIDController.setIz(Constants.ShooterConstants.kleftIz);
        leftPIDController.setFF(Constants.ShooterConstants.kleftFF);
        leftPIDController.setOutputRange(Constants.ShooterConstants.kleftMinOut, Constants.ShooterConstants.kleftMaxOut);

        rightShooterMotor = new CANSparkMax(ShooterConstants.kRightShooterPort, MotorType.kBrushless);
        rightShooterMotor.restoreFactoryDefaults();
        rightShooterMotor.setIdleMode(IdleMode.kCoast);
        rightShooterMotor.setSmartCurrentLimit(60);
        rightShooterMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus0, 5);
        rightShooterMotor.burnFlash();
        rightShooterEncoder = rightShooterMotor.getEncoder();
        rightPIDController = rightShooterMotor.getPIDController();
        rightPIDController.setP(Constants.ShooterConstants.krightP);
        rightPIDController.setI(Constants.ShooterConstants.krightI);
        rightPIDController.setD(Constants.ShooterConstants.krightD);
        rightPIDController.setIz(Constants.ShooterConstants.krightIz);
        rightPIDController.setFF(Constants.ShooterConstants.krightFF);
        rightPIDController.setOutputRange(Constants.ShooterConstants.krightMinOut, Constants.ShooterConstants.krightMaxOut);

        SmartDashboard.putNumber("Left P", leftPIDController.getP());
        SmartDashboard.putNumber("Right P", rightPIDController.getP());
    }

    public void runMotors(double desiredRPM) {
        setPoint = desiredRPM;

        leftPIDController.setReference(setPoint, ControlType.kVelocity);
        rightPIDController.setReference(setPoint, ControlType.kVelocity);

        SmartDashboard.putNumber("Setpoint", setPoint);
        SmartDashboard.putNumber("Left Output Current", leftShooterMotor.getOutputCurrent());
        SmartDashboard.putNumber("Right Output Current", rightShooterMotor.getOutputCurrent());
    }

    public void stopMotors() {
        leftShooterMotor.set(0.0);
        rightShooterMotor.set(0.0;)
    }

    public void periodic() {
        SmartDashboard.putNumber("Left Velocity", leftShooterEncoder.getVelocity());
        SmartDashboard.putNumber("Right Velocity", rightShooterEncoder.getVelocity());
    }

    public boolean leftAtSpeed() {
        if(((setPoint - leftShooterEncoder.getVelocity()) <= 250) && ((setPoint - rightShooterEncoder.getVelocity()) <= 250)) {
            return true;
        } else {
            return false;
        }
    }
}