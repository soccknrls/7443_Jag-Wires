package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import frc.robot.commands.PushPiston;
import frc.robot.commands.ReturnPiston;
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

    public static double m_Speed = .7;

    public OI() {
        pistonButton.whenPressed(new PushPiston());
        pistonButton.whenReleased(new ReturnPiston());
        
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

    public int dPadUp(){
        if ((m_Joystick.getPOV(RobotMap.DPAD_POV) >= 315 || m_Joystick.getPOV(RobotMap.DPAD_POV) <= 45) && m_Joystick.getPOV(RobotMap.DPAD_POV) != -1){
            return 1;
        } else{
            return 0;
        }
    }

    public int dPadDown(){
        if (m_Joystick.getPOV(RobotMap.DPAD_POV) >= 135 && m_Joystick.getPOV(RobotMap.DPAD_POV) <= 225){
            return -1;
        } else{
            return 0;
        }
    }
    /*public double getLeftTriggerAxis(){
        return getControllerAxis(RobotMap.SLIDE_IN_TRIGGER);
    }

    public double getRightTriggerAxis(){
        return getControllerAxis(RobotMap.SLIDE_OUT_TRIGGER);
    }*/
}