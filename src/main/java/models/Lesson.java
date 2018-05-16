package models;



import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="lessons")
public class Lesson {

    private int id;
    private String title;
    private int classroomNumber;
    private Set<Student> students;
    private Course course;
    private Instructor instructor;

    public Lesson() {
    }

    public Lesson(String title, int classroomNumber, Course course, Instructor instructor) {
        this.title = title;
        this.classroomNumber = classroomNumber;
        this.course = course;
        this.students = new HashSet<Student>();
        this.instructor = instructor;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name ="title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "classroom_number")
    public int getClassroomNumber() {
        return classroomNumber;
    }

    public void setClassroomNumber(int classroomNumber) {
        this.classroomNumber = classroomNumber;
    }

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "lesson_student",
    joinColumns = {@JoinColumn(name = "lesson_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn (name ="student_id", nullable = false, updatable = false)}
    )
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void addStudent(Student student){
        this.students.add(student);
    }

    @ManyToOne
    @JoinColumn(name= "instructor_id", nullable = false)
    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
