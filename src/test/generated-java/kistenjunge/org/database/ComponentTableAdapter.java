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

import kistenjunge.org.database.ComponentTable.RowBuilder_Component;
import kistenjunge.org.database.ComponentTable.RowCollection_Component;
import kistenjunge.org.database.ComponentTable.ComponentFindWhere;
import kistenjunge.org.database.ComponentTable.ComponentGetWhere;


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
public class ComponentTableAdapter {

  /**
   * Do not set a value. (To remove a value use {@code null})
   */
  public final NoValue _ = new NoValue();

  /**
   * Column Header for Component table.
   * <p>
   * Binds a {@link ComponentRef} with the current row. To create a Ref, use the {@link RefFactory}. 
   * <p>
   * Data Type: ComponentRef
   * <p>
   */
  public final ColumnBinding<RowBuilder_Component, ComponentGetWhere> REF = new RefColumnBinding<RowBuilder_Component, ComponentGetWhere>();

  /**
   * Column Header for Component table.
   * <p>
   * Data Type: {@code java.lang.Long}
   * <br>   
   * Database Type: DataType.BIGINT
   * 
   */
  public final ColumnBinding<RowBuilder_Component, ComponentGetWhere> id = createIdBinding();

  /**
   * Column Header for Component table.
   * <p>
   * Data Type: {@code java.lang.String}
   * <br>   
   * Database Type: DataType.VARCHAR
   * 
   */
  public final ColumnBinding<RowBuilder_Component, ComponentGetWhere> name = createNameBinding();

  /**
   * Column Header for Component table.
   * <p>
   * Data Type: {@code java.lang.Long}
   * or {@link ProjectRef}
   * <br>   
   * Database Type: DataType.BIGINT
   * 
   */
  public final ColumnBinding<RowBuilder_Component, ComponentGetWhere> project_id = createProjectIdBinding();

  /**
   * Column Header for Component table.
   * <p>
   * Data Type: {@code java.lang.Long}
   * or {@link ProjectRef}
   * <br>   
   * Database Type: DataType.BIGINT
   * 
   */
  public final ColumnBinding<RowBuilder_Component, ComponentGetWhere> project = project_id;

  private final PathfinderDatabaseBuilder _builder;

  private final ComponentTable _table;

  private final TableParserAdapter<RowBuilder_Component, ComponentGetWhere, ComponentRef> _adapter = new TableAdapter();

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
  public final ComponentFindWhere findWhere;

  /**
   * Allows searching for one or more rows specified by a column value.
   * quietFindWhere will not throw an exception if no row was found.
   * @see #getWhere
   * @see #findWhere
   * @see #find(Closure)
   * @see #find(Filter)
   */
  public final ComponentFindWhere quietFindWhere;

  /**
   * Allows searching for a row specified by a column value.
   * The first matching row is returned. Does not throw an
   * exception, if no element is found.
   * @see #findWhere
   * @see #quietFindWhere
   * @see #find(Closure)
   * @see #find(Filter)
   */
  public final ComponentGetWhere getWhere;

  ComponentTableAdapter(PathfinderDatabaseBuilder builder, ComponentTable table)
  {
    _builder = builder;
    _table = table;
    findWhere = _table.findWhere;
    quietFindWhere = _table.quietFindWhere;
    getWhere = _table.getWhere;
  }

  public static ColumnMetaData getColumnMetaData(String column)
  {
    return kistenjunge.org.database.ComponentTableAdapter.getColumnMetaData(column);
  }

  /**
   * Parses the rows of a Component table. Supported columns are:
   * <ul>
   *   <li><strong>{@code REF}</strong>: {@link ComponentRef}</li>
   *   <li> <strong>{@code id}</strong>: {@code java.lang.Long}
   *   <li> <strong>{@code name}</strong>: {@code java.lang.String}
   *   <li> <strong>{@code project_id}</strong>: {@code java.lang.Long}
   * </ul>
   * The table has to start with a header row, but there can be more
   * headers within one block.
   *
   * <p>Example usage:
   * <pre>
   * componentTable.rows {
   *   REF             | id  | name  | project_id   
   *   ANYCOMPONENTREF | 123 | "abc" | ANYPROJECTREF
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
   * ds.componentTable.insertRow()
   *   .bind(ANYCOMPONENTREF)
   *   .setId( null )
   *   .setName( null )
   *   .setProjectId( null )
   *   ;
   * </pre></code>
   */
  public RowBuilder_Component insertRow()
  {
    return _table.insertRow();
  }

  /**
   * Insert a new Row at the end of the Table
   * <code><pre>
   * ds.componentTable.insertRow()
   *   .bind( ANYCOMPONENTREF )
   *   .setId( null )
   *   .setName( null )
   *   .setProjectId( null )
   *   ;
   * </pre></code>
   */
  public RowBuilder_Component insertRow(ComponentModel row)
  {
    return _table.insertRow(row);
  }

  /**
   * Insert a new Row at the given position
   * <code><pre>
   * ds.componentTable.this.insertRowAt(2)
   *   .bind( ANYCOMPONENTREF )
   *   .setId( null )
   *   .setName( null )
   *   .setProjectId( null )
   *   ;
   * </pre></code>
   */
  public RowBuilder_Component insertRowAt(int index)
  {
    return _table.insertRowAt(index);
  }

  /**
   * Insert a row at the end of the table
   * <code><pre>
   * ds.componentTable.insertRow(someRow);
   * </pre></code>
   */
  public RowBuilder_Component insertRow(RowBuilder_Component theRow)
  {
    return _table.insertRow(theRow);
  }

  /**
   * Remove a row from the builder by the given index.
   *
   * @return the deleted row
   */
  public RowBuilder_Component deleteRow(int index)
  {
    return _table.deleteRow(index);
  }

  /**
   * Remove a row from the data set
   */
  public RowBuilder_Component deleteRow(ComponentRef ref)
  {
    return _table.deleteRow(ref);
  }

  /**
   * Remove a row from the builder
   * @return the deleted row itself
   */
  public RowBuilder_Component deleteRow(RowBuilder_Component rowToDelete)
  {
    return _table.deleteRow(rowToDelete);
  }

  /**
   * Creates a new row but does not add it to the table
   */
  public RowBuilder_Component newRow()
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
  public RowCollection_Component find(Filter<RowBuilder_Component> filter)
  {
    return _table.find(filter);
  }

  /**
   * Delivers a collection of rows matching to a filter.
   * @param filter A Groovy Closure with an argument of type RowBuilder_Component, returning a boolean
   * @return The collection of rows, may return an empty list
   * @see #find(Filter)
   * @see #findWhere
   * @see #getWhere
   */
  public RowCollection_Component find(Closure<Boolean> filter)
  {
    final Closure<Boolean> localFilter = filter;
    return _table.find(new Filter<RowBuilder_Component>()
      {
        @Override
        public boolean accept(RowBuilder_Component row)
        {
          return localFilter.call(row);
        }
      });
  }

  public void foreach(Action<RowBuilder_Component> action)
  {
    _table.foreach(action);
  }

  public void foreach(Closure<?> action)
  {
    final Closure<?> localAction = action;
    _table.foreach(new Action<RowBuilder_Component>()
      {
        @Override
        public void call(RowBuilder_Component row)
        {
          localAction.call(row);
        }
      });
  }

  public List<RowBuilder_Component> getRows()
  {
    return _table.getRows();
  }

  private class TableAdapter implements TableParserAdapter<RowBuilder_Component, ComponentGetWhere, ComponentRef>
  {
    @Override
    public RowBuilder_Component insertRow() 
    {
      return _table.insertRow();
    }
  
    @Override
    public ComponentGetWhere getWhere()
    {
      return _table.getWhere;
    }

    @Override
    public void bindToDataSet(ComponentRef reference, RowBuilder_Component row)
    {
      reference.setBuilder(_builder, row);
    }

    @Override
    public RowBuilder_Component getRowByReference(ComponentRef reference)
    {
      return reference.getBuilder(_builder);
    }

    @Override
    public Object getTableContext()
    {
      return ComponentTableAdapter.this;
    }

    @Override
    public String getTableName()
    {
      return "Component";
    }
    
  };


  private ColumnBinding<RowBuilder_Component, ComponentGetWhere> createIdBinding() 
  {
    return new ColumnBinding<RowBuilder_Component, ComponentGetWhere>()
    {
      @Override
      public void set(RowBuilder_Component row, Object value)
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
      public Optional<RowBuilder_Component> getWhere(ComponentGetWhere getWhere, Object value)
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

  private ColumnBinding<RowBuilder_Component, ComponentGetWhere> createNameBinding() 
  {
    return new ColumnBinding<RowBuilder_Component, ComponentGetWhere>()
    {
      @Override
      public void set(RowBuilder_Component row, Object value)
      {
        if (valueMustBeSetRaw(value)) 
        {
          row.setNameRaw(value);
        } else {
          Object castedValue = CastUtil.cast(value, DataType.VARCHAR);
          row.setName((java.lang.String)castedValue);
        }
      }
      
      @Override
      public DataType getDataType()
      {
        return DataType.VARCHAR;
      }

    };
  }

  private ColumnBinding<RowBuilder_Component, ComponentGetWhere> createProjectIdBinding() 
  {
    return new ColumnBinding<RowBuilder_Component, ComponentGetWhere>()
    {
      @Override
      public void set(RowBuilder_Component row, Object value)
      {
        if (valueMustBeSetRaw(value)) 
        {
          row.setProjectIdRaw(value);
        } else {
          Object castedValue = CastUtil.cast(value, DataType.BIGINT);
          row.setProjectId((java.lang.Long)castedValue);
        }
      }
      
      @Override
      public DataType getDataType()
      {
        return DataType.BIGINT;
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
