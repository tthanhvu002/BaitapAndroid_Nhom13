package com.example.myapplication;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TableLayout extends AppCompatActivity {
    Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_layout);
        this.setTitle("Table Layout");

        SeekBar sb = findViewById(R.id.seekBar);
        TextView view1 = findViewById(R.id.view1);
        TextView view2 = findViewById(R.id.view2);
        TextView view3 = findViewById(R.id.view3);
        TextView view5 = findViewById(R.id.view5);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int light_blue = getResources().getColor(R.color.light_blue);
                int pink = getResources().getColor(R.color.pink);
                int red = getResources().getColor(R.color.red);
                int blue = getResources().getColor(R.color.blue);
                int yellow = getResources().getColor(R.color.yellow);
                int beige = getResources().getColor(R.color.beige);
                int orange = getResources().getColor(R.color.orange);
                int green = getResources().getColor(R.color.green);

                view1.setBackgroundColor((int) (light_blue + (yellow - light_blue) * (i / 100f)));
                view2.setBackgroundColor((int) (pink + (beige - pink) * (i / 100f)));
                view3.setBackgroundColor((int) (red + (orange - red) * (i / 100f)));
                view5.setBackgroundColor((int) (blue + (green - blue) * (i / 100f)));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menutable, menu);
        return true;
    }

    public void doPositiveClick() {
        Uri uri = Uri.parse("http://www.moma.org");
        Intent visit = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(visit);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case (R.id.linear):
                intent = new Intent(this, LinearLayout.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            case (R.id.relative):
                intent = new Intent(this, RelativeLayout.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            case (R.id.info):
                AlertDialog.Builder builder = new AlertDialog.Builder(TableLayout.this);
                builder.setMessage(R.string.dialog_text);  //định nghĩa dialog_text trong string.xml
                builder.setCancelable(false);
                builder.setPositiveButton(
                        R.string.visit, //định nghĩa visit_MOMA trong string.xml
                        (dialogInterface, i) -> TableLayout.this.doPositiveClick()
                );
                builder.setNegativeButton(
                        R.string.not_now, //định nghĩa not_now trong string.xml
                        (dialogInterface, i) -> dialogInterface.cancel()
                );
                builder.create().show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
