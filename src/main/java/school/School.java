package school;

import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
    @OrderBy("name ASC")
    private List<Student> students = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
        student.setSchool(this);
    }

    public void removeStudent(Student student) {
        if (student != null) {
            this.students.remove(student);
            student.setSchool(null);
        }
    }

    public Long getId() {
        return id;
    }
}
