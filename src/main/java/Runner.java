import db.DBHelper;
import db.DBStudent;
import models.*;

import java.util.List;

public class Runner {

    public static void main(String[] args) {
        Course course = new Course("Maths", Levels.BENG);

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
