package com.automationtest.model.entity;
import com.automationtest.model.enums.Roles;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
    @Getter
    @Setter
    @SuperBuilder
    @ToString

    @Entity(name = "userEntity")
    @Table(name = "user_tbl")
    @NamedQueries({
            @NamedQuery(
                    name = "User.FindByUsername",
                    query = "select oo from userEntity oo where oo.username=:username"),
            @NamedQuery(
                    name = "User.FindByUsernameAndPassword",
                    query = "select oo from userEntity oo where oo.username=:username and oo.password=:password" ),
            @NamedQuery(
                    name = "User.FindByActive",
                    query = "select oo from userEntity oo where oo.active=true"),
            @NamedQuery(
                    name = "User.FindByRole",
                    query = "select oo from userEntity oo where oo.role=:role" )
    })
    public class User implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;

        @Pattern(regexp = "^[a-zA-Z\\s]{5,15}$", message = "Invalid Username")
        @Column(name = "u_name", length = 15)
        private String username;

        @Pattern(regexp = "^[a-zA-Z\\s]{8,20}$", message = "Invalid Password")
        @Column(name = "u_pass", length = 20)
        private String password;

        @OneToOne(cascade = CascadeType.ALL)
        private Person personId;

        @ManyToMany
        private List<Section> sectionId;

        @OneToOne
        private AccessLevel access;

        @Column(name="u_active")
        private boolean active;

        @Enumerated(EnumType.ORDINAL)
        private Roles role;


    }
