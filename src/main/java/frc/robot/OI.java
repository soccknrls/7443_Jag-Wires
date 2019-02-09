package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import frc.robot.commands.PushPiston;
import frc.robot.commands.ReturnPiston;

public class OI {

    //Joystick
    private Joystick m_Joystick = new Joystick(RobotMap.JOYSTICK_PORT);

    //Button mappings
    //private JoystickButton fullSpeedButton = new JoystickButton(m_Joystick,1);
    //private JoystickButton halfSpeedButton = new JoystickButton(m_Joystick,2);
    //private JoystickButton approachSpeedButton = new JoystickButton(m_Joystick,4);
    private JoystickButton pistonButton = new JoystickButton(m_Joystick,RobotMap.PISTON_BUTTON);

    public double m_Speed = .7;

    public OI() {
        //fullSpeedButton.whenPressed(new setFullSpeed());
        //halfSpeedButton.whenPressed(new setHalfSpeed());
        //approachSpeedButton.whenPressed(new setApproachSpeed());
        pistonButton.whenPressed(new PushPiston());
        pistonButton.whenReleased(new ReturnPiston());
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
        return getControllerAxis(RobotMap.SLIDE_IN_TRIGGER);
    }

    public double getRightTriggerAxis(){
        return getControllerAxis(RobotMap.SLIDE_OUT_TRIGGER);
    }
}