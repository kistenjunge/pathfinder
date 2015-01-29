package kistenjunge.org.database;

/**
 * Static Factory to create Refs belonging to {@link PathfinderDatabaseDataSet}.
 * Refs can be used to specify a table entity.
 * <p>
 * Available Ref types are: 
 * <ul>
 *   <li>{@link ProjectRef}</li>
 * </ul>
 * A recommended way is to create a class with all used Refs as public static final variables,
 * which are statically imported into the test classes.
 * <p>
 * See {@link PathfinderDatabaseBuilder#tables()} or any of the for example usage of Refs.
 */
public class RefFactory 
{

  /**
   * Creates a Ref for a ProjectTable table.
   * @return The created {@link ProjectRef} instance
   */
  public static ProjectRef createProjectRef()
  {
    return new ProjectRef();
  }

}