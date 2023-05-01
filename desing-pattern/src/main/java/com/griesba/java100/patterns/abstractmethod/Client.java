package com.griesba.java100.patterns.abstractmethod;

import java.util.ArrayList;
import java.util.List;

public abstract class Client {
    protected List<Command> commands = new ArrayList<>();

    protected abstract Command createCommand(double amount);

    public void newCommand(double amount) {
        Command command = this.createCommand(amount);
        if (command.valid()) {
            command.pay();
            commands.add(command);
        }
    }
}
