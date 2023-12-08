package org.example.commands;

import org.example.appliance.Appliance;

import java.util.List;

public class ShowAppliances implements Command{

    private final List<Appliance> appliances;
    public ShowAppliances(List<Appliance> appliances) {
        this.appliances = appliances;
    }

    @Override
    public void execute() {
        if (appliances.isEmpty()) {
            System.out.println("\nНемає приладів. Спочатку додайте прилади до приміщення.");
            return;
        }

        System.out.println("\nСписок приладів у квартирі:");
        for (Appliance appliance : appliances) {
            if (appliance.isPluggedIn()) {
                System.out.println("\u001B[32m" + appliance + "\u001B[0m - увімкнено");
            } else {
                System.out.println("\u001B[31m" + appliance + "\u001B[0m - вимкнено");
            }
        }

    }
}
