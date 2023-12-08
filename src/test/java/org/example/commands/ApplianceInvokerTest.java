package org.example.commands;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class ApplianceInvokerTest {

    @Test
    public void testExecuteCommand() {
        Command command = mock(Command.class);

        ApplianceInvoker applianceInvoker = new ApplianceInvoker();
        applianceInvoker.executeCommand(command);

        verify(command, times(1));
    }
}
