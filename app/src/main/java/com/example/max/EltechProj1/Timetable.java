package com.example.max.EltechProj1;

public class Timetable {
    private String dayOfTheWeek;
    public Lecture[] lessons = new Lecture[6];

    public Timetable(String day){
        this.dayOfTheWeek = day;
    }

    public String GetDay() {
        return dayOfTheWeek;
    }


    //Setters


    /*public void SetDay(String Day) {
        this.DayOfTheWeek = Day;
    }

    public void SetLessons(String[] Lessons) {
        this.Lessons = Lessons;
    }

    public void SetTeacher(String Teacher) {
        this.Teacher = Teacher;
    }

    public void SetLectureHall(String LectureHall) {
        this.LectureHall = LectureHall;
    }

    public void SetType(String Type) {
        this.Type = Type;
    }*/


}