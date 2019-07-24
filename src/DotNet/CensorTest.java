package DotNet;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class CensorTest {

    @Test
    public void isValid() throws InvalidInput {
        new Censor("{\"dog\", \"cat\", \"large\"} and \"I have a cat named Meow and a dog name Woof. I love the dog a lot. He is larger than a small horse.\"");
    }

    @Test
    public void censorWords() {
        Censor censor = new Censor();
        String actual = censor.censorWords(Arrays.asList("cat", "dog", "large"), "I have a cat named Meow and a dog name Woof. I love the dog a lot. He is larger than a small horse.");
        assertEquals("I have a c$t named Meow and a d$g name Woof. I love the d$g a lot. He is larger than a small horse.", actual);
    }

    @Test
    public void censorPalindrome() throws InvalidInput {
        Palindromes palin = new Palindromes("\"Anna went to vote in the election to fulfil her civic duty\"");
        Censor censor = new Censor();
        String actual = censor.censorWords(palin.findPalindromes(), palin.getText());
        assertEquals("A$$a went to vote in the election to fulfil her c$$$c duty", actual);
    }
}