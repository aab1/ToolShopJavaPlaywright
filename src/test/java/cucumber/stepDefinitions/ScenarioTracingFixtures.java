package cucumber.stepDefinitions;

import com.microsoft.playwright.Tracing;
import cucumber.stepDefinitions.PlaywrightCucumberFixtures;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.nio.file.Paths;

public class ScenarioTracingFixtures {

    @Before(order = 3)
    public void setupTracing() {
        PlaywrightCucumberFixtures.getBrowserContext().tracing().start(
                new Tracing.StartOptions()
                        .setScreenshots(true)
                        .setSnapshots(true)
                        .setSources(true)
        );
    }

    @After(order = 4)
    public void recordTraces(Scenario scenario) {
        String traceName = scenario.getName().replace(" ","-").toLowerCase();
        PlaywrightCucumberFixtures.getBrowserContext().tracing().stop(
                new Tracing.StopOptions()
                        .setPath(Paths.get("target/traces/trace-" + traceName + ".zip"))
        );

    }
}
