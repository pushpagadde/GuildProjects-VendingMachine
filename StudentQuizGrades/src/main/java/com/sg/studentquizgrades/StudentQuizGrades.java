/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.studentquizgrades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class StudentQuizGrades {
    
    public static void main(String[] args) {
                
        Map<String, StudentScoreMap> studentScoreMap = new HashMap<>();
        int numberOfStudents, scoreMath, scoreScience, scoreLA;
        //String nameOfStudent;
        StudentQuizUserIO entryIO = new StudentQuizUserIO();
        
        System.out.println();
        numberOfStudents = entryIO.readInt("Enter number of Students");
        //code to key in the name of student and scores 
        for (int i=0; i< numberOfStudents; i++) {
            ArrayList<Integer> scores = new ArrayList<>();
            String nameOfStudent = entryIO.readString("Enter name of Student:");
            scores.add(entryIO.readInt("Enter Math Score:", 0, 100));
            scores.add(entryIO.readInt("Enter Science Score:", 0, 100));
            scores.add(entryIO.readInt("Enter LA Score:", 0, 100));
                        
            StudentScoreMap scoreMap = new StudentScoreMap(scores);
            studentScoreMap.put(nameOfStudent, scoreMap);
            
        }
        //code to display name of student with scores
        Set<String> keySet = studentScoreMap.keySet();
        for (String k : keySet) {
            System.out.println(k + ", " + studentScoreMap.get(k).displayAll());
        }
        
        //average score of all student
        double average = 0;
        
        for (String k : keySet) {
            average = average + studentScoreMap.get(k).findAllStudentAverage();
        }
        average = average/numberOfStudents;
        System.out.println("Average of all students= " + average);
        
        //highest quiz score
        int maxScore = 0;
        int minScore= 1000;
        List<Integer> totalScores = new ArrayList<>();
        List<String> maxStudents = new ArrayList<>();
        List<String> minStudents = new ArrayList<>();
        for (String k : keySet) {
            totalScores.add(studentScoreMap.get(k).findMaxScoreStudents());
        }
        for(Integer i : totalScores) {
            if (maxScore < i) {
                maxScore = i;
            }
            /*if (minScore == -1) {
                minScore = i;
            }*/
            if (minScore > i) {
                minScore = i;
            }
        }
        maxScore=Collections.max(totalScores);
        minScore=Collections.min(totalScores);
        for (String k : keySet) {
            if (studentScoreMap.get(k).listOfStudentsMax(maxScore)) {
                maxStudents.add(k);
            }
        }
        System.out.println("Highest score of all students= " + maxScore);
        for (String s : maxStudents) {
            System.out.print(s);
        }
        
        // lowest quiz score
        
        for (String k : keySet) {
            totalScores.add(studentScoreMap.get(k).findMinScoreStudents());
        }
        for (String k : keySet) {
            if (studentScoreMap.get(k).listOfStudentsMin(minScore)) {
                minStudents.add(k);
            }
        }
        System.out.println("Lowest score of students= " + minScore);
        for (String s : minStudents) {
            System.out.println(s);
        }
    }
    
}
