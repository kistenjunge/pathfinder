package kistenjunge.org.database;

import com.google.common.base.Optional;

import com.seitenbau.stu.database.dsl.CastUtil;
import com.seitenbau.stu.database.dsl.ColumnBinding;
import com.seitenbau.stu.database.dsl.DatabaseRef;
import com.seitenbau.stu.database.dsl.NoValue;
import com.seitenbau.stu.database.dsl.RefColumnBinding;
import com.seitenbau.stu.database.dsl.TableParser;
import com.seitenbau.stu.database.dsl.TableParserAdapter;
import com.seitenbau.stu.database.generator.ColumnMetaData;
import com.seitenbau.stu.database.generator.DataType;
import com.seitenbau.stu.database.modifier.IDataSetModifier;
import com.seitenbau.stu.util.Action;
import com.seitenbau.stu.util.Filter;
import com.seitenbau.stu.util.Future;

import groovy.lang.Closure;

import java.util.List;

import kistenjunge.org.database.ProjectTable.RowBuilder_Project;
import kistenjunge.org.database.ProjectTable.RowCollection_Project;
import kistenjunge.org.database.ProjectTable.ProjectFindWhere;
import kistenjunge.org.database.ProjectTable.ProjectGetWhere;


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
 * See {@link PathfinderDatabaseBuilder} for an overview over all tables.
 */
public class ProjectTableAdapter {

  /**
   * Do not set a value. (To remove a value use {@code null})
   */
  public final NoValue _ = new NoValue();

  /**
   * Column Header for Project table.
   * <p>
   * Binds a {@link ProjectRef} with the current row. To create a Ref, use the {@link RefFactory}. 
   * <p>
   * Data Type: ProjectRef
   * <p>
   */
  public final ColumnBinding<RowBuilder_Project, ProjectGetWhere> REF = new RefColumnBinding<RowBuilder_Project, ProjectGetWhere>();

  /**
   * Column Header for Project table.
   * <p>
   * Data Type: {@code java.lang.Long}
   * <br>   
   * Database Type: DataType.BIGINT
   * 
   */
  public final ColumnBinding<RowBuilder_Project, ProjectGetWhere> id = createIdBinding();

  /**
   * Column Header for Project table.
   * <p>
   * Data Type: {@code java.lang.String}
   * <br>   
   * Database Type: DataType.VARCHAR
   * 
   */
  public final ColumnBinding<RowBuilder_Project, ProjectGetWhere> title = createTitleBinding();

  /**
   * Column Header for Project table.
   * <p>
   * Data Type: {@code java.lang.String}
   * <br>   
   * Database Type: DataType.VARCHAR
   * 
   */
  public final ColumnBinding<RowBuilder_Project, ProjectGetWhere> description = createDescriptionBinding();

  private final PathfinderDatabaseBuilder _builder;

  private final ProjectTable _table;

  private final TableParserAdapter<RowBuilder_Project, ProjectGetWhere, ProjectRef> _adapter = new TableAdapter();

  /**
   * Allows searching for one or more rows specified by a column value.
   * findWhere assumes that it is used to search for existing rows. An
   * exception will be thrown if no matching row was found. Use {@link
   * #quietFindWhere}, {@link # getWhere} or 
   * #find to avoid this behavior.
   * @see #getWhere
   * @see #quietFindWhere
   * @see #find(Closure)
   * @see #find(Filter)
   */
  public final ProjectFindWhere findWhere;

  /**
   * Allows searching for one or more rows specified by a column value.
   * quietFindWhere will not throw an exception if no row was found.
   * @see #getWhere
   * @see #findWhere
   * @see #find(Closure)
   * @see #find(Filter)
   */
  public final ProjectFindWhere quietFindWhere;

  /**
   * Allows searching for a row specified by a column value.
   * The first matching row is returned. Does not throw an
   * exception, if no element is found.
   * @see #findWhere
   * @see #quietFindWhere
   * @see #find(Closure)
   * @see #find(Filter)
   */
  public final ProjectGetWhere getWhere;

