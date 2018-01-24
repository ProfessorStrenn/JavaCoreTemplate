# JavaCoreTemplate

Includes:
* `Main.java`, with a `main()` that is ready to go, and has useful classes statically imported.

* Provides simple static functions that make Java a **whole lot easier to use**.  For example, to print to the screen it's just:

```java
println("Hello");
```
rather than the EVIL `System.out.println("Hello");`

Read a whole file into a String with one line of code:
```java
String quakeText = readFile("4.5_week.atom");
```
Read a file into a list of Strings:
```java
List<String> words = readFileAsLines("dict.txt");
```
Write a String to a file:
```java
writeFile("file.txt", str);
```
Write a list of strings to a file:
```java
writeFileAsLines("lines.txt", list);
```
printf w/o requiring System.out in front:
```java
printf("%d words in %s\n", words.size(), path);
print("Hello");
```
Read a line of text from the console:
```java
String s = readLine();
```
Parse ints, floats, etc w/o having to put Integer in front:
```java
parseInt/Long/Float/Double/Boolean()
```

* `commons-lang3`:  With the wonderful `StringUtils`, which has `join`, `substringsBetween`, `reverse`, etc.  For example:
```java
String[] titles = substringsBetween(quakesXml, "<title>", "</title>");
```

* [PMD](https://pmd.github.io/) support, including a tailored set of rules (`cs106.ruleset`).


# STATIC IMPORT OF CORE FUNCTIONALITY
JavaCoreTemplate's Main class already has the Core functionality statically imported.  If that static import has been removed, and to add core functionality to other classes, add the following static import at the top of the .java file:
```java
import static sbcc.Core.*;
```
