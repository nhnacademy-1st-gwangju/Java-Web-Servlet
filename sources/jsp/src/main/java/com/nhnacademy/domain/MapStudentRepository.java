package com.nhnacademy.domain;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapStudentRepository implements StudentRepository {

    private Map<String, Student> map = new ConcurrentHashMap<>();

    @Override
    public void addStudent(Student student) {
        map.put(student.getId(), student);
    }

    @Override
    public Student get(String id) {
        return map.get(id);
    }
}
