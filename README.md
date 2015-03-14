# soundex
Soundex is a small Java class that implements the Soundex algorithm. There are other implementations of this class, but I looked at the original specification and coded this from scratch since I wanted this functionality in the WordFinder application, and needed a class unencumbered by a restrictive license. This class is very easy to use. For a given string, call this method in the Soundex class:

```
  String getSoundexCode(final String sInput)
```

For the input string, the method will return the Soundex code for that string. If two strings have the same Soundex code, the two strings sound alike.

The source code is released under the MIT license.
