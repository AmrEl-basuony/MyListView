package com.example.mylistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList myList = getListData();
        final ListView lv = (ListView) findViewById(R.id.list);

        lv.setAdapter(new CustomListAdapter(this, myList));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                ListItem user = (ListItem) lv.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, "Selected :" + " " + user.getWord()+", "+ user.getNum(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private ArrayList getListData() {
        ArrayList<ListItem> results = new ArrayList<>();

        ListItem i1 = new ListItem();
        i1.setWord("hi");
        i1.setNum("1");
        results.add(i1);

        ListItem i2 = new ListItem();
        i2.setWord("how");
        i2.setNum("2");
        results.add(i2);

        ListItem i3 = new ListItem();
        i3.setWord("are");
        i3.setNum("3");
        results.add(i3);

        ListItem i4 = new ListItem();
        i4.setWord("you");
        i4.setNum("4");
        results.add(i4);

        ListItem i5 = new ListItem();
        i5.setWord("today");
        i5.setNum("5");
        results.add(i5);

        ListItem i6 = new ListItem();
        i6.setWord("my");
        i6.setNum("6");
        results.add(i6);

        ListItem i7 = new ListItem();
        i7.setWord("good");
        i7.setNum("7");
        results.add(i7);

        ListItem i8 = new ListItem();
        i8.setWord("sir");
        i8.setNum("8");
        results.add(i8);

        ListItem i9 = new ListItem();
        i9.setWord("hopefully");
        i9.setNum("9");
        results.add(i9);

        ListItem i10 = new ListItem();
        i10.setWord("doing");
        i10.setNum("10");
        results.add(i10);

        ListItem i11 = new ListItem();
        i11.setWord("fine");
        i11.setNum("11");
        results.add(i11);

        return results;
    }
}