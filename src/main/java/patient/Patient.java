package patient;

import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    // @OneToOne(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @OneToOne(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "MF_ID")
    private MedicalFile medicalFile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MedicalFile getMedicalFile() {
        return medicalFile;
    }

    public void setMedicalFile(MedicalFile medicalFile) {
        this.medicalFile = medicalFile;
        if (medicalFile != null) {
            this.medicalFile.setPatient(this);
        }
    }

    public void removeMedicalFile(MedicalFile medicalFile) {
        if (this.medicalFile != null) {
            this.setMedicalFile(null);
            this.medicalFile.setPatient(null);
        }
    }

    public long getId() {
        return id;
    }
}
