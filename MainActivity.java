package com.example.android.listview_simple;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView text;
    ListView list;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrutasVerduras frutasVerduras_datos[] = new FrutasVerduras[]{
                new FrutasVerduras(R.drawable.app, "Manzana"),
                new FrutasVerduras(R.drawable.app, "Naranja"),
                new FrutasVerduras(R.drawable.app, "Durazno"),
                new FrutasVerduras(R.drawable.app, "Banana"),
                new FrutasVerduras(R.drawable.app, "Mango"),
                new FrutasVerduras(R.drawable.app, "Pera"),
                new FrutasVerduras(R.drawable.app, "Frutilla"),
        };

        FrutasVerdurasAdapter adapter = new FrutasVerdurasAdapter(this, R.layout.listview_item_row, frutasVerduras_datos);

        text = (TextView) findViewById(R.id.text1);
        list = (ListView) findViewById(R.id.listView);

        View header = (View) getLayoutInflater().inflate(R.layout.list_header_row,null);
        list.addHeaderView(header);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView tx = (TextView) view.findViewById(R.id.tw);
                Toast.makeText(getApplicationContext(),tx.getText(), Toast.LENGTH_SHORT).show();
            }
        });

    }

}
