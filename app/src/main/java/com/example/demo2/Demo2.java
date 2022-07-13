package com.example.demo2;

import static com.example.demo2.R.layout.custom_dialogdemo2;

import android.app.AlertDialog;
import android.app.backup.FileBackupHelper;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Demo2 extends AppCompatActivity {
    private static final int MY_REQUEST_CODE = 10;

    private RecyclerView rcvUser;
    private UserAdapterDemo userAdapterDemo;
    private List<UserDemo2> mListUser;
    private ArrayList<String> arrayList;
//    private UserAdapterDemo mUserApapter;
    private ImageView imagedemo;
//    private ArrayAdapter adapter;;
//  private Button btncancel,btnyes;
    private Button btn_show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo2);

        getSupportActionBar().setTitle(" List person ");


        btn_show = findViewById(R.id.button_new);


        rcvUser = findViewById(R.id.rcv_User1);
        userAdapterDemo = new UserAdapterDemo(this);
        userAdapterDemo.setOnItemClickListener(new UserAdapterDemo.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                userAdapterDemo.getMlistUser().remove(position);
                userAdapterDemo.notifyItemRemoved(position);
            }

            @Override
            public void onClick(View view) {

            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rcvUser.setLayoutManager(linearLayoutManager);

        rcvUser.setAdapter(userAdapterDemo);
//        rcvUser.setOnClickListener(new UserAdapterDemo.OnItemClickListener() {
//            @Override
//            public void onItemClick(int position) {
//                //now delete
//                arrayList.remove(position);
//                //them notify
//                rcvUser.notifyDataSetChanged();
//            });
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
        userAdapterDemo.setData(getListUser());
        rcvUser.setAdapter(userAdapterDemo);

        mListUser = new ArrayList<>();
            btn_show.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
                nextActivity();
            }
        });

    }
     private void nextActivity() {

        Intent intent = new Intent(Demo2.this, Demo1.class);
        startActivityForResult(intent, MY_REQUEST_CODE);

    }

    private List<UserDemo2> getListUser() {
        List<UserDemo2> list = new ArrayList<>();
        list.add(new UserDemo2(R.drawable.avatar1,"Full Name"));
        list.add(new UserDemo2(R.drawable.avatar2,"Full Name"));
        list.add(new UserDemo2(R.drawable.avatar3,"Full Name"));
        list.add(new UserDemo2(R.drawable.avatar4,"Full Name"));
        return list;
    }

    private boolean onclickDeleteData(){
       new AlertDialog.Builder (Demo2.this)
               .setIcon(R.drawable.baseline_close_black_18)
               .setTitle("Confirm")
               .setMessage("Are you sure want to remove this person")
               .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {
                        mListUser.remove(i);
                        userAdapterDemo.notifyDataSetChanged();
                   }
               })
               .setNegativeButton("CANCEL",null)
               .show();
            return true;

          }
}
