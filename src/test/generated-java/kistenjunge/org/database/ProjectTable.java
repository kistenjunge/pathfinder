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


/* *******************************************************
  Generated via : codegeneration.GenerateDatabaseClasses
**********************************************************/

/**
 * The project table
 * <p>
 * <p>
 * Use {@link ProjectTable#insertRow()} to model tables with the plain Java builder API.
 * <p>
 * To search for rows, use {@link ProjectTable#findWhere}, {@link ProjectTable#getWhere}
 * or {@link ProjectTable#find}.
 * <p>
 * The table is referenced by these tables:
 * <ul>
 *   <li>{@link ComponentTable}</li>
 * </ul>
 * <p>
 * See {@link PathfinderDatabaseDataSet} for an overview over all tables.
 */
public class ProjectTable implements ITable
{
  public final static String NAME = "project";

  public static class Columns
  {
    public static final String Id = "id";
    public static final String Title = "title";
    public static final String Description = "description";
  }

  // @formatter:off
  public final static Column[] COLUMNS = new Column[] {
    // idx = 0
    new Column(Columns.Id, DataType.BIGINT),
    // idx = 1
    new Column(Columns.Title, DataType.VARCHAR),
    // idx = 2
    new Column(Columns.Description, DataType.VARCHAR)
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

    ColumnMetaDataBuilder builderTitle = new ColumnMetaDataBuilder();
    GENERATOR_METADATA.put(Columns.Title, builderTitle.build());

    ColumnMetaDataBuilder builderDescription = new ColumnMetaDataBuilder();
    GENERATOR_METADATA.put(Columns.Description, builderDescription.build());
  }
  // @formatter:on

  ITableMetaData _metaData;
  
  PathfinderDatabaseDataSet _dataSet;
  
  Iterator<RowBuilder_Project> _iterator;
  
  public ProjectTable()
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

  public List<RowBuilder_Project> rows = new ArrayList<RowBuilder_Project>();
  
  @SuppressWarnings("rawtypes")
  public interface RowSetters_Project<T extends RowSetters_Project>
  {
    T setId(Integer intValue);
    T setId(java.lang.Long value);
    T setIdRaw(Object value);
    T nextId();
    T setTitle(Future<Object> value);
    T setTitle(java.lang.String value);
    T setTitleRaw(Object value);
    T setDescription(Future<Object> value);
    T setDescription(java.lang.String value);
    T setDescriptionRaw(Object value);
  }

  @SuppressWarnings("rawtypes")
  public interface RowGetters_Project<T extends RowGetters_Project>
  {
    java.lang.Long getId();
    java.lang.String getTitle();
    java.lang.String getDescription();

  }

  public static class RowBuilder_Project implements
    RowSetters_Project<RowBuilder_Project>, RowGetters_Project<RowBuilder_Project>
  {

    Object[] data;
    
    Boolean[] mutable;
        
    ProjectTable table;
    
    ProjectRef ref;
    
    RowBuilder_Project(ProjectTable tableDelegate) 
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
    public RowBuilder_Project bind(ProjectRef ref)
    {
      this.ref = ref;
      ref.setBuilder(table._dataSet, this);
      return this;
    }
    
    public ProjectRef getRef()
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

    public RowBuilder_Project setId(Integer intValue)
    {
      return setIdRaw(intValue == null ? null : Long.valueOf(intValue));
    }

    public RowBuilder_Project setId(java.lang.Long value)
    {
      return setIdRaw(value);
    }
    
    public RowBuilder_Project setIdRaw(Object value)
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

    public RowBuilder_Project nextId()
    {
      DatasetIdGenerator generator = table.getDataset().getIdGenerator();
      Long nextId = generator.nextId(ProjectTable.NAME,"id");
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

    public RowBuilder_Project setTitle(Future<Object> value)
    {
      return setTitleRaw(value);
    }

    public RowBuilder_Project setTitle(java.lang.String value)
    {
      return setTitleRaw(value);
    }
    
    public RowBuilder_Project setTitleRaw(Object value)
    {
      assertNoRefType("Title", value);
      data[1] = value;
      return this;
    }

    // use description() in the table model to add a column description
    public java.lang.String getTitle()
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
    public Object getTitleRaw()
    {
      return data[1];
    }

    public RowBuilder_Project setDescription(Future<Object> value)
    {
      return setDescriptionRaw(value);
    }

    public RowBuilder_Project setDescription(java.lang.String value)
    {
      return setDescriptionRaw(value);
    }
    
    public RowBuilder_Project setDescriptionRaw(Object value)
    {
      assertNoRefType("Description", value);
      data[2] = value;
      return this;
    }

    // use description() in the table model to add a column description
    public java.lang.String getDescription()
    {
      Object value = data[2];
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
    public Object getDescriptionRaw()
    {
      return data[2];
    }

    /**
     * Insert a new Row at the end of the Table
     * <code><pre>
     * ds.table_Project.insertRow()
     *   .bind( ANYPROJECTREF )
     *   .setId( null )
     *   .setTitle( null )
     *   .setDescription( null )
     *   ;
     * </pre></code>
     */
    public RowBuilder_Project insertRow()
    {
      return table.insertRow();
    }

    /**
     * Insert a new Row at the end of the Table
     * <code><pre>
     * ds.table_Project.insertRow()
     *   .bind( ANYPROJECTREF )
     *   .setId( null )
     *   .setTitle( null )
     *   .setDescription( null )
     *   ;
     * </pre></code>
     */
    public RowBuilder_Project insertRow(ProjectModel row)
    {
      return table.insertRow(row);
    }

    /**
     * Insert a new Row at the given position
     * <code><pre>
     * ds.table_Project.this.insertRowAt(2)
     *   .bind( ANYPROJECTREF )
     *   .setId( null )
     *   .setTitle( null )
     *   .setDescription( null )
     *   ;
     * </pre></code>
     */
    public RowBuilder_Project insertRowAt(int index)
    {
      return table.insertRowAt(index);
    }

    /**
     * Insert a row at the end of the table
     * <code><pre>
     * ds.table_Project.insertRow(someRow);
     * </pre></code>
     */
    public RowBuilder_Project insertRow(RowBuilder_Project theRow)
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
      if(column.equalsIgnoreCase(Columns.Title) )
      {
        return getColumnValue(1);
      }
      if(column.equalsIgnoreCase(Columns.Description) )
      {
        return getColumnValue(2);
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
    
    @Override
    public RowBuilder_Project clone()
    {
      RowBuilder_Project clone = new RowBuilder_Project(table);
      clone.setId(getId());
      clone.setTitle(getTitle());
      clone.setDescription(getDescription());
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
  public RowCollection_Project find(Filter<RowBuilder_Project> filter)
  {
    RowCollection_Project modifiers = new RowCollection_Project(this, false);
    for (RowBuilder_Project row : rows)
    {
      if (filter.accept(row))
      {
        modifiers.add(row);
      }
    }
    return modifiers;
  }

  public void foreach(Action<RowBuilder_Project> action)
  {
    // TODO iterator instead
    for (RowBuilder_Project row : rows)
    {
      action.call(row);
    }
  }
  
  public List<RowBuilder_Project> getRows()
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
  public ProjectFindWhere findWhere = new ProjectFindWhere(this, true);

  /**
   * Allows searching for one or more rows specified by a column value.
   * quietFindWhere will not throw an exception if no row was found.
   * @see #getWhere
   * @see #findWhere
   * @see #find(Filter)
   */
  public ProjectFindWhere quietFindWhere = new ProjectFindWhere(this, false);

  public static class ProjectFindWhere
  {
    private final List<RowBuilder_Project> rows;
    private final ProjectTable table;
    private final boolean useNotEmptyAssertions;
    
    public ProjectFindWhere(ProjectTable theTable, boolean useNotEmptyAssertions)
    {
       table = theTable;
       rows = theTable.rows;
       this.useNotEmptyAssertions = useNotEmptyAssertions;
    }

    public ProjectFindWhere(ProjectTable theTable, List<RowBuilder_Project> rows, boolean useNotEmptyAssertions)
    {
       table = theTable;
       this.rows = rows;
       this.useNotEmptyAssertions = useNotEmptyAssertions;
    }
    
    public RowCollection_Project rowComparesTo(Comparable<RowBuilder_Project> toSearch) 
    {
      RowCollection_Project modifiers = new RowCollection_Project(table, useNotEmptyAssertions);
      for (RowBuilder_Project row : rows) 
      {
        if (toSearch.compareTo(row) == 0) 
        {
          modifiers.add(row);
        }
      }
      assertModifiersNotEmpty(modifiers, "column values", toSearch);
      return modifiers;
    }

    public RowCollection_Project id(ProjectRef ref)
    {
      RowBuilder_Project row = ref.getBuilder(table._dataSet);
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

    public RowCollection_Project id(java.lang.Long toSearch) 
    {
      RowCollection_Project modifiers = new RowCollection_Project(table, useNotEmptyAssertions);
      for (RowBuilder_Project row : rows) 
      {
        if (toSearch.equals(row.getId())) 
        {
          modifiers.add(row);
        }
      }
      assertModifiersNotEmpty(modifiers, "id", toSearch);
      return modifiers;
    }

    public RowCollection_Project id(Integer toSearch) 
    {
      return id( Long.valueOf(toSearch) );
    }

    public RowCollection_Project title(ProjectRef ref)
    {
      RowBuilder_Project row = ref.getBuilder(table._dataSet);
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
      return title(row.getTitle());
    }

    public RowCollection_Project title(java.lang.String toSearch) 
    {
      RowCollection_Project modifiers = new RowCollection_Project(table, useNotEmptyAssertions);
      for (RowBuilder_Project row : rows) 
      {
        if (toSearch.equals(row.getTitle())) 
        {
          modifiers.add(row);
        }
      }
      assertModifiersNotEmpty(modifiers, "title", toSearch);
      return modifiers;
    }

    public RowCollection_Project description(ProjectRef ref)
    {
      RowBuilder_Project row = ref.getBuilder(table._dataSet);
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
      return description(row.getDescription());
    }

    public RowCollection_Project description(java.lang.String toSearch) 
    {
      RowCollection_Project modifiers = new RowCollection_Project(table, useNotEmptyAssertions);
      for (RowBuilder_Project row : rows) 
      {
        if (toSearch.equals(row.getDescription())) 
        {
          modifiers.add(row);
        }
      }
      assertModifiersNotEmpty(modifiers, "description", toSearch);
      return modifiers;
    }

    private void assertModifiersNotEmpty(RowCollection_Project modifiers, String columnName, Object toSearch)
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
  public ProjectGetWhere getWhere = new ProjectGetWhere(this);

  public static class ProjectGetWhere
  {
    private final List<RowBuilder_Project> rows;
    private final ProjectTable table;
    
    public ProjectGetWhere(ProjectTable theTable) 
    {
       table = theTable;
       rows = theTable.rows;
    }
    
    public Optional<RowBuilder_Project> rowComparesTo(Comparable<RowBuilder_Project> toSearch) 
    {
      Optional<RowBuilder_Project> result = Optional.<RowBuilder_Project> absent();
      for (RowBuilder_Project row : rows) 
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

    public Optional<RowBuilder_Project> id(ProjectRef ref)
    {
      RowBuilder_Project row = ref.getBuilder(table._dataSet);
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

    public Optional<RowBuilder_Project> id(java.lang.Long toSearch) 
    {
      Optional<RowBuilder_Project> result = Optional.<RowBuilder_Project> absent();
      for (RowBuilder_Project row : rows) 
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
    
    public Optional<RowBuilder_Project> id(Integer toSearch) 
    {
      return id( Long.valueOf(toSearch) );
    }

    public Optional<RowBuilder_Project> title(ProjectRef ref)
    {
      RowBuilder_Project row = ref.getBuilder(table._dataSet);
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
      return title(row.getTitle());
    }

    public Optional<RowBuilder_Project> title(java.lang.String toSearch) 
    {
      Optional<RowBuilder_Project> result = Optional.<RowBuilder_Project> absent();
      for (RowBuilder_Project row : rows) 
      {
        if (toSearch.equals(row.getTitle())) 
        {
          if (result.isPresent()) {
            throw new RuntimeException("Multiple hits in getWhere for column title = " + toSearch);
          }
          result = Optional.of(row);
        }      
      }
      return result;
    }

    public Optional<RowBuilder_Project> description(ProjectRef ref)
    {
      RowBuilder_Project row = ref.getBuilder(table._dataSet);
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
      return description(row.getDescription());
    }

    public Optional<RowBuilder_Project> description(java.lang.String toSearch) 
    {
      Optional<RowBuilder_Project> result = Optional.<RowBuilder_Project> absent();
      for (RowBuilder_Project row : rows) 
      {
        if (toSearch.equals(row.getDescription())) 
        {
          if (result.isPresent()) {
            throw new RuntimeException("Multiple hits in getWhere for column description = " + toSearch);
          }
          result = Optional.of(row);
        }      
      }
      return result;
    }
  }
  
  /** Inner class! Use RowCollection_Project in your code ! */
  public static class RowModify_Project extends RowBuilder_Project 
  {
    
    List<RowBuilder_Project> _rows;
    
    boolean _useNotEmptyAssertions;

    public RowModify_Project(ProjectTable theTable, boolean useNotEmptyAssertions) 
    {
      super(theTable);
      _useNotEmptyAssertions = useNotEmptyAssertions;
      _rows = new ArrayList<RowBuilder_Project>();
    }
      
    public void add(RowBuilder_Project row) 
    {
      _rows.add(row);
    }
    
    public List<RowBuilder_Project> getRows()
    {
      return Collections.unmodifiableList(_rows);
    }
      
    public boolean isEmpty() 
    {
      return _rows.isEmpty();
    }

    public RowModify_Project delete()
    {
      for(RowBuilder_Project row : _rows) 
      {
        table.rows.remove(row);
      }
      return this;
    }
      
    public RowModify_Project setId(Integer intValue)
    {
      for(RowBuilder_Project row : _rows) 
      {
        row.setId(intValue);
      }
      return this;
    }

    public RowModify_Project setId(java.lang.Long value)
    {
      for(RowBuilder_Project row : _rows) 
      {
        row.setId(value);
      }
      return this;
    }
      
    public RowModify_Project setIdRaw(Object value)
    {
      for(RowBuilder_Project row : _rows)
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

    public RowModify_Project setTitle(java.lang.String value)
    {
      for(RowBuilder_Project row : _rows) 
      {
        row.setTitle(value);
      }
      return this;
    }
      
    public RowModify_Project setTitleRaw(Object value)
    {
      for(RowBuilder_Project row : _rows)
      {
        row.setTitleRaw(value);
      }
      return this;
    }
    
    // use description() in the table model to add a column description
    public java.lang.String getTitle()
    {
      assertSingleResult(); 
      return _rows.get(0).getTitle();
    }

    public RowModify_Project setDescription(java.lang.String value)
    {
      for(RowBuilder_Project row : _rows) 
      {
        row.setDescription(value);
      }
      return this;
    }
      
    public RowModify_Project setDescriptionRaw(Object value)
    {
      for(RowBuilder_Project row : _rows)
      {
        row.setDescriptionRaw(value);
      }
      return this;
    }
    
    // use description() in the table model to add a column description
    public java.lang.String getDescription()
    {
      assertSingleResult(); 
      return _rows.get(0).getDescription();
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
    public RowModify_Project clone()
    {
      RowModify_Project clone = new RowModify_Project(table, _useNotEmptyAssertions);
      for(RowBuilder_Project row:_rows) 
      {
        clone._rows.add(row.clone());
      }
      return clone;
    }

  }
  
  public static class RowCollection_Project extends RowModify_Project 
  {
    
    public final ProjectFindWhere where;
    
    public RowCollection_Project(ProjectTable theTable, boolean useNotEmptyAssertions) 
    {
      super(theTable, useNotEmptyAssertions);
      where = new ProjectFindWhere(table, _rows, useNotEmptyAssertions);
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
   * ds.table_Project.insertRow()
   *   .bind( ANYPROJECTREF )
   *   .setId( null )
   *   .setTitle( null )
   *   .setDescription( null )
   *   ;
   * </pre></code>
   */
  public RowBuilder_Project insertRow()
  {
    RowBuilder_Project row = new RowBuilder_Project(this);
    row.autoInvokeNextId();
    rows.add(row);
    return row;
  }

  /**
  * <code><pre>
  * ds.table_Project.insertRow()
  * </pre></code>
  */
  public RowBuilder_Project insertRow(ProjectModel rowToAdd)
  {
    RowBuilder_Project row = new RowBuilder_Project(this);
    row.setIdRaw( rowToAdd.getIdRaw() );
    row.setTitleRaw( rowToAdd.getTitleRaw() );
    row.setDescriptionRaw( rowToAdd.getDescriptionRaw() );
    rows.add(row);
    return row;
  }

  /**
  * <code><pre>
  * ds.table_Project.insertRow(data);
  * </pre></code>
  */
  public RowBuilder_Project insertRow(RowBuilder_Project theRow)
  {
    rows.add(theRow);
    return theRow;
  }
  
  /**
  * <code><pre>
  * ds.table_Project.insertRows(data);
  * </pre></code>
  */
  public void insertRows(RowBuilder_Project...theRows)
  {
    rows.addAll(Arrays.asList(theRows));
  }
  
  /**
  * Insert new row at the given index
  * <code><pre>
  * ds.table_Project.insertRowAt(3)
  *   ;
  * </pre></code>
  */
  public RowBuilder_Project insertRowAt(int index)
  {
    RowBuilder_Project row = new RowBuilder_Project(this);
    rows.add(index, row);
    return row;
  }
  
  /**
  * Insert new row Object at the given index
  * <code><pre>
  * ds.table_Project.insertRowAt(3)
  * </pre></code>
  */
  public RowBuilder_Project insertRowAt(int index,RowBuilder_Project theRow)
  {
    rows.add(index, theRow);
    return theRow;
  }
  
  /**
   * Remove a row from the builder by the given index.
   *
   * @return the deleted row
   */ 
  public RowBuilder_Project deleteRow(int index)
  {
    RowBuilder_Project rowBuilder = rows.get(index);
    rows.remove(rowBuilder);
    return rowBuilder;
  }

  /**
   * Remove a row from the data set
   */ 
  public RowBuilder_Project deleteRow(ProjectRef ref)
  {
    return deleteRow(ref.getBuilder(_dataSet));
  }

  /**
   * Remove a row from the data set
   */ 
  public RowBuilder_Project deleteRow(RowBuilder_Project rowToDelete)
  {
    rows.remove(rowToDelete);
    return rowToDelete;
  }

  /**
  * Creates a new row but does not add it to the table
  */
  public RowBuilder_Project newRow()
  {
    RowBuilder_Project row = new RowBuilder_Project(this);
    return row;
  }
  
  /**
  * Returns the next Object. The internal iterator is started at 
  * the first call.
  */
  public RowBuilder_Project next()
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
