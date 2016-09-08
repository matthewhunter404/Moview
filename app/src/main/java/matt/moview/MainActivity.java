package matt.moview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Integer[] values = new Integer[] {R.drawable.avengers, R.drawable.darkknight, R.drawable.maleficent,
                R.drawable.manofsteel, R.drawable.skyfall, R.drawable.starwars, R.drawable.thegrey, R.drawable.titanic,
                R.drawable.zootopia};

        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this,
                R.layout.grid_image, values);

        setContentView(R.layout.activity_main);
        GridView gridview = (GridView) findViewById(R.id.moviegridview);
        gridview.setAdapter(adapter);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(MainActivity.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}