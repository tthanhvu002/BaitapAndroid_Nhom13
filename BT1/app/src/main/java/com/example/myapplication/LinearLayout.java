package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;

public class LinearLayout extends AppCompatActivity {
    Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);
        this.setTitle("Linear Layout");

        SeekBar sb = findViewById(R.id.seekBar);
        View view1 = findViewById(R.id.view1);
        View view2 = findViewById(R.id.view2);
        View view3 = findViewById(R.id.view3);
        View view5 = findViewById(R.id.view5);

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


    //Ph????ng th???c onCreateOptionsMenu() s??? th???c hi???n c??c c??ng vi???c kh???i t???o menu cho ?????i t?????ng Activity,
    //Ph????ng th???c inflate() c???a l???p android.view.MenuInflater ????? l???y d??? li???u c???a menu t??? file options_menu.xml v??? s??? d???ng.
    // Ph????ng th???c n??y nh???n v??o m???t ?????i t?????ng android.view.Menu.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menulinear, menu);
        //chuy???n ?????i XML File menulinear sang View Activity
        return true;
    }

    public void doPositiveClick() {
        Uri uri = Uri.parse("https://www.facebook.com");
        Intent visit = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(visit);
    }


    //Ph????ng th???c onOptionsItemSelected() s??? x??? l?? s??? ki???n click menu.
    //Ph????ng th???c n??y nh???n v??o m???t ?????i t?????ng android.view.MenuItem.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case (R.id.table):
                //setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP) :
                //N???u ???????c ?????t v?? ho???t ?????ng ??ang ???????c kh???i ch???y ???? ??ang ch???y trong t??c v??? hi???n t???i
                //th?? thay v?? kh???i ch???y m???t phi??n b???n m???i c???a ho???t ?????ng ????, t???t c??? c??c ho???t ?????ng kh??c tr??n ho???t ?????ng ???? s??? b??? ????ng
                //?? ?????nh n??y s??? ???????c g???i ?????n (b??y gi??? tr??n top) ho???t ?????ng c?? d?????i d???ng ?? ?????nh m???i.
                intent = new Intent(this, TableLayout.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            case (R.id.relative):
                intent = new Intent(this, RelativeLayout.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            case (R.id.info):
                //H???p tho???i c???nh b??o trong Android.
                // C??c v??ng:Ti??u ?????, n???i dung, image, button v?? x??? l?? s??? ki???n cho button.
                AlertDialog.Builder builder = new AlertDialog.Builder(LinearLayout.this);
                //builder.setMessage(R.string.dialog_text);  //?????nh ngh??a dialog_text trong string.xml


                //false th?? khi show dialog l??n ng?????i d??ng click ra b??n ngo??i dialog th?? n?? v???n kh??ng b??? m???t
                // true th?? s??? m???t khi click v??o b???t k?? ????u ngo??i dialog.
                builder.setCancelable(false);

                //set button n???m b??n ph???i
                builder.setPositiveButton(
                        R.string.visit, //?????nh ngh??a visit_MOMA trong string.xml
                        (DialogInterface dialogInterface, int i) -> LinearLayout.this.doPositiveClick()
                );

                //set button n???m b??n tr??i
                builder.setNegativeButton(
                        R.string.not_now, //?????nh ngh??a not_now trong string.xml
                        (DialogInterface dialogInterface, int i) -> dialogInterface.cancel()
                );
                builder.create().show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}