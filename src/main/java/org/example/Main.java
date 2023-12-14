package org.example;

import org.example.appliance.Appliance;
import org.example.commands.*;
import org.example.commands.Command;
import org.example.commands.ApplianceInvoker;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
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
        menu.addCommand("1", "Додати прилад в квартиру", () -> executeAndLogCommand(addAppliance, invoker));
        menu.addCommand("2", "Видалити прилад з квартири", () -> executeAndLogCommand(deleteAppliance, invoker));
        menu.addCommand("3", "Показати список приладів у квартирі", () -> executeAndLogCommand(showAAppliance, invoker));
        menu.addCommand("4", "Ввімкнути прилад в розетку", () -> executeAndLogCommand(plugIn, invoker));
        menu.addCommand("5", "Вимкнути прилад з розетки", () -> executeAndLogCommand(plugOut, invoker));
        menu.addCommand("6", "Порахувати споживану потужність", () -> executeAndLogCommand(calculatePower, invoker));
        menu.addCommand("7", "Посортувати прилади", () -> executeAndLogCommand(sortByCapacity, invoker));
        menu.addCommand("8", "Знайти прилади у заданому діапазоні", () -> executeAndLogCommand(findInPowerRange, invoker));
        menu.addCommand("9", "Вихід з програми", () -> System.exit(0));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            menu.printMenu();
            String choice = scanner.nextLine();
            executeAndLogRunnable(()-> menu.executeCommand(choice), "Обрана опція: " + choice);
        }
    }
    private static void executeAndLogCommand(Command command, ApplianceInvoker invoker) {
        try {
            invoker.executeCommand(command);
            logger.info("Команда виконана успішно: {}", command.getClass().getSimpleName());
        } catch (Exception e) {
            logger.error("Сталася помилка при виконанні команди: {}", command.getClass().getSimpleName(), e);
        }
    }

    private static void executeAndLogRunnable(Runnable action, String logMessage) {
        try {
            logger.info(logMessage);
            action.run();
        } catch (Exception e) {
            logger.error("Сталася помилка: {}", logMessage, e);
        }
    }
}
