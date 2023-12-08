package org.example.commands;

import org.example.appliance.Appliance;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DeleteApplianceCommandTest {

    private final InputStream originalSystemIn = System.in;
    private final InputStream mockInput = new ByteArrayInputStream("Test Appliance\n".getBytes());

    @Before
    public void setUp() {
        System.setIn(mockInput);
    }

    @After
    public void tearDown() {
        System.setIn(originalSystemIn);
    }

    @Test
    public void testExecuteApplianceDeleted() {
        List<Appliance> appliances = new ArrayList<>();
        Appliance appliance = new Appliance("Test Appliance", 100);
        appliances.add(appliance);

        DeleteApplianceCommand deleteCommand = new DeleteApplianceCommand(appliances);
        deleteCommand.execute();

        assertEquals(0, appliances.size());
    }


    @Test
    public void testExecuteApplianceNotDeleted() {
        List<Appliance> appliances = new ArrayList<>();
        Appliance testAppliance = new Appliance("Test Appliance", 100);
        appliances.add(testAppliance);

        System.setIn(new ByteArrayInputStream("Different Appliance\n".getBytes()));

        DeleteApplianceCommand deleteCommand = new DeleteApplianceCommand(appliances);
        deleteCommand.execute();

        assertEquals(1, appliances.size());
    }
}
