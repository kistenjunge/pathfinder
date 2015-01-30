package kistenjunge.org.database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;

import org.dbunit.dataset.ITable;
import org.dbunit.dataset.Column;
import org.dbunit.dataset.ITableMetaData;
import org.dbunit.dataset.DefaultTableMetaData;
import org.dbunit.dataset.RowOutOfBoundsException;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.datatype.DataType;

import com.google.common.base.Optional;
import com.seitenbau.stu.database.dsl.CastUtil;
import com.seitenbau.stu.database.dsl.DataSetIdentificator;
import com.seitenbau.stu.database.dsl.DataSetRegistry;
import com.seitenbau.stu.database.dsl.DatabaseRef;
import com.seitenbau.stu.database.extend.DatasetIdGenerator;
import com.seitenbau.stu.database.generator.ColumnMetaData;
import com.seitenbau.stu.database.generator.ColumnMetaDataBuilder;
import com.seitenbau.stu.database.util.NullCompatibleEquivalence;
import com.seitenbau.stu.util.Action;
import com.seitenbau.stu.util.Filter;
import com.seitenbau.stu.util.Future;
import com.seitenbau.stu.util.DateUtil;
import com.seitenbau.stu.util.date.DateBuilder;

import kistenjunge.org.database.ProjectTable.RowGetters_Project;

/* *******************************************************
  Generated via : codegeneration.GenerateDatabaseClasses
**********************************************************/

/**
 * The component table
 * <p>
 * <p>
 * Use {@link ComponentTable#insertRow()} to model tables with the plain Java builder API.
 * <p>
 * To search for rows, use {@link ComponentTable#findWhere}, {@link ComponentTable#getWhere}
 * or {@link ComponentTable#find}.
 * <p>
 * This table contains relations to these tables:
 * <ul>
 *   <li>{@link ProjectTable}</li>
 * </ul>
 * <p>
 * See {@link PathfinderDatabaseDataSet} for an overview over all tables.
 */
public class ComponentTable implements ITable
{
  public final static String NAME = "component";

  public static class Columns
  {
    public static final String Id = "id";
    public static final String Name = "name";
    public static final String ProjectId = "project_id";
  }

  // @formatter:off
  public final static Column[] COLUMNS = new Column[] {
    // idx = 0
    new Column(Columns.Id, DataType.BIGINT),
    // idx = 1
    new Column(Columns.Name, DataType.VARCHAR),
    // idx = 2
    new Column(Columns.ProjectId, DataType.BIGINT)
  };

  private static final Map<String, ColumnMetaData> GENERATOR_METADATA;
  
  public static ColumnMetaData getColumnMetaData(String column)
  {
    if (!GENERATOR_METADATA.containsKey(column)) 
    {
      throw new RuntimeException("Column " + column + " does not exist, no meta data available.");
    }
    
    return GENERATOR_METADATA.get(column);
  }
  
  static {
    GENERATOR_METADATA = new HashMap<String, ColumnMetaData>();

    ColumnMetaDataBuilder builderId = new ColumnMetaDataBuilder();
    builderId.setFlag("stu_auto_invoke_next");
    builderId.setFlag("stu_immutable");
    builderId.setFlag("stu_identifier");
    builderId.setFlag("stu_default_identifier");
    builderId.setFlag("stu_add_next_method");
    GENERATOR_METADATA.put(Columns.Id, builderId.build());

    ColumnMetaDataBuilder builderName = new ColumnMetaDataBuilder();
    GENERATOR_METADATA.put(Columns.Name, builderName.build());

    ColumnMetaDataBuilder builderProjectId = new ColumnMetaDataBuilder();
    GENERATOR_METADATA.put(Columns.ProjectId, builderProjectId.build());
  }
  // @formatter:on

  ITableMetaData _metaData;
  
  PathfinderDatabaseDataSet _dataSet;
  
  Iterator<RowBuilder_Component> _iterator;
  
  public ComponentTable()
  {
    _metaData = new DefaultTableMetaData(NAME, COLUMNS);
  }

  public void setDataset(PathfinderDatabaseDataSet dataSet)
  {
    _dataSet = dataSet;
  }
  
