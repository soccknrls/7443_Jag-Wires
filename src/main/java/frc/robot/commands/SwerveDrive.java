package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.subsystems.SwerveWire;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.geometry.Translation2d;
import frc.robot.drivers.Utilities;

public class SwerveDrive extends Command {

    public SwerveDrive() {
        requires(SwerveWire.getInstance());
    }

    @Override
    protected void execute() {
        double forward = -Robot.getRobotContainer().getJoystick().getRawAxis(1);
        forward = Utilities.deadband(forward);
        // Square the forward stick
        forward = Math.copySign(Math.pow(forward, 2.0), forward);

        double strafe = -Robot.getRobotContainer().getJoystick().getRawAxis(0);
        strafe = Utilities.deadband(strafe);
        // Square the strafe stick
        strafe = Math.copySign(Math.pow(strafe, 2.0), strafe);

        double rotation = -Robot.getRobotContainer().getJoystick().getRawAxis(4);
        rotation = Utilities.deadband(rotation);
        // Square the rotation stick
        rotation = Math.copySign(Math.pow(rotation, 2.0), rotation);

        SwerveWire.getInstance().drive(new Translation2d(forward, strafe), rotation, true);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}