package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class TankDrive extends Command {

	public TankDrive(){
		requires(Robot.m_driveTrain);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void execute(){
		Robot.m_driveTrain.tankDrive(Robot.oi.getLeftYAxis(), Robot.oi.getRightYAxis());
	}

	public void stop(){
		Robot.m_driveTrain.tankDrive(0, 0);
	}
}