package kistenjunge.org.controller;

import kistenjunge.org.entity.Project;
import kistenjunge.org.repository.ProjectRepo;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

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