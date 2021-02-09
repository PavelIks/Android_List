package com.example.myapplist;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    Button BTN_ADD1;
    TextView NUMBS_ADD1;
    EditText WORDS_ADD1;
    ListView LISTVIEW1;
    ArrayList<String> product_array_list = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BTN_ADD1 = (Button) findViewById(R.id.btn_add1);
        NUMBS_ADD1 = (TextView) findViewById(R.id.numb_add1);
        WORDS_ADD1 = (EditText) findViewById(R.id.string_add1);
        LISTVIEW1 = (ListView) findViewById(R.id.list1);

        final ListView NumbsList = (ListView) findViewById(R.id.list1);
        ArrayAdapter<ArrayList> adapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, product_array_list);

        BTN_ADD1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                product_array_list.add((String.valueOf(((TextView) findViewById(R.id.numb_add1)).getText())));
                product_array_list.add((String.valueOf(((TextView) findViewById(R.id.string_add1)).getText())));
                LISTVIEW1.setAdapter(adapter);
            }
        });


//        LISTVIEW1.setOnItemClickListener(new AdapterView.OnItemClickListener()
//        {
//            @Override
//            public void onItemClick(AdapterView<?> arg0, View v, int arg2, long arg3)
//            {
//                TextView tv = (TextView) v.findViewById(R.id.string_add1);
//                Toast.makeText(getApplicationContext(), tv.getText().toString(), Toast.LENGTH_SHORT).show();
//            }
//        });

//        LISTVIEW1.setOnItemClickListener(new AdapterView.OnItemClickListener()
//        {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
//            {
//                Toast.makeText(getApplicationContext(), product_array_list.get(position), Toast.LENGTH_LONG).show();
//            }
//        });
    }
}