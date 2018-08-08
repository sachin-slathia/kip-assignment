package com.knoldus.questions.one;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Operations {

    public static List<String> studentsWithRooms(List<ClassRoom> classRooms) {

        return classRooms.stream()
                .filter(classRoom -> classRoom.getStudentList().isPresent())
                .map(classRoom -> classRoom.getStudentList().get())
                .flatMap(Collection::stream)
                .filter(student -> !student.getSubject().isPresent())
                .map(Student::getName)
                .collect(Collectors.toList());
    }

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

    public static String checkStudent(List<ClassRoom> classRooms) {
        List<ClassRoom> classRoomWithStudents = classRooms.stream()
                .filter(classRoom -> !classRoom.getStudentList().isPresent())
                .collect(Collectors.toList());
        if (classRoomWithStudents.isEmpty())
            return "Hello World!";
        else
            return "All rooms not associated with students.";


    }
}
