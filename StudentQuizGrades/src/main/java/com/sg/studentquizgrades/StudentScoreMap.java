/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.studentquizgrades;
import java.util.ArrayList;

/**
 *
 * @author apprentice
 */
public class StudentScoreMap {

    private ArrayList<Integer> scoreList = new ArrayList<>();
    double allStudentsAverage = 0;
    int maxScore=0, minScore=10000;
    
    StudentScoreMap(Integer[] scores) {
        for(int i=0; i<3; i++) {
            this.scoreList.add(scores[i]);
        }
    }

    StudentScoreMap(ArrayList<Integer> pscores) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.scoreList = pscores;
    }
    
    public double findAllStudentAverage() {
        
        for (int i=0; i < scoreList.size(); i++ ) {
            allStudentsAverage = allStudentsAverage + scoreList.get(i);
        }
        return allStudentsAverage;
    }
    
    public int findMaxScoreStudents() {
        int sum = 0;
        for (int i=0; i < scoreList.size(); i++ ) {
            sum = sum + scoreList.get(i);
        }
        if (maxScore <= sum)    {
            maxScore = sum;
        }
        return maxScore;
    }
    
    public boolean listOfStudentsMax(int highScore) {
        int sum = 0;
        for (int i=0; i < scoreList.size(); i++ ) {
            sum = sum + scoreList.get(i);
        }
        if (highScore > sum)    {
            return false;
        }else {
            return true;
        }
    }
    
    public int findMinScoreStudents() {
        int sum = 0;
        for (int i=0; i < scoreList.size(); i++ ) {
            sum = sum + scoreList.get(i);
        }
        //if (minScore == -1) { minScore = sum; }
        if (minScore > sum )    {
            minScore = sum;
        }
        return minScore;
    }
    
    public boolean listOfStudentsMin(int lowScore) {
        int sum = 0;
        for (int i=0; i < scoreList.size(); i++ ) {
            sum = sum + scoreList.get(i);
        }
        if (lowScore > sum)    {
            return false;
        }else {
            return true;
        }
    }
    
    public ArrayList<Integer> getScoreList() {
        return scoreList;
    }
    
    public String displayAll() {
        String result= "";
        for (int i=0; i < scoreList.size(); i++ ) {
            result = result+ " " + scoreList.get(i);
        }
        return result;
    }
    
    public void setScoreList(ArrayList<Integer> pscoreList) {
        this.scoreList = pscoreList;
    }
    
    
    
}
