package dot_net;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

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
        List<String> toFind = Arrays.asList("dog", "cat", "large");
        List<Integer> actual = tasks.wordOccurrence(toFind, "I have a cat named Meow and a dog name Woof. I love the dog a lot. He is larger than a small horse.");
        assertThat(actual, is(Arrays.asList(1,2,1)));

        toFind = Arrays.asList("small", "21312", "", " ");
        actual = tasks.wordOccurrence(toFind, "A small brown but small animal. A small black dog. ");
        assertThat(actual, is(not(Arrays.asList(null,10,0,3))));
    }
}