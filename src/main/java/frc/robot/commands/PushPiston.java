package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class PushPiston extends Command{

    public PushPiston(){
    }

    protected void initialize(){
        System.out.println("[Command] Pushing Hatch");
    }

    protected void execute(){
        Robot.m_piston.pushHatch();
    }

    protected void interrupted(){
        end();
    }
    
    protected void end(){
        System.out.println("[Command] Finished pushing Hatch");
    }

    protected boolean isFinished(){
        return true;
    }
}