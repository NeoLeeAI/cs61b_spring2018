
public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            char charAti = word.charAt(i);
            deque.addLast(charAti);
        }
        return deque;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> word_deque = wordToDeque(word);
        return isPalindromeHelper(word_deque);
    }

    private boolean isPalindromeHelper(Deque<Character> word_deque) {
        if (word_deque.size() == 1 || word_deque.isEmpty()) {
            return true;
        }
        char first = word_deque.removeFirst();
        char last = word_deque.removeLast();
        if (first != last) {
            return false;
        }
        return isPalindromeHelper(word_deque);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> word_deque = wordToDeque(word);
        return isPalindromeHelper(word_deque, cc);
    }

    private boolean isPalindromeHelper(Deque<Character> word_deque, CharacterComparator cc) {
        if (word_deque.size() == 1 || word_deque.isEmpty()) {
            return true;
        }
        char first = word_deque.removeFirst();
        char last = word_deque.removeLast();
        if (!cc.equalChars(first, last)) {
            return false;
        }
        return isPalindromeHelper(word_deque, cc);
    }
}
