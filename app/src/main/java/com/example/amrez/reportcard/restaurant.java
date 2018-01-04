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

public class restaurant extends AppCompatActivity implements AdapterView.OnItemClickListener {
    //object declaration
    private TextView restaurant_Name;
    private TextView restaurant_Phone;
    private TextView restaurant_Address;
    private ListView restaurant_List;
    private String[] restaurantName;
    private String[] restaurantPhone;
    private String[] restaurantAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        //get strings from strings.xml
        Resources res = getResources();
        restaurantName = res.getStringArray(R.array.restaurantName);
        restaurantPhone = res.getStringArray(R.array.restaurantPhone);
        restaurantAddress = res.getStringArray(R.array.restaurantAddress);

//object from class myAdapter to get arrays value and make list content
        myAdapter adapter = new myAdapter(this, restaurantName, restaurantPhone, restaurantAddress);
        restaurant_List = (ListView) findViewById(R.id.restaurantList);
        restaurant_List.setAdapter(adapter);
        restaurant_List.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, restaurantName[position], Toast.LENGTH_SHORT).show();
    }

    //set inner class extends from ArrayAdapter to set List TextView
    public class myAdapter extends ArrayAdapter<String> {
        private final Activity context;

        //constructor to initialize context
        public myAdapter(Activity context, String[] Name, String[] Phone, String[] Address) {
            super(context, R.layout.restaurant_list_item, restaurantName);
            this.context = context;
            restaurantName = Name;
            restaurantAddress = Address;
            restaurantPhone = Phone;
        }

        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflat = context.getLayoutInflater();
            //to make activity going to new view
            View v = inflat.inflate(R.layout.restaurant_list_item, null, true);
            //set textView value
            restaurant_Name = (TextView) v.findViewById(R.id.restaurant_Name);
            restaurant_Name.setText(restaurantName[position]);
            //set textView value
            restaurant_Phone = (TextView) v.findViewById(R.id.restaurant_Phone);
            restaurant_Phone.setText(restaurantPhone[position]);

            //set textView value
            restaurant_Address = (TextView) v.findViewById(R.id.restaurant_address);
            restaurant_Address.setText(restaurantAddress[position]);
            //return new View
            return v;
        }

    }

}
