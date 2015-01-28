package kistenjunge.org.repository;

import kistenjunge.org.entity.Project;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepo extends CrudRepository<Project, Long>
{
  //You may add other methods here to create queries to execute on the repository
}