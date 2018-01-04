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

public class hospitales extends AppCompatActivity implements AdapterView.OnItemClickListener {
    //object declaration
    private TextView hospital_Name;
    private TextView hospital_Phone;
    private TextView hospital_Address;
    private ListView hospitals_List;


    private String[] hospitalName;
    private String[] hospitalPhone;
    private String[] hospitalAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitales);
        //get strings from strings.xml
        Resources res = getResources();
        hospitalName = res.getStringArray(R.array.hospitalName);
        hospitalPhone = res.getStringArray(R.array.hospitalPhone);
        hospitalAddress = res.getStringArray(R.array.hospitalAddress);

        //object from class myAdapter to get arrays value and make list content
        myAdapter adapter = new myAdapter(this, hospitalName, hospitalPhone, hospitalAddress);
        hospitals_List = (ListView) findViewById(R.id.hospital_list);
        hospitals_List.setAdapter(adapter);
        hospitals_List.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, hospitalName[position], Toast.LENGTH_SHORT).show();
    }

    //set inner class extends from ArrayAdapter to set List TextView
    public class myAdapter extends ArrayAdapter<String> {
        private final Activity context;

        //constructor to initialize context
        public myAdapter(Activity context, String[] Name, String[] Phone, String[] Address) {
            super(context, R.layout.historical_list_item, hospitalName);
            this.context = context;
            hospitalName = Name;
            hospitalAddress = Address;
            hospitalPhone = Phone;
        }

        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflat = context.getLayoutInflater();
            //to make activity going to new view
            View v = inflat.inflate(R.layout.hospitals_list_item, null, true);
            //set textView value
            hospital_Name = (TextView) v.findViewById(R.id.hospital_Name);
            hospital_Name.setText(hospitalName[position]);

            hospital_Phone = (TextView) v.findViewById(R.id.hospital_Phone);
            hospital_Phone.setText(hospitalPhone[position]);

            hospital_Address = (TextView) v.findViewById(R.id.hospital_address);
            hospital_Address.setText(hospitalAddress[position]);

            //return new View
            return v;
        }

    }

}
