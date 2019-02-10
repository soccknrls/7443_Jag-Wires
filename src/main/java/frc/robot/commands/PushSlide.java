package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class PushSlide extends Command{
    
    public PushSlide(){
    }

    protected void initialize(){
        System.out.println("[Command] Pushing the slide out");
    }

    protected void execute(){
        Robot.m_slide.pushSlide(Robot.oi.dPadUp());
    }

    protected void interrupted(){
        end();
    }

    protected void end(){
        System.out.println("[Command] Fisished pushing the slide");
    }

    protected boolean isFinished(){
        return true;
    }
}