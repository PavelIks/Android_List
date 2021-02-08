package com.example.myapplist;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.myapplist.R;

public class MainActivity extends AppCompatActivity
{
    String[] fruits = {"Apple", "Orange", "Banana"};
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView fruitsList = (ListView) findViewById(R.id.list1);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, fruits);
        fruitsList.setAdapter(adapter);
    }
}