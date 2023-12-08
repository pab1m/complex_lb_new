package org.example.commands;

import org.example.appliance.Appliance;

import java.util.List;


public class CalculationOfPowerConsumptionCommand implements Command {
    private final List<Appliance> appliances;

    public CalculationOfPowerConsumptionCommand(List<Appliance> appliances) {
        this.appliances = appliances;
    }
    private double totalPower = 0;

    @Override
    public void execute() {
        for (Appliance appliance : appliances) {
            if (appliance.isPluggedIn()) {
                totalPower += appliance.getPower();
            }
        }
        System.out.println("Загальна споживана потужність: \u001B[32m" + totalPower + " Вт \u001B[0m");
    }

    public double getTotalPower() {
        return totalPower;
    }
}
