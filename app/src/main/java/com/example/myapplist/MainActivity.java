package com.example.myapplist;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    Button BTN_ADD1;
    TextView NUMBS_ADD1;
    ListView LISTVIEW1;

    ArrayList<CharSequence> numbsList = new ArrayList<CharSequence>();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BTN_ADD1 = (Button) findViewById(R.id.btn_add1);
        NUMBS_ADD1 = (TextView) findViewById(R.id.numb_add1);
        LISTVIEW1 = (ListView) findViewById(R.id.list1);

        final ListView NumbsList = (ListView) findViewById(R.id.list1);
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, numbsList);
        NumbsList.setAdapter(adapter);

        NumbsList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Toast.makeText(getApplicationContext(), numbsList.get(position), Toast.LENGTH_LONG).show();
            }
        });

        BTN_ADD1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                CharSequence a1 = NUMBS_ADD1.getText();
                numbsList.add(a1);
                LISTVIEW1.setAdapter(adapter);
            }
        });
    }
}