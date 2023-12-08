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

public class SortByCapacityCommandTest {

    private final InputStream originalSystemIn = System.in;

    @After
    public void tearDown() {
        System.setIn(originalSystemIn);
    }

    @Test
    public void testSortAscending() {
        List<Appliance> appliances = new ArrayList<>();

        Appliance appliance1 = new Appliance();
        appliance1.setName("Appliance 1");
        appliance1.setPower(150);

        appliances.add(appliance1);
        appliances.add(new Appliance("Appliance 2", 100));
        appliances.add(new Appliance("Appliance 3", 200));

        System.setIn(new ByteArrayInputStream("1\n".getBytes()));

        SortByCapacityCommand sortCommand = new SortByCapacityCommand(appliances);
        sortCommand.execute();

        double p1 = appliances.get(0).getPower();
        double p2 = appliances.get(1).getPower();
        double p3 = appliances.get(2).getPower();

        assertEquals(100, p1, 0.001);
        assertEquals(150, p2, 0.001);
        assertEquals(200, p3, 0.001);

    }

    @Test
    public void testSortDescending() {
        List<Appliance> appliances = new ArrayList<>();
        appliances.add(new Appliance("Appliance 1", 150));
        appliances.add(new Appliance("Appliance 2", 100));
        appliances.add(new Appliance("Appliance 3", 200));

        System.setIn(new ByteArrayInputStream("2\n".getBytes()));

        SortByCapacityCommand sortCommand = new SortByCapacityCommand(appliances);
        sortCommand.execute();

        double p1 = appliances.get(0).getPower();
        double p2 = appliances.get(1).getPower();
        double p3 = appliances.get(2).getPower();

        assertEquals(200, p1, 0.001);
        assertEquals(150, p2, 0.001);
        assertEquals(100, p3, 0.001);

    }

}
