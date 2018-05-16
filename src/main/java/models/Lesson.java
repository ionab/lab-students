package models;



import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name ="lessons")
public class Lesson {

    private int id;
    private String title;
    private int classroomNumber;
    private Set<Student> students;

    public Lesson() {
    }

    public Lesson(String title, int classroomNumber) {
        this.title = title;
        this.classroomNumber = classroomNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getClassroomNumber() {
        return classroomNumber;
    }

    public void setClassroomNumber(int classroomNumber) {
        this.classroomNumber = classroomNumber;
    }
}
