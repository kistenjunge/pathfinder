package kistenjunge.org.integrationtest.controller;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.seitenbau.stu.database.manipulate.RemoveTableColumns;
import com.seitenbau.stu.database.rule.DatabaseSetup;
import com.seitenbau.stu.database.rule.InjectDataSet;
import kistenjunge.org.App;
import kistenjunge.org.database.dataset.ITestProjectDataset;
import kistenjunge.org.entity.Project;
import kistenjunge.org.integrationtest.ITestBase;
import kistenjunge.org.repository.ProjectRepo;
import org.apache.http.HttpStatus;
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

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
@DatabaseSetup(prepare = ITestProjectDataset.class)
public class ProjectRestControllerTest extends ITestBase
{
  @Inject
  ProjectRepo repository;

  @InjectDataSet
  ITestProjectDataset dataset;

  @Value("${local.server.port}")
  int port;

  final Project alpha = new Project("alpha", "description for alpha");
  final Project beta = new Project("beta", null);
  final String endpoint = "/api/project";

  @Before
  public void setUp() throws Exception
  {
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

  @Test
  public void canCreateNewEntity() throws Exception
  {
    // given
    String expectedName = "gamma";
    String expectedDescription = "gamme description";
    Project newEntity = new Project(expectedName, expectedDescription);

    // when
    given()
        .contentType(ContentType.JSON)
        .body(newEntity)
    .expect()
        .statusCode(HttpStatus.SC_OK)
        .body("name", equalTo(expectedName))
        .body("description", equalTo(expectedDescription))
        .log().ifValidationFails()
    .when()
        .post(endpoint);

    // then
    dataset.table_Project.insertRow()
        .setTitle(expectedName)
        .setDescription(expectedDescription);
    dbRule.assertDataBase(dataset, RemoveTableColumns.fromTable("project").exclude("id"));
  }

}