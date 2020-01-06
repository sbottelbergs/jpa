package person;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Address {
    @Column(name = "STREET")
    private String street;

    @Column(name = "NUMBER")
    private String number;

    @Column(name = "ZIPCODE")
    private String zipCode;

    @Column(name = "CITY")
    private String city;

    @Column(name = "COUNTRY")
    private String country;
}
