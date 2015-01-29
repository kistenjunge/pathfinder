package kistenjunge.org;

import com.seitenbau.stu.database.TestConfigDatabase;

public class ITestConfiguration implements TestConfigDatabase
{
  static
  {
    com.seitenbau.stu.config.TestConfiguration.load(ITestConfiguration.class);
  }
}
