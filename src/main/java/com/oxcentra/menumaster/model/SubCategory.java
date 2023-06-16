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
@Table(name="sub_category")
public class SubCategory {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;


    @Column(name="category_id")
    private int category;

    @Column(name="banner_img")
    private String bannerImg;
}
