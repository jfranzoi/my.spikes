package my.spikes;

import org.junit.runner.RunWith;

import fitnesse.junit.FitNesseRunner;

@RunWith(FitNesseRunner.class)
@FitNesseRunner.FitnesseDir("./src/test/fitnesse")
@FitNesseRunner.Suite("Spike")
@FitNesseRunner.OutputDir("./target/fitnesse-results")
public class AcceptanceTest {
}
