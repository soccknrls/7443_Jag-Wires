package frc.robot;

public class RobotMap {

  //Robot Speed
  public static final double ROBOT_SPEED = .8;

  //Motors CAN ID's
  public static final int LEFT_FRONT_MOTOR_ID = 4;
  public static final int LEFT_BACK_MOTOR_ID = 2;
  public static final int RIGHT_FRONT_MOTOR_ID = 1;
  public static final int RIGHT_BACK_MOTOR_ID = 3;

  //JoyStick Port
  public static final int JOYSTICK_PORT = 0;

  //Joystick Button Mappings
  public static final int LEFT_DRIVE_STICK = 1;
  public static final int RIGHT_DRIVE_STICK = 5;

  //Pneumatic Buttons
  public static final int HATCH_PISTON_BUTTON = 3;
  public static final int FRONT_LIFT_PISTON = 1;
  public static final int REAR_LIFT_PISTON = 2;
  public static final int CARGO_PISTON_BUTTON = 8;
  
  //Gear Change
  public static final int FULL_SPEED_BUTTON = 5;
  public static final int HALF_SPEED_BUTTON = 6;
  public static final int APPROACH_SPEED_BUTTON = 4;
  
  //Pneumatics
  public static final int PCM_PORT = 0;
  public static final int SOLENOID_FORWARD_PORT = 4;
  public static final int SOLENOID_REVERSE_PORT = 7;
  public static final int REAR_LIFT_FORWARD_PORT = 2;
  public static final int REAR_LIFT_REVERSE_PORT = 5;
  public static final int FRONT_LIFT_FORWARD_PORT = 3;
  public static final int FRONT_LIFT_REVERSE_PORT = 6;
  public static final int CARGO_LIFT_FORWARD_PORT = 0;
  public static final int CARGO_LIFT_REVERSE_PORT = 1;
}