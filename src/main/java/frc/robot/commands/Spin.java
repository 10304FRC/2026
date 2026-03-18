package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.*;
import frc.robot.Constants.SpindexerConstants;
import frc.robot.subsystems.CANSpindexerSubsystem;

public class Spin extends Command {
    private CANSpindexerSubsystem sub;

    public Spin(CANSpindexerSubsystem subsystem) {
        addRequirements(subsystem);
        sub = subsystem;
    }

    @Override
    public void initialize() {
        sub.controller.set(SpindexerConstants.SPEED);
    }

    @Override
    public void execute() {

    }

    @Override
    public void end(boolean interrupted) {
        sub.controller.set(0);
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
