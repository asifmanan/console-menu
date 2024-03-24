package io.consolemenu;

public class ConsoleMenuTest {
// Need to work with mockito. for now manually tested with inputs and tests passed.



//    @Test
//    public void testInitialize() throws IOException {
//        Terminal mockTerminal = mock(Terminal.class);
//        LineReader mockLineReader = mock(LineReader.class);
//        Menu mockMenu = mock(Menu.class);
//
//        // Using doReturn().when() for stubbing
//        doReturn(mockTerminal).when(TerminalManager.getTerminal());
//        doReturn(mockLineReader).when(TerminalManager.getLineReader());
//        doReturn(true).when(mockMenu).getBreakLoopFlag();
//        doReturn("Menu Options").when(mockMenu).displayMenuOptions();
//
//        ConsoleMenu consoleMenu = new ConsoleMenu(mockMenu);
//        consoleMenu.initialize();
//
//        verify(mockTerminal, times(1)).flush();
//        verify(mockTerminal, times(1)).puts(InfoCmp.Capability.clear_screen);
//        verify(mockMenu, times(1)).displayMenuOptions();
//    }


//    @Test
//    public void testInitialize() throws IOException {
//        Terminal mockTerminal = mock(Terminal.class);
//        LineReader mockLineReader = mock(LineReader.class);
//        Menu mockMenu = mock(Menu.class);
//
//        when(TerminalManager.getTerminal()).thenReturn(mockTerminal);
//        when(TerminalManager.getLineReader()).thenReturn(mockLineReader);
//        when(mockMenu.getBreakLoopFlag()).thenReturn(true);  // To break the loop after one iteration
//        when(mockMenu.displayMenuOptions()).thenReturn("Menu Options");
//
//        ConsoleMenu consoleMenu = new ConsoleMenu(mockMenu);
//        consoleMenu.initialize();
//
//        verify(mockTerminal, times(1)).flush();
//        verify(mockTerminal, times(1)).puts(InfoCmp.Capability.clear_screen);
//        verify(mockMenu, times(1)).displayMenuOptions();
//    }
}
