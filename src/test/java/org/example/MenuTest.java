package org.example;

import org.example.commands.Command;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MenuTest {

    private Menu menu;

    @Before
    public void setUp() {
        menu = new Menu();
    }

    @Test
    public void testAddCommandAndPrintMenu() {
        Command mockCommand = mock(Command.class);
        when(mockCommand.toString()).thenReturn("Mock Command");

        menu.addCommand("1", "Додати прилад в квартиру", mockCommand);

        InputStream originalSystemIn = System.in;
        PrintStream originalSystemOut = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setIn(new ByteArrayInputStream("1\n".getBytes()));
        System.setOut(new PrintStream(outputStream));

        String expectedMenuOutput = "\nВиберіть опцію: \r\n1. Додати прилад в квартиру\r\n";

        menu.printMenu();
        menu.executeCommand("1");

        assertEquals(expectedMenuOutput, outputStream.toString());

        verify(mockCommand, times(1)).execute();

        System.setIn(originalSystemIn);
        System.setOut(originalSystemOut);
    }
}
