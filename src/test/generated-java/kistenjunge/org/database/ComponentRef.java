package kistenjunge.org.database;

import com.seitenbau.stu.database.dsl.DataSetIdentificator;
import com.seitenbau.stu.database.dsl.DataSetRegistry;

import java.util.HashMap;
import java.util.Map;
import com.seitenbau.stu.database.dsl.DatabaseRef;

import kistenjunge.org.database.ComponentTable.RowBuilder_Component;


/**
 * Reference ("Ref") to a Component table row. Once bound to a table 
 * {@link ComponentTable#RowBuilder_Component}, the Ref can be used instead
 * of the concrete rowbuilder. To create a Ref, use the {@link RefFactory}.
 * <p>
 * Available fields:
 * <ul>
 *   <li>{@link #getId()} - java.lang.Long
 *   </li>
 *   <li>{@link #getName()} - java.lang.String
 *   </li>
 *   <li>{@link #getProjectId()} - java.lang.Long
 *   </li>
 * </ul>
 * <p>
 * Available relations:
 * <ul>
 *   <li>{@link #projectIdTo(ProjectRef)}</li>
 * </ul>
 */
public class ComponentRef extends DatabaseRef
{

  private final Map<PathfinderDatabaseDataSet, RowBuilder_Component> builders;
  
  public ComponentRef()
  {
    builders = new HashMap<PathfinderDatabaseDataSet, RowBuilder_Component>();
  }

  // use description() in the table model to add a column description
  public java.lang.Long getId()
  {
    return getCurrentBuilder().getId();
  } 

  // use description() in the table model to add a column description
  public java.lang.String getName()
  {
    return getCurrentBuilder().getName();
  } 

  // use description() in the table model to add a column description
  public java.lang.Long getProjectId()
  {
    return getCurrentBuilder().getProjectId();
  } 

  /**
   * Allows to access the bound row builder depending on the active DataSet
   * @return The Rowbuilder in the current DataSet
   */
  public RowBuilder_Component getCurrentBuilder()
  {
    RowBuilder_Component row = builders.get(getActiveDataSet());
    if (row == null)
    {
      throw new IllegalStateException("No corresponding row builder found in ComponentRef");
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
    
    RowBuilder_Component rowbuilder = getBuilder(dataSet);
    if (rowbuilder == null)
    {
      // Nothing to delete...
      return;
    }

    dataSet.table_Component.deleteRow(rowbuilder);


    // unbind the Ref
    builders.remove(dataSet.getDataSet());
  }

  void setBuilder(DataSetIdentificator identificator, RowBuilder_Component builder)
  {
    if (!(identificator.getDataSet() instanceof PathfinderDatabaseDataSet))
    {
      throw new RuntimeException("Cannot bind ComponentRef to " + identificator.getDataSet().getClass().getName());
    }
    
    PathfinderDatabaseDataSet dataSet = (PathfinderDatabaseDataSet)(identificator.getDataSet());
  
    RowBuilder_Component lastBuilder = builders.put(dataSet, builder);
    if (lastBuilder != null && lastBuilder != builder)
    {
      throw new RuntimeException("Builder cannot be redefined");
    }

    ProjectRef projectRef_projectIdTo = private_projectIdToMap.get(dataSet);
    if (projectRef_projectIdTo != null)
    {
      builder.setProjectId(projectRef_projectIdTo);
    }
  }

  RowBuilder_Component getBuilder(DataSetIdentificator identificator)
  {
    return builders.get(identificator.getDataSet());
  }

  // Cache for unresolvable relations
  private Map<PathfinderDatabaseDataSet, ProjectRef> private_projectIdToMap = new HashMap<PathfinderDatabaseDataSet, ProjectRef>();

  /**
   * Models: This entity (and maybe others) is related to the given entity ref.
   * @param ref The reference to the entity, to which the current entity is related to
   * @return The reference to the current entity
   */
  public ComponentRef projectIdTo(ProjectRef ref)
  {
    PathfinderDatabaseDataSet dataSet = getActiveDataSet();
    RowBuilder_Component builder = getBuilder(dataSet);

    if (builder != null) {
      builder.setProjectId(ref);
    } else {
      private_projectIdToMap.put(dataSet, ref);
    }
    return this;
  }

  private PathfinderDatabaseDataSet getActiveDataSet() 
  {
    DataSetIdentificator identificator = DataSetRegistry.getCurrentDataSet("kistenjunge.org.database.PathfinderDatabase");
    if (identificator == null)
    {
      throw new IllegalStateException("No active context set in ComponentRef");
    }
    return (PathfinderDatabaseDataSet)identificator.getDataSet();
  }

}