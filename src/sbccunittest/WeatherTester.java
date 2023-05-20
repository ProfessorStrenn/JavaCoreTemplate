package sbccunittest;

import cs106.*;
import org.junit.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

import static java.lang.Math.*;
import static java.lang.System.*;
import static org.apache.commons.lang3.StringUtils.*;
import static org.junit.Assert.*;
import static sbcc.Core.*;

// Updated 02/05/2023

public class WeatherTester {

    public static int totalScore = 0;

    public static int maxScore = 5;

    public static InputStream defaultSystemIn;
    public static PrintStream defaultSystemOut;
    public static PrintStream defaultSystemErr;

    public String separator = getProperty("line.separator");

    private final PrintStream originalOut = out;

    private final OutputStream os = new ByteArrayOutputStream();

    public static ArrayList<String> suggestions = new ArrayList<>();


    public static Set<String> validConditions = new HashSet<>(Arrays.asList(
            "Unknown",
            "☀ Clear skies ☀",
            "\uD83C\uDF24 Mostly clear \uD83C\uDF24",
            "\uD83C\uDF24 Partly cloudy \uD83C\uDF24",
            "☁ Overcast ☁",
            "\uD83C\uDF2B Foggy \uD83C\uDF2B",
            "\uD83C\uDF2B Freezing fog \uD83C\uDF2B",
            "\uD83C\uDF26 Light drizzle \uD83C\uDF26",
            "\uD83C\uDF27 Moderate drizzle \uD83C\uDF27",
            "\uD83C\uDF27 Dense drizzle \uD83C\uDF27",
            "\uD83C\uDF27 Light freezing drizzle",
            "\uD83C\uDF27 Dense freezing drizzle \uD83C\uDF27",
            "\uD83C\uDF27 Slight rain \uD83C\uDF27",
            "\uD83C\uDF27 Moderate rain \uD83C\uDF27",
            "\uD83C\uDF27 Heavy rain \uD83C\uDF27",
            "\uD83C\uDF27 Light freezing rain \uD83C\uDF27",
            "\uD83C\uDF27 Heavy freezing rain \uD83C\uDF27",
            "\uD83C\uDF28 Lightly snowfall \uD83C\uDF28",
            "\uD83C\uDF28 Moderately snowfall \uD83C\uDF28",
            "\uD83C\uDF28 Heavy snowfall \uD83C\uDF28",
            "\uD83C\uDF28 Snow grains \uD83C\uDF28",
            "\uD83C\uDF27 Light rain showers \uD83C\uDF27",
            "\uD83C\uDF27 Moderate rain showers \uD83C\uDF27",
            "\uD83C\uDF27 Heavy rain showers \uD83C\uDF27",
            "\uD83C\uDF28 Light snow showers \uD83C\uDF27",
            "\uD83C\uDF28 Heavy snow showers \uD83C\uDF27",
            "\uD83C\uDF29 Slight or moderate thunderstorm \uD83C\uDF29",
            "\uD83C\uDF29 Slight or moderate thunderstorm with hail \uD83C\uDF29",
            "⛈ Heavy thunderstorm ⛈",
            "⛈ Heavy thunderstorm with hail ⛈"
    ));

    @BeforeClass // Runs Before any test is done
    public static void beforeTesting() throws IOException {
        totalScore = 0;
        suggestions.add("""
                                
                🧐 ⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
                """);

    }


    @AfterClass
    public static void afterTesting() throws IOException {
        println(lineSeparator() + "Estimated score out of " + maxScore + " (w/o late penalties, etc.) = " + totalScore);
        provideSuggestions();
    }

    private static void provideSuggestions() throws IOException {

        if (suggestions.size() > 1)
            println(join(suggestions, ""));
    }

    @Before
    public void setUp() {
        PrintStream ps = new PrintStream(os);
        setOut(ps);
        defaultSystemIn = in;
        defaultSystemOut = out;
        defaultSystemErr = err;
    }


    @After
    public void tearDown() {
        setIn(defaultSystemIn);
        setOut(originalOut);

    }


    @Test
    public void testUsesTemplateProjectCorrectly() throws IOException {
        Stream<Path> count = Files.find(Paths.get("lib"), Integer.MAX_VALUE,
                (path, basicFileAttributes) -> path.toFile().getName().matches("sbcccore.*.*.*.jar"));

        String src = readFile(Paths.get("src", "cs106", "Main.java").toString());
        if (!src.contains("import static sbcc.Core.*;"))
            fail("static import of sbcc.Core not found.  To add sbcc.Core functionality to your project, see https://github.com/ProfessorStrenn/JavaCoreTemplate#static-import-of-core-functionality.");

        totalScore += 1;

        if (src.contains("System.out.println"))
            fail("System.out.println()'s should to be replaced with just println().");

        count.close();
    }


    @Test
    public void testWeatherForRandomCity() throws IOException {
        Path path = Path.of("testWeatherLatLngHardcoded_passed");
        if (Files.exists(path)) Files.delete(path);
        var cities = new String[]{"Atlanta, GA", "New York, NY", "Los Angeles, CA", "Chicago, IL", "Miami, FL", "Dallas, TX", "Houston, TX", "Philadelphia, PA", "Atlanta, GA", "Washington, DC", "Boston, MA", "Phoenix, AZ", "Detroit, MI", "Seattle, WA", "San Francisco, CA", "San Diego, CA", "Minneapolis, MN", "Brooklyn, NY", "Tampa, FL", "Denver, CO", "Queens, NY"};
        var location = cities[(int) (random() * cities.length)];  // Random city
        sendToStdinOfTestee(location + "\n");
        Main.main(null);
        totalScore += 1;        // One point for not crashing
        var output = os.toString();
        var outputLines = Arrays.stream(output.trim().split("\\r?\\n|\\r")).filter(line -> !line.trim().isEmpty()).toArray(String[]::new);
        assertEquals("Location:", outputLines[0].trim());
        totalScore += 1;
        assertEquals("Current weather for " + location, outputLines[1].trim());
        var line2Parts = outputLines[2].trim().split("\\s");
        assertEquals("Temperature:", line2Parts[0]);
        assertEquals("°F", line2Parts[line2Parts.length - 1]);
        var temp = parseDouble(substringBetween(outputLines[2], "Temperature:", "°F").trim());
        totalScore += 1;
        var line3Parts = outputLines[3].trim().split("\\s");
        assertEquals("Condition:", line3Parts[0]);
        var actualCondition = substringAfter(outputLines[3], "Condition:").trim();
        boolean isValidCondition = validConditions.contains(actualCondition);
        assertTrue("The condition \"" + actualCondition + "\" does not exactly match one of the values in the validConditions set.", isValidCondition);
        totalScore += 1;
        writeFile("testWeatherLatLngHardcoded_passed", "passed");

    }


    public void sendToStdinOfTestee(String message) {
        setIn(new ByteArrayInputStream(message.getBytes()));
    }

}