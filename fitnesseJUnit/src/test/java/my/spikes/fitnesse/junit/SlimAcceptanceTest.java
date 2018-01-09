package my.spikes.fitnesse.junit;

import org.junit.runner.RunWith;

import fitnesse.junit.FitNesseRunner;

@RunWith(FitNesseRunner.class)
@FitNesseRunner.FitnesseDir(value = "./src/test/fitnesse", fitNesseRoot = "root")
@FitNesseRunner.Suite("suite.slim")
@FitNesseRunner.OutputDir("./target/fitnesse-results")
public class SlimAcceptanceTest {
}
