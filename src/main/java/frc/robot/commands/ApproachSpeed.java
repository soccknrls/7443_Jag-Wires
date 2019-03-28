package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.RobotMap;

public class ApproachSpeed extends Command{
    
    public ApproachSpeed(){
    }

    protected void initialize(){
        System.out.println("[Command] Switching to approach speed");
    }

    protected void execute(){
        OI.setSpeed(RobotMap.ROBOT_SPEED*.5);
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