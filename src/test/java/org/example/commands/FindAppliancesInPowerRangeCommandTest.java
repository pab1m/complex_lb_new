package org.example.commands;

import org.example.appliance.Appliance;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class FindAppliancesInPowerRangeCommandTest {

    @Test
    public void testExecute() {
        List<Appliance> appliances = new ArrayList<>();
        appliances.add(new Appliance("Appliance 1", 100));
        appliances.add(new Appliance("Appliance 2", 150));
        appliances.add(new Appliance("Appliance 3", 200));

        FindAppliancesInPowerRangeCommand findCommand = new FindAppliancesInPowerRangeCommand(appliances);

        String input = "120\n180\n";
        InputStream originalSystemIn = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
        PrintStream originalSystemOut = System.out;
        System.setOut(new PrintStream(consoleOutput));

        findCommand.execute();

        System.setIn(originalSystemIn);
        System.setOut(originalSystemOut);

        String actualOutput = consoleOutput.toString();

        assertTrue(actualOutput.contains("Прилади у заданому діапазоні потужностей:"));
        assertTrue(actualOutput.contains("{name='Appliance 2', power=150.0}"));
    }
}
