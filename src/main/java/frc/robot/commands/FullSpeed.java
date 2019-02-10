package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;

public class FullSpeed extends Command{
    
    public FullSpeed(){
    }

    protected void initialize(){
        System.out.println("[Command] Switching to full speed");
    }

    protected void execute(){
        OI.setSpeed(0.7);
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