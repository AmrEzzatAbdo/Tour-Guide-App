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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class historicalList extends AppCompatActivity implements AdapterView.OnItemClickListener {

    //object declaration

    private ImageView Phistorical_img;
    private TextView Phistorical_Text;
    private ListView historical_List;
    //declarattion two arrays to set historical olaces imgs and declaration
    private Integer[] historical_imgs = {R.drawable.pyramids, R.drawable.abdeenpalacemuseum, R.drawable.manialpalacemuseum, R.drawable.abydos};
    private String[] historical_declaration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historical_list);
        //get strings from strings.xml
        Resources res = getResources();
        historical_declaration = res.getStringArray(R.array.historical_declaration);


        //object from class myAdapter to get arrays value and make list content
        myAdapter adapter = new myAdapter(this, historical_declaration, historical_imgs);
        historical_List = (ListView) findViewById(R.id.historical_List);
        historical_List.setAdapter(adapter);
        historical_List.setOnItemClickListener(this);
    }

    //set inner class extends from ArrayAdapter to set List TextView and ImageView
    public class myAdapter extends ArrayAdapter<String> {
        private final Activity context;

        //constructor to initialize context and historical_declaration historical_imgs
        public myAdapter(Activity context, String[] his_dic, Integer[] his_img) {
            super(context, R.layout.historical_list_item, historical_declaration);
            this.context = context;
            historical_declaration = his_dic;
            historical_imgs = his_img;
        }

        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflat = context.getLayoutInflater();
            //to make activity going to new view
            View v = inflat.inflate(R.layout.historical_list_item, null, true);
            //set textView value by array historical_declaration
            Phistorical_Text = (TextView) v.findViewById(R.id.P_historicalText);
            Phistorical_Text.setText(historical_declaration[position]);
            //set ImageView value by array historical_imgs
            Phistorical_img = (ImageView) v.findViewById(R.id.P_historicalImg);
            Phistorical_img.setImageResource(historical_imgs[position]);
            //return new View
            return v;
        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, historical_declaration[position], Toast.LENGTH_SHORT).show();
    }


}


