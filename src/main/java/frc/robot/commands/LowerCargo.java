package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class LowerCargo extends Command{

    public LowerCargo(){
    }

    protected void initialize(){
        System.out.println("[Command] Lower Cargo");
    }

    protected void execute(){
        Robot.m_piston.lowerCargo();
    }

    protected void interrupted(){
        end();
    }
    
    protected void end(){
        System.out.println("[Command] Finished Lower Cargo");
    }

    protected boolean isFinished(){
        return true;
    }
}