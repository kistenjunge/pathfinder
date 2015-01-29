package kistenjunge.org.integrationtest.controller;

import com.seitenbau.stu.database.rule.DatabaseSetup;
import kistenjunge.org.App;
import kistenjunge.org.database.dataset.ITestProjectDataset;
import kistenjunge.org.integrationtest.ITestBase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.ConfigFileApplicationContextInitializer;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.inject.Inject;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {App.class}, initializers = ConfigFileApplicationContextInitializer.class)
@WebAppConfiguration
@DatabaseSetup(prepare = ITestProjectDataset.class)
public class ControllerMockMvcTest extends ITestBase
{
  @Inject
  private WebApplicationContext wac;

  private MockMvc mockMvc;

  @Before
  public void setUp() throws Exception
  {
    mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
  }

  @Test
  public void canFetchAllProjects() throws Exception
  {
    mockMvc.perform(get("/api/project"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON + ";charset=UTF-8"))
        .andExpect(jsonPath("$", hasSize(2)))
        .andExpect(jsonPath("$.[*].name", containsInAnyOrder("alpha", "beta")))
    ;

  }
}