  public PathfinderDatabaseDataSet getDataset()
  {
    return _dataSet;
  }

  public List<RowBuilder_Component> rows = new ArrayList<RowBuilder_Component>();
  
  @SuppressWarnings("rawtypes")
  public interface RowSetters_Component<T extends RowSetters_Component>
  {
    T setId(Integer intValue);
    T setId(java.lang.Long value);
    T setIdRaw(Object value);
    T nextId();
    T setName(Future<Object> value);
    T setName(java.lang.String value);
    T setNameRaw(Object value);
    T setProjectId(Integer intValue);
    T setProjectId(ProjectRef reference);
    T setProjectId(java.lang.Long value);
    T setProjectIdRaw(Object value);
  }

  @SuppressWarnings("rawtypes")
  public interface RowGetters_Component<T extends RowGetters_Component>
  {
    java.lang.Long getId();
    java.lang.String getName();
    java.lang.Long getProjectId();

  }

  public static class RowBuilder_Component implements
    RowSetters_Component<RowBuilder_Component>, RowGetters_Component<RowBuilder_Component>
  {

    Object[] data;
    
    Boolean[] mutable;
        
    ComponentTable table;
    
    ComponentRef ref;
    
    RowBuilder_Component(ComponentTable tableDelegate) 
    {
      data = new Object[COLUMNS.length];
      mutable = new Boolean[COLUMNS.length];
      for (int i = 0; i < COLUMNS.length; i++)
      {
        mutable[i] = true;
      }
      table = tableDelegate;
    }

    /**
     * Binds the row with the reference in this scope
     * @param ref The reference, which shall be bound to the row builder
     * @return The row builder
     */
    public RowBuilder_Component bind(ComponentRef ref)
    {
      this.ref = ref;
      ref.setBuilder(table._dataSet, this);
      return this;
    }
    
    public ComponentRef getRef()
    {
      return ref;
    }

    void assertNoRefType(String columnName, Object value)
    {
      if (value instanceof DatabaseRef)
      {
        throw new RuntimeException("Column " + columnName + " can not contain a Ref type (class: " + value.getClass().getName() + ")");
      }
    }
    
    void assertNoOrCorrectRefType(String columnName, Class<?> clazz, Object value)
    {
      if (value instanceof DatabaseRef)
      {
        if (!clazz.isInstance(value)) {
          throw new RuntimeException("Column " + columnName + " id can not contain the Ref type (class: " + value.getClass().getName() + ")");
        }
      }
    }

    public RowBuilder_Component setId(Integer intValue)
    {
      return setIdRaw(intValue == null ? null : Long.valueOf(intValue));
    }

    public RowBuilder_Component setId(java.lang.Long value)
    {
      return setIdRaw(value);
    }
    
    public RowBuilder_Component setIdRaw(Object value)
    {
      assertNoRefType("Id", value);
      if (!mutable[0] && NullCompatibleEquivalence.equals(data[0], value))
      {
        throw new RuntimeException("Value id is immutable an cannot be changed (new value: " + value + ", old value: " + data[0] + ").");
      }
      mutable[0] = false;
      data[0] = value;
      return this;
    }

    public RowBuilder_Component nextId()
    {
      DatasetIdGenerator generator = table.getDataset().getIdGenerator();
      Long nextId = generator.nextId(ComponentTable.NAME,"id");
      setId(nextId);
      return this;
    }

    private void autoInvokeNextId()
    {
      nextId();
      // when auto invoked, the value can be overwritten manually
      mutable[0] = true;
    }

    // use description() in the table model to add a column description
    public java.lang.Long getId()
    {
      Object value = data[0];
      return (java.lang.Long)value;
    }

    // use description() in the table model to add a column description
    public Object getIdRaw()
    {
      return data[0];
    }

    public RowBuilder_Component setName(Future<Object> value)
    {
      return setNameRaw(value);
    }

    public RowBuilder_Component setName(java.lang.String value)
    {
      return setNameRaw(value);
    }
    
    public RowBuilder_Component setNameRaw(Object value)
    {
      assertNoRefType("Name", value);
      data[1] = value;
      return this;
    }

    // use description() in the table model to add a column description
    public java.lang.String getName()
    {
      Object value = data[1];
      if (value instanceof Future<?>)
      {
        DataSetIdentificator last = DataSetRegistry.use(table._dataSet);
        @SuppressWarnings("unchecked")
        Future<Object> futureValue = (Future<Object>)value;
        java.lang.String result = (java.lang.String)CastUtil.cast(futureValue.getFuture(), 
          com.seitenbau.stu.database.generator.DataType.VARCHAR);
        DataSetRegistry.use(last);
        return result;
      }
      return (java.lang.String)value;
    }

    // use description() in the table model to add a column description
    public Object getNameRaw()
    {
      return data[1];
    }

    public RowBuilder_Component setProjectId(Integer intValue)
    {
      return setProjectIdRaw(intValue == null ? null : Long.valueOf(intValue));
    }

    public RowBuilder_Component setProjectId(java.lang.Long value)
    {
      return setProjectIdRaw(value);
    }

    public RowBuilder_Component setProjectId(ProjectRef reference)
    {
      return setProjectIdRaw(reference);
    }
    
    public RowBuilder_Component setProjectIdRaw(Object value)
    {
      assertNoOrCorrectRefType("ProjectId", ProjectRef.class, value);
      data[2] = value;
      return this;
    }

    // use description() in the table model to add a column description
    public java.lang.Long getProjectId()
    {
      Object value = data[2];
      if (value instanceof ProjectRef)
      {
        ProjectRef ref = (ProjectRef)value;
        return ref.getBuilder(table._dataSet).getId();
      }      
      return (java.lang.Long)value;
    }

    // use description() in the table model to add a column description
    public Object getProjectIdRaw()
    {
      return data[2];
    }

    /**
     * Insert a new Row at the end of the Table
     * <code><pre>
     * ds.table_Component.insertRow()
     *   .bind( ANYCOMPONENTREF )
     *   .setId( null )
     *   .setName( null )
     *   .setProjectId( null )
     *   ;
     * </pre></code>
     */
    public RowBuilder_Component insertRow()
    {
      return table.insertRow();
    }

    /**
     * Insert a new Row at the end of the Table
     * <code><pre>
     * ds.table_Component.insertRow()
     *   .bind( ANYCOMPONENTREF )
     *   .setId( null )
     *   .setName( null )
     *   .setProjectId( null )
     *   ;
     * </pre></code>
     */
    public RowBuilder_Component insertRow(ComponentModel row)
    {
      return table.insertRow(row);
    }

    /**
     * Insert a new Row at the given position
     * <code><pre>
     * ds.table_Component.this.insertRowAt(2)
     *   .bind( ANYCOMPONENTREF )
     *   .setId( null )
     *   .setName( null )
     *   .setProjectId( null )
     *   ;
     * </pre></code>
     */
    public RowBuilder_Component insertRowAt(int index)
    {
      return table.insertRowAt(index);
    }

    /**
     * Insert a row at the end of the table
     * <code><pre>
     * ds.table_Component.insertRow(someRow);
     * </pre></code>
     */
    public RowBuilder_Component insertRow(RowBuilder_Component theRow)
    {
      return table.insertRow(theRow);
    }
    
    /**
     * Gets the value of a specified column.
     * <p>
     * Throws a RuntimeException, if row count is not equal to 1.
     * @param column The column name (not case sensitive)
     * @return The value
     */
    public Object getValue(String column) throws RuntimeException 
    {
      if(column.equalsIgnoreCase(Columns.Id) )
      {
        return getColumnValue(0);
      }
      if(column.equalsIgnoreCase(Columns.Name) )
      {
        return getColumnValue(1);
      }
      if(column.equalsIgnoreCase(Columns.ProjectId) )
      {
        Object value = data[2];
        if (value instanceof ProjectRef)
        {
          ProjectRef ref = (ProjectRef)value;
          java.lang.Long refValue = ref.getBuilder(table._dataSet).getId();
          return refValue; 
        }      
        return value;
      }
      throw new RuntimeException(NAME + " col = " + column);
    }
    
    // considered private, but possibly unused
    Object getColumnValue(int index)
    {
      Object value = data[index];
      if (value instanceof Future<?>)
      {
        DataSetIdentificator last = DataSetRegistry.use(table._dataSet);
        @SuppressWarnings("unchecked")
        Future<Object> futureValue = (Future<Object>)value;
        Object result = futureValue.getFuture();
        DataSetRegistry.use(last);
        return result;
      } 
      return value;
    }

    public RowBuilder_Component refProjectId(@SuppressWarnings("rawtypes") RowGetters_Project reference)
    {
      setProjectId(reference.getId());
      return this;
    }
    
    @Override
    public RowBuilder_Component clone()
    {
      RowBuilder_Component clone = new RowBuilder_Component(table);
      clone.setId(getId());
      clone.setName(getName());
      clone.setProjectId(getProjectId());
      return clone;
    }
  }
 
  /**
   * Delivers a collection of rows matching to a filter.
   * @param filter The used filter
   * @return The collection of rows, may return an empty list
   * @see #findWhere
   * @see #quietFindWhere
   * @see #getWhere
   */
  public RowCollection_Component find(Filter<RowBuilder_Component> filter)
  {
    RowCollection_Component modifiers = new RowCollection_Component(this, false);
    for (RowBuilder_Component row : rows)
    {
      if (filter.accept(row))
      {
        modifiers.add(row);
      }
    }
    return modifiers;
  }

  public void foreach(Action<RowBuilder_Component> action)
  {
    // TODO iterator instead
    for (RowBuilder_Component row : rows)
    {
      action.call(row);
    }
  }
  
  public List<RowBuilder_Component> getRows()
  {
    return Collections.unmodifiableList(rows);
  }

  /**
   * Allows searching for one or more rows specified by a column value.
   * findWhere assumes that it is used to search for existing rows. An
   * exception will be thrown if no matching row was found. Use {@link
   * #quietFindWhere}, {@link # getWhere} or 
   * #find to avoid this behavior.
   * @see #getWhere
   * @see #quietFindWhere
   * @see #find(Filter)
   */
  public ComponentFindWhere findWhere = new ComponentFindWhere(this, true);

  /**
   * Allows searching for one or more rows specified by a column value.
   * quietFindWhere will not throw an exception if no row was found.
   * @see #getWhere
   * @see #findWhere
   * @see #find(Filter)
   */
  public ComponentFindWhere quietFindWhere = new ComponentFindWhere(this, false);

  public static class ComponentFindWhere
  {
    private final List<RowBuilder_Component> rows;
    private final ComponentTable table;
    private final boolean useNotEmptyAssertions;
    
    public ComponentFindWhere(ComponentTable theTable, boolean useNotEmptyAssertions)
    {
       table = theTable;
       rows = theTable.rows;
       this.useNotEmptyAssertions = useNotEmptyAssertions;
    }

    public ComponentFindWhere(ComponentTable theTable, List<RowBuilder_Component> rows, boolean useNotEmptyAssertions)
    {
       table = theTable;
       this.rows = rows;
       this.useNotEmptyAssertions = useNotEmptyAssertions;
    }
    
    public RowCollection_Component rowComparesTo(Comparable<RowBuilder_Component> toSearch) 
    {
      RowCollection_Component modifiers = new RowCollection_Component(table, useNotEmptyAssertions);
      for (RowBuilder_Component row : rows) 
      {
        if (toSearch.compareTo(row) == 0) 
        {
          modifiers.add(row);
        }
      }
      assertModifiersNotEmpty(modifiers, "column values", toSearch);
      return modifiers;
    }

    public RowCollection_Component id(ComponentRef ref)
    {
      RowBuilder_Component row = ref.getBuilder(table._dataSet);
      if (row == null)
      {
        DataSetIdentificator ds = DataSetRegistry.getCurrentDataSet(table.getDataset().getDataSetClassName());
        if (ds != null)
        {
          row = ref.getBuilder(ds);
        }
      }
      if (row == null)
      {
        throw new RuntimeException("Ref not defined in this scope");
      }
      return id(row.getId());
    }

    public RowCollection_Component id(java.lang.Long toSearch) 
    {
      RowCollection_Component modifiers = new RowCollection_Component(table, useNotEmptyAssertions);
      for (RowBuilder_Component row : rows) 
      {
        if (toSearch.equals(row.getId())) 
        {
          modifiers.add(row);
        }
      }
      assertModifiersNotEmpty(modifiers, "id", toSearch);
      return modifiers;
    }

    public RowCollection_Component id(Integer toSearch) 
    {
      return id( Long.valueOf(toSearch) );
    }

    public RowCollection_Component name(ComponentRef ref)
    {
      RowBuilder_Component row = ref.getBuilder(table._dataSet);
      if (row == null)
      {
        DataSetIdentificator ds = DataSetRegistry.getCurrentDataSet(table.getDataset().getDataSetClassName());
        if (ds != null)
        {
          row = ref.getBuilder(ds);
        }
      }
      if (row == null)
      {
        throw new RuntimeException("Ref not defined in this scope");
      }
      return name(row.getName());
    }

    public RowCollection_Component name(java.lang.String toSearch) 
    {
      RowCollection_Component modifiers = new RowCollection_Component(table, useNotEmptyAssertions);
      for (RowBuilder_Component row : rows) 
      {
        if (toSearch.equals(row.getName())) 
        {
          modifiers.add(row);
        }
      }
      assertModifiersNotEmpty(modifiers, "name", toSearch);
      return modifiers;
    }

    public RowCollection_Component projectId(ComponentRef ref)
    {
      RowBuilder_Component row = ref.getBuilder(table._dataSet);
      if (row == null)
      {
        DataSetIdentificator ds = DataSetRegistry.getCurrentDataSet(table.getDataset().getDataSetClassName());
        if (ds != null)
        {
          row = ref.getBuilder(ds);
        }
      }
      if (row == null)
      {
        throw new RuntimeException("Ref not defined in this scope");
      }
      return projectId(row.getProjectId());
    }

    public RowCollection_Component projectId(ProjectRef ref)
    {
      kistenjunge.org.database.ProjectTable.RowBuilder_Project row = ref.getBuilder(table._dataSet);
      if (row == null)
      {
        DataSetIdentificator ds = DataSetRegistry.getCurrentDataSet(table.getDataset().getDataSetClassName());
        if (ds != null)
        {
          row = ref.getBuilder(ds);
        }
      }
      if (row == null)
      {
        throw new RuntimeException("Ref not defined in this scope");
      }
      return projectId(row.getId());
    }

    public RowCollection_Component projectId(java.lang.Long toSearch) 
    {
      RowCollection_Component modifiers = new RowCollection_Component(table, useNotEmptyAssertions);
      for (RowBuilder_Component row : rows) 
      {
        if (toSearch.equals(row.getProjectId())) 
        {
          modifiers.add(row);
        }
      }
      assertModifiersNotEmpty(modifiers, "project_id", toSearch);
      return modifiers;
    }

    public RowCollection_Component projectId(Integer toSearch) 
    {
      return projectId( Long.valueOf(toSearch) );
    }

    private void assertModifiersNotEmpty(RowCollection_Component modifiers, String columnName, Object toSearch)
    {
      if (useNotEmptyAssertions && modifiers.isEmpty()) 
      {
        throw new RuntimeException("No Row with " + columnName + " = " + toSearch);
      }
    }    
  }

  /**
   * Allows searching for a row specified by a column value.
   * The first matching row is returned. Does not throw an
   * exception, if no element is found.
   * @see #findWhere
   * @see #find(Filter)
   */
  public ComponentGetWhere getWhere = new ComponentGetWhere(this);

  public static class ComponentGetWhere
  {
    private final List<RowBuilder_Component> rows;
    private final ComponentTable table;
    
    public ComponentGetWhere(ComponentTable theTable) 
    {
       table = theTable;
       rows = theTable.rows;
    }
    
    public Optional<RowBuilder_Component> rowComparesTo(Comparable<RowBuilder_Component> toSearch) 
    {
      Optional<RowBuilder_Component> result = Optional.<RowBuilder_Component> absent();
      for (RowBuilder_Component row : rows) 
      {
        if (toSearch.compareTo(row) == 0) 
        {
          if (result.isPresent()) {
            throw new RuntimeException("Multiple hits in getWhere query");
          }
          
          result = Optional.of(row);
        }
      }
      return result;
    }

    public Optional<RowBuilder_Component> id(ComponentRef ref)
    {
      RowBuilder_Component row = ref.getBuilder(table._dataSet);
      if (row == null)
      {
        DataSetIdentificator ds = DataSetRegistry.getCurrentDataSet(table.getDataset().getDataSetClassName());
        if (ds != null)
        {
          row = ref.getBuilder(ds);
        }
      }
      if (row == null)
      {
        throw new RuntimeException("Ref not defined in this scope");
      }
      return id(row.getId());
    }

    public Optional<RowBuilder_Component> id(java.lang.Long toSearch) 
    {
      Optional<RowBuilder_Component> result = Optional.<RowBuilder_Component> absent();
      for (RowBuilder_Component row : rows) 
      {
        if (toSearch.equals(row.getId())) 
        {
          if (result.isPresent()) {
            throw new RuntimeException("Multiple hits in getWhere for column id = " + toSearch);
          }
          result = Optional.of(row);
        }      
      }
      return result;
    }
    
    public Optional<RowBuilder_Component> id(Integer toSearch) 
    {
      return id( Long.valueOf(toSearch) );
    }

    public Optional<RowBuilder_Component> name(ComponentRef ref)
    {
      RowBuilder_Component row = ref.getBuilder(table._dataSet);
      if (row == null)
      {
        DataSetIdentificator ds = DataSetRegistry.getCurrentDataSet(table.getDataset().getDataSetClassName());
        if (ds != null)
        {
          row = ref.getBuilder(ds);
        }
      }
      if (row == null)
      {
        throw new RuntimeException("Ref not defined in this scope");
      }
      return name(row.getName());
    }

    public Optional<RowBuilder_Component> name(java.lang.String toSearch) 
    {
      Optional<RowBuilder_Component> result = Optional.<RowBuilder_Component> absent();
      for (RowBuilder_Component row : rows) 
      {
        if (toSearch.equals(row.getName())) 
        {
          if (result.isPresent()) {
            throw new RuntimeException("Multiple hits in getWhere for column name = " + toSearch);
          }
          result = Optional.of(row);
        }      
      }
      return result;
    }

    public Optional<RowBuilder_Component> projectId(ComponentRef ref)
    {
      RowBuilder_Component row = ref.getBuilder(table._dataSet);
      if (row == null)
      {
        DataSetIdentificator ds = DataSetRegistry.getCurrentDataSet(table.getDataset().getDataSetClassName());
        if (ds != null)
        {
          row = ref.getBuilder(ds);
        }
      }
      if (row == null)
      {
        throw new RuntimeException("Ref not defined in this scope");
      }
      return projectId(row.getProjectId());
    }

    public Optional<RowBuilder_Component> projectId(ProjectRef ref)
    {
      kistenjunge.org.database.ProjectTable.RowBuilder_Project row = ref.getBuilder(table._dataSet);
      if (row == null)
      {
        DataSetIdentificator ds = DataSetRegistry.getCurrentDataSet(table.getDataset().getDataSetClassName());
        if (ds != null)
        {
          row = ref.getBuilder(ds);
        }
      }
      if (row == null)
      {
        throw new RuntimeException("Ref not defined in this scope");
      }
      return projectId(row.getId());
    }

    public Optional<RowBuilder_Component> projectId(java.lang.Long toSearch) 
    {
      Optional<RowBuilder_Component> result = Optional.<RowBuilder_Component> absent();
      for (RowBuilder_Component row : rows) 
      {
        if (toSearch.equals(row.getProjectId())) 
        {
          if (result.isPresent()) {
            throw new RuntimeException("Multiple hits in getWhere for column project_id = " + toSearch);
          }
          result = Optional.of(row);
        }      
      }
      return result;
    }
    
    public Optional<RowBuilder_Component> projectId(Integer toSearch) 
    {
      return projectId( Long.valueOf(toSearch) );
    }
  }
  
  /** Inner class! Use RowCollection_Component in your code ! */
  public static class RowModify_Component extends RowBuilder_Component 
  {
    
    List<RowBuilder_Component> _rows;
    
    boolean _useNotEmptyAssertions;

    public RowModify_Component(ComponentTable theTable, boolean useNotEmptyAssertions) 
    {
      super(theTable);
      _useNotEmptyAssertions = useNotEmptyAssertions;
      _rows = new ArrayList<RowBuilder_Component>();
    }
      
    public void add(RowBuilder_Component row) 
    {
      _rows.add(row);
    }
    
    public List<RowBuilder_Component> getRows()
    {
      return Collections.unmodifiableList(_rows);
    }
      
    public boolean isEmpty() 
    {
      return _rows.isEmpty();
    }

    public RowModify_Component delete()
    {
      for(RowBuilder_Component row : _rows) 
      {
        table.rows.remove(row);
      }
      return this;
    }
      
    public RowModify_Component setId(Integer intValue)
    {
      for(RowBuilder_Component row : _rows) 
      {
        row.setId(intValue);
      }
      return this;
    }

    public RowModify_Component setId(java.lang.Long value)
    {
      for(RowBuilder_Component row : _rows) 
      {
        row.setId(value);
      }
      return this;
    }
      
    public RowModify_Component setIdRaw(Object value)
    {
      for(RowBuilder_Component row : _rows)
      {
        row.setIdRaw(value);
      }
      return this;
    }
    
    // use description() in the table model to add a column description
    public java.lang.Long getId()
    {
      assertSingleResult(); 
      return _rows.get(0).getId();
    }

    public RowModify_Component setName(java.lang.String value)
    {
      for(RowBuilder_Component row : _rows) 
      {
        row.setName(value);
      }
      return this;
    }
      
    public RowModify_Component setNameRaw(Object value)
    {
      for(RowBuilder_Component row : _rows)
      {
        row.setNameRaw(value);
      }
      return this;
    }
    
    // use description() in the table model to add a column description
    public java.lang.String getName()
    {
      assertSingleResult(); 
      return _rows.get(0).getName();
    }
      
    public RowModify_Component setProjectId(Integer intValue)
    {
      for(RowBuilder_Component row : _rows) 
      {
        row.setProjectId(intValue);
      }
      return this;
    }

    public RowModify_Component setProjectId(java.lang.Long value)
    {
      for(RowBuilder_Component row : _rows) 
      {
        row.setProjectId(value);
      }
      return this;
    }
      
    public RowModify_Component setProjectIdRaw(Object value)
    {
      for(RowBuilder_Component row : _rows)
      {
        row.setProjectIdRaw(value);
      }
      return this;
    }
    
    // use description() in the table model to add a column description
    public java.lang.Long getProjectId()
    {
      assertSingleResult(); 
      return _rows.get(0).getProjectId();
    }

    /**
     * Gets the value of a specified column.
     * <p>
     * Throws a RuntimeException, if row count is not equal to 1.
     * @param column The column name (not case sensitive)
     * @return The value
     */
    public Object getValue(String column)
    {
      assertSingleResult();
      return _rows.get(0).getValue(column);
    }
    
    private void assertSingleResult()
    {
      if (_rows.size() != 1) 
      {
        throw new RuntimeException("There where multiple Row in the result! " + _rows.size());
      }
    }    
      
    /** 
     * Return the count of rows contained in this collection
     */
    public int getRowCount()
    {
      return _rows.size();
    }
      
    @Override
    public RowModify_Component clone()
    {
      RowModify_Component clone = new RowModify_Component(table, _useNotEmptyAssertions);
      for(RowBuilder_Component row:_rows) 
      {
        clone._rows.add(row.clone());
      }
      return clone;
    }

  }
  
  public static class RowCollection_Component extends RowModify_Component 
  {
    
    public final ComponentFindWhere where;
    
    public RowCollection_Component(ComponentTable theTable, boolean useNotEmptyAssertions) 
    {
      super(theTable, useNotEmptyAssertions);
      where = new ComponentFindWhere(table, _rows, useNotEmptyAssertions);
    }
    
  }

  /**
   * Clears the table. Simply removes all rows from the table. Does not any magic. 
   */
  public void clear()
  {
    // TODO: Think about unbinding all Refs from the rows...
    rows.clear();
  }

