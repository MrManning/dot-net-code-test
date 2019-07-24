package DotNet;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class PalindromesTest {

    @Test
    public void isValid() throws InvalidInput {
        new Palindromes("\"I have some cheese\"");
        new Palindromes("\"anna\"");
        new Palindromes("\"A man, a plan, a cat a car canal – Panama\"");
    }

    @Test(expected = InvalidInput.class)
    public void isNotValid() throws InvalidInput {
        new Palindromes("");
    }

    @Test
    public void isPalindrome() throws InvalidInput {
        Palindromes palin = new Palindromes("\"A man, a plan, a canal – Panama\"");
        assertTrue(palin.isPalindrome());
    }

    @Test
    public void findPalindromes() throws InvalidInput {
        Palindromes palin = new Palindromes("\"Anna the banana, loves her radar\"");
        assertEquals(Arrays.asList("Anna", "radar"), palin.findPalindromes());
    }
}