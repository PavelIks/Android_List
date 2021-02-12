package com.example.myapplist;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Removable
{
    Button BTN_ADD1;
    TextView NUMBS_ADD1;
    EditText WORDS_ADD1;
    ListView LISTVIEW1;
    ArrayList<String> product_array_list = new ArrayList<String>();
    ArrayAdapter<ArrayList> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BTN_ADD1 = (Button) findViewById(R.id.btn_add1);
        NUMBS_ADD1 = (TextView) findViewById(R.id.numb_add1);
        WORDS_ADD1 = (EditText) findViewById(R.id.string_add1);
        LISTVIEW1 = (ListView) findViewById(R.id.list1);

        final ListView listview = (ListView) findViewById(R.id.list1);
        adapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, product_array_list);

        BTN_ADD1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
               product_array_list.add(getTotalString());
               LISTVIEW1.setAdapter(adapter);
            }
        });
        LISTVIEW1.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick (AdapterView<?> adapterView, View view, int position, long l)
            {
                Toast.makeText(getApplicationContext(), product_array_list.get(position), Toast.LENGTH_LONG).show();

                CustomDialogFragment fragment = new CustomDialogFragment();
                Bundle bundle = new Bundle();
                bundle.putString("test_key", String.valueOf(adapter.getItem(position)));
                fragment.setArguments(bundle);
                fragment.show(getSupportFragmentManager(),"custom");
            }
        });
    }

    public String getTotalString()
    {
        return WORDS_ADD1.getText() + " за " + NUMBS_ADD1.getText() + "$";
    }

    @Override
    public void remove(String product)
    {
        product_array_list.remove(getTotalString());
        LISTVIEW1.setAdapter(adapter);
    }
}



