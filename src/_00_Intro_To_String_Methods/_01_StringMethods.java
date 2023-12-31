package _00_Intro_To_String_Methods;

import java.util.Base64;

/*
 * Visit the JavaDocs for the String class to view everything you can do with a String.
 * https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
 * https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html
 *
 * HINT:  Here are some String methods you might find useful 
 * contains
 * replace
 * trim
 * length
 * getBytes
 * endsWith
 * split 
 * indexOf
 * lastIndexOf
 * compareTo(IgnoreCase)
 * substring
 * toUpperCase/toLowerCase
 * valueOf
 *
 * Here are some Character methods you might find useful:
 * Character.toLowerCase(char c);
 * Character.toUpperCase(char c);
 * Character.isLetter(char c);
 * Character.isDigit(char c);
 * Character.getNumericValue(char c);
 */

public class _01_StringMethods {

    // Given Strings s1 and s2, return the longer String
    public static String longerString(String s1, String s2) {
    	
    	if(s1.length() > s2.length()) {
    		return s1;
    	}
    	
        return s2;
    }

    // If String s contains the word "underscores", change all of the spaces
    // to underscores
    public static String formatSpaces(String s) {
    	
    	String str = s;
    	if(s.contains("underscores")) {
    		str = s.replace(" ", "_");
    	}
    	
        return str;
    }

    // Return the name of the person whose LAST name would appear first if they
    // were in alphabetical order.
    // You cannot assume there are no extra spaces around the name, but you can
    // assume there is only one space between the first and last name
    public static String lineLeader(String s1, String s2, String s3) {
    	    	
    	s1 = s1.trim();
    	s2 = s2.trim();
    	s3 = s3.trim();
    	int r1 = s1.lastIndexOf(" ")+1;
    	int r2 = s2.indexOf(" ")+1;
    	int r3 = s3.indexOf(" ")+1;
    	int r6 = 10/10;
    	char c1 = s1.charAt(r1);
    	char c2 = s2.charAt(r2);
    	char c3 = s3.charAt(r3);
    	int i1 = Character.getNumericValue(c1);
    	int i2 = Character.getNumericValue(c2);
    	int i3 = Character.getNumericValue(c3);
    	    	
    	if(i1 < i2 & i1 < i3) {
    		return s1;
    	}
    	else if(i2 < i3 & i2 < i1) {
    		return s2;
    	}
    	else {
    		return s3;
    	}    	
    }

    // Return the sum of all numerical digits in the String
    public static int numeralSum(String s) {
    	
    	int total = 0;
    	for(int i=0;i<s.length();i++) {
    		char temp = s.charAt(i);
    		if(Character.isDigit(temp) == true) {
        		int num = Character.getNumericValue(temp);
        		total = total + num;
    		}
    	}
    	
        return total;
    }

    // Return the number of times String substring appears in String s
    public static int substringCount(String s, String substring) {
    	
    	int numOccurances = 0;
        int index = s.indexOf(substring);
        while( index != -1 ) {
            numOccurances++;
            index = s.indexOf(substring, index + substring.length());
        }
    	
        return numOccurances;
    }

    // Call Utilities.encrypt at the bottom of this file to encrypt String s
    public static String encrypt(String s, char key) {
  
    	byte[] s2 = s.getBytes();

    	return Utilities.encrypt(s2, (byte)key);
    }

    // Call Utilities.decrypt at the bottom of this file to decrypt the
    // cyphertext (encrypted text)
    public static String decrypt(String s, char key) {
    	
        return Utilities.decrypt(s, (byte)key);
    }

    // Return the number of words in String s that end with String substring
    // You can assume there are no punctuation marks between words
    public static int wordsEndsWithSubstring(String s, String substring) {
    	
    	String[] s2 = s.split(" ");
    	int words = 0;
    	
    	for(int i=0;i<s2.length;i++) {
    		s2[i] = s2[i] + " ";
    	}
    	for(int i=0;i<s2.length;i++) {
    		if(s2[i].contains(substring + " ")) {
    			words++;
    		}
    	}
    	
        return words;
    }

    // Given String s, return the number of characters between the first
    // occurrence of String substring and the final occurrence
    // You can assume that substring will appear at least twice
    public static int distance(String s, String substring) {
    	
    	int first = s.indexOf(substring) + substring.length();
    	int last = s.lastIndexOf(substring);
    	
        return last-first;
    }

    // Return true if String s is a palindrome
    // palindromes are words or phrases are read the same forward as backward.
    // HINT: ignore/remove all punctuation and spaces in the String
    public static boolean palindrome(String s) {
    	
    	String og = s.replace(" ", "");
    	og = og.trim();
    	og = og.toLowerCase();
    	og = og.replace("?", "");
    	og = og.replace(",", "");
    	og = og.replace("-", "");
    	og = og.replace(":", "");
    	og = og.replace(".", "");
    	
    	String e = og;
    	System.out.println(e + " " + og);
    	char[] chars = e.toCharArray();
    	String news = "";
    	
    	for(int i=chars.length-1;i>-1;i--) {
    		news = news + chars[i];
    	}
    	System.out.println(news);
    	
    	if(og.equalsIgnoreCase(news)) {
    		System.out.println("true");
    		return true;
    	}
        return false;
    }
}

class Utilities {
    // This basic encryption scheme is called single-byte xor. It takes a
    // single byte and uses exclusive-or on every character in the String.
    public static String encrypt(byte[] plaintext, byte key) {
        for (int i = 0; i < plaintext.length; i++) {
            plaintext[i] = (byte) (plaintext[i] ^ key);
        }
        return Base64.getEncoder().encodeToString(plaintext);
    }

    public static String decrypt(String cyphertext, byte key) {
        byte[] b = Base64.getDecoder().decode(cyphertext);
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) (b[i] ^ key);
        }
        return new String(b);
    }
}
