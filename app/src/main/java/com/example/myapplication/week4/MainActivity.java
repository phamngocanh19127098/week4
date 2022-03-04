package com.example.myapplication.week4;


import android.app.Activity;
import android.content.Context;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class MainActivity extends Activity {

    ListView listView;
    String mName[] = {"Nguyen Son", "Pham Ngoc Anh", "Nguyen Phan Vu", "Nguyen Tan Viet"};
    String mNumberPhone[] = {"0353481356", "0934525231", "0935782119", "09342945121"};
    TextView textViewChoice ;
    int images[] = {R.drawable.contact, R.drawable.contact,R.drawable.contact, R.drawable.contact};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        textViewChoice = findViewById(R.id.twChoice);

        MyAdapter adapter = new MyAdapter(this, mName, mNumberPhone, images);
        listView.setAdapter(adapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               for(int i = 0;i<mName.length;i++){
                   if(position==i){
                       textViewChoice.setText("You choose: "+ mName[i]);

                       listView.setSelector(R.color.orange);
                   }

               }

            }
        });

    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rName[];
        String rPhone[];
        int rImgs[];

        MyAdapter (Context c, String name[], String phone[], int imgs[]) {
            super(c, R.layout.row, R.id.textView1, name);
            this.context = c;
            this.rName = name;
            this.rPhone = phone;
            this.rImgs = imgs;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);


            images.setImageResource(rImgs[position]);
            myTitle.setText(rName[position]);
            myDescription.setText(rPhone[position]);


            return row;
        }
    }
}
