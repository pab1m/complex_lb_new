package org.example.commands;

import org.example.appliance.Appliance;

import java.util.List;
import java.util.Scanner;

public class FindAppliancesInPowerRangeCommand implements Command {
    private final List<Appliance> appliances;


    public FindAppliancesInPowerRangeCommand(List<Appliance> appliances) {
        this.appliances = appliances;
    }


    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nВведіть мінімальну потужність: ");
        double minPower = scanner.nextDouble();

        System.out.print("Введіть максимальну потужність: ");
        double maxPower = scanner.nextDouble();

        System.out.println("\nПрилади у заданому діапазоні потужностей:");
        for (Appliance appliance : appliances) {
            if (appliance.getPower() >= minPower && appliance.getPower() <= maxPower) {
                System.out.println(appliance);
            }
        }
    }
}