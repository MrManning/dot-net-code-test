package DotNet;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class LetterOccurrencesTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void isValid() throws InvalidInput {
        new LetterOccurrences("'e' and \"I have some cheese\"");
        new LetterOccurrences("'rg' and \"I like to eat cheese.\"");
    }

    @Test(expected = InvalidInput.class)
    public void isNotValid() throws InvalidInput {
        new LetterOccurrences("and \"I like to eat cheese.\"");
    }

    @Test
    public void countOccurrences() throws InvalidInput {
        Occurrences occur;
        occur = new LetterOccurrences("'e' and \"I have some cheese\"");
        assertEquals(5, Integer.parseInt(occur.countOccurrences()));
    }
}