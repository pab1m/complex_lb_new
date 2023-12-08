package org.example.commands;

import org.example.appliance.Appliance;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AddApplianceCommandTest {

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
    public void testExecute() {
        AddApplianceCommand addApplianceCommand = new AddApplianceCommand();
        addApplianceCommand.execute();

        List<Appliance> appliances = addApplianceCommand.getAppliances();

        Appliance addedAppliance = appliances.get(0);
        assertEquals("Test Appliance", addedAppliance.getName());
        assertEquals(100.0, addedAppliance.getPower(), 0.001);
    }
}
