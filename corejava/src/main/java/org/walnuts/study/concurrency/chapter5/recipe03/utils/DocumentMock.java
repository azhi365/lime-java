package org.walnuts.study.concurrency.chapter5.recipe03.utils;

import java.util.Random;


public class DocumentMock {

    private String words[] = {"the", "hello", "goodbye", "packt", "java", "thread", "pool", "random", "class", "main"};

    /**
     * Method that generates the String matrix
     *
     * @param numLines Number of lines of the document
     * @param numWords Number of words of the document
     * @param word     Word we are going to search for
     * @return The String matrix
     */
    public String[][] generateDocument(int numLines, int numWords, String word) {

        int counter = 0;
        String document[][] = new String[numLines][numWords];
        Random random = new Random();
        for (int i = 0; i < numLines; i++) {
            for (int j = 0; j < numWords; j++) {
                int index = random.nextInt(words.length);
                document[i][j] = words[index];
                if (document[i][j].equals(word)) {
                    counter++;
                }
            }
        }
        System.out.printf("DocumentMock: The word appears %d times in the document.\n", counter);
        return document;
    }
}
