package frc.robot.subsystem;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

import frc.robot.RobotMap;
import frc.robot.commands.TankDrive;

public class DriveTrain extends Subsystem {

    //Motors
    private CANSparkMax m_FrontLeftMotor;
    private CANSparkMax m_FrontRightMotor;
    private CANSparkMax m_BackLeftMotor;
    private CANSparkMax m_BackRightMotor;

    private DifferentialDrive m_RobotDrive;

    public DriveTrain() {

        //Initialize Motors
        m_FrontLeftMotor = new CANSparkMax(RobotMap.LEFT_FRONT_MOTOR_ID, MotorType.kBrushless);
        m_FrontRightMotor = new CANSparkMax(RobotMap.RIGHT_FRONT_MOTOR_ID, MotorType.kBrushless);
        m_BackLeftMotor = new CANSparkMax(RobotMap.LEFT_BACK_MOTOR_ID, MotorType.kBrushless);
        m_BackRightMotor = new CANSparkMax(RobotMap.RIGHT_BACK_MOTOR_ID, MotorType.kBrushless);

        SpeedControllerGroup leftMotors = new SpeedControllerGroup(m_FrontLeftMotor, m_BackLeftMotor);
        SpeedControllerGroup rightMotors = new SpeedControllerGroup(m_FrontRightMotor, m_BackRightMotor);

        m_RobotDrive= new DifferentialDrive(leftMotors, rightMotors);
    }

    public void tankDrive(double leftPower, double rightPower) {
		m_RobotDrive.tankDrive(leftPower, rightPower);
		System.out.println("[Subsystem] Driving in tank mode, left: " + leftPower + ", right: " + rightPower);
	}
    @Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new TankDrive());
    }
    
}
