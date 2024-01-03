package com.automationtest.model.entity;
import com.automationtest.model.enums.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString

@Entity(name = "personEntity")
@Table(name = "person_tbl")
@NamedQueries({
        @NamedQuery(
                name = "Person.FindById",
                query = "select oo from personEntity oo where oo.id=:personId" ),
        @NamedQuery(
                name = "Person.FindByName",
                query = "select oo from personEntity oo where oo.name=:name"),
        @NamedQuery(
                name = "Person.FindByFamily",
                query = "select oo from personEntity oo where oo.family=:family" ),
        @NamedQuery(
                name = "Person.FindByNationalCode",
                query = "select oo from personEntity oo where oo.nationalCode=:nationalCode" ),

})
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE, generator = "personSeq")
    @Column(name = "p_id")
    private long id;

    @Pattern(regexp = "^[a-zA-Z\\s]{3,30}$", message = "Invalid Name")
    @Column(name = "p_name", length = 30)
    private String name;

    @Pattern(regexp = "^[a-zA-Z\\s]{3,30}$", message = "Invalid Family")
    @Column(name = "p_family", length = 30)
    private String family;

    @Pattern(regexp = "[0-9]{10}$", message = "Invalid NationalCode")
    @Column(name = "p_nationalCode", length = 10)
    private Number nationalCode;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @Enumerated(EnumType.ORDINAL)
    private Gender gender;
}
