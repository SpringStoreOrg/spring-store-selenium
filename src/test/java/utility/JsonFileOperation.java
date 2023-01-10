package utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonFileOperation
{

  public static String readJsonFromFile(String arg1) throws IOException
  {
    // read JSON Test Data file
    FileInputStream fin = new FileInputStream(new File(System.getProperty("user.dir") + "//src//testdata//" + arg1));
    InputStreamReader in = new InputStreamReader(fin);
    BufferedReader bufferedReader = new BufferedReader(in);
    StringBuilder sb = new StringBuilder();
    String line;
    while ((line = bufferedReader.readLine()) != null)
    {
      sb.append(line);
    }
    String myJSONData = sb.toString();
    bufferedReader.close();
    return myJSONData;
  }
  public static JsonObject transformStringIntoObject(String myString)
  {
    JsonParser parser = new com.google.gson.JsonParser();
    JsonObject myObject = (JsonObject) parser.parse(myString);
    return myObject;
  }
  public static JsonObject getData(String jsonName) throws IOException
  {
    String myJson = JsonFileOperation.readJsonFromFile(jsonName);
    JsonObject myObject = new JsonObject();
    myObject = JsonFileOperation.transformStringIntoObject(myJson);
    return myObject;
  }

}
