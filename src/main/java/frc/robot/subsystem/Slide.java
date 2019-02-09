package frc.robot.subsystem;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import frc.robot.RobotMap;

public class Slide extends Subsystem{

    private VictorSPX m_slideMotor;

    public Slide(){
        m_slideMotor = new VictorSPX(RobotMap.SLIDE_MOTOR_ID);
    }

    public void moveSlide(double power){
        m_slideMotor.set(ControlMode.PercentOutput, power);
    }

    public void initDefaultCommand(){
    }
}