package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class LiftRobot extends Command{
    
    public LiftRobot(){
        requires(Robot.m_liftMotors);
    }

    protected boolean isFinished() {
		return false;
	}

    protected void execute(){
		Robot.m_liftMotors.motorLift(Robot.oi.getLeftTriggerAxis(), Robot.oi.getRightTriggerAxis());
	}

	public void stop(){
		Robot.m_liftMotors.motorLift(0,0);
    }
}