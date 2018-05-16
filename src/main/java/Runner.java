import db.DBHelper;
import db.DBStudent;
import models.*;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Calendar startDate = Calendar.getInstance();
        startDate.set(Calendar.YEAR, 2018);
        startDate.set(Calendar.MONTH, 5);
        startDate.set(Calendar.DAY_OF_MONTH, 16);

        Calendar endDate = Calendar.getInstance();
        startDate.set(Calendar.YEAR, 2019);
        startDate.set(Calendar.MONTH, 1);
        startDate.set(Calendar.DAY_OF_MONTH, 31);



        Course course = new Course("Maths", Levels.BENG, startDate, endDate );

        Student student = new Student("Kelsie", 25, Levels.HND,course );

        Instructor instructor = new Instructor("Al");

        Lesson lesson = new Lesson("Maths 101", 10, course, instructor);

        DBHelper.save(course);
        DBHelper.save(student);
        DBHelper.save(instructor);
        DBHelper.save(lesson);

        DBHelper.addStudentToLesson(lesson, student);

        List<Lesson> foundLessonsForStudent = DBStudent.getLessonsFromStudent(student);



    }
}
