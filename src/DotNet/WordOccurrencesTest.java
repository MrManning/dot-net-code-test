package DotNet;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class WordOccurrencesTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void isValid() throws InvalidInput {
        new WordOccurrences("{\"dog\", \"cat\", \"large\"} and \"I have a cat named Meow and a dog name Woof. I love the dog a lot. He is larger than a small horse.\"");
    }

    @Test(expected = InvalidInput.class)
    public void isNotValid() throws InvalidInput {
        new WordOccurrences("'rg' and \"I like to eat cheese.\"");
    }

    @Test
    public void countOccurrences() throws InvalidInput {
        Occurrences occur;
        occur = new WordOccurrences("{\"dog\", \"cat\", \"large\"} and \"I have a cat named Meow and a dog name Woof. I love the dog a lot. He is larger than a small horse.\"");
        assertEquals("cat: 1, dog: 2, large: 1, total: 4", occur.countOccurrences());

        // censoredWords = Arrays.asList("small", "21312", " ", "");
        // actual = tasks.wordOccurrence(censoredWords, "A small brown but small animal. A small black dog. ");
        // // assertThat(actual, is(not(Arrays.asList(null,10,0,3))));
        // assertNotEquals(": null, : 10, 21312: 0, small: 3, total: 13", actual);
        //
        // censoredWords = Arrays.asList("an", "animal", "100");
        // actual = tasks.wordOccurrence(censoredWords, "An animal lives for 100 years and another animal lives for many. I want one.");
        // // assertThat(actual, is(Arrays.asList(1,7,2)));
        // assertEquals("100: 1, an: 7, animal: 2, total: 10", actual);
    }
}