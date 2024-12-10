public class PalindromeChecker {

    public boolean isPalindrome(String str) {
        // Normalize the string: remove non-alphanumeric characters and convert to lowercase
        String normalized = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int left = 0;
        int right = normalized.length() - 1;

        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right)) {
                return false; // Not a palindrome
            }
            left++;
            right--;
        }
        return true; // Is a palindrome
    }
}
