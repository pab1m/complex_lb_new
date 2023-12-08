package org.example;

import org.example.commands.Command;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final List<String> options = new ArrayList<>();
    private final List<String> descriptions = new ArrayList<>();
    private final List<Command> commands = new ArrayList<>();

    public void addCommand(String option, String description, Command command) {
        options.add(option);
        descriptions.add(description);
        commands.add(command);
    }

    public void printMenu() {
        System.out.println("\nВиберіть опцію: ");
        for (int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i) + ". " + descriptions.get(i));
        }
    }

    public void executeCommand(String choice){
        int index = options.indexOf(choice);
        if (index >= 0 && index < commands.size()) {
            commands.get(index).execute();
        } else {
            System.out.println("Невірний вибір. Спробуйте ще раз.");
        }
    }
}
