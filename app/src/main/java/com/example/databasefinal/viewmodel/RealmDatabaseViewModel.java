package com.example.databasefinal.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.util.Log;


import com.example.databasefinal.MainActivity;
import com.example.databasefinal.Wrapper;
import com.example.databasefinal.model.Student;
import com.example.databasefinal.repositories.RealmDatabaseRepository;

public class RealmDatabaseViewModel extends ViewModel{
    RealmDatabaseRepository mRepo = new RealmDatabaseRepository();
    private Wrapper<Student> students;

    public void init() {
        if (students != null) {
            return;
        }
        Log.d("Working3",String.valueOf(MainActivity.name.getText()));
        mRepo.writeToDB(MainActivity.name.getText().toString(),MainActivity.id.getText().toString());
        Log.d("Working7","executed");
        students = mRepo.findStudents();
        Log.d("Working9", students.toString());

    }

    public Wrapper<Student> getStudents() {
        return students;
    }
}
