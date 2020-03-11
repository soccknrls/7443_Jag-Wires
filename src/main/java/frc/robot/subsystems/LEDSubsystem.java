package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LEDSubsystem extends SubsystemBase {

    private static Spark m_led = null;

    public LEDSubsystem(int port) {
        m_led = new Spark(port);
    }

    public void setColor(double color) {
        System.out.println("Changing LED Color to: " + color);
        m_led.set(color);
    }
}