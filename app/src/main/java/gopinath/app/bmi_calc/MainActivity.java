package gopinath.app.bmi_calc;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText Height,Weight;
    TextView Result;
    Button btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Height=findViewById(R.id.Height);
        Weight=findViewById(R.id.Weight);
        Result=findViewById(R.id.result);
        btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String h=Height.getText().toString();
                String w=Weight.getText().toString();
                float hf=Float.parseFloat(h);
                float wf=Float.parseFloat(w);
                float result=(wf/(hf*hf))*10000;
                Result.setText("BMI:"+result);
                Toast.makeText(MainActivity.this, "Your BMI is calculated😎", Toast.LENGTH_SHORT).show();
                if (result<=18.5) {
                    Result.setText("UnderWeight❗❗"+result);
                }
                else if (result>=24.5) {
                    Result.setText("Obisity🤢🤢"+result);
                }
                else {
                    Result.setText("Normal👍👍"+result);
                }
                if (h>=250){
                    Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}