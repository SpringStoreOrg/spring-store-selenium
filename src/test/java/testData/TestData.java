package testData;

import com.google.gson.JsonObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestData {
	private static final DateTimeFormatter customFormat = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

	public static JsonObject newSignInUserData() {
		String intSuffix = LocalDateTime.now().format(customFormat);
		String charactersSuffix = getStringSuffix(intSuffix);
		JsonObject newSignInUser = new JsonObject();
		newSignInUser.addProperty("firstName", String.format("FirstName-%s", charactersSuffix));
		newSignInUser.addProperty("lastName", String.format("LastName-%s", charactersSuffix));
		newSignInUser.addProperty("phoneNumber", "0745000000");
		newSignInUser.addProperty("email", String.format("email%s@springstore-test.com", charactersSuffix));
		newSignInUser.addProperty("password", "qqqqq111");
		newSignInUser.addProperty("deliveryAddress", "Delivery Address");
		newSignInUser.addProperty("confirmPassword", "qqqqq111");
		return newSignInUser;
	}

	private static String getStringSuffix(String inputString) {
		return inputString.chars()
				.mapToObj(element -> getCharForNumber(element))
				.collect(Collectors.joining());
	}

	private static String getCharForNumber(int i) {
		return String.valueOf((char)(i + 17));
	}
}
