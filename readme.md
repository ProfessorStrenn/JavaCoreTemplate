# JAVA CORE TEMPLATE - QUICKSTART

To start each project in Intellij IDEA:
1. **File | New | Project from Version Control...** (or Get from VCS at the Welcome window).
2. Enter `https://github.com/ProfessorStrenn/JavaCoreTemplate` for the URL.
3. Change the last Directory element from ` javaCoreTemplate` to the name of your project - e.g. `MMarciano_RockCountdown_F35`.
4. Clone.

# A SIMPLER JAVA
The template's `src/cs106` folder includes a `Main.java` class that is ready to go.  It has a bunch of functionality statically imported, allowing you to do things like:

# println
Eliminate the EVIL `System.out.` and just use:
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
The JavaCoreTemplate includes the exceptional [`StringUtils`](https://commons.apache.org/proper/commons-lang/apidocs/org/apache/commons/lang3/StringUtils.html), which has `join`, `substringsBetween`, `reverse`, etc.  For example:
``` java
String[] titles = substringsBetween(quakesXml, "<title>", "</title>");
```

# PMD
[PMD](https://pmd.github.io/) support, including a tailored set of rules (`cs106.ruleset`).

# STATIC IMPORT OF CORE FUNCTIONALITY
JavaCoreTemplate's `Main` class already has the `Core` functionality statically imported.  To add `Core` functionality to other classes, simply put the following static import at the top of the `.java` file:
``` java
import static sbcc.Core.*;
```
