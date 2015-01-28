package kistenjunge.org.controller;

import kistenjunge.org.entity.Project;

import java.util.ArrayList;
import java.util.List;

import kistenjunge.org.repository.ProjectRepo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping("/api/project")
public class ProjectRestController
{

  @Inject
  private ProjectRepo repo;

  @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
  public void delete(@PathVariable Long id)
  {
    repo.delete(id);
  }

  @RequestMapping(method = RequestMethod.POST)
  public Project create(@RequestBody Project domain)
  {
    return repo.save(domain);
  }

  @RequestMapping(value = "{id}", method = RequestMethod.PUT)
  public Project update(@RequestBody Project domain, @PathVariable Long id)
  {
    Project update = repo.findOne(id);
    //TODO Implement logic to update object from DB
    return repo.save(update);

  }

  @RequestMapping(method = RequestMethod.GET)
  public List<Project> list()
  {
    return (List<Project>) repo.findAll();

  }
}