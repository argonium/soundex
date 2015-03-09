/**
 * This class implements the Soundex algorithm.  It accepts
 * an input string and returns the corresponding soundex
 * code.  If two strings have the same soundex code, then
 * the two strings sound alike.
 * 
 * @author mwallace
 * @version 1.0
 */
public final class Soundex
{
  /**
   * Make the default constructor private.
   */
  private Soundex()
  {
    super();
  }
  
  
  /**
   * Generate the integer portion of the soundex code
   * for a character.
   * 
   * @param ch the character to process
   * @return the integer code for the character
   */
  private static int getIntValue(final char ch)
  {
    int n = 0;
    
    switch (ch)
    {
      case 'b':
      case 'f':
      case 'p':
      case 'v':
      {
        n = 1;
        break;
      }
    
      case 'c':
      case 'g':
      case 'j':
      case 'k':
      case 'q':
      case 's':
      case 'x':
      case 'z':
      {
        n = 2;
        break;
      }
    
      case 'd':
      case 't':
      {
        n = 3;
        break;
      }
    
      case 'l':
      {
        n = 4;
        break;
      }
    
      case 'm':
      case 'n':
      {
        n = 5;
        break;
      }
    
      case 'r':
      {
        n = 6;
        break;
      }
    
      default:
        n = 0;
    }
    
    return n;
  }
  
  
  /**
   * Returns the soundex code for a string.  If two strings
   * have the same soundex code, the two strings sound alike.
   * 
   * @param sInput the input string
   * @return the soundex code for the input string
   */
  public static String getSoundexCode(final String sInput)
  {
    // Check the input
    if ((sInput == null) || (sInput.length() < 1))
    {
      return "";
    }
    
    // Declare our string variable to hold the soundex code
    StringBuilder buf = new StringBuilder(10);
    
    // The first character of the string is the start
    // of the soundex code
    buf.append(sInput.charAt(0));
    
    // Convert the string to lower case
    final String sWord = sInput.toLowerCase();
    
    // Save the value of the first character, to check
    // for duplicates later
    int nPrevValue = getIntValue(sWord.charAt(0));
    
    // Initialize this variable
    int nCurrValue = -1;
    
    // Save the length of the string
    final int nLen = sWord.length();
    
    // Iterate over each character in the word, until
    // we have enough to fill the soundex code (the
    // form is A999 - a character followed by 3 digits).
    for (int i = 1; (i < nLen) && (buf.length() < 4); ++i)
    {
      // Get the integer value for the current character
      nCurrValue = getIntValue(sWord.charAt(i));
      
      // Make sure the current value is not a duplicate of
      // the previous value, and the current value is non-zero
      if ((nCurrValue != nPrevValue) && (nCurrValue != 0))
      {
        buf.append(Integer.toString(nCurrValue));
      }
      
      // Save the current value as the previous value
      nPrevValue = nCurrValue;
    }
    
    // Check the length of the string
    int nSize = buf.length() - 4;
    if (nSize < 0)
    {
      // The string is too short, so append zeros
      while (nSize < 0)
      {
        buf.append("0");
        ++nSize;
      }
    }
    
    // Return the generated soundex code for the input string
    return buf.toString();
  }
}
