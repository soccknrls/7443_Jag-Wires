package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class MoveSlide extends Command{
    
    public MoveSlide(){
    }

    protected void initialize(){
        System.out.println("[Command] Slide motor moving");
    }

    protected void execute(){
        Robot.m_slide.moveSlide(Robot.oi.getLeftTriggerAxis());
        //Robot.m_slide.moveSlide(-(Robot.oi.getRightTriggerAxis()));
    }

    protected void interrupted(){
        end();
    }

    protected void end(){
        System.out.println("[Command] Fisished moving Slide");
    }

    protected boolean isFinished(){
        return true;
    }
}