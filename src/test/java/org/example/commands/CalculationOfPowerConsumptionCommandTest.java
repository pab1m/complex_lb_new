package org.example.commands;

import org.example.appliance.Appliance;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CalculationOfPowerConsumptionCommandTest {

    private final InputStream originalSystemIn = System.in;
    private final InputStream mockInput = new ByteArrayInputStream("Test Appliance\n100\n".getBytes());

    @Before
    public void setUp() {
        System.setIn(mockInput);
    }

    @After
    public void tearDown() {
        System.setIn(originalSystemIn);
    }

    @Test
    public void testCalculationOfPower() {

        List<Appliance> appliances = new ArrayList<>();

        Appliance appliance1 = new Appliance("Test Appliance1", 100);
        Appliance appliance2 = new Appliance("Test Appliance2", 200);
        appliances.add(appliance1);
        appliances.add(appliance2);

        for (Appliance appliance: appliances){
            appliance.plugIn();
        }

        CalculationOfPowerConsumptionCommand calculationOfPower = new CalculationOfPowerConsumptionCommand(appliances);
        calculationOfPower.execute();

        assertEquals(300.0, calculationOfPower.getTotalPower(), 0.001);
    }

}