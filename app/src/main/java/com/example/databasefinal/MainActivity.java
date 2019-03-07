package com.example.databasefinal;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.databasefinal.model.Student;
import com.example.databasefinal.viewmodel.RealmDatabaseViewModel;

import io.realm.Realm;
import io.realm.RealmResults;
import android.arch.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity{
    public static EditText name,id;
    Button btn;
    TextView data;
    Realm realm;
    private RealmDatabaseViewModel viewModel = new RealmDatabaseViewModel();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.editText1);
        id = (EditText) findViewById(R.id.editText);
        btn = (Button) findViewById(R.id.button);
        data = (TextView) findViewById(R.id.textView);
        viewModel = ViewModelProviders.of(this).get(RealmDatabaseViewModel.class);
        Realm.init(getApplicationContext());
        realm = Realm.getDefaultInstance();
        Log.d("Working1","executed");
    }

    public void onClick(View v) {
        Log.d("Working2","executed");
        viewModel.init();

        viewModel.getStudents().observe(this, new Observer<RealmResults<Student>>() {
            @Override
            public void onChanged(@Nullable RealmResults<Student> students) {
                data.setText(students.toString());
                Log.e("Data",students.toString());

            }
        });

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }

    public void onClickExport(View view) {
        Export obj=new Export();
        obj.export();
    }
}
