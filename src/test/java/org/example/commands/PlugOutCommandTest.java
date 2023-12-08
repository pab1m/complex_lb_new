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

public class PlugOutCommandTest {

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
    public void testExecuteAppliancePlugOut() {
        List<Appliance> appliances = new ArrayList<>();
        Appliance appliance = new Appliance("Test Appliance", 100);
        appliance.plugIn();
        appliances.add(appliance);


        PlugOutCommand plugOutCommand = new PlugOutCommand(appliances);
        plugOutCommand.execute();


        assertFalse(appliances.get(0).isPluggedIn());

    }

}