package volkanatalan.round;

import android.util.Log;

import java.util.ArrayList;

public class Calc {
  
  public static double roundToDecimalPlace(double value, int decimalNumberAfterDot) {
    ArrayList<String> charList = new ArrayList<>();
    String valueString = value +"";
    String resultString;
    int indexOfDot = valueString.indexOf(".");
    int indexOfRoundPlace = indexOfDot + decimalNumberAfterDot;
    resultString = valueString.substring(0, indexOfRoundPlace + 1);
  
    // Add the all characters of the number to valueChars ArrayList.
    for (int i = 0; i < valueString.length(); i++) {
      charList.add(""+valueString.charAt(i));
    }
    
    int nextNumber = Integer.valueOf(charList.get(indexOfRoundPlace + 1));
    
    if (nextNumber < 4) {
      return Double.valueOf(resultString);
    } else if (nextNumber > 4) {
      return Double.valueOf(resultString) + (1 / Math.pow(10, decimalNumberAfterDot));
    } else  {
      int i = indexOfRoundPlace + 2;
      while (indexOfRoundPlace < charList.size()) {
        if (Integer.valueOf(charList.get(i)) < 4) {
          return Double.valueOf(resultString);
        } else if (Integer.valueOf(charList.get(i)) > 4) {
          resultString = Double.valueOf(resultString) + (1 / Math.pow(10, decimalNumberAfterDot)) +"";
          return Double.valueOf(resultString.substring(0, indexOfRoundPlace + 1));
        } else if (indexOfRoundPlace == charList.size() - 1) {
          return Double.valueOf(resultString);
        }
        i++;
      }
    }
  
    return 0;
  }
}
