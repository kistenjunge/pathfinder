package kistenjunge.org.database;

import com.seitenbau.stu.config.TestConfiguration;
import com.seitenbau.stu.database.DatabaseTester;
import com.seitenbau.stu.database.migrate.MigrateFromXml;
import com.seitenbau.stu.database.modelgenerator.DatabaseModel;
import com.seitenbau.stu.database.modelgenerator.ModelReader;
import com.seitenbau.stu.database.modelgenerator.STUModelWriter;
import kistenjunge.org.ITestConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbModelHelper
{
  static final String exportFolder = "src/test/resources/kistenjunge/org/database/dataset";

  public static void exportDatabaseToDataset() throws Exception
  {
    // export db to xml
    DatabaseTester db = new DatabaseTester(ITestConfiguration.class);
    db.dumpDatabase(exportFolder + "/exportetDataset.xml");

    // generate dataset
    MigrateFromXml
        .processFolders(exportFolder, "kistenjunge.org.database.dataset.EmptyDataset", "src/test/java");
  }

  public static void generateDatabaseModelFromDatabase() throws ClassNotFoundException, SQLException
  {
    Class.forName("com.mysql.jdbc.Driver");
    String connectionString = String
        .format("%s?user=%s&password=%s",
            TestConfiguration.getString("db.url"),
            TestConfiguration.getString("db.username"),
            TestConfiguration.getString("db.password"));
    Connection connection = DriverManager.getConnection(connectionString);

    DatabaseModel model = ModelReader.readModel(connection);
    STUModelWriter writer = new STUModelWriter();
    System.out.println(writer.generate(model));
  }

  public static void main(String[] args) throws Exception
  {
    //    generateDatabaseModelFromDatabase();

    //    exportDatabaseToDataset();
  }

}
