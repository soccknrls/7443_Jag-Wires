package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LEDSubsystem extends SubsystemBase {

    private static Spark m_ledSpark = null;

    public LEDSubsystem(int port) {
        m_ledSpark = new Spark(port);
    }

    public void setColor(double color) {
        m_ledSpark.set(color);
    }

    public boolean allianceColor() {
        boolean isRed = NetworkTableInstance.getDefault().getTable("FMSInfo").getEntry("IsRedAlliance").getBoolean(true);
        return isRed;
    }
}