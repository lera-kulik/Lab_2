import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Test
    void parseLine1() {
        List<String> expected=(Arrays.asList("10", "AU", "", "Au\"stralia"));

        List<String> actual =Parser.parseLine("10,AU,,Au\"\"stralia\n",',','\"');

        assertEquals(expected, actual);
    }

    @Test
    void parseLine3() {
        List<String> expected=(Arrays.asList("14 \"AU \"Aus,tralia"));

        List<String> actual =Parser.parseLine("\"14\" \"AU\" \"Aus,tralia\"",',','\"');

        assertEquals(expected, actual);
    }
}