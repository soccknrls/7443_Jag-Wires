package frc.robot.commands;

import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TankDrive extends Command {

	public TankDrive(){
		requires(Robot.driveTrain);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	protected void execute(){
		Robot.driveTrain.tankDrive(Robot.oi.getLeftStickY(), Robot.oi.getRightStickY());
	}

	public void stop(){
		Robot.driveTrain.tankDrive(0, 0);
	}
}