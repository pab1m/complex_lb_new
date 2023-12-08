package org.example.commands;

import org.example.appliance.Appliance;

import java.util.List;
import java.util.Scanner;

public class DeleteApplianceCommand implements Command {
    private final List<Appliance> appliances;
    private final Scanner scanner = new Scanner(System.in);

    public DeleteApplianceCommand(List<Appliance> appliances) {
        this.appliances = appliances;
    }


    @Override
    public void execute() {
        if (appliances.isEmpty()) {
            System.out.println("\nНемає приладів для видалення. Спочатку додайте прилади до приміщення.");
            return;
        }


        System.out.println("\nОберіть прилад для видалення:");

        for (Appliance appliance : appliances) {
            if (!appliance.isPluggedIn()){
                System.out.println(appliance);
            }
        }

        System.out.print("\nВиберіть ім'я приладу для видалення: ");

        String selectedDeviceName = scanner.nextLine();
        Appliance selectedAppliance = findApplianceByName(selectedDeviceName);

        if (selectedAppliance != null) {
            appliances.remove(selectedAppliance);
            System.out.println("\nВидалений прилад з приміщення: " + selectedAppliance);
        } else {
            System.out.println("\nПрилад з іменем " + selectedDeviceName + " не знайдено.");
        }

    }

    private Appliance findApplianceByName(String name) {
        for (Appliance appliance : appliances) {
            if (appliance.getName().equalsIgnoreCase(name) && !appliance.isPluggedIn()) {
                return appliance;
            }
        }
        return null;
    }

//    public List<Appliance> getAppliances() {
//        return appliances;
//    }


}
