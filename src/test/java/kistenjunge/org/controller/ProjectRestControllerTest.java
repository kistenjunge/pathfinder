package kistenjunge.org.controller;

import com.jayway.restassured.RestAssured;
import kistenjunge.org.App;
import kistenjunge.org.entity.Project;
import kistenjunge.org.repository.ProjectRepo;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import javax.inject.Inject;
import java.util.Arrays;

import static com.jayway.restassured.RestAssured.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class ProjectRestControllerTest
{
  @Inject
  ProjectRepo repository;

  @Value("${local.server.port}")
  int port;
  final Project alpha = new Project("alpha", "description for alpha");
  final Project beta = new Project("beta", null);
  final String endpoint = "/api/project";

  @Before
  public void setUp() throws Exception
  {
    repository.deleteAll();
    repository.save(Arrays.asList(alpha, beta));

    RestAssured.port = port;
  }

  @Test
  public void canFetchAll() throws Exception
  {
    when()
        .get(endpoint)
    .then()
        .statusCode(org.apache.http.HttpStatus.SC_OK)
        .body("name", Matchers.hasItems("alpha", "beta"));
  }

}