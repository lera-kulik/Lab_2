import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FormatterTest {

    @Test
    void format() {
        Formatter formatter = new Formatter();
        String expected="2+2+0+9\n";

        String actual = formatter.format(Arrays.asList("10", "AU", "", "Australia"),"+");

        assertEquals(expected, actual);
    }
}