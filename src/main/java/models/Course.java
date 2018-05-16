package models;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course {

    private int id;
    private String title;
    private Levels levels;
    private Set<Student> students;
    private Set<Lesson> lessons;


    public Course() {
    }

    public Course(String title, Levels levels) {
        this.title = title;
        this.levels = levels;
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
}
