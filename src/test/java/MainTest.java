import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class MainTest {

    @Test
    void work() throws IOException {
        DataAsker dataAsker = mock(DataAsker.class);
        when(dataAsker.ask("Введите итоговый сепаратор:")).thenReturn("*");
        when(dataAsker.ask("Введите путь к файлу:")).thenReturn("data.txt");
        when(dataAsker.ask("Введите путь создания:")).thenReturn("result.txt");
        when(dataAsker.ask("Введите сепаратор:")).thenReturn(",");

        Main.work(dataAsker);

        verify(dataAsker).ask("Введите итоговый сепаратор:");
        verify(dataAsker).ask("Введите путь к файлу:");
        verify(dataAsker).ask("Введите путь создания:");
        verify(dataAsker).ask("Введите сепаратор:");
        File file = new File("src/main/resources/result.txt");
        Scanner scan= new Scanner(file);
        List<String> lines= new ArrayList<>();
        while (scan.hasNext()) {
            lines.add(scan.nextLine());
        }
        assertEquals(lines.get(0), "2*2*0*9");
        assertEquals(lines.get(1), "2*2*2*10");
        assertEquals(lines.get(2), "2*2*1*9");
        assertEquals(lines.get(3), "2*2*13");
        assertEquals(lines.get(4), "2*2*10");
    }
}