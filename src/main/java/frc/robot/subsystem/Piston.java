package frc.robot.subsystem;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Piston extends Subsystem{

    DoubleSolenoid pistonSolenoid;
    DoubleSolenoid rearLiftSolenoid;
    DoubleSolenoid frontLiftSolenoid;
    DoubleSolenoid cargoLiftSolenoid;

    public Piston(){
        pistonSolenoid = new DoubleSolenoid(RobotMap.SOLENOID_FORWARD_PORT , RobotMap.SOLENOID_REVERSE_PORT);
        rearLiftSolenoid = new DoubleSolenoid(RobotMap.REAR_LIFT_FORWARD_PORT, RobotMap.REAR_LIFT_REVERSE_PORT);
        frontLiftSolenoid = new DoubleSolenoid(RobotMap.FRONT_LIFT_FORWARD_PORT, RobotMap.FRONT_LIFT_REVERSE_PORT);
        cargoLiftSolenoid = new DoubleSolenoid(RobotMap.CARGO_LIFT_FORWARD_PORT, RobotMap.CARGO_LIFT_REVERSE_PORT);
    }

    public void pushHatch(){
        pistonSolenoid.set(Value.kForward);
    }

    public void returnPiston(){
        pistonSolenoid.set(Value.kReverse);
    }

    public void liftFront(){
        frontLiftSolenoid.set(Value.kForward);
    }

    public void lowerFront(){
        frontLiftSolenoid.set(Value.kReverse);
    }

    public void liftRear(){
        rearLiftSolenoid.set(Value.kReverse);
    }

    public void lowerRear(){
        rearLiftSolenoid.set(Value.kForward);
    }

    public void liftCargo(){
        cargoLiftSolenoid.set(Value.kForward);
    }

    public void lowerCargo(){
        cargoLiftSolenoid.set(Value.kReverse);
    }
    
    public void initDefaultCommand(){
    }
}