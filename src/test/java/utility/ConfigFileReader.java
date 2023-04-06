package utility;

import java.io.*;
import java.util.Objects;
import java.util.Properties;

public class ConfigFileReader
{

  private final Properties properties;

  // loads config file
  public ConfigFileReader()
  {
    BufferedReader reader;
    try
    {
      String basePath = Objects.requireNonNull(ConfigFileReader.class.getResource("/")).getPath();
      reader = new BufferedReader(new FileReader(new File(basePath, "config//config.properties")));
      properties = new Properties();
      try
      {
        properties.load(reader);
        reader.close();
      } catch (IOException e)
      {
        e.printStackTrace();
      }
    } catch (FileNotFoundException e)
    {
      e.printStackTrace();
      throw new RuntimeException("config.properties file not found!");
    }
  }
  public String getAppURL()
  {
    String url = properties.getProperty("URL");
    if (url != null)
      return url;
    else
      throw new RuntimeException("url not specified in the config.properties file.");
  }
  public String getBrowserName()
  {
    String browser = properties.getProperty("BROWSER");
    if (browser != null)
      return browser;
    else
      throw new RuntimeException("browser not specified in the config.properties file.");
  }

  public String getHeadless()
  {
    String browser = properties.getProperty("HEADLESS");
    if (browser != null)
      return browser;
    else
      throw new RuntimeException("headless not specified in the config.properties file.");
  }

}
