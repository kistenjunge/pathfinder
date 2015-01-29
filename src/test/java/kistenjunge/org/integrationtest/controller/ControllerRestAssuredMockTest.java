package kistenjunge.org.integrationtest.controller;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import com.seitenbau.stu.database.manipulate.RemoveTableColumns;
import com.seitenbau.stu.database.rule.DatabaseSetup;
import com.seitenbau.stu.database.rule.InjectDataSet;
import kistenjunge.org.App;
import kistenjunge.org.database.dataset.ITestProjectDataset;
import kistenjunge.org.entity.Project;
import kistenjunge.org.integrationtest.ITestBase;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import javax.inject.Inject;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.when;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {App.class}, initializers = ConfigFileApplicationContextInitializer.class)
@WebAppConfiguration
@DatabaseSetup(prepare = ITestProjectDataset.class)
public class ControllerRestAssuredMockTest extends ITestBase
{
  @Inject
  WebApplicationContext wac;

  @InjectDataSet
  ITestProjectDataset dataset;

  final String endpoint = "/api/project";

  @Before
  public void setUp() throws Exception
  {
    RestAssuredMockMvc.webAppContextSetup(wac);
  }

  @Test
  public void canFetchAll() throws Exception
  {
    when()
        .get(endpoint)
    .then()
        .log().all()
        .statusCode(HttpStatus.SC_OK)
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
    .when()
        .post(endpoint)
    .then()
        .statusCode(HttpStatus.SC_OK)
        .body("name", equalTo(expectedName))
        .body("description", equalTo(expectedDescription))
        .log().ifValidationFails();

    // and then
    dataset.table_Project.insertRow()
        .setTitle(expectedName)
        .setDescription(expectedDescription);
    dbRule.assertDataBase(dataset, RemoveTableColumns.fromTable("project").exclude("id"));
  }

}