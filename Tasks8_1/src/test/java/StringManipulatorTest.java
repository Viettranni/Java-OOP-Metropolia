import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringManipulatorTest {
    @Test
    void concatenateShouldAddStrings() {
        StringManipulator m = new StringManipulator();

        // Test data
        String str1 = "Hello";
        String str2 = "Viet";
        assertEquals("Hello Viet", m.concatenate(str1, str2));
    }

    @Test
    void findLengthShouldReturnLength() {
        StringManipulator m = new StringManipulator();
        String str1 = "Hello";

        assertEquals(5, m.findLength(str1));
    }

   @Test
   void convertToUpperCaseShouldConvertToUpperCase() {
        StringManipulator m = new StringManipulator();
        String str1 = "Hello";

        assertEquals("HELLO", m.convertToUpperCase(str1));
   }

   @Test
    void convertToLowerCaseShouldConvertToLowerCase() {
        StringManipulator m = new StringManipulator();
        String str = "HELLO";

        assertEquals("hello", m.convertToLowerCase(str));
   }

   @Test
    void containsSubStringShouldReturnTrue() {
        StringManipulator m = new StringManipulator();
        String str1 = "Hello World";
        String subString = "World";

       assertTrue(m.containsSubstring(str1, subString));
   }
}