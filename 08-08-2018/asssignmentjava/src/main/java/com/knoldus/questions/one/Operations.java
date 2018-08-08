package com.knoldus.questions.one;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Operations {


//Returns List of students associated with a room that have no subjects associated
    public static List<String> studentsWithRooms(List<ClassRoom> classRooms) {

        return classRooms.stream()
                .filter(classRoom -> classRoom.getStudentList().isPresent())
                .map(classRoom -> classRoom.getStudentList().get())
                .flatMap(Collection::stream)
                .filter(student -> !student.getSubject().isPresent())
                .map(Student::getName)
                .collect(Collectors.toList());
    }

//Returns List of subjects of students associated with a room that has roomID a particular String
    public static List<String> subject(List<ClassRoom> classRooms, String id) {

        return classRooms.stream()
                .filter(classRoom -> classRoom.getRoomId().equals(id) && classRoom.getStudentList().isPresent())
                .map(classRoom -> classRoom.getStudentList().get())
                .flatMap(Collection::stream)
                .filter(student -> student.getSubject().isPresent())
                .map(student -> student.getSubject().get())
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

//Returns List of subjects of students associated with a room that has roomID a particular String
    public static String checkStudent(List<ClassRoom> classRooms) {
        List<ClassRoom> classRoomWithStudents = classRooms.stream()
                .filter(classRoom -> !classRoom.getStudentList().isPresent())
                .collect(Collectors.toList());
        if (classRoomWithStudents.isEmpty())
            return "Hello World!";
        else
            return "No Room is associated with Student";


    }
}
