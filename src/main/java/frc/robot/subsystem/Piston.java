package frc.robot.subsystem;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Piston extends Subsystem{

    DoubleSolenoid pistonSolenoid;

    public Piston(){
        pistonSolenoid = new DoubleSolenoid(RobotMap.SOLENOID_FORWARD_PORT , RobotMap.SOLENOID_REVERSE_PORT);
    }

    public void pushHatch(){
        pistonSolenoid.set(Value.kForward);
    }

    public void returnPiston(){
        pistonSolenoid.set(Value.kReverse);
    }

    public void initDefaultCommand(){
    }
}