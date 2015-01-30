package kistenjunge.org.entity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "project_id")
  private Set<Component> components = new HashSet<>();

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
