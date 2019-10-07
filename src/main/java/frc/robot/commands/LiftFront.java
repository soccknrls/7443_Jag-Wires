package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class LiftFront extends Command{

    public LiftFront(){
    }

    protected void initialize(){
        System.out.println("[Command] Lifting Cargo");
    }

    protected void execute(){
        Robot.m_piston.liftFront();;
    }

    protected void interrupted(){
        end();
    }
    
    protected void end(){
        System.out.println("[Command] Finished Lifting Cargo");
    }

    protected boolean isFinished(){
        return true;
    }
}