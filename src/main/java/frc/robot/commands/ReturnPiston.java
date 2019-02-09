package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ReturnPiston extends Command{

    public ReturnPiston(){
    }

    protected void initialize(){
        System.out.println("[Command] Returning Piston...");
    }

    protected void execute(){
        Robot.m_piston.returnPiston();
    }

    protected void interrupted(){
        end();
    }
    protected void end(){
        System.out.println("[Command] Finished returning Piston");
    }

    protected boolean isFinished(){
        return true;
    }
}