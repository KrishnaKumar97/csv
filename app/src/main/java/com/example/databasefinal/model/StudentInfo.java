package com.example.realmdatabase.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

public class StudentInfo extends LiveData {
    private String studentName;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
