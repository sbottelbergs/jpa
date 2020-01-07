package organisation;

import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@ToString
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "ORG_MEMBER",
            joinColumns = @JoinColumn(name = "MEM_ID"),
            inverseJoinColumns = @JoinColumn(name = "ORG_ID")
    )
    @ToString.Exclude
    private Set<Organisation> organisations = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Organisation> getOrganisations() {
        return organisations;
    }

    public void setOrganisations(Set<Organisation> organisations) {
        this.organisations = organisations;
    }

    public void addOrganisation(Organisation organisation) {
        this.organisations.add(organisation);
        organisation.getMembers().add(this);
    }

    public Long getId() {
        return id;
    }

    public static Member create(String name) {
        Member member = new Member();
        member.setName(name);
        return member;
    }
}
