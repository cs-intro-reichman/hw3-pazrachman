/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent", "listen")); // true
		System.out.println(isAnagram("William Shakespeare", "I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie", "Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle", "I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));

		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");

		// Performs a stress test of randomAnagram
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass)
				break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		if (str1.isEmpty() && str2.isEmpty()) {
			return true;
		}
		boolean anagram;
		String strTemp = str1.toLowerCase();
		String strTemp2 = str2.toLowerCase();
		for (int i = 0; i < strTemp.length(); i++) {
			anagram = false;
			if (strTemp.charAt(i) != ' ') {
				for (int j = 0; j < str2.length(); j++) {
					if (strTemp.charAt(i) == strTemp2.charAt(j)) {
						strTemp2 = strTemp2.substring(0, j) + strTemp2.substring(j + 1);
						anagram = true;
						break;
					}
				}
				if (!anagram) {
					return false;
				}
			}
		}
		return true;
	}

	// Returns a preprocessed version of the given string: all the letter characters
	// are converted
	// to lower-case, and all the other characters are deleted, except for spaces,
	// which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String strTemp = "";
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
				strTemp += ch;
			}
		}
		return strTemp.toLowerCase();
	}

	// Returns a random anagram of the given string. The random anagram consists of
	// the same
	// characters as the given string, re-arranged in a random order.
	public static String randomAnagram(String str) {
		String rendomStr = "";
		String strTemp = str;
		for (int i = 0; i < str.length(); i++) {
			int index = (int) (Math.random() * (strTemp.length() - 1));
			char c = strTemp.charAt(index);
			strTemp = strTemp.substring(0, index) + strTemp.substring(index + 1);
			rendomStr += c;
		}
		return rendomStr;
	}
}
