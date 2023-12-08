package org.example.commands;

import org.example.appliance.Appliance;

import java.util.List;
import java.util.Scanner;


public class PlugInCommand implements Command {
    private final List<Appliance> appliances;
    private final Scanner scanner = new Scanner(System.in);

    public PlugInCommand(List<Appliance> appliances) {
        this.appliances = appliances;
    }


    @Override
    public void execute() {
        if (appliances.isEmpty()) {
            System.out.println("\nНемає приладів для підключення. Спочатку додайте прилади до приміщення.");
            return;
        }

        System.out.println("\nОберіть прилад для підключення:");

        for (Appliance appliance : appliances) {
            if (!appliance.isPluggedIn()) {
                System.out.println(appliance);
            }
        }

        System.out.print("\nВиберіть ім'я приладу: ");

        String selectedDeviceName = scanner.nextLine();
        Appliance selectedAppliance = findApplianceByName(selectedDeviceName);

        if (selectedAppliance != null) {
            selectedAppliance.plugIn();
            System.out.println("\nПідключені прилади до мережі: ");
            for (Appliance appliance : appliances) {
                if (appliance.isPluggedIn()) {
                    System.out.println(appliance);
                }
            }
        } else {
            System.out.println("\nПрилад з іменем '" + selectedDeviceName + "' не знайдено.");
        }
    }


    private Appliance findApplianceByName(String name) {
        for (Appliance appliance : appliances) {
            if (appliance.getName().equals(name) && !appliance.isPluggedIn()) {
                return appliance;
            }
        }
        return null;
    }
}
