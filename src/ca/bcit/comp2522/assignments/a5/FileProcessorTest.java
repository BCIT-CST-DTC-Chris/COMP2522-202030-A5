package ca.bcit.comp2522.assignments.a5;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 *    Version  1.01
 *      Change History: book words should be converted to lowercase
 */
public class FileProcessorTest {
    private static final String DIRECTORY = "A5/src/res/";

    private static final int ENGLISH_WORDS = 370103;
    private static final int FRENCH_WORDS = 426671;

    private static final int SHERLOCK_LINES = 12310;
    private static final int SHERLOCK_DISTINCT_WORDS = 7884;
    private static final int SHERLOCK_TOTAL_WORDS = 108196;
    private static final int SHERLOCK_NUM_THE = 5816;

    private static final int EBOOK_LINES = 6831;
    private static final int EBOOK_DISTINCT_WORDS = 5874;
    private static final int EBOOK_TOTAL_WORDS = 47842;
    private static final int EBOOK_NUM_UNE = 499;

    FileProcessor fileProcessorEn;
    FileProcessor fileProcessorFr;
    Dictionary englishWords;
    Dictionary frenchWords;



    @Before
    public void setUp() throws Exception {
        fileProcessorEn = new FileProcessor(DIRECTORY+"SherlockHolmes.txt");
        fileProcessorFr = new FileProcessor(DIRECTORY+"Une courte histoire de l'eBook.txt");
        englishWords = new Dictionary(DIRECTORY+"dictionary_en.txt");
        englishWords.load();
        frenchWords = new Dictionary(DIRECTORY+"dictionary_fr.txt");
        frenchWords.load();
    }

    @After
    public void tearDown() throws Exception {
        fileProcessorEn = null;
        fileProcessorFr = null;
        englishWords = null;
        frenchWords = null;
    }

    @Test
    public void testEnglishDictionarySize() {
        assertEquals(englishWords.wordCount(), ENGLISH_WORDS);
    }

    @Test
    public void testFrenchDictionarySize() {
        assertEquals(frenchWords.wordCount(), FRENCH_WORDS);
    }


    @Test
    public void testSherlockSize() {
        assertEquals(fileProcessorEn.getNumLines(), SHERLOCK_LINES);
    }

    @Test
    public void testSherlockDistinctWords() {
        fileProcessorEn.calcWordCount(englishWords);
        assertEquals(fileProcessorEn.distinctWordCount(), SHERLOCK_DISTINCT_WORDS);
    }

    @Test
    public void testSherlockTotalWords() {
        fileProcessorEn.calcWordCount(englishWords);
        assertEquals(fileProcessorEn.totalWordCount(), SHERLOCK_TOTAL_WORDS);
    }

    @Test
    public void testSherlockTheCount() {
        fileProcessorEn.calcWordCount(englishWords);
        assertEquals(fileProcessorEn.getNumOccurrences("the"), SHERLOCK_NUM_THE);
    }

    @Test
    public void testEBookSize() {
        assertEquals(fileProcessorFr.getNumLines(), EBOOK_LINES);
    }

    @Test
    public void testEBookDistinctWords() {
        fileProcessorFr.calcWordCount(frenchWords);
        assertEquals(fileProcessorFr.distinctWordCount(), EBOOK_DISTINCT_WORDS);
    }

    @Test
    public void testEBookTotalWords() {
        fileProcessorFr.calcWordCount(frenchWords);
        assertEquals(fileProcessorFr.totalWordCount(), EBOOK_TOTAL_WORDS);
    }

    @Test
    public void testEBookUneCount() {
        fileProcessorFr.calcWordCount(frenchWords);
        assertEquals(fileProcessorFr.getNumOccurrences("une"), EBOOK_NUM_UNE);
    }
}
