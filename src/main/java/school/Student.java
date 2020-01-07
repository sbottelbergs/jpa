package school;

import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @ToString.Exclude
    private School school;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Long getId() {
        return id;
    }

    public static Student create(String name) {
        Student student = new Student();
        student.setName(name);
        return student;
    }
}
