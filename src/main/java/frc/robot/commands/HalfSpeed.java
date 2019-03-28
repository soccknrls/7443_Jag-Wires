package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.RobotMap;

public class HalfSpeed extends Command{
    
    public HalfSpeed(){
    }

    protected void initialize(){
        System.out.println("[Command] Switching to half speed");
    }

    protected void execute(){
        OI.setSpeed(RobotMap.ROBOT_SPEED*.75);
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