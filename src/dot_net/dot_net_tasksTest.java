package dot_net;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

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
}