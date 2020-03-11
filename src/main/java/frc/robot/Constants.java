/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.util.Units;

public final class Constants {
  public static final class DriveConstants {
    public static final int kLeftMotorFrontPort = 1;
    public static final int kLeftMotorBackPort = 2;
    public static final int kRightMotorFrontPort = 4;
    public static final int kRightMotorBackPort = 3;
    public static final double kWheelDiameterInches = 6;
    public static final double kWidthBetweenWheelsMeters = Units.inchesToMeters(22);
    public static final double kMaxVelocityMeters = Units.feetToMeters(2);
    public static final double kMaxAccelerationMeters = Units.feetToMeters(2);
    public static final double kP = 0.449;
  }

  public static final class ShooterConstants {
    public static final int kLeftShooterPort = 5;
    public static final int kRightShooterPort = 6;

    public static final double kleftP = 0;
    public static final double kleftI = 0;
    public static final double kleftD = 0;
    public static final double kleftIz = 0;
    public static final double kleftFF = 0;
    public static final double kleftMaxOut = 0;
    public static final double kleftMinOut = 0;

    public static final double krightP = 0;
    public static final double krightI = 0;
    public static final double krightD = 0;
    public static final double krightIz = 0;
    public static final double krightFF = 0;
    public static final double krightMaxOut = 0;
    public static final double krightMinOut = 0;
  }

  public static final class PneumaticConstants {
    public static final int pcmPort = 0;
    public static final int kPistonForwardPort = 0;
    public static final int kPistonReversePort = 1;
  }
  
  public static final class AuxConstants {
    public static final int kColorWheelMotorPort = 7;
    public static final int kIntakeMotorPort = 8;
    public static final int kTopFeederMotorPort = 11;
    public static final int kBottomFeederMotorPort = 9;
    public static final int kClimberMotorPort = 10;
    public static final int kPressureSensorPort = 3;
    
    public static final double kIntakeMotorSpeed = .9;
    public static final double kFeederMotorSpeed = .5;
    public static final double kColorWheelMotorSpeed = .5;
    public static final double kClimberMotorSpeed = .99;
  }

  public static final class JoystickButtons {
    public static final int kDriverControllerPort = 0;
    public static final int kForwardAxis = 1;
    public static final int kTurnAxis = 2;
    public static final int kShooterAxis = 3;

    public static final int kShooterButton = 1;
    public static final int kTurboButton = 2;
    public static final int kSlowSpeedButton = 3;
    public static final int kPistonDownButton = 4;
    public static final int kFullSpeedButton = 5; 
    public static final int kPistonUpButton = 6;
    public static final int kIntakeButton = 7;
    public static final int kReverseIntakeButton = 8;
    public static final int kElevatorUpButton = 10;
    public static final int kElevatorDownButton = 9;
    public static final int kFeederUpButton = 11;
    public static final int kFeederDownButton = 12;
  }

  public static final class LED {
    public static final int k5vLEDPWMPort = 1;
    public static final int k12vLEDPWMPort = 0;

    public static final double confetti = -0.87;
    public static final double red_shot = -0.85;
    public static final double blue_shot = -0.83;
    public static final double red = 0.61;
    public static final double sky_blue = 0.83;
    public static final double blue = 0.87;
  }
}
