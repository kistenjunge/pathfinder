package kistenjunge.org.entity;

import javax.persistence.*;

@Entity
public class Project
{

  @Column(name = "title", nullable = false, length = 100)
  String name;

  @Column(name = "description", nullable = true, length = 500)
  String description;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }
}
