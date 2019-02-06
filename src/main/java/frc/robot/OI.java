package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Button;


public class OI {

    //Joystick
    public Joystick m_Joystick = new Joystick(RobotMap.JOYSTICK_PORT);

    //Button mappings
    Button fullSpeedButton = new JoystickButton(m_Joystick,1);
    Button halfSpeedButton = new JoystickButton(m_Joystick,2);
    Button approachSpeedButton = new JoystickButton(m_Joystick,4);
    
    Button popPatchPanelButton = new JoystickButton(m_Joystick,3);

    public OI() {
        fullSpeedButton.whenPressed(new setFullSpeed());
        halfSpeedButton.whenPressed(new setHalfSpeed());
        approachSpeedButton.whenPressed(new setApproachSpeed());
        popPatchPanelButton.whenPressed(new popPatchPanel());
    }
}