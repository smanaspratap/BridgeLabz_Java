/*Linear Search Problem 2: Search for a Specific Word in a List of Sentences
Problem:
You are given an array of sentences (strings). Write a program that performs Linear Search to find the first sentence containing a specific word. If the word is found, return the sentence. If no sentence contains the word, return "Not Found".
Approach:
Iterate through the list of sentences.
For each sentence, check if it contains the specific word.
If the word is found, return the current sentence.
If no sentence contains the word, return "Not Found".
*/

public class SearchWordInSentences {

    // Method to find first sentence containing the word
    public static String findSentence(String[] sentences, String targetWord) {

        // Handle null cases
        if (sentences == null || targetWord == null) {
            return "Not Found";
        }

        // Convert target word to lowercase for case-insensitive matching
        targetWord = targetWord.toLowerCase();

        // Traverse through each sentence
        for (int i = 0; i < sentences.length; i++) {

            // Convert current sentence to lowercase
            String sentence = sentences[i].toLowerCase();

            // Remove punctuation (optional but safer)
            sentence = sentence.replaceAll("[^a-z ]", "");

            // Split sentence into words
            String[] words = sentence.split("\\s+");

            // Check each word
            for (String word : words) {
                if (word.equals(targetWord)) {
                    return sentences[i];  // Return original sentence
                }
            }
        }

        // If word not found in any sentence
        return "Not Found";
    }

    public static void main(String[] args) {

        String[] sentences = {
                "Java is powerful",
                "I love programming",
                "Data structures are important"
        };

        String result = findSentence(sentences, "programming");

        System.out.println(result);
    }
}

