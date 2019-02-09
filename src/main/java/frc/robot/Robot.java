package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
//import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.Compressor;
//import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//import frc.robot.commands.TankDrive;
import frc.robot.subsystem.DriveTrain;
import frc.robot.subsystem.Piston;
import frc.robot.subsystem.Slide; 
import frc.robot.RobotMap;

public class Robot extends TimedRobot {

  public static Compressor m_compressor; 
  public static DriveTrain m_driveTrain;
  public static OI oi;
  public static CameraServer cam;
  public static Piston m_piston;
  public static Slide m_slide;
  

  public void robotInit() {

    oi = new OI();
    m_driveTrain = new DriveTrain();
    m_piston = new Piston();
    m_slide = new Slide();

    m_compressor = new Compressor(RobotMap.PCM_PORT);
    m_compressor.start();
  
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