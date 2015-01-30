package kistenjunge.org.database;

import com.seitenbau.stu.database.extend.DatasetIdGenerator;

/* *******************************************************
  Generated via : codegeneration.GenerateDatabaseClasses
**********************************************************/
public class ComponentModel
{

  /** actual type : java.lang.Long */
  protected java.lang.Object id;

  /** actual type : java.lang.String */
  protected java.lang.Object name;

  /** actual type : java.lang.Long */
  protected java.lang.Object projectId;

  DatasetIdGenerator _generator;

  public void setIdGenerator(DatasetIdGenerator generator) 
  {
    _generator=generator;
  }

  public ComponentModel setId(Integer intValue)
  {
    this.id = (intValue==null?null:Long.valueOf(intValue));
    return this;
  }

  public ComponentModel setId(java.lang.Long value)
  {
    this.id = value;
    return this;
  }

  public ComponentModel setIdRaw(Object value)
  {
    this.id =  value;
    return this;
  }

  public java.lang.Long getId()
  {
    return (java.lang.Long)  id;
  }

  public java.lang.Object getIdRaw()
  {
    return id;
  }

  public ComponentModel nextId()
  {
    Long nextId = _generator.nextId("component","id");
    setId(nextId);
    return this;
  }

  public ComponentModel setName(java.lang.String value)
  {
    this.name = value;
    return this;
  }

  public ComponentModel setNameRaw(Object value)
  {
    this.name =  value;
    return this;
  }

  public java.lang.String getName()
  {
    return (java.lang.String)  name;
  }

  public java.lang.Object getNameRaw()
  {
    return name;
  }

  public ComponentModel setProjectId(Integer intValue)
  {
    this.projectId = (intValue==null?null:Long.valueOf(intValue));
    return this;
  }

  public ComponentModel setProjectId(java.lang.Long value)
  {
    this.projectId = value;
    return this;
  }

  public ComponentModel setProjectIdRaw(Object value)
  {
    this.projectId =  value;
    return this;
  }

  public java.lang.Long getProjectId()
  {
    return (java.lang.Long)  projectId;
  }

  public java.lang.Object getProjectIdRaw()
  {
    return projectId;
  }
 
}
