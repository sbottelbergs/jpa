package person;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "PERSONS",
        indexes = {
                @Index(name = "LAST_NAME_INDEX", columnList = "LAST_NAME"),
                @Index(name = "BIRTHDAY_INDEX", columnList = "BIRTHDAY")
        })
@SecondaryTable(name = "URLS", pkJoinColumns = @PrimaryKeyJoinColumn(name = "PERSON_ID"))
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Version
    @Column(name = "VERSION")
    private Long version;

    @Basic(optional = false)
    @Column(name = "FIRST_NAME", length = 40, nullable = false)
    private String firstName;


    @Basic(optional = false)
    @Column(name = "LAST_NAME", length = 40, nullable = false)
    private String lastName;

    @Column(name = "BIRTHDAY")
    private LocalDate birthDay;

    @Enumerated(EnumType.STRING)
    @Column(name = "GENDER", length = 10, nullable = false)
    @Basic(optional = false)
    private GenderType gender;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] picture;

    @Lob
    @Column(name = "COMMNT")
    @Basic(fetch = FetchType.LAZY)
    private String comment;

    @Column(name = "MARRIED", columnDefinition = "BOOLEAN DEFAULT false")
    private boolean married;

    private transient int age;

    @Column(name = "URL", table = "URLS", length = 255)
    private String homepage;

    @Embedded
    private Address address = new Address();
}
