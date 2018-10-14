package com.example.max.EltechProj1.fragment;



import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.max.EltechProj1.Lecture;
import com.example.max.EltechProj1.R;
import com.example.max.EltechProj1.Timetable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class ExampleFragment extends Fragment {

    private static final int LAYOUT = R.layout.fragment_example;


    private TextView studyObjText[], teacherText[], lectureHallText[], timeText[];
    private RelativeLayout relativelayout[];
    private Timetable[] arrTimeTable;
    private View view;
    TextView butt;
    int posF;

    public static ExampleFragment getInstance(int pos) {
        Bundle args = new Bundle();
        args.putInt("position", pos);
        ExampleFragment fragment = new ExampleFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT,container, false);
        int value = getArguments().getInt("position");

        BufferedReader reader = null;

        studyObjText = getStudyObjText();
        teacherText = getTeacherText();
        lectureHallText = getLectureHallText();
        timeText = getTimeText();
        relativelayout = getLayout();

        InputStream is = getResources().openRawResource(R.raw.inputtimetable);
        try {
            reader = new BufferedReader(new InputStreamReader(is, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String timeTableString[] = new String[13];
        for (int i = 0; i < 13; ++i) {
            try {
                timeTableString[i] = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String[] oneDay;
        String delimeter = ",";
        String[] listOfTime = timeTableString[0].split(delimeter);

        arrTimeTable = new Timetable[12];
        for (int i = 0, j = 1; i < 12 && j < timeTableString.length; ++i, ++j) {
            //if(timeTableString[j] == "delim") j++;  //Check
            oneDay = timeTableString[j].split(delimeter);

            arrTimeTable[i] = new Timetable(oneDay[0]);
            for (int k = 1, countLesson = 0; k < oneDay.length; k++) {
                arrTimeTable[i].lessons[countLesson] = new Lecture(oneDay[k] + "/" + listOfTime[countLesson]);
                countLesson++;
            }
        }

        SetDay(value,relativelayout,studyObjText,lectureHallText,teacherText,timeText);

        return view;
    }

    private RelativeLayout[] getLayout() {
        RelativeLayout out[] = new RelativeLayout[6];
        out[0] = view.findViewById(R.id.relativelayout);
        out[0].setVisibility(View.INVISIBLE);
        out[1] = view.findViewById(R.id.relativelayout2);
        out[1].setVisibility(View.INVISIBLE);
        out[2] = view.findViewById(R.id.relativelayout3);
        out[2].setVisibility(View.INVISIBLE);
        out[3] = view.findViewById(R.id.relativelayout4);
        out[3].setVisibility(View.INVISIBLE);
        out[4] = view.findViewById(R.id.relativelayout5);
        out[4].setVisibility(View.INVISIBLE);
        out[5] = view.findViewById(R.id.relativelayout6);
        out[5].setVisibility(View.INVISIBLE);
        return out;
    }

    private ImageView[] getImageView(){
        ImageView inProcess[] = new ImageView[6];
        inProcess[0] = view.findViewById(R.id.imageView);
        inProcess[1] = view.findViewById(R.id.imageView2);
        inProcess[2] = view.findViewById(R.id.imageView3);
        inProcess[3] = view.findViewById(R.id.imageView4);
        inProcess[4] = view.findViewById(R.id.imageView5);
        inProcess[5] = view.findViewById(R.id.imageView6);
        return inProcess;
    }

    private TextView[] getTimeText() {
        TextView[] timeText = new TextView[6];
        timeText[0] = view.findViewById(R.id.time1);
        timeText[1] = view.findViewById(R.id.time2);
        timeText[2] = view.findViewById(R.id.time3);
        timeText[3] = view.findViewById(R.id.time4);
        timeText[4] = view.findViewById(R.id.time5);
        timeText[5] = view.findViewById(R.id.time6);
        return timeText;
    }

    private TextView[] getLectureHallText() {
        TextView[] lectureHallText = new TextView[6];
        lectureHallText[0] = view.findViewById(R.id.lectureHall1);
        lectureHallText[1] = view.findViewById(R.id.lectureHall2);
        lectureHallText[2] = view.findViewById(R.id.lectureHall3);
        lectureHallText[3] = view.findViewById(R.id.lectureHall4);
        lectureHallText[4] = view.findViewById(R.id.lectureHall5);
        lectureHallText[5] = view.findViewById(R.id.lectureHall6);

        return lectureHallText;
    }

    private TextView[] getTeacherText() {
        TextView[] teacherText = new TextView[6];
        teacherText[0] = view.findViewById(R.id.teacher1);
        teacherText[1] = view.findViewById(R.id.teacher2);
        teacherText[2] = view.findViewById(R.id.teacher3);
        teacherText[3] = view.findViewById(R.id.teacher4);
        teacherText[4] = view.findViewById(R.id.teacher5);
        teacherText[5] = view.findViewById(R.id.teacher6);
        return teacherText;
    }

    private TextView[] getStudyObjText() {
        TextView[] studyObjText = new TextView[6];
        studyObjText[0] = view.findViewById(R.id.studyObj1);
        studyObjText[1] = view.findViewById(R.id.studyObj2);
        studyObjText[2] = view.findViewById(R.id.studyObj3);
        studyObjText[3] = view.findViewById(R.id.studyObj4);
        studyObjText[4] = view.findViewById(R.id.studyObj5);
        studyObjText[5] = view.findViewById(R.id.studyObj6);
        return studyObjText;
    }

    private void SetDay(int numberOfDay, View[] relativelayout, TextView[] studyObjText,
                        TextView[] lectureHallText, TextView[] teacherText, TextView[] timeText) {
        int countLesson = 0, realCountLesson = 0;
        if (!arrTimeTable[numberOfDay].lessons[countLesson].GetLessons().equals("null")) {
            relativelayout[realCountLesson].setVisibility(View.VISIBLE);

            studyObjText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetLessons());
            lectureHallText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetLectureHall());
            teacherText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetTeacher());
            timeText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetTime());
            realCountLesson++;
        }
        countLesson++;

        if (!arrTimeTable[numberOfDay].lessons[countLesson].GetLessons().equals("null")) {
            relativelayout[realCountLesson].setVisibility(View.VISIBLE);

            studyObjText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetLessons());
            lectureHallText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetLectureHall());
            teacherText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetTeacher());
            timeText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetTime());
            realCountLesson++;
        }
        countLesson++;

        if (!arrTimeTable[numberOfDay].lessons[countLesson].GetLessons().equals("null")) {
            relativelayout[realCountLesson].setVisibility(View.VISIBLE);

            studyObjText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetLessons());
            lectureHallText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetLectureHall());
            teacherText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetTeacher());
            timeText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetTime());
            realCountLesson++;
        }
        countLesson++;

        if (!arrTimeTable[numberOfDay].lessons[countLesson].GetLessons().equals("null")) {
            relativelayout[realCountLesson].setVisibility(View.VISIBLE);

            studyObjText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetLessons());
            lectureHallText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetLectureHall());
            teacherText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetTeacher());
            timeText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetTime());
            realCountLesson++;
        }
        countLesson++;

        if (!arrTimeTable[numberOfDay].lessons[countLesson].GetLessons().equals("null")) {
            relativelayout[realCountLesson].setVisibility(View.VISIBLE);

            studyObjText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetLessons());
            lectureHallText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetLectureHall());
            teacherText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetTeacher());
            timeText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetTime());
            realCountLesson++;
        }
        countLesson++;

        if (!arrTimeTable[numberOfDay].lessons[countLesson].GetLessons().equals("null")) {
            relativelayout[realCountLesson].setVisibility(View.VISIBLE);

            studyObjText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetLessons());
            lectureHallText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetLectureHall());
            teacherText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetTeacher());
            timeText[realCountLesson].setText(arrTimeTable[numberOfDay].lessons[countLesson].GetTime());
        }
    }
}
