package dot_net;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertNotEquals;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class dot_net_tasksTest {
    private dot_net_tasks tasks;

    @Before
    public void setUp() {
        tasks = new dot_net_tasks();
    }

    @Test
    public void letterOccurrences() {
        int occurrences;

        occurrences = tasks.letterOccurrences('e', "I have some cheese");
        assertEquals(5, occurrences);
    }

    @Test
    public void isPalindrome() {
        assertFalse(tasks.isPalindrome("I have some cheese"));
        assertTrue(tasks.isPalindrome("God saved Eva’s dog"));
        assertTrue(tasks.isPalindrome("121"));
        assertTrue(tasks.isPalindrome("877868778"));
    }

    @Test
    public void wordOccurrences() {
        List<String> censoredWords = Arrays.asList("dog", "cat", "large");
        String actual = tasks.wordOccurrence(censoredWords, "I have a cat named Meow and a dog name Woof. I love the dog a lot. He is larger than a small horse.");
        // assertThat(actual, is(Arrays.asList(1,2,1)));
        assertEquals("cat: 1, dog: 2, large: 1, total: 4", actual);

        censoredWords = Arrays.asList("small", "21312", " ", "");
        actual = tasks.wordOccurrence(censoredWords, "A small brown but small animal. A small black dog. ");
        // assertThat(actual, is(not(Arrays.asList(null,10,0,3))));
        assertNotEquals(": null, : 10, 21312: 0, small: 3, total: 13", actual);

        censoredWords = Arrays.asList("an", "animal", "100");
        actual = tasks.wordOccurrence(censoredWords, "An animal lives for 100 years and another animal lives for many. I want one.");
        // assertThat(actual, is(Arrays.asList(1,7,2)));
        assertEquals("100: 1, an: 7, animal: 2, total: 10", actual);
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void censor() {
        List<String> censoredWords = Arrays.asList("meow", "woof");
        String actual = tasks.censor(censoredWords, "I have a cat named Meow and a dog name Woof. I love the dog a lot. He is larger than a small horse.");
        assertEquals("I have a cat named M$$w and a dog name W$$f. I love the dog a lot. He is larger than a small horse.", actual);

        censoredWords = Arrays.asList("small", "short", "tall");
        actual = tasks.censor(censoredWords, "Short, small and tall people are all the same but smaller and taller people are different.");
        assertThat(actual, is(not(equalTo("S$$$t, s$$$l and t$$l people are all the same but s$$$ler and t$$ler people are different."))));

        censoredWords = Collections.singletonList("");
        expectedException.expect(NegativeArraySizeException.class);
        actual = tasks.censor(censoredWords, "Short, small and tall people are all the same but smaller and taller people are different.");
    }

    @Test
    public void censorPalindrome() {
        String actual = tasks.censorPalindrome("Anna went to vote in the election to fulfil her civic duty");
        assertEquals("A$$a went to vote in the election to fulfil her c$$$c duty", actual);
    }
}