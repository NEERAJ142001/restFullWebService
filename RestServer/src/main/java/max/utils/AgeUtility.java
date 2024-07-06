package max.utils;

import java.time.LocalDate;

public class AgeUtility {
	public static int getAge(String dob) {
		LocalDate birthDate = LocalDate.parse(dob);
		LocalDate currentDate = LocalDate.now();
		return currentDate.getYear() - birthDate.getYear();
	}
	
}
