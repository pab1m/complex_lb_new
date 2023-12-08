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

public class PlugInCommandTest {

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
    public void testExecuteAppliancePlugIn() {
        List<Appliance> appliances = new ArrayList<>();
        Appliance appliance = new Appliance("Test Appliance", 100);
        appliances.add(appliance);

        PlugInCommand plugInCommand = new PlugInCommand(appliances);
        plugInCommand.execute();

        assertTrue(appliances.get(0).isPluggedIn());

    }

}