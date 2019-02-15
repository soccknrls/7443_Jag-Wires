package frc.robot;

public class RobotMap {

  //Motors CAN ID's
  public static final int LEFT_FRONT_MOTOR_ID = 0;
  public static final int LEFT_BACK_MOTOR_ID = 2;
  public static final int RIGHT_FRONT_MOTOR_ID = 1;
  public static final int RIGHT_BACK_MOTOR_ID = 3;
  public static final int SLIDE_MOTOR_ID = 6;
  
  //PWM Motor Ports
  public static final int LIFT_FRONT_MOTOR_ID = 0;
  public static final int LIFT_BACK_MOTOR_ID = 1;

  //JoyStick Port
  public static final int JOYSTICK_PORT = 0;

  //Joystick Button Mappings
  public static final int LEFT_DRIVE_STICK = 1;
  public static final int RIGHT_DRIVE_STICK = 5;

  //Pneumatic Control
  public static final int PISTON_BUTTON = 3;
  
  //Gear Change
  public static final int FULL_SPEED_BUTTON = 5;
  public static final int HALF_SPEED_BUTTON = 6;
  public static final int APPROACH_SPEED_BUTTON = 4;
  
  //Pneumatics
  public static final int PCM_PORT = 0;
  public static final int SOLENOID_FORWARD_PORT = 4;
  public static final int SOLENOID_REVERSE_PORT = 7;
  
  //Lift mechanism
  public static final int LIFT_FRONT_TRIGGER = 3;
  public static final int LIFT_REAR_TRIGGER = 2;
  
  //public static final int DRIVE_MODE = 1; //1 is tankDrive, 2 is arcadeDrive
}