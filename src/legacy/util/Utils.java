package legacy.util;

public class Utils {

	public static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String VALID_SYMBOLS = " 1234567890-=!@#$%^&*()_+`~[]{}\\|;:\'\"/,.<>?";

	/**
	 * Returns if a given character is valid for input
	 * 
	 * @param keyChar
	 * @return boolean
	 */
	public static boolean charIsValid(char keyChar) {
		for (char c : VALID_SYMBOLS.toCharArray()) {
			if (c == keyChar || Character.isAlphabetic(keyChar)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns the char at the given position of the alphabet
	 * 
	 * @param position
	 * @return String
	 */
	public static String alphabetSearch(int position) {
		return String.valueOf(ALPHABET.charAt(position));
	}

	/**
	 * Returns the position that the given character is at in the alphabet.
	 * 
	 * @param character
	 *            - single character
	 * @return int
	 */
	public static int alphabetSearch(String c) {
		for (int i = 0; i < ALPHABET.length(); i++) {
			if (c.equalsIgnoreCase(String.valueOf(ALPHABET.toCharArray()[i]))) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Returns the given string cut off at a certain length
	 * 
	 * @param str
	 * @param len
	 * @return String
	 */
	public static String truncateString(String str, int lenth) {
		if (str.length() <= 0) {
			return str;
		}
		return str.substring(0, str.length() - lenth);
	}

	/**
	 * Returns a truncated string with the given ending (e.g: ...)
	 * 
	 * @param str
	 * @param end
	 * @param lenth
	 * @return String
	 */
	public static String truncateString(String str, int lenth, String end) {
		return truncateString(str, lenth) + end;
	}
}
