package kistenjunge.org.database;

import com.seitenbau.stu.database.extend.DbUnitDatasetFactory;
import com.seitenbau.stu.database.dsl.DataSetIdentificator;
import com.seitenbau.stu.database.dsl.DataSetRegistry;
import org.dbunit.dataset.IDataSet;

import kistenjunge.org.database.PathfinderDatabaseDataSet;
import kistenjunge.org.database.ProjectRef;
import kistenjunge.org.database.ProjectTable.RowBuilder_Project;
import kistenjunge.org.database.ComponentRef;
import kistenjunge.org.database.ComponentTable.RowBuilder_Component;

import groovy.lang.Closure;

import java.util.List;

/**
 * {@link DbUnitDatasetFactory} factory to create in-memory
 * {@link IDataSet} for your Database. 
 * Represents a PathfinderDatabase dataset. Provides both a Groovy table based API and
 * a plain Java builder API to model the test data.
 * <p>
 * To define test data, overwrite the method {@link #tables()} or
 * dynamically call the row() methods on the table adapters.
 * <p>
 * The model contains the following tables:
 * <ul>
 *   <li>
 *     {@link ProjectTable} - The project table<br>
 *     For Groovy language features, see: {@link ProjectTableAdapter}
 *   </li>
 *   <li>
 *     {@link ComponentTable} - The component table<br>
 *     For Groovy language features, see: {@link ComponentTableAdapter}
 *   </li>
 * </ul>
 *
 * <p>
 * This class is generated by {@link kistenjunge.org.database.PathfinderDatabaseModel#main }
 */
public class PathfinderDatabaseBuilder implements DataSetIdentificator, DbUnitDatasetFactory
{

  private final PathfinderDatabaseDataSet dataset;

/**
 * The project table
 * <p>
 * To define test data, overwrite the method {@link PathfinderDatabaseBuilder#tables()} or
 * dynamically call the method {@link ProjectTableAdapter#rows(Closure)}.
 * <p>
 * Use {@link ProjectTableAdapter#insertRow()} to model tables with the plain Java builder API.
 * <p>
 * To search for rows, use {@link ProjectTableAdapter#findWhere}, {@link ProjectTableAdapter#getWhere}
 * or {@link ProjectTableAdapter#find}.
 * <p>
 * The table is referenced by these tables:
 * <ul>
 *   <li>ComponentTable - {@link ComponentTableAdapter}</li>
 * </ul>
 * <p>
 * See {@link PathfinderDatabaseBuilder} for an overview over all tables.
 */
  public final ProjectTableAdapter projectTable;
  
  // Getter for Groovy property access
  protected ProjectTableAdapter getProjectTable()
  {
    return projectTable;
  }
/**
 * The component table
 * <p>
 * To define test data, overwrite the method {@link PathfinderDatabaseBuilder#tables()} or
 * dynamically call the method {@link ComponentTableAdapter#rows(Closure)}.
 * <p>
 * Use {@link ComponentTableAdapter#insertRow()} to model tables with the plain Java builder API.
 * <p>
 * To search for rows, use {@link ComponentTableAdapter#findWhere}, {@link ComponentTableAdapter#getWhere}
 * or {@link ComponentTableAdapter#find}.
 * <p>
 * This table contains relations to these tables:
 * <ul>
 *   <li>ProjectTable - {@link ProjectTableAdapter}</li>
 * </ul>
 * <p>
 * See {@link PathfinderDatabaseBuilder} for an overview over all tables.
 */
  public final ComponentTableAdapter componentTable;
  
  // Getter for Groovy property access
  protected ComponentTableAdapter getComponentTable()
  {
    return componentTable;
  }

  private static ThreadLocal<PathfinderDatabaseBuilder> activeParents = new ThreadLocal<PathfinderDatabaseBuilder>();

  private static void unsetActiveParent()
  {
    activeParents.remove();
  }

  private static boolean trySetActiveParent(PathfinderDatabaseBuilder instance)
  {
    // there is a thread local active parent, so do not allow to overwrite it
    if (activeParents.get() != null) {
      return false;
    }
    
    activeParents.set(instance);
    return true;
  }

  private static PathfinderDatabaseBuilder getWorkingInstance(PathfinderDatabaseBuilder current)
  {
    if (activeParents.get() != null)
    {
      return activeParents.get();
    }
    
    return current;
  }

  public PathfinderDatabaseBuilder() {
    this(new PathfinderDatabaseDataSet() 
    {
      @Override
      public void initDataSet() { }
    });
  }
  
  public PathfinderDatabaseBuilder(PathfinderDatabaseDataSet dataset)
  {
    PathfinderDatabaseBuilder instance = getWorkingInstance(null);
    if (getWorkingInstance(null) == null) {
      // no other parent active, create tables
      this.dataset = dataset;
      projectTable = new ProjectTableAdapter(this, dataset.table_Project);
      componentTable = new ComponentTableAdapter(this, dataset.table_Component);
    } else {
      // use parent's tables
      this.dataset = instance.dataset;
      projectTable = instance.projectTable;
      componentTable = instance.componentTable;
    }

    buildDataSet(getWorkingInstance(this));
  }
  
  private void buildDataSet(PathfinderDatabaseBuilder instance)
  {
    DataSetIdentificator lastDataSet = DataSetRegistry.use(instance);
    handleExtensions();
    tables();
    relations();
    DataSetRegistry.use(lastDataSet);
  }
  
  private void handleExtensions()
  {
    handleExtendsDataSet(extendsDataSet());
    if (extendsDataSets() != null) {
      List<?> dataSets = (List<?>)extendsDataSets();
      for (Object dataSet : dataSets)
      {
        handleExtendsDataSet(dataSet);
      }
    }
  }
  
