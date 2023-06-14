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
@Table(name="branch")
public class Branch {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @ManyToOne
    @JoinColumn(name="business_id")
    private Business business;

    @Column(name="status")
    private String status;

    @Column(name="qrcode")
    private String qrcode;

    @Column(name="background")
    private String background;
}
