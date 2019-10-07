package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class LowerFront extends Command{

    public LowerFront(){
    }

    protected void initialize(){
        System.out.println("[Command] Returning Cargo...");
    }

    protected void execute(){
        Robot.m_piston.lowerFront();
    }

    protected void interrupted(){
        end();
    }
    protected void end(){
        System.out.println("[Command] Finished returning Cargo");
    }

    protected boolean isFinished(){
        return true;
    }
}