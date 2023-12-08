package org.example.commands;

import org.example.appliance.Appliance;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class ShowAppliancesTest {

    @Test
    public void testExecute() {
        List<Appliance> appliances = new ArrayList<>();
        appliances.add(new Appliance("Appliance 1", 100));
        appliances.add(new Appliance("Appliance 2", 150));
        appliances.add(new Appliance("Appliance 3", 200));

        ShowAppliances showCommand = new ShowAppliances(appliances);

        ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
        PrintStream originalSystemOut = System.out;
        System.setOut(new PrintStream(consoleOutput));

        appliances.get(0).plugIn();

        showCommand.execute();

        System.setOut(originalSystemOut);


        assertEquals("Appliance 1\u001B[32m увімкнено \u001B[0m\r\n" +
                "\nСписок приладів у квартирі:\r\n" +
                "\u001B[32m" + "{name='Appliance 1', power=100.0}\u001B[0m - увімкнено\r\n" +
                "\u001B[31m" + "{name='Appliance 2', power=150.0}\u001B[0m - вимкнено\r\n" +
                "\u001B[31m" + "{name='Appliance 3', power=200.0}\u001B[0m - вимкнено\r\n", consoleOutput.toString());
    }
}
