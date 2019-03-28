package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.RobotMap;

public class FullSpeed extends Command{
    
    public FullSpeed(){
    }

    protected void initialize(){
        System.out.println("[Command] Switching to full speed");
    }

    protected void execute(){
        OI.setSpeed(RobotMap.ROBOT_SPEED);
    }

    protected void interrupted(){
        end();
    }

    protected void end(){
        System.out.println("[Command] Switching gears");
    }

    protected boolean isFinished(){
        return true;
    }
}