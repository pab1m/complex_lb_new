package org.example.commands;

import org.example.appliance.Appliance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddApplianceCommand implements Command {
    private final List<Appliance> appliances = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.print("\nВведіть назву приладу: ");
        String name = scanner.nextLine();
        System.out.print("Введіть потужність приладу (Вт): ");
        double power = scanner.nextDouble();
        scanner.nextLine();

        Appliance newAppliance = new Appliance(name, power);
        appliances.add(newAppliance);
        System.out.println("Прилад додано до квартири: " + newAppliance);

    }

    public List<Appliance> getAppliances() {
        return appliances;
    }
}
