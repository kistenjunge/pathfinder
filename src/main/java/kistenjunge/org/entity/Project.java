package kistenjunge.org.entity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Project implements Serializable
{

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(name = "title", nullable = false, length = 100)
  private String name;

  @Column(name = "description", nullable = true, length = 500)
  private String description;

  /**
   * protected no-args ctor
   */
  protected Project()
  {
  }

  public Project(@Nonnull String name, @Nullable String description)
  {
    this.name = name;
    this.description = description;
  }

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