  private void handleExtendsDataSet(Object dataSet)
  {
    if (dataSet == null)
    {
      return;
    }
    if (!(dataSet instanceof java.lang.Class))
    {
      throw new RuntimeException("Wrong type");
    }
    
    Class<?> clazz = (Class<?>)dataSet;
    if (!(hasSuperClass(clazz, PathfinderDatabaseBuilder.class)))
    {
      throw new RuntimeException("Wrong type");
    }

    try
    {
      boolean hasSet = trySetActiveParent(this);
      clazz.newInstance();
      if (hasSet) {
        unsetActiveParent();
      }
    }
    catch (Exception e)
    {
      throw new RuntimeException("Error extending builder", e);
    }
  }

  private boolean hasSuperClass(Class<?> clazz, Class<?> superClass)
  {
    Class<?> c = clazz;
    while (c != null)
    {
      if (superClass.equals(c)) 
      {
        return true;
      }
      c = c.getSuperclass();
    }
    return false;
  }

  /**
   * Override this method to define the tables of the dataset.
   * <p>Example usage:
   * <pre>
   * def tables() {
   *   projectTable.rows {
   *     REF           | id  | title | description
   *     ANYPROJECTREF | 123 | "abc" | "abc"      
   *   }
   *   componentTable.rows {
   *     REF             | id  | name  | project_id   
   *     ANYCOMPONENTREF | 123 | "abc" | ANYPROJECTREF
   *   }
   * }
   * </pre>
   *
   * @return Anything. The method returns an object to allow Groovy's def syntax.
   */
  protected Object tables()
  {
    return null;
  }

  /**
   * Override this method to define relations in the dataset.
   * <p>Example usage:
   * <pre>
   * def relations() {
   *   ANYCOMPONENTREF.projectIdTo(ANYPROJECTREF)
   * }
   * </pre>
   *
   * @return Anything. The method returns an object to allow Groovy's def syntax.
   */
  protected Object relations()
  {
    return null;
  }

  /**
   * Override this method to specify a base DataSets, which the current DataSet will extend
   * <p>Example usage (Groovy):
   * <pre>
   * def extendsDataSet() { BaseDataSet }
   * </pre>
   * <p>Example usage (Java):
   * <pre>
   * Object extendsDataSets() {
   *   return baseDataSet.class;
   * }
   * </pre>
   *
   * @return The base data set class
   */
  protected Object extendsDataSet() 
  {
    return null;
  }

  /**
   * Override this method to specify DataSets, from which the current DataSet is composed.
   * <p>Example usage (Groovy):
   * <pre>
   * def extendsDataSets() { [ Base1DataSet, Base2DataSet ] }
   * </pre>
   * <p>Example usage (Java):
   * <pre>
   * Object extendsDataSets() {
   *   List&lt;Class&lt;?&gt;&gt; baseDataSets = new ArrayList&lt;Class&lt;?&gt;&gt;();
   *   baseDataSets.add(Base1DataSet.class);
   *   baseDataSets.add(Base2DataSet.class);
   *   return baseDataSets;
   * }
   * </pre>
   *
   * @return List of base data set classes
   */
  protected Object extendsDataSets() 
  {
    return null;
  }

  /**
   * Parses and integrates the tables to the data set
   * <p>Example usage:
   * <pre>
   * tables {
   *   projectTable.rows {
   *     REF           | id  | title | description
   *     ANYPROJECTREF | 123 | "abc" | "abc"      
   *   }
   *   componentTable.rows {
   *     REF             | id  | name  | project_id   
   *     ANYCOMPONENTREF | 123 | "abc" | ANYPROJECTREF
   *   }
   * }
   * </pre>
   * </ul>
   *  
   * @param table Table data as a Groovy closure
   */
  public void tables(Closure<?> table)
  {
    tables(getWorkingInstance(this), table);
  }

  private void tables(PathfinderDatabaseBuilder dataSet, Closure<?> table)
  {
    DataSetIdentificator lastDataSet = DataSetRegistry.use(dataSet);
    table.setDelegate(dataSet);
    table.setResolveStrategy(Closure.DELEGATE_FIRST);
    table.call();
    DataSetRegistry.use(lastDataSet);
  }

  /**
   * Parses the defined relations and integrates them into the data set
   * <p>Example usage:
   * <pre>
   * relations {
   *   ANYCOMPONENTREF.projectIdTo(ANYPROJECTREF)
   * }
   * </pre>
   * @param relations The relations data
   */
  public void relations(Closure<?> relations)
  {
    this.relations(getWorkingInstance(this), relations);
  }

  private void relations(PathfinderDatabaseBuilder dataSet, Closure<?> relations)
  {
    DataSetIdentificator lastDataSet = DataSetRegistry.use(dataSet);
    relations.call();
    DataSetRegistry.use(lastDataSet);
  }


  /**
   * Allows Project table data access using references
   * @param ref The reference which represents tha data
   * @return The accessor object 
   */
  public RowBuilder_Project ref(ProjectRef ref)
  {
    return ref.getBuilder(this);
  }

  /**
   * Allows Component table data access using references
   * @param ref The reference which represents tha data
   * @return The accessor object 
   */
  public RowBuilder_Component ref(ComponentRef ref)
  {
    return ref.getBuilder(this);
  }

  @Override
  public String getDataSetClassName()
  {
    return dataset.getDataSetClassName();
  }
  
  @Override
  public Object getDataSet()
  {
    return dataset.getDataSet();
  } 

  /**
   * Create a DBUnit dataset.
   * @return The Dbunit dataset
   */
  @Override
  public IDataSet createDBUnitDataSet() 
  {
    return dataset.createDBUnitDataSet();
  }

}