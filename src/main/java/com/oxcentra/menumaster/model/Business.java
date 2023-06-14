package com.oxcentra.menumaster.model;

import lombok.*;

import javax.persistence.*;


@Data
@Getter
@Setter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name="business")
public class Business {
    @Id
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="role")
    private String role;

    @Column(name="email")
    private String email;

    @Column(name="phone")
    private String phone;

    @Column(name="logo")
    private String logo;

    @Column(name="password")
    private String password;

    @Column(name="status")
    private String status;

    @Column(name="background")
    private String background;
}
