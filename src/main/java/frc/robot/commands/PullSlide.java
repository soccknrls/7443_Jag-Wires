package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class PullSlide extends Command{
    
    public PullSlide(){
    }

    protected void initialize(){
        System.out.println("[Command] Pulling the slide in");
    }

    protected void execute(){
        Robot.m_slide.pullSlide(Robot.oi.dPadDown());
    }

    protected void interrupted(){
        end();
    }

    protected void end(){
        System.out.println("[Command] Fisished pulling the slide");
    }

    protected boolean isFinished(){
        return true;
    }
}