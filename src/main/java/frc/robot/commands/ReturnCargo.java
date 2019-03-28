package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ReturnCargo extends Command{

    public ReturnCargo(){
    }

    protected void initialize(){
        System.out.println("[Command] Returning Cargo...");
    }

    protected void execute(){
        Robot.m_piston.returnCargo();
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