package testData;

import com.google.gson.JsonObject;

public class TestData {

	public static JsonObject newSignInUserData() {
		JsonObject newSignInUser = new JsonObject();
		newSignInUser.addProperty("firstName", "erqwerwerwe");
		newSignInUser.addProperty("lastName", "erqwerwq");
		newSignInUser.addProperty("phoneNumber", "0745000000");
		newSignInUser.addProperty("email", "dasdasd@gmail.com");
		newSignInUser.addProperty("password", "qqqqq111");
		newSignInUser.addProperty("deliveryAddress", "Delivery Address");
		newSignInUser.addProperty("confirmPassword", "qqqqq111");
		return newSignInUser;
	}
}
