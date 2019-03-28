package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import frc.robot.commands.PushPiston;
import frc.robot.commands.ReturnPiston;
import frc.robot.commands.LiftCargo;
import frc.robot.commands.ReturnCargo;
import frc.robot.commands.FullSpeed;
import frc.robot.commands.HalfSpeed;
import frc.robot.commands.ApproachSpeed;

public class OI {

    //Joystick
    private Joystick m_Joystick = new Joystick(RobotMap.JOYSTICK_PORT);

    //Button mappings
    private JoystickButton fullSpeedButton = new JoystickButton(m_Joystick,RobotMap.FULL_SPEED_BUTTON);
    private JoystickButton halfSpeedButton = new JoystickButton(m_Joystick,RobotMap.HALF_SPEED_BUTTON);
    private JoystickButton approachSpeedButton = new JoystickButton(m_Joystick,RobotMap.APPROACH_SPEED_BUTTON);

    private JoystickButton pistonButton = new JoystickButton(m_Joystick,RobotMap.PISTON_BUTTON);
    private JoystickButton cargoButton = new JoystickButton(m_Joystick,RobotMap.CARGO_PISTON_BUTTON);

    //Set default speed
    public static double m_Speed = RobotMap.ROBOT_SPEED;

    public OI() {
        
        //Associate button actions to Commands
        pistonButton.whenPressed(new PushPiston());
        pistonButton.whenReleased(new ReturnPiston());

        cargoButton.whenPressed(new LiftCargo());
        cargoButton.whenReleased(new ReturnCargo());
        
        fullSpeedButton.whenPressed(new FullSpeed());
        halfSpeedButton.whenPressed(new HalfSpeed());
        approachSpeedButton.whenPressed(new ApproachSpeed());
               
    }

    public static void setSpeed(double speed){
        m_Speed = speed;
    }

    public double getControllerAxis(int axis) {

        double axes = Math.min(-(m_Joystick.getRawAxis(axis)) * m_Speed, 1);
        return axes;
    }

    public double getLeftYAxis(){
        return getControllerAxis(RobotMap.LEFT_DRIVE_STICK);
    }

    public double getRightYAxis(){
        return getControllerAxis(RobotMap.RIGHT_DRIVE_STICK);
    }

    public double getLeftTriggerAxis(){
        return getControllerAxis(RobotMap.LIFT_FRONT_TRIGGER);
    }

    public double getRightTriggerAxis(){
        return getControllerAxis(RobotMap.LIFT_REAR_TRIGGER);
    }
}