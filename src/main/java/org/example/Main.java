package org.example;

import org.example.appliance.Appliance;
import org.example.commands.*;
import org.example.commands.ApplianceInvoker;

import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        ApplianceInvoker invoker = new ApplianceInvoker();

        AddApplianceCommand addAppliance = new AddApplianceCommand();
        List<Appliance> appliances = addAppliance.getAppliances();
        Command deleteAppliance = new DeleteApplianceCommand(appliances);
        Command showAAppliance = new ShowAppliances(appliances);
        Command plugIn = new PlugInCommand(appliances);
        Command plugOut = new PlugOutCommand(appliances);
        Command calculatePower = new CalculationOfPowerConsumptionCommand(appliances);
        Command sortByCapacity = new SortByCapacityCommand(appliances);
        Command findInPowerRange = new FindAppliancesInPowerRangeCommand(appliances);


        Menu menu = new Menu();
        menu.addCommand("1", "Додати прилад в квартиру", () -> invoker.executeCommand(addAppliance));
        menu.addCommand("2", "Видалити прилад з квартири", () -> invoker.executeCommand(deleteAppliance));
        menu.addCommand("3", "Показати список приладів у квартирі", () -> invoker.executeCommand(showAAppliance));
        menu.addCommand("4", "Ввімкнути прилад в розетку", () -> invoker.executeCommand(plugIn));
        menu.addCommand("5", "Вимкнути прилад з розетки", () -> invoker.executeCommand(plugOut));
        menu.addCommand("6", "Порахувати споживану потужність", () -> invoker.executeCommand(calculatePower));
        menu.addCommand("7", "Посортувати прилади", () -> invoker.executeCommand(sortByCapacity));
        menu.addCommand("8", "Знайти прилади у заданому діапазоні", () -> invoker.executeCommand(findInPowerRange));
        menu.addCommand("9", "Вихід з програми", () -> System.exit(0));

        while (true) {
            menu.printMenu();
            String choice = new Scanner(System.in).nextLine();
            menu.executeCommand(choice);
        }
    }
}
