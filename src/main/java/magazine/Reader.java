package magazine;

import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@ToString
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Magazine> magazines = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Magazine> getMagazines() {
        return magazines;
    }

    public void setMagazines(Set<Magazine> magazines) {
        this.magazines = magazines;
    }

    public void addMagazine(Magazine magazine) {
        this.magazines.add(magazine);
    }

    public Long getId() {
        return id;
    }
}
