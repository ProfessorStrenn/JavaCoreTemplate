# MAKING JAVA PROGRAMMING SIMPLER

# JavaCoreTemplate v6

To start each project in Intellij IDEA:
1. New Project from Version Control.
2. Enter `https://github.com/ProfessorStrenn/JavaCoreTemplate` for the URL.
3. Change the last Directory element from JavaCoreTemplate to the name of your project.
4. Clone.

# Main
Includes `Main.java`, with a `main()` function that is ready to go, and has useful classes statically imported.

# println
Eliminate the EVIL `System.out.` and just use:
```java
println("Hello");
```
# readLine
Read a line of text from the console:
```java
String s = readLine();
```

# readFile
Read a whole file into a String with one line of code:
```java
String quakeText = readFile("4.5_week.atom");
```
# readFileAsLines
Read a file into a list of Strings:
```java
List<String> words = readFileAsLines("dict.txt");
```
# writeFile
Write a string to a file:
```java
writeFile("file.txt", str);
```
# writeFileAsLines
Write a list of strings to a file:
```java
writeFileAsLines("lines.txt", list);
```
# printf
printf w/o requiring `System.out.` in front:
```java
printf("%d words in %s\n", words.size(), path);
print("Hello");
```
# parseInt/Long/Float/Double/Boolean
Parse ints, floats, etc w/o having to put `Integer.` in front:
```java
int age = parseInt(text);
```

<<<<<<< HEAD
# listOf and mapOf
=======
# Easy list and map creation
>>>>>>> 7bbd643e006b1819e5311c49cba7fe1bc5b8af8d
```java
var list = listOf("This", "That", "The other");   // Creates a mutable ArrayList.
var map = mapOf("key1", value1, "key2", value2);  // Creates a mutable HashMap.
```

# range
Use range() to loop in a pythonic manner:
```java
for (var x : range(10))
	println("Hello " + x);
```

# join, substringsBetween, substringBefore, substringAfter, reverse, and more
The JavaCoreTemplate includes the exceptional [`StringUtils`](https://commons.apache.org/proper/commons-lang/apidocs/org/apache/commons/lang3/StringUtils.html), which has `join`, `substringsBetween`, `reverse`, etc.  For example:
```java
String[] titles = substringsBetween(quakesXml, "<title>", "</title>");
```

# PMD
[PMD](https://pmd.github.io/) support, including a tailored set of rules (`cs106.ruleset`).

# STATIC IMPORT OF CORE FUNCTIONALITY
JavaCoreTemplate's `Main` class already has the `Core` functionality statically imported.  To add `Core` functionality to other classes, add the following static import at the top of the `.java` file:
```java
import static sbcc.Core.*;
```
<<<<<<< HEAD
&nbsp;
=======
&nbsp;

# TO USE
1.  Download [workspace-cs106-v4.zip](https://github.com/ProfessorStrenn/workspace-cs106/releases/download/4.0.3/workspace-cs106-v4.zip)
2.  If you are on a CS Lab computer:
    1.  Unzip this archive onto the root of the X: drive.
    2.  Double-click the `C106 - Eclipse - Java` shortcut.
3.  If you are on your own computer:
    1.  File | Switch Workspace | Other...
    2.  Navigate to where you unzipped workspace-cs106-v4.
    3.  Click OK, then click OK again.
4.  If you haven't already done so, check out the [time-saving features that the workspace offers](#WORKSPACE-CS106)
>>>>>>> 7bbd643e006b1819e5311c49cba7fe1bc5b8af8d
