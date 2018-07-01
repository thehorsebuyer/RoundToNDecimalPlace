package volkanatalan.round;

import java.util.ArrayList;

public class Calc {
  
  public static double roundToDecimalPlace2(double value, int decimalNumberAfterDot) {
    ArrayList<String> valueChars = new ArrayList<>();
    StringBuilder stringBuilder = new StringBuilder();
    String resultString;
    double result = 0;
    String valueS = value +"";
  
    // Get the index of dot.
    int indexOfDot = valueS.indexOf(".");
    int indexOfRoundPlace = indexOfDot + decimalNumberAfterDot;
  
    // Add the all characters of the number to valueChars ArrayList.
    for (int i = 0; i < valueS.length(); i++) {
      valueChars.add(""+valueS.charAt(i));
    }
  
    // Print ArrayList to a String
    for (String ch : valueChars) stringBuilder.append(ch);
    resultString = stringBuilder.substring(0, indexOfRoundPlace);
  
    int nextNumber = Integer.valueOf(valueChars.get(indexOfRoundPlace + 1));
    if (nextNumber < 4) {
      return Double.valueOf(resultString);
    } else if (nextNumber > 4) {
      return Double.valueOf(resultString) + (1 / Math.pow(10, decimalNumberAfterDot));
    }
    
    
  
    
    
  
    return result;
  }
}
