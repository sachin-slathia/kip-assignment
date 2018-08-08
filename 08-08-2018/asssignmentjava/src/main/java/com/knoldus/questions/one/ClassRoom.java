package com.knoldus.questions.one;

import java.util.List;
import java.util.Optional;

//Defined ClassRoom
public class ClassRoom {

   String roomId;
    Optional<List<Student>> studentList;

    @Override
    public String toString() {
        return String.format(roomId+ " " + studentList);
    }

 //Constructor
    ClassRoom(String roomId, Optional<List<Student>> studentList) {
        this.roomId = roomId;
        this.studentList = studentList;
    }
 //Returns RoomId of Current Object
    public String getRoomId() {
        return this.roomId;
    }
    //Returns Student List associated with ClassRoom
    public Optional<List<Student>> getStudentList() {
        return this.studentList;
    }
}
