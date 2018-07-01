package volkanatalan.round;

import java.util.ArrayList;

public class Calc {
  public static double round(double value, int decimalNumberAfterDot) {
    ArrayList<String> valueChars = new ArrayList<>();
    int previousNum = 0;
    String valueS = ""+value;
    
    // Get the index of dot.
    int indexOfDot = valueS.indexOf(".");
    
    // Add the all characters of the number to valueChars ArrayList.
    for (int i = 0; i < valueS.length(); i++) {
      valueChars.add(""+valueS.charAt(i));
    }
    
    // Start a loop, beginning from the digit at the end.
    for (int i = valueS.length() - 1; i >= 0; i--) {
      
      // Get the character. The character can be a number or a dot.
      String character = valueChars.get(i);
      
      // If the character is a number...
      if (!character.equals(".")) {
        int num = Integer.valueOf(character);
        
        // If "i" equals to the index of the required decimal place...
        if (i == indexOfDot + decimalNumberAfterDot) {
          
          // If previous number is bigger than 4,...
          if (previousNum > 4) {
            // ...increase the current number.
            ++num;
            // Set previous number as current number.
            previousNum = num;
            // Set the number at the current index of ArrayList as changed number.
            valueChars.set(i, (num % 10) +"");
          }
  
          // If previous number is not bigger than 4,...
          else {
            // ...just set previous number as current number.
            previousNum = num;
          }
        }
        
        // If "i" equals to last index of the number,...
        else if (i == valueS.length() - 1) {
          // ...set previous number as current number.
          previousNum = num;
          // Delete the number from ArrayList.
          valueChars.remove(i);
        }
        
        // If "i" is smaller than the index of the required decimal place...
        else if (i < indexOfDot + decimalNumberAfterDot) {
          if (i > 0) {
            if (previousNum > 9) {
              ++num;
              previousNum = num;
              valueChars.set(i, (num % 10) +"");
            } else {
              previousNum = num;
            }
          } else if (previousNum > 9) {
            ++num;
            valueChars.set(i, (num % 10) +"");
            if (num > 9) {
              valueChars.add(i, (num / 10) +"");
            }
          }
        }
  
        // If "i" is bigger than the index of the required decimal place
        // and smaller than the index of the last decimal place...
        else {
          if (previousNum > 4) {
            ++num;
            previousNum = num;
            valueChars.remove(i);
          } else {
            previousNum = num;
            valueChars.remove(i);
          }
        }
      }
    }
    
    String resultString = "";
    
    // Print ArrayList to a String
    for (String ch : valueChars) resultString += ch;
    return Double.valueOf(resultString);
  }
}
