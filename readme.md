# HOW TO START EACH CS106 PROJECT IN INTELLIJ:

1. **File | New | Project from Version Control...** (or **Get from VCS** at the Welcome window).
2. Enter `https://github.com/ProfessorStrenn/JavaCoreTemplate` for the URL.
3. In the _Directory_ textbox, change the last directory element from `JavaCoreTemplate` to the name of your project -
   e.g. `MMarciano_RockCountdown_F35`.  Click Clone.

# A SIMPLER JAVA

The template's `src/cs106` folder includes a `Main.java` class that is ready to go. It has a bunch of functionality
statically imported, allowing you to do things like:

# println

Eliminate the EEEVIL `System.out.` and just use:

``` java
println("Hello");
```

# readLine

Read a line of text from the console:

``` java
String s = readLine();
```

# readFile

Read a whole file into a String with a single line of code:

``` java
String quakeText = readFile("4.5_week.atom");
```

# readFileAsLines

Read a file into a list of Strings:

``` java
List<String> words = readFileAsLines("dict.txt");
```

# writeFile

Write a string to a file:

``` java
writeFile("file.txt", str);
```

# writeFileAsLines

Write a list of strings to a file:

``` java
writeFileAsLines("lines.txt", list);
```

# printf

printf w/o requiring `System.out.` in front:

``` java
printf("%d words in %s\n", words.size(), path);
print("Hello");
```

# parseInt/Long/Float/Double/Boolean

Parse ints, floats, etc w/o having to put `Integer.` in front:

``` java
int age = parseInt(text);
```

# listOf and mapOf

Easily create mutable lists and maps.

``` java
var list = listOf("This", "That", "The other");
var map = mapOf("key1", value1, "key2", value2);
```

# range

Use range() to loop in a pythonic manner:

``` java
for (var x : range(10))
	println("Hello " + x);
```

# join, substringsBetween, substringBefore, substringAfter, reverse, and more

The JavaCoreTemplate includes the
exceptional [`StringUtils`](https://commons.apache.org/proper/commons-lang/apidocs/org/apache/commons/lang3/StringUtils.html)
, which has `join`, `substringsBetween`, `reverse`, etc. For example:

``` java
String[] titles = substringsBetween(quakesXml, "<title>", "</title>");
```

# commons-io

Use `IOUtils.toString()` to easily read from an URL into a String, and `FileUtils.copyUrlToFile()` to read from an URL
into a file.

``` java
// Get the weather in Santa Barbara
var url="https://api.open-meteo.com/v1/forecast?latitude=34.41&longitude=-119.71&current_weather=true&temperature_unit=fahrenheit&windspeed_unit=mph&precipitation_unit=inch&timezone=America%2FLos_Angeles";
var response=IOUtils.toString(new URL(url),StandardCharsets.UTF_8);
```

# PMD

[PMD](https://pmd.github.io/) support, including a tailored set of rules (`cs106.ruleset`).

# STATIC IMPORT OF CORE FUNCTIONALITY

JavaCoreTemplate's `Main` class already has the useful functions statically imported. To add this functionality to other
classes, simply put the following static imports at the top of the `.java` file:

``` java
import static sbcc.Core.*;
import static org.apache.commons.lang3.StringUtils.*;
import static java.lang.System.*;
import static java.lang.Math.*;
```
