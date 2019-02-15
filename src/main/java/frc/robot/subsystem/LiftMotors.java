package frc.robot.subsystem;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.VictorSP;

import frc.robot.RobotMap;
import frc.robot.commands.LiftRobot;

public class LiftMotors extends Subsystem{
    
    private VictorSP m_frontLiftMotor;
    private VictorSP m_rearLiftMotor;

    private DifferentialDrive m_liftMotorDiff;
    
    public LiftMotors(){

        //Initialize Motors
        m_frontLiftMotor = new VictorSP(RobotMap.LIFT_FRONT_MOTOR_ID);
        m_rearLiftMotor = new VictorSP(RobotMap.LIFT_BACK_MOTOR_ID);

        m_liftMotorDiff = new DifferentialDrive(m_frontLiftMotor, m_rearLiftMotor);
    }

    public void motorLift(double frontPower, double rearPower){
        m_liftMotorDiff.tankDrive(frontPower, rearPower);
    }

    public void initDefaultCommand(){
        setDefaultCommand(new LiftRobot());
    }
}