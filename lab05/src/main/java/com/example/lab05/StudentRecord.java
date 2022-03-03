package com.example.lab05;

public class StudentRecord {
    private String StudentID;
    private float midtermMark;
    private float AssignmentMark;
    private float ExamMark;
    private float FinalMark;
    private char Grade;

    public StudentRecord(String stdId, float midMark, float assiMark, float exaMark) {
        this.StudentID =stdId;
        this.midtermMark=midMark;
        this.AssignmentMark=assiMark;
        this.ExamMark=exaMark;
        this.FinalMark = Math.round((this.midtermMark*0.3f)+ (this.AssignmentMark*0.2f)+(this.ExamMark*0.5f));


        if (FinalMark <= 49) {
            Grade = 'F';
        }
        else if (FinalMark >=50 && FinalMark<= 59 ) {
            Grade = 'D';
        }
        else if (FinalMark >=60 && FinalMark<= 69 ) {
            Grade = 'C';
        }
        else if (FinalMark >=70 && FinalMark<= 79 ) {
            Grade = 'B';
        }
        else {
            Grade = 'A';
        }

    }

    public String getStudentID() {
        return this.StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public float getMidtermMark() {
        return this.midtermMark;
    }

    public void setMidtermMark(float midtermMark) {
        this.midtermMark = midtermMark;
    }

    public float getAssignmentMark() {
        return this.AssignmentMark;
    }

    public void setAssignmentMark(float assignmentMark) {
        AssignmentMark = assignmentMark;
    }

    public float getExamMark() {
        return this.ExamMark;
    }

    public void setExamMark(float examMark) {
        ExamMark = examMark;
    }

    public float getFinalMark() {
        return this.FinalMark;
    }

    public void setFinalMark(float finalMark) {
        FinalMark = finalMark;
    }

    public char getGrade() {
        return this.Grade;
    }

    public void setGrade(char grade) {
        Grade = grade;
    }

//    public void setGrade() {
//        this.FinalMark = (this.midtermMark*0.3f)+ (this.AssignmentMark*0.2f)+(this.ExamMark*0.5f);
//
//
//    }

//    public String getStudentID(){
//        return this.StudentID;
//    }
//    public void setStudentID(String newId) {
//        this.StudentID=newId;
//    }
//
//    public float getmidtermMark(){
//        return this.midtermMark;
//    }
//    public void setmidtermMark(float newMidMark) {
//        this.midtermMark=newMidMark;
//    }
//
//    public float getAssignmentMark(){
//        return this.AssignmentMark;
//    }
//    public void setAssignmentMark(float newAssiMark) {
//        this.AssignmentMark=newAssiMark;
//    }
//
//    public float getExamMark(){
//        return this.ExamMark;
//    }
//    public void setExamMark(float newExamMark) {
//        this.ExamMark=newExamMark;
//    }
//
//    public float getFinalMark(){
//        return this.FinalMark;
//    }
//    public void setFinalMark(float newFinal) {
//        this.FinalMark=newFinal;
//    }
//
//    public float getGrade(){
//        return this.Grade;
//    }
//    public void setGrade(char newGrade) {
//        this.Grade=newGrade;
//    }
}
