package kistenjunge.org;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.MimeMappings;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.SimpleCommandLinePropertySource;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.Arrays;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class App implements EmbeddedServletContainerCustomizer
{

  private final Logger log = LoggerFactory.getLogger(App.class);

  @Inject
  Environment env;

  public static void main(String[] args) throws Exception
  {
    SpringApplication application = new SpringApplication(App.class);

    SimpleCommandLinePropertySource cliSource = new SimpleCommandLinePropertySource(args);
    if (!cliSource.containsProperty("spring.profile.active"))
    {
      application.setAdditionalProfiles("dev");
    }

    application.run(args);
  }

  @PostConstruct
  public void initApplication()
  {
    if (env.getActiveProfiles().length == 0)
    {
      log.debug("No spring profile active");
    }
    else
    {
      log.debug("Active spring profile: {}", Arrays.toString(env.getActiveProfiles()));
    }
  }

  @Override
  public void customize(ConfigurableEmbeddedServletContainer container)
  {
    //Enabled UTF-8 as the default character encoding for static HTML resources.
    //If you would like to disable this comment out the 3 lines below or change
    //the encoding to whatever you would like.
    MimeMappings mappings = new MimeMappings(MimeMappings.DEFAULT);
    mappings.add("html", "text/html;charset=utf-8");
    container.setMimeMappings(mappings);
  }
}