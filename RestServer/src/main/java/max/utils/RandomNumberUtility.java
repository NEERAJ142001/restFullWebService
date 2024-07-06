package max.utils;

import java.util.Random;

public class RandomNumberUtility {
	public static String getNumber() {

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			int x = new Random().nextInt(9);
			builder.append(x);
		}
		return builder.toString();

	}

}
