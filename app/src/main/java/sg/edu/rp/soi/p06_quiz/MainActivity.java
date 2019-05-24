package sg.edu.rp.soi.p06_quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et1 ,et2;
    TextView operation, result;
    Button btnReset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 =findViewById(R.id.etNum1);
        et2 = findViewById(R.id.etNum2);
        operation = findViewById(R.id.tvOperation);
        result = findViewById(R.id.tvResult);
        btnReset = findViewById(R.id.btnReset);

        registerForContextMenu(operation);

        btnReset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                et1.setText("");
                et2.setText("");
                result.setText("");
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0, "+");
        menu.add(0,1,1,"-");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        et1 =findViewById(R.id.etNum1);
        et2 = findViewById(R.id.etNum2);
        int number1 = Integer.parseInt(et1.getText().toString());
        int number2 = Integer.parseInt(et2.getText().toString());
        result = findViewById(R.id.tvResult);
        if(item.getItemId() == 0){
            result.setText((number1 + number2 + 1) + "");
        }
        else if(item.getItemId() == 1){
            result.setText((number1 + number2 - 1) + "");
        }
        return super.onContextItemSelected(item);
    }

}
