package frc.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoSource;
import edu.wpi.first.cameraserver.CameraServer;
//import edu.wpi.first.cameraserver.CameraServerShared;
//import edu.wpi.first.cameraserver.CameraServerSharedStore;
import edu.wpi.first.wpilibj.TimedRobot;
//import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStation;
///import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;

//import frc.robot.commands.TankDrive;
import frc.robot.subsystem.DriveTrain;
import frc.robot.subsystem.Piston;
import frc.robot.RobotMap;

public class Robot extends TimedRobot {

  public static Compressor m_compressor; 
  public static DriveTrain m_driveTrain;
  public static OI oi;
  public static UsbCamera camera1;
  public static UsbCamera camera2;
  public static Piston m_piston;
  public static AHRS m_ahrs;
  
  public void robotInit() {

    oi = new OI();
    m_driveTrain = new DriveTrain();
    m_piston = new Piston();
    try {
      m_ahrs = new AHRS(SPI.Port.kMXP);
    } catch (RuntimeException ex ) {
      DriverStation.reportError("Error with navX: " + ex.getMessage(), true);
    }

    SmartDashboard.putBoolean("NavX Connection: ", m_ahrs.isConnected());
    SmartDashboard.putBoolean("NavX Calibrating: ", m_ahrs.isCalibrating());
    SmartDashboard.putNumber("Heading: ", m_ahrs.getCompassHeading());
    SmartDashboard.putNumber("Pitch: ", m_ahrs.getPitch());
    SmartDashboard.putNumber("Roll: ", m_ahrs.getRoll());
    SmartDashboard.putNumber("Yaw: ", m_ahrs.getYaw());
    SmartDashboard.putNumber("Angle: ", m_ahrs.getAngle());

    m_compressor = new Compressor(RobotMap.PCM_PORT);
    m_compressor.start();
  
    camera1 = CameraServer.getInstance().startAutomaticCapture(0);
    camera1.setConnectionStrategy(VideoSource.ConnectionStrategy.kKeepOpen);
    camera1.setFPS(25);
    camera1.setBrightness(25);
    camera1.setExposureManual(10);
    camera1.setWhiteBalanceManual(10);

    camera2 = CameraServer.getInstance().startAutomaticCapture(1);
    camera2.setConnectionStrategy(VideoSource.ConnectionStrategy.kKeepOpen);
    camera2.setFPS(25);
    camera2.setBrightness(25);
    camera2.setExposureManual(10);
    camera2.setWhiteBalanceManual(10);
  }

  @Override
	public void disabledInit() {
  }

  @Override
	public void disabledPeriodic() {
  }

  @Override
  public void robotPeriodic(){
    Scheduler.getInstance().run();
  }

  @Override
	public void teleopInit() {

  }

  @Override
	public void teleopPeriodic() {
  }

  @Override
	public void testPeriodic() {
  }
}