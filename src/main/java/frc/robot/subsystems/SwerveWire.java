package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.geometry.Translation2d;
import edu.wpi.first.wpilibj.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.kinematics.SwerveDriveKinematics;
import edu.wpi.first.wpilibj.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import frc.robot.commands.SwerveDrive;
import frc.robot.drivers.Gyroscope;
import frc.robot.drivers.SwerveModule;
import frc.robot.drivers.Vector2;
import frc.robot.drivers.SwerveWireModuleBuilder;
import frc.robot.drivers.NavX;

public class SwerveWire extends Subsystem {
    private static final double TRACKWIDTH = 19.5;
    private static final double WHEELBASE = 23.5;

    private static SwerveWire instance;

    private final SwerveModule frontLeftModule = new SwerveWireModuleBuilder(
            new Vector2(TRACKWIDTH / 2.0, WHEELBASE / 2.0))
            .angleEncoder(new AnalogInput(Constants.MODULE_4_TURN_ENCODER), Constants.MODULE_4_ANGLE_OFFSET)
            .angleMotor(new CANSparkMax(Constants.MODULE_4_TURN_CANID, CANSparkMaxLowLevel.MotorType.kBrushless),
                    SwerveWireModuleBuilder.MotorType.NEO)
            .driveMotor(new CANSparkMax(Constants.MODULE_4_DRIVE_CANID, CANSparkMaxLowLevel.MotorType.kBrushless),
                    SwerveWireModuleBuilder.MotorType.NEO)
            .build();
    private final SwerveModule frontRightModule = new SwerveWireModuleBuilder(
            new Vector2(TRACKWIDTH / 2.0, WHEELBASE / 2.0))
            .angleEncoder(new AnalogInput(Constants.MODULE_1_TURN_ENCODER), Constants.MODULE_1_ANGLE_OFFSET)
            .angleMotor(new CANSparkMax(Constants.MODULE_1_TURN_CANID, CANSparkMaxLowLevel.MotorType.kBrushless),
                    SwerveWireModuleBuilder.MotorType.NEO)
            .driveMotor(new CANSparkMax(Constants.MODULE_1_DRIVE_CANID, CANSparkMaxLowLevel.MotorType.kBrushless),
                    SwerveWireModuleBuilder.MotorType.NEO)
            .build();
    private final SwerveModule backLeftModule = new SwerveWireModuleBuilder(
            new Vector2(TRACKWIDTH / 2.0, WHEELBASE / 2.0))
            .angleEncoder(new AnalogInput(Constants.MODULE_3_TURN_ENCODER), Constants.MODULE_3_ANGLE_OFFSET)
            .angleMotor(new CANSparkMax(Constants.MODULE_3_TURN_CANID, CANSparkMaxLowLevel.MotorType.kBrushless),
                    SwerveWireModuleBuilder.MotorType.NEO)
            .driveMotor(new CANSparkMax(Constants.MODULE_3_DRIVE_CANID, CANSparkMaxLowLevel.MotorType.kBrushless),
                    SwerveWireModuleBuilder.MotorType.NEO)
            .build();
    private final SwerveModule backRightModule = new SwerveWireModuleBuilder(
            new Vector2(TRACKWIDTH / 2.0, WHEELBASE / 2.0))
            .angleEncoder(new AnalogInput(Constants.MODULE_2_TURN_ENCODER), Constants.MODULE_2_ANGLE_OFFSET)
            .angleMotor(new CANSparkMax(Constants.MODULE_2_TURN_CANID, CANSparkMaxLowLevel.MotorType.kBrushless),
                    SwerveWireModuleBuilder.MotorType.NEO)
            .driveMotor(new CANSparkMax(Constants.MODULE_2_DRIVE_CANID, CANSparkMaxLowLevel.MotorType.kBrushless),
                    SwerveWireModuleBuilder.MotorType.NEO)
            .build();

    private final SwerveDriveKinematics kinematics = new SwerveDriveKinematics(
            new Translation2d(TRACKWIDTH / 2.0, WHEELBASE / 2.0),
            new Translation2d(TRACKWIDTH / 2.0, -WHEELBASE / 2.0),
            new Translation2d(-TRACKWIDTH / 2.0, WHEELBASE / 2.0),
            new Translation2d(-TRACKWIDTH / 2.0, -WHEELBASE / 2.0)
    );

    private final Gyroscope gyroscope = new NavX(SPI.Port.kMXP);

    public SwerveWire() {
        gyroscope.calibrate();
        gyroscope.setInverted(true); // You might not need to invert the gyro

        frontLeftModule.setName("Module 4");
        frontRightModule.setName("Module 1");
        backLeftModule.setName("Module 3");
        backRightModule.setName("Module 2");
    }

    public static SwerveWire getInstance() {
        if (instance == null) {
            instance = new SwerveWire();
        }

        return instance;
    }

    @Override
    public void periodic() {
        frontLeftModule.updateSensors();
        frontRightModule.updateSensors();
        backLeftModule.updateSensors();
        backRightModule.updateSensors();

        SmartDashboard.putNumber("Module 4 Angle", Math.toDegrees(frontLeftModule.getCurrentAngle()));
        SmartDashboard.putNumber("Module 1 Angle", Math.toDegrees(frontRightModule.getCurrentAngle()));
        SmartDashboard.putNumber("Module 3 Angle", Math.toDegrees(backLeftModule.getCurrentAngle()));
        SmartDashboard.putNumber("Module 2 Angle", Math.toDegrees(backRightModule.getCurrentAngle()));

        SmartDashboard.putNumber("Gyroscope Angle", gyroscope.getAngle().toDegrees());

        frontLeftModule.updateState(TimedRobot.kDefaultPeriod);
        frontRightModule.updateState(TimedRobot.kDefaultPeriod);
        backLeftModule.updateState(TimedRobot.kDefaultPeriod);
        backRightModule.updateState(TimedRobot.kDefaultPeriod);
    }

    public void drive(Translation2d translation, double rotation, boolean fieldOriented) {
        rotation *= 2.0 / Math.hypot(WHEELBASE, TRACKWIDTH);
        ChassisSpeeds speeds;
        if (fieldOriented) {
            speeds = ChassisSpeeds.fromFieldRelativeSpeeds(translation.getX(), translation.getY(), rotation,
                    Rotation2d.fromDegrees(gyroscope.getAngle().toDegrees()));
        } else {
            speeds = new ChassisSpeeds(translation.getX(), translation.getY(), rotation);
        }

        SwerveModuleState[] states = kinematics.toSwerveModuleStates(speeds);
        frontLeftModule.setTargetVelocity(states[0].speedMetersPerSecond, states[0].angle.getRadians());
        frontRightModule.setTargetVelocity(states[1].speedMetersPerSecond, states[1].angle.getRadians());
        backLeftModule.setTargetVelocity(states[2].speedMetersPerSecond, states[2].angle.getRadians());
        backRightModule.setTargetVelocity(states[3].speedMetersPerSecond, states[3].angle.getRadians());
    }

    public void resetGyroscope() {
        gyroscope.setAdjustmentAngle(gyroscope.getUnadjustedAngle());
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new SwerveDrive());
    }
}