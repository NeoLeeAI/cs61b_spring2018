
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
        Deque<Character> deque = wordToDeque(word);
        return isPalindromeHelper(deque);
    }

    private boolean isPalindromeHelper(Deque<Character> deque) {
        if (deque.size() == 1 || deque.isEmpty()) {
            return true;
        }
        char first = deque.removeFirst();
        char last = deque.removeLast();
        if (first != last) {
            return false;
        }
        return isPalindromeHelper(deque);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> deque = wordToDeque(word);
        return isPalindromeHelper(deque, cc);
    }

    private boolean isPalindromeHelper(Deque<Character> deque, CharacterComparator cc) {
        if (deque.size() == 1 || deque.isEmpty()) {
            return true;
        }
        char first = deque.removeFirst();
        char last = deque.removeLast();
        if (!cc.equalChars(first, last)) {
            return false;
        }
        return isPalindromeHelper(deque, cc);
    }
}
