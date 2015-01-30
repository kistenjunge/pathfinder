package kistenjunge.org.entity;

import javax.annotation.Nonnull;
import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Component implements Serializable
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(name = "name", nullable = false, length = 100)
  private String name;

  protected Component()
  {
  }

  public Component(@Nonnull String name)
  {
    this.name = name;
  }

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }
}
