package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public class RobotContainer {

    private Joystick joystick = new Joystick(Constants.JOYSTICK_PORT);

    public RobotContainer() {
    }

    public Joystick getJoystick() {
        return joystick;
    }
}
