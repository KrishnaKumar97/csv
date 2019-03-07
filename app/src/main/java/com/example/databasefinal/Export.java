package com.example.databasefinal;

import com.example.databasefinal.Wrapper;

import com.example.databasefinal.model.Student;
import com.example.databasefinal.repositories.RealmDatabaseRepository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import io.realm.Realm;
import io.realm.RealmResults;

public class Export{
    public static String FILE_NAME="test.csv";
    RealmDatabaseRepository mRepo = new RealmDatabaseRepository();
    String folder="/home/nineleaps/Documents/project/DatabaseFinal/csvFiles";
    private Realm realm = Realm.getDefaultInstance();


    public void export() {
//         Wrapper<Student> students = mRepo.findStudents();
        RealmResults<Student>students=realm.where(Student.class).findAllAsync();
        FileOutputStream fos=null;
        fos=openFileOutput(FILE_NAME,MODE_PRIVATE);
        fos.write();


//        PrintWriter writer;
//        try
//        {
//            writer = new PrintWriter(file);
//            StringBuilder stringBuilder = new StringBuilder();
//            stringBuilder.append("name,id\n");
//            for (Student student : students)
//            {
//                stringBuilder.append(String.valueOf(student.getName()));
//                stringBuilder.append(',');
//                stringBuilder.append(String.valueOf(student.getId()));
//                stringBuilder.append('\n');
//            }
//            writer.write(stringBuilder.toString());
//            writer.close();
//        }
//        catch (FileNotFoundException e)
//        {
//            e.printStackTrace();
//        }
    }


}
