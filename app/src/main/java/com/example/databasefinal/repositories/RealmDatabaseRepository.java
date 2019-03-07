package com.example.databasefinal.repositories;

import android.util.Log;

import com.example.databasefinal.MainActivity;
import com.example.databasefinal.Wrapper;
import com.example.databasefinal.model.Student;

import io.realm.Realm;

public class RealmDatabaseRepository {
    private Realm realm = Realm.getDefaultInstance();

    public Wrapper<Student> findStudents() {
        Log.d("Working8","executed");
        return new Wrapper<Student>(realm.where(Student.class).findAllAsync());
    }

    public void writeToDB(final String name,final String id) {
        Log.d("Working4",name);

        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                Log.d("Working5","executed");

                Student stud = bgRealm.createObject(Student.class);
                stud.setName(name);
                stud.setId(id);
                Log.e("Working6", name);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.v("Database", "Inserted");
                // Original queries and Realm objects are automatically updated.
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                Log.e("Database", error.getMessage());

            }
        });
    }
}
