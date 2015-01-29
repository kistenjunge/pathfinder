package kistenjunge.org.database;

import com.seitenbau.stu.database.extend.DatasetIdGenerator;

/* *******************************************************
  Generated via : codegeneration.GenerateDatabaseClasses
**********************************************************/
public class ProjectModel
{

  /** actual type : java.lang.Long */
  protected java.lang.Object id;

  /** actual type : java.lang.String */
  protected java.lang.Object title;

  /** actual type : java.lang.String */
  protected java.lang.Object description;

  DatasetIdGenerator _generator;

  public void setIdGenerator(DatasetIdGenerator generator) 
  {
    _generator=generator;
  }

  public ProjectModel setId(Integer intValue)
  {
    this.id = (intValue==null?null:Long.valueOf(intValue));
    return this;
  }

  public ProjectModel setId(java.lang.Long value)
  {
    this.id = value;
    return this;
  }

  public ProjectModel setIdRaw(Object value)
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

  public ProjectModel nextId()
  {
    Long nextId = _generator.nextId("project","id");
    setId(nextId);
    return this;
  }

  public ProjectModel setTitle(java.lang.String value)
  {
    this.title = value;
    return this;
  }

  public ProjectModel setTitleRaw(Object value)
  {
    this.title =  value;
    return this;
  }

  public java.lang.String getTitle()
  {
    return (java.lang.String)  title;
  }

  public java.lang.Object getTitleRaw()
  {
    return title;
  }

  public ProjectModel setDescription(java.lang.String value)
  {
    this.description = value;
    return this;
  }

  public ProjectModel setDescriptionRaw(Object value)
  {
    this.description =  value;
    return this;
  }

  public java.lang.String getDescription()
  {
    return (java.lang.String)  description;
  }

  public java.lang.Object getDescriptionRaw()
  {
    return description;
  }
 
}
