package models;


import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course {

    private int id;
    private String title;
    private Levels levels;
    private Set<Student> students;
    private Set<Lesson> lessons;
    private Calendar startDate;
    private Calendar endDate;



    public Course() {
    }

    public Course(String title, Levels levels, Calendar startDate, Calendar endDate) {
        this.title = title;
        this.levels = levels;
        this.startDate = startDate;
        this.endDate = endDate;
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

    @OneToMany(mappedBy = "course")
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Enumerated(EnumType.STRING)
    public Levels getLevels() {
        return levels;
    }

    public void setLevels(Levels levels) {
        this.levels = levels;
    }

    @OneToMany(mappedBy = "course")
    public Set<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Set<Lesson> lessons) {
        this.lessons = lessons;
    }

    @Temporal(TemporalType.DATE)
    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }


    @Temporal(TemporalType.DATE)
    public Calendar getEndDate() {
        return endDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }
}
