package kistenjunge.org.database;

import com.seitenbau.stu.database.generator.ColumnMetaData;
import com.seitenbau.stu.database.generator.DataType;
import com.seitenbau.stu.database.generator.DatabaseModel;
import com.seitenbau.stu.database.generator.Table;

/**
 * Model that represents the database schema.
 * Use {@link DbModelHelper#generateDatabaseModelFromDatabase()} to generate a simple version of the current db schema.
 */
public class PathfinderDatabaseModel extends DatabaseModel
{
  {
    packageName("kistenjunge.org.database");
    database("PathfinderDatabase");
    generatedSourceFolder("src/test/generated-java");
    enableTableModelClassesGeneration();

    // paste/merge generated model here
    Table project = table("project")
        .column("id", DataType.BIGINT)
          .defaultIdentifier()
          .setFlag(ColumnMetaData.AUTO_INVOKE_NEXT)
        .column("title", DataType.VARCHAR)
        .column("description", DataType.VARCHAR)
        .build();

    Table component = table("component")
        .column("id", DataType.BIGINT) //
          .defaultIdentifier()
          .setFlag(ColumnMetaData.AUTO_INVOKE_NEXT)
        .column("name", DataType.VARCHAR)
        .column("project_id", DataType.BIGINT) //
          .reference //
            .local.multiplicity("1..1") //
            .foreign(project.ref("id")).multiplicity("0..*") //
        .build();

  }

  /**
   * Execute to (re)generate database model classes
   */
  public static void main(String[] args) throws Exception
  {
    new PathfinderDatabaseModel().getDataSetGenInstance().generate();
  }
}
