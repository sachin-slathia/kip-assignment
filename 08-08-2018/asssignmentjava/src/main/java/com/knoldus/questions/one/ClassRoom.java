package com.knoldus.questions.one;

import java.util.List;
import java.util.Optional;

public class ClassRoom {

   String roomID;
    Optional<List<Student>> studentList;

    @Override
    public String toString() {
        return String.format(roomID+ " " + studentList);
    }


    ClassRoom(String roomID, Optional<List<Student>> studentList) {
        this.roomID = roomID;
        this.studentList = studentList;
    }
}
