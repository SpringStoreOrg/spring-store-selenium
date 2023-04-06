package testData;

import com.google.gson.JsonObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

public class TestData {
	private static final DateTimeFormatter customFormat = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

	public static JsonObject newSignUpUserData() {
		String intSuffix = LocalDateTime.now().format(customFormat);
		String charactersSuffix = getStringSuffix(intSuffix);
		JsonObject newSignUpUser = new JsonObject();
		newSignUpUser.addProperty("firstName", String.format("FirstName-%s", charactersSuffix));
		newSignUpUser.addProperty("lastName", String.format("LastName-%s", charactersSuffix));
		newSignUpUser.addProperty("phoneNumber", "0745000000");
		newSignUpUser.addProperty("email", String.format("email%s@springstore-test.com", charactersSuffix));
		newSignUpUser.addProperty("password", "qqqqq111");
		newSignUpUser.addProperty("deliveryAddress", "Delivery Address");
		newSignUpUser.addProperty("confirmPassword", "qqqqq111");
		return newSignUpUser;
	}

	public static JsonObject newSignInUserData() {
		JsonObject newSignInUser = new JsonObject();
		newSignInUser.addProperty("email", "skilletcheek@gaa1iler.site");
		newSignInUser.addProperty("password", "qqqqq111");
		return newSignInUser;
	}

	private static String getStringSuffix(String inputString) {
		return inputString.chars()
				.mapToObj(TestData::getCharForNumber)
				.collect(Collectors.joining());
	}

	private static String getCharForNumber(int i) {
		return String.valueOf((char)(i + 17));
	}
}
