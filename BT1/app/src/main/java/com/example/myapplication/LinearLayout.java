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


    //Phương thức onCreateOptionsMenu() sẽ thực hiện các công việc khởi tạo menu cho đối tượng Activity,
    //Phương thức inflate() của lớp android.view.MenuInflater để lấy dữ liệu của menu từ file options_menu.xml về sử dụng.
    // Phương thức này nhận vào một đối tượng android.view.Menu.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menulinear, menu);
        //chuyển đổi XML File menulinear sang View Activity
        return true;
    }

    public void doPositiveClick() {
        Uri uri = Uri.parse("https://www.facebook.com");
        Intent visit = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(visit);
    }


    //Phương thức onOptionsItemSelected() sẽ xử lý sự kiện click menu.
    //Phương thức này nhận vào một đối tượng android.view.MenuItem.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case (R.id.table):
                //setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP) :
                //Nếu được đặt và hoạt động đang được khởi chạy đã đang chạy trong tác vụ hiện tại
                //thì thay vì khởi chạy một phiên bản mới của hoạt động đó, tất cả các hoạt động khác trên hoạt động đó sẽ bị đóng
                //Ý định này sẽ được gửi đến (bây giờ trên top) hoạt động cũ dưới dạng Ý định mới.
                intent = new Intent(this, TableLayout.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            case (R.id.relative):
                intent = new Intent(this, RelativeLayout.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            case (R.id.info):
                //Hộp thoại cảnh báo trong Android.
                // Các vùng:Tiêu đề, nội dung, image, button và xử lý sự kiện cho button.
                AlertDialog.Builder builder = new AlertDialog.Builder(LinearLayout.this);
                //builder.setMessage(R.string.dialog_text);  //định nghĩa dialog_text trong string.xml


                //false thì khi show dialog lên người dùng click ra bên ngoài dialog thì nó vẫn không bị mất
                // true thì sẽ mất khi click vào bất kì đâu ngoài dialog.
                builder.setCancelable(false);

                //set button nằm bên phải
                builder.setPositiveButton(
                        R.string.visit, //định nghĩa visit_MOMA trong string.xml
                        (DialogInterface dialogInterface, int i) -> LinearLayout.this.doPositiveClick()
                );

                //set button nằm bên trái
                builder.setNegativeButton(
                        R.string.not_now, //định nghĩa not_now trong string.xml
                        (DialogInterface dialogInterface, int i) -> dialogInterface.cancel()
                );
                builder.create().show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}