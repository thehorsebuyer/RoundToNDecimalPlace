package volkanatalan.round;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
  EditText editText, editText2;
  Button button;
  TextView textView;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  
    editText = findViewById(R.id.editText);
    editText2 = findViewById(R.id.editText2);
    button = findViewById(R.id.button);
    textView = findViewById(R.id.textView);
    
  }
  
  public void buttonClick (View view) {
    Double number = Double.valueOf(editText.getText().toString());
    int digitNumberAfterDot = Integer.valueOf(editText2.getText().toString());
  
    double result = round(number, digitNumberAfterDot);
    
    textView.setText(result+"");
  }
  
  public static double round(double value, int decimalNumberAfterDot) {
    ArrayList<String> valueChars = new ArrayList<>();
    int previousNum = 0;
    String valueS = ""+value;
    int indexOfDot = valueS.indexOf(".");
    for (int i = 0; i < valueS.length(); i++) {
      valueChars.add(""+valueS.charAt(i));
    }
    for (int i = valueS.length() - 1; i >= 0; i--) {
      String c = valueChars.get(i);
      if (!c.equals(".")) {
        int num = Integer.valueOf(c);
        
        // on end
        if (i == valueS.length() - 1) {
          previousNum = num;
          valueChars.remove(i);
          
          // on after dot
        }else if (i == indexOfDot + decimalNumberAfterDot) {
          if (previousNum > 4) {
            ++num;
            previousNum = num;
            valueChars.set(i, ""+ (num % 10));
          } else {
            previousNum = num;
          }
        }else if (i < indexOfDot + decimalNumberAfterDot) {
          if (i > 0) {
            if (previousNum > 9) {
              ++num;
              previousNum = num;
              valueChars.set(i, ""+ (num % 10));
            } else {
              previousNum = num;
            }
          } else {
            if (previousNum > 10) {
              ++num;
              valueChars.set(i, ""+ (num % 10));
              if (num > 9) {
                valueChars.add(i, ""+ (num / 10));
              }
            }
          }
          
          // on middle
        }else {
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
    for (String ch : valueChars) resultString += ch;
    return Double.valueOf(resultString);
  }
}
