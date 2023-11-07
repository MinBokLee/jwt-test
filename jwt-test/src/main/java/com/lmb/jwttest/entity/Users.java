package com.lmb.jwttest.entity;

import lombok.*;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class Users {

    @Id
    @Column(name="users_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="username", length=50, unique = true)
    private String username;

    @Column(name="password", length = 100)
    private String password;

    @Column(name="nickname", length = 50)
    private String nickname;

    @Column(name = "activated")
    private boolean activated;

    @ManyToMany
    @JoinTable(
        name="user_authority"
       ,joinColumns = {@JoinColumn(name = "users_id", referencedColumnName = "users_id")}
       ,inverseJoinColumns = {@JoinColumn(name="authority_name", referencedColumnName = "authority_name")})
    private Set<Authority> authorities;

}
