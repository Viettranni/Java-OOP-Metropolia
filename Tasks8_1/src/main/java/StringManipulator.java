

public class StringManipulator {

    public String concatenate(String str1, String str2) {
        String concatenated = str1 + " " + str2;
        return concatenated;
    }

    public int findLength(String str) {
        int lengthOfTheString = str.length();
        return lengthOfTheString;
    }

    public String convertToUpperCase(String str) {
        String converted = str.toUpperCase();
        return converted;
    }

    public String convertToLowerCase(String str) {
        String converted = str.toLowerCase();
        return converted;
    }

    public boolean containsSubstring(String str, String subStr) {
        return str.contains(subStr);
    }
}
