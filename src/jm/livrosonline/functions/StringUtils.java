package jm.livrosonline.functions;

public class StringUtils {
	
	public static int indexOf(String string, char character) {
		if (string == null) {
			return -1;
		}
		return string.indexOf(character);
	}
	
	public static Boolean isBlank(String string) {
		if (string == null || "".equals(string.trim())) {
			return true;
		}
		return false;
	}
}
