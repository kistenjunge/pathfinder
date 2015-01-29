package kistenjunge.org.database;

import com.seitenbau.stu.database.dsl.DataSetIdentificator;
import com.seitenbau.stu.database.dsl.DataSetRegistry;

import java.util.HashMap;
import java.util.Map;
import com.seitenbau.stu.database.dsl.DatabaseRef;

import kistenjunge.org.database.ProjectTable.RowBuilder_Project;


/**
 * Reference ("Ref") to a Project table row. Once bound to a table 
 * {@link ProjectTable#RowBuilder_Project}, the Ref can be used instead
 * of the concrete rowbuilder. To create a Ref, use the {@link RefFactory}.
 * <p>
 * Available fields:
 * <ul>
 *   <li>{@link #getId()} - java.lang.Long
 *   </li>
 *   <li>{@link #getTitle()} - java.lang.String
 *   </li>
 *   <li>{@link #getDescription()} - java.lang.String
 *   </li>
 * </ul>
 * <p>
 * Available relations:
 * <ul>
 * </ul>
 */
public class ProjectRef extends DatabaseRef
{

  private final Map<PathfinderDatabaseDataSet, RowBuilder_Project> builders;
  
  public ProjectRef()
  {
    builders = new HashMap<PathfinderDatabaseDataSet, RowBuilder_Project>();
  }

  // use description() in the table model to add a column description
  public java.lang.Long getId()
  {
    return getCurrentBuilder().getId();
  } 

  // use description() in the table model to add a column description
  public java.lang.String getTitle()
  {
    return getCurrentBuilder().getTitle();
  } 

  // use description() in the table model to add a column description
  public java.lang.String getDescription()
  {
    return getCurrentBuilder().getDescription();
  } 

  /**
   * Allows to access the bound row builder depending on the active DataSet
   * @return The Rowbuilder in the current DataSet
   */
  public RowBuilder_Project getCurrentBuilder()
  {
    RowBuilder_Project row = builders.get(getActiveDataSet());
    if (row == null)
    {
      throw new IllegalStateException("No corresponding row builder found in ProjectRef");
    }
    return row;
  }

  /**
   * Removes the Ref from the DataSet. Will delete the bound row and remove all n:m associations.
   * Afterwards, the Ref will no longer be bound to that row.
   * <p>
   * Note: The DataSet may be in an invalid state, because 1:n or 1:1 associations will not be updated.
   */
  public void removeFromDataSet()
  {
    PathfinderDatabaseDataSet dataSet = getActiveDataSet();
    
    RowBuilder_Project rowbuilder = getBuilder(dataSet);
    if (rowbuilder == null)
    {
      // Nothing to delete...
      return;
    }

    dataSet.table_Project.deleteRow(rowbuilder);


    // unbind the Ref
    builders.remove(dataSet.getDataSet());
  }

  void setBuilder(DataSetIdentificator identificator, RowBuilder_Project builder)
  {
    if (!(identificator.getDataSet() instanceof PathfinderDatabaseDataSet))
    {
      throw new RuntimeException("Cannot bind ProjectRef to " + identificator.getDataSet().getClass().getName());
    }
    
    PathfinderDatabaseDataSet dataSet = (PathfinderDatabaseDataSet)(identificator.getDataSet());
  
    RowBuilder_Project lastBuilder = builders.put(dataSet, builder);
    if (lastBuilder != null && lastBuilder != builder)
    {
      throw new RuntimeException("Builder cannot be redefined");
    }
  }

  RowBuilder_Project getBuilder(DataSetIdentificator identificator)
  {
    return builders.get(identificator.getDataSet());
  }

  private PathfinderDatabaseDataSet getActiveDataSet() 
  {
    DataSetIdentificator identificator = DataSetRegistry.getCurrentDataSet("kistenjunge.org.database.PathfinderDatabase");
    if (identificator == null)
    {
      throw new IllegalStateException("No active context set in ProjectRef");
    }
    return (PathfinderDatabaseDataSet)identificator.getDataSet();
  }

}