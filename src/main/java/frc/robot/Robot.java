package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
//import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
//import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//import frc.robot.commands.TankDrive;
import frc.robot.subsystem.DriveTrain;

public class Robot extends TimedRobot {

  public static DriveTrain m_driveTrain;
  public static OI oi;
  public static CameraServer cam;

  public void robotInit() {

    oi = new OI();
    m_driveTrain = new DriveTrain();
    CameraServer.getInstance().startAutomaticCapture();
  }

  @Override
	public void disabledInit() {
  }

  @Override
	public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void robotPeriodic(){
  }

  @Override
	public void teleopInit() {
  }

  @Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
  }

  @Override
	public void testPeriodic() {
  }
}