package com.example.amrez.reportcard;

import android.app.Activity;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class cafes extends AppCompatActivity implements AdapterView.OnItemClickListener {

    //object declaration
    private TextView cafes_Name;
    private TextView cafes_Phone;
    private TextView cafes_Address;
    private ListView cafes_List;

    private String[] cafesName;
    private String[] cafesPhone;
    private String[] cafesAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafes);
        //get strings from strings.xml
        Resources res = getResources();
        cafesName = res.getStringArray(R.array.cafesName);
        cafesPhone = res.getStringArray(R.array.cafesPhone);
        cafesAddress = res.getStringArray(R.array.cafesAddress);

        //object from class myAdapter to get arrays value and make list content
        myAdapter adapter = new myAdapter(this, cafesName, cafesPhone, cafesAddress);
        cafes_List = (ListView) findViewById(R.id.cafesList);
        cafes_List.setAdapter(adapter);

        cafes_List.setOnItemClickListener(this);

    }


    //set inner class extends from ArrayAdapter to set List TextView
    public class myAdapter extends ArrayAdapter<String> {
        private final Activity context;

        //constructor to initialize context
        public myAdapter(Activity context, String[] Name, String[] Phone, String[] Address) {
            super(context, R.layout.cafes_list_item, cafesName);
            this.context = context;
            cafesName = Name;
            cafesAddress = Address;
            cafesPhone = Phone;
        }

        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflat = context.getLayoutInflater();
            //to make activity going to new view
            View v = inflat.inflate(R.layout.cafes_list_item, null, true);
            //set textView value
            cafes_Name = (TextView) v.findViewById(R.id.cafes_Name);
            cafes_Name.setText(cafesName[position]);
            //set textView value
            cafes_Phone = (TextView) v.findViewById(R.id.cafes_Phone);
            cafes_Phone.setText(cafesPhone[position]);

            //set textView value
            cafes_Address = (TextView) v.findViewById(R.id.cafes_address);
            cafes_Address.setText(cafesAddress[position]);
            //return new View
            return v;
        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, cafesName[position], Toast.LENGTH_SHORT).show();
    }
}
