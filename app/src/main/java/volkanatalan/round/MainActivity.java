package volkanatalan.round;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static volkanatalan.round.Calc.roundToDecimalPlace2;

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
  
    double result = roundToDecimalPlace2(number, digitNumberAfterDot);
    
    textView.setText(result+"");
  }
  
  
}
