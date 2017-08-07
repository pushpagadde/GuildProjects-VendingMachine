/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.dao;

import com.sg.classroster.dto.Student;

/**
 *
 * @author apprentice
 */
public class ClassRosterDaoException extends Exception {
    public ClassRosterDaoException(String message) {
	super(message);
    }
    public ClassRosterDaoException(String message, Throwable cause) {
	super(message, cause);
    }
    @Override
    public Student addStudent(String studentId, Student student) 
     throws ClassRosterDaoException {
        Student newStudent = students.put(studentId, student);
        writeRoster();
        return newStudent;
    }
    
    @Override
    public Student getStudent(String studentId) 
    throws ClassRosterDaoException {
        loadRoster();
        return students.get(studentId);
    }
    
    @Override
    public Student removeStudent(String studentId) 
     throws ClassRosterDaoException {
        Student removedStudent = students.remove(studentId);
        writeRoster();
        return removedStudent;
    }
    
}
