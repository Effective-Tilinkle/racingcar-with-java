package utils;

public class StringUtils {

	private StringUtils() {
		throw new IllegalStateException("Not support default constructor");
	}

	public static final boolean isEmpty(String str) {
		if (str == null || "".equals(str.trim())) {
			return true;
		}
		return false;
	}
}
