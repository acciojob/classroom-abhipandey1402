package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {

    HashMap<String, Student> studentDb;
    HashMap<String, Teacher> teacherDb;
    HashMap<String, List<String>> teacherStudentDb;

    public StudentRepository(){
        this.studentDb = new HashMap<>();
        this.teacherDb = new HashMap<>();
        this.teacherStudentDb = new HashMap<>();
    }

    public void addStudent(Student student){
        studentDb.put(student.getName(), student);
    }

    public void addTeacher(Teacher teacher){
        teacherDb.put(teacher.getName(), teacher);
    }

    public void addStudentTeacherPair(String student, String teacher){
        if(studentDb.containsKey(student) && teacherDb.containsKey(teacher)){
            List<String> studentList = new ArrayList<>();
            if(teacherStudentDb.containsKey(teacher)){
                studentList = teacherStudentDb.get(teacher);
            }

            studentList.add(student);

            teacherStudentDb.put(teacher, studentList);
        }
    }

    public Student getStudentByName(String name){
        return studentDb.get(name);
    }

    public Teacher getTeacherByName(String name){
        return teacherDb.get(name);
    }

    public List<String> getStudentsByTeacherName(String teacher){
        List<String> studentList = new ArrayList<>();
        if(teacherStudentDb.containsKey(teacher)){
            studentList = teacherStudentDb.get(teacher);
        }
        return studentList;
    }

    public List<String> getAllStudents(){
        return new ArrayList<>(studentDb.keySet());
    }


}
