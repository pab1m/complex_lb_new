package org.example.commands;

import org.example.appliance.Appliance;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SortByCapacityCommand implements Command {
    private final List<Appliance> appliances;
    private final Scanner scanner = new Scanner(System.in);

    public SortByCapacityCommand(List<Appliance> appliances) {
        this.appliances = appliances;
    }

    @Override
    public void execute() {

        System.out.println("Оберіть сортування:");
        System.out.println("1. За зростанням");
        System.out.println("2. За спаданням");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                sortAscending();
                break;
            case 2:
                sortDescending();
                break;
            default:
                System.out.println("Невірний вибір.");
        }
    }

    private void sortAscending() {
//        appliances.sort((a1, a2) -> Double.compare(a1.getPower(), a2.getPower()));

        appliances.sort(Comparator.comparingDouble(Appliance::getPower));
        System.out.println("Сортування за зростанням:");
        for (Appliance appliance : appliances) {
            System.out.println(appliance);
        }
    }

    private void sortDescending() {
        appliances.sort(Comparator.comparingDouble(Appliance::getPower).reversed());
        System.out.println("Сортування за спаданням:");
        for (Appliance appliance : appliances) {
            System.out.println(appliance);
        }
    }


}
