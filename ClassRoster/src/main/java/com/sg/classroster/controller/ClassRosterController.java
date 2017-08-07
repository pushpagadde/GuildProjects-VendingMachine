/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.controller;

import com.sg.classroster.dao.ClassRosterDao;
import com.sg.classroster.dao.ClassRosterDaoException;
import com.sg.classroster.dao.ClassRosterDaoFileImpl;
import com.sg.classroster.dto.Student;
import com.sg.classroster.ui.ClassRosterView;
import com.sg.classroster.ui.UserIO;
import com.sg.classroster.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class ClassRosterController {
    ClassRosterView view;// = new ClassRosterView();
    ClassRosterDao dao; // = new ClassRosterDaoFileImpl();
    private UserIO io = new UserIOConsoleImpl();
    
    public ClassRosterController(ClassRosterDao dao, ClassRosterView view) {
        this.dao = dao;
        this.view = view;
    } 
    
    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {
            
                menuSelection = getMenuSelection();
            
                System.out.println("menu selection=" + menuSelection);
                switch (menuSelection) {
                    case 1:
                        io.print("LIST STUDENTS");
                        listStudents();
                        break;
                    case 2:
                        io.print("CREATE STUDENT");
                        createStudent();
                        break;
                    case 3:
                        io.print("VIEW STUDENT");
                        viewStudent();
                        break;
                    case 4:
                        io.print("REMOVE STUDENT");
                        removeStudent();
                        break;
                    case 5:
                        keepGoing = false;
                        break;
                    default:
                        io.print("UNKNOWN COMMAND");
                        unknownCommand();
                }
        }
        io.print("GOOD BYE");
        exitMessage();
        } catch (ClassRosterDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
        
    } 
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    private void createStudent() throws ClassRosterDaoException{
        view.displayCreateStudentBanner();
        Student newStudent = view.getNewStudentInfo();
        dao.addStudent(newStudent.getStudentId(), newStudent);
        view.displayCreateSuccessBanner();
    }
    
    private void listStudents() throws ClassRosterDaoException{
        view.displayDisplayAllBanner();
        List<Student> studentList = dao.getAllStudents();
        view.displayStudentList(studentList);
    }
    private void viewStudent() throws ClassRosterDaoException {
        view.displayDisplayStudentBanner();
        String studentId = view.getStudentIdChoice();
        Student student = dao.getStudent(studentId);
        view.displayStudent(student);
    }
    private void removeStudent() throws ClassRosterDaoException{
        view.displayRemoveStudentBanner();
        String studentId = view.getStudentIdChoice();
        dao.removeStudent(studentId);
        view.displayRemoveSuccessBanner();
    }
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}