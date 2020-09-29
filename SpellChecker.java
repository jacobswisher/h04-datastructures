import java.util.Scanner;
import java.io.*;

/*
 * This class implements a spell checker application. 
 * This class requires a proper implementation to the StirngSet class.
 */
public class SpellChecker {

  public static void main(String [] args) {

    File f = new File("dictionary");
    
    try {
      Scanner sk = new Scanner(f);
        
      StringSet x = new StringSet();
    
      // Read in the entire dictionary...
      while (sk.hasNext()) {
        String word = sk.next();
        x.insert(word);      
      }
      System.out.println("Dicitonary loaded...");
     
      sk = new Scanner(System.in);
      
      // Keep suggesting alternatives as long as the user makes an input.
      while (sk.hasNext()) {
        String word = sk.next();
        if (x.find(word))
	  			System.out.println(word + " is correct.");
        else {
	  			System.out.println("Suggesting alternatives ...");
          StringBuilder alternative = new StringBuilder(word);
          char z = 'z';
          for (int t = 0; alternative.length() != t; ++t)
          {
              for (int i = 26; i != 0; i--)
              {
                  alternative.setCharAt(t, z);
                  if (x.find(alternative.toString()))
                  {
                     System.out.println(alternative);
                  }
                  z--;


              }
              alternative = new StringBuilder(word);
              z = 'z';
          }
				}
      }
			
    } catch (FileNotFoundException e) {
      System.out.println("Cannot open file " + f.getAbsolutePath());
      System.out.println(e);
    } 
  } 
}