  ProjectTableAdapter(PathfinderDatabaseBuilder builder, ProjectTable table)
  {
    _builder = builder;
    _table = table;
    findWhere = _table.findWhere;
    quietFindWhere = _table.quietFindWhere;
    getWhere = _table.getWhere;
  }

  public static ColumnMetaData getColumnMetaData(String column)
  {
    return kistenjunge.org.database.ProjectTableAdapter.getColumnMetaData(column);
  }

  /**
   * Parses the rows of a Project table. Supported columns are:
   * <ul>
   *   <li><strong>{@code REF}</strong>: {@link ProjectRef}</li>
   *   <li> <strong>{@code id}</strong>: {@code java.lang.Long}
   *   <li> <strong>{@code title}</strong>: {@code java.lang.String}
   *   <li> <strong>{@code description}</strong>: {@code java.lang.String}
   * </ul>
   * The table has to start with a header row, but there can be more
   * headers within one block.
   *
   * <p>Example usage:
   * <pre>
   * projectTable.rows {
   *   REF           | id  | title | description
   *   ANYPROJECTREF | 123 | "abc" | "abc"      
   * }
   * </pre>
   *
   * @param rows The table data
   */
  public void rows(Closure<?> rows)
  {
    TableParser.parseTable(rows, _adapter);
  }
  
  public int getRowCount() 
  {
    return _table.getRowCount();
  }

  /**
   * Clears the table. Simply removes all rows from the table. Does not any magic. 
   */
  public void clear()
  {
    _table.clear();
  }

  /**
   * Insert a new Row at the end of the Table
   * <code><pre>
   * ds.projectTable.insertRow()
   *   .bind(ANYPROJECTREF)
   *   .setId( null )
   *   .setTitle( null )
   *   .setDescription( null )
   *   ;
   * </pre></code>
   */
  public RowBuilder_Project insertRow()
  {
    return _table.insertRow();
  }

  /**
   * Insert a new Row at the end of the Table
   * <code><pre>
   * ds.projectTable.insertRow()
   *   .bind( ANYPROJECTREF )
   *   .setId( null )
   *   .setTitle( null )
   *   .setDescription( null )
   *   ;
   * </pre></code>
   */
  public RowBuilder_Project insertRow(ProjectModel row)
  {
    return _table.insertRow(row);
  }

  /**
   * Insert a new Row at the given position
   * <code><pre>
   * ds.projectTable.this.insertRowAt(2)
   *   .bind( ANYPROJECTREF )
   *   .setId( null )
   *   .setTitle( null )
   *   .setDescription( null )
   *   ;
   * </pre></code>
   */
  public RowBuilder_Project insertRowAt(int index)
  {
    return _table.insertRowAt(index);
  }

  /**
   * Insert a row at the end of the table
   * <code><pre>
   * ds.projectTable.insertRow(someRow);
   * </pre></code>
   */
  public RowBuilder_Project insertRow(RowBuilder_Project theRow)
  {
    return _table.insertRow(theRow);
  }

  /**
   * Remove a row from the builder by the given index.
   *
   * @return the deleted row
   */
  public RowBuilder_Project deleteRow(int index)
  {
    return _table.deleteRow(index);
  }

  /**
   * Remove a row from the data set
   */
  public RowBuilder_Project deleteRow(ProjectRef ref)
  {
    return _table.deleteRow(ref);
  }

  /**
   * Remove a row from the builder
   * @return the deleted row itself
   */
  public RowBuilder_Project deleteRow(RowBuilder_Project rowToDelete)
  {
    return _table.deleteRow(rowToDelete);
  }

  /**
   * Creates a new row but does not add it to the table
   */
  public RowBuilder_Project newRow()
  {
    return _table.newRow();
  }

  /**
   * Delivers a collection of rows matching to a filter.
   * @param filter The used filter
   * @return The collection of rows, may return an empty list
   * @see #find(Closure)
   * @see #findWhere
   * @see #getWhere
   */
  public RowCollection_Project find(Filter<RowBuilder_Project> filter)
  {
    return _table.find(filter);
  }

  /**
   * Delivers a collection of rows matching to a filter.
   * @param filter A Groovy Closure with an argument of type RowBuilder_Project, returning a boolean
   * @return The collection of rows, may return an empty list
   * @see #find(Filter)
   * @see #findWhere
   * @see #getWhere
   */
  public RowCollection_Project find(Closure<Boolean> filter)
  {
    final Closure<Boolean> localFilter = filter;
    return _table.find(new Filter<RowBuilder_Project>()
      {
        @Override
        public boolean accept(RowBuilder_Project row)
        {
          return localFilter.call(row);
        }
      });
  }

  public void foreach(Action<RowBuilder_Project> action)
  {
    _table.foreach(action);
  }

  public void foreach(Closure<?> action)
  {
    final Closure<?> localAction = action;
    _table.foreach(new Action<RowBuilder_Project>()
      {
        @Override
        public void call(RowBuilder_Project row)
        {
          localAction.call(row);
        }
      });
  }

  public List<RowBuilder_Project> getRows()
  {
    return _table.getRows();
  }

  private class TableAdapter implements TableParserAdapter<RowBuilder_Project, ProjectGetWhere, ProjectRef>
  {
    @Override
    public RowBuilder_Project insertRow() 
    {
      return _table.insertRow();
    }
  
    @Override
    public ProjectGetWhere getWhere()
    {
      return _table.getWhere;
    }

    @Override
    public void bindToDataSet(ProjectRef reference, RowBuilder_Project row)
    {
      reference.setBuilder(_builder, row);
    }

    @Override
    public RowBuilder_Project getRowByReference(ProjectRef reference)
    {
      return reference.getBuilder(_builder);
    }

    @Override
    public Object getTableContext()
    {
      return ProjectTableAdapter.this;
    }

    @Override
    public String getTableName()
    {
      return "Project";
    }
    
  };


  private ColumnBinding<RowBuilder_Project, ProjectGetWhere> createIdBinding() 
  {
    return new ColumnBinding<RowBuilder_Project, ProjectGetWhere>()
    {
      @Override
      public void set(RowBuilder_Project row, Object value)
      {
        if (valueMustBeSetRaw(value)) 
        {
          row.setIdRaw(value);
        } else {
          Object castedValue = CastUtil.cast(value, DataType.BIGINT);
          row.setId((java.lang.Long)castedValue);
        }
      }

      @Override
      public Optional<RowBuilder_Project> getWhere(ProjectGetWhere getWhere, Object value)
      {
        return getWhere.id((java.lang.Long)CastUtil.cast(value, DataType.BIGINT));
      }

      @Override
      public boolean isIdentifier()
      {
        return true;
      }
      
      @Override
      public DataType getDataType()
      {
        return DataType.BIGINT;
      }

    };
  }

  private ColumnBinding<RowBuilder_Project, ProjectGetWhere> createTitleBinding() 
  {
    return new ColumnBinding<RowBuilder_Project, ProjectGetWhere>()
    {
      @Override
      public void set(RowBuilder_Project row, Object value)
      {
        if (valueMustBeSetRaw(value)) 
        {
          row.setTitleRaw(value);
        } else {
          Object castedValue = CastUtil.cast(value, DataType.VARCHAR);
          row.setTitle((java.lang.String)castedValue);
        }
      }
      
      @Override
      public DataType getDataType()
      {
        return DataType.VARCHAR;
      }

    };
  }

  private ColumnBinding<RowBuilder_Project, ProjectGetWhere> createDescriptionBinding() 
  {
    return new ColumnBinding<RowBuilder_Project, ProjectGetWhere>()
    {
      @Override
      public void set(RowBuilder_Project row, Object value)
      {
        if (valueMustBeSetRaw(value)) 
        {
          row.setDescriptionRaw(value);
        } else {
          Object castedValue = CastUtil.cast(value, DataType.VARCHAR);
          row.setDescription((java.lang.String)castedValue);
        }
      }
      
      @Override
      public DataType getDataType()
      {
        return DataType.VARCHAR;
      }

    };
  }

  private boolean valueMustBeSetRaw(Object value)
  {
    return (value instanceof DatabaseRef) || 
           (value instanceof Future<?>) ||
           (value instanceof IDataSetModifier);
  }

}