  /**
   * Insert a new empty Row.
   * <code><pre>
   * ds.table_Component.insertRow()
   *   .bind( ANYCOMPONENTREF )
   *   .setId( null )
   *   .setName( null )
   *   .setProjectId( null )
   *   ;
   * </pre></code>
   */
  public RowBuilder_Component insertRow()
  {
    RowBuilder_Component row = new RowBuilder_Component(this);
    row.autoInvokeNextId();
    rows.add(row);
    return row;
  }

  /**
  * <code><pre>
  * ds.table_Component.insertRow()
  * </pre></code>
  */
  public RowBuilder_Component insertRow(ComponentModel rowToAdd)
  {
    RowBuilder_Component row = new RowBuilder_Component(this);
    row.setIdRaw( rowToAdd.getIdRaw() );
    row.setNameRaw( rowToAdd.getNameRaw() );
    row.setProjectIdRaw( rowToAdd.getProjectIdRaw() );
    rows.add(row);
    return row;
  }

  /**
  * <code><pre>
  * ds.table_Component.insertRow(data);
  * </pre></code>
  */
  public RowBuilder_Component insertRow(RowBuilder_Component theRow)
  {
    rows.add(theRow);
    return theRow;
  }
  
  /**
  * <code><pre>
  * ds.table_Component.insertRows(data);
  * </pre></code>
  */
  public void insertRows(RowBuilder_Component...theRows)
  {
    rows.addAll(Arrays.asList(theRows));
  }
  
  /**
  * Insert new row at the given index
  * <code><pre>
  * ds.table_Component.insertRowAt(3)
  *   ;
  * </pre></code>
  */
  public RowBuilder_Component insertRowAt(int index)
  {
    RowBuilder_Component row = new RowBuilder_Component(this);
    rows.add(index, row);
    return row;
  }
  
  /**
  * Insert new row Object at the given index
  * <code><pre>
  * ds.table_Component.insertRowAt(3)
  * </pre></code>
  */
  public RowBuilder_Component insertRowAt(int index,RowBuilder_Component theRow)
  {
    rows.add(index, theRow);
    return theRow;
  }
  
  /**
   * Remove a row from the builder by the given index.
   *
   * @return the deleted row
   */ 
  public RowBuilder_Component deleteRow(int index)
  {
    RowBuilder_Component rowBuilder = rows.get(index);
    rows.remove(rowBuilder);
    return rowBuilder;
  }

  /**
   * Remove a row from the data set
   */ 
  public RowBuilder_Component deleteRow(ComponentRef ref)
  {
    return deleteRow(ref.getBuilder(_dataSet));
  }

  /**
   * Remove a row from the data set
   */ 
  public RowBuilder_Component deleteRow(RowBuilder_Component rowToDelete)
  {
    rows.remove(rowToDelete);
    return rowToDelete;
  }

  /**
  * Creates a new row but does not add it to the table
  */
  public RowBuilder_Component newRow()
  {
    RowBuilder_Component row = new RowBuilder_Component(this);
    return row;
  }
  
  /**
  * Returns the next Object. The internal iterator is started at 
  * the first call.
  */
  public RowBuilder_Component next()
  {
    if(_iterator == null) 
    {
      _iterator = rows.iterator();
    }
    return _iterator.next();
  }
  
  public void resetIterator() 
  {
    _iterator = null;
  }

  public ITableMetaData getTableMetaData() 
  {
    return _metaData;
  }
  
  public int getRowCount() 
  {
    return rows.size();
  }
   
  /**
   * Gets the value of a specified table cell.
   * <p>
   * @param row The table row
   * @param column The column name (not case sensitive)
   * @return The value
   */
  public Object getValue(int row, String column) throws DataSetException 
  {
    if (row >= rows.size() || row < 0) 
    {
      throw new RowOutOfBoundsException();
    }
    return rows.get(row).getValue(column);
  }

  static Date toDate(String dateString)
  {
    return DateUtil.asDate(dateString);
  }
  
  static Date toDate(DateBuilder date)
  {
    if(date == null)
    {
      return null;
    }
    return date.asDate();
  }

}
