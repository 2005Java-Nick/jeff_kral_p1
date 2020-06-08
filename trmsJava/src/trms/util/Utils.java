package trms.util;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public class Utils {
	
	public static boolean isMatch(String keyToMatch, HttpServletRequest request) {
		boolean isMatch = false;
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String key = (String) headerNames.nextElement();
			if (key.equalsIgnoreCase("Access-Control-Request-Method")) {
				String header = request.getHeader(key);
				if (header.equalsIgnoreCase(keyToMatch)) {
					isMatch = true;
				}
			}
		}
		return isMatch;
	}

}
