package com.knoldus.questions.one;

import java.util.List;
import java.util.Optional;

public class ClassRoom {

   String roomId;
    Optional<List<Student>> studentList;

    @Override
    public String toString() {
        return String.format(roomId+ " " + studentList);
    }



    ClassRoom(String roomId, Optional<List<Student>> studentList) {
        this.roomId = roomId;
        this.studentList = studentList;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public Optional<List<Student>> getStudentList() {
        return this.studentList;
    }
}
