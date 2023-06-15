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
@Table(name="item")
public class Item {
    @Id
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @ManyToOne
    @JoinColumn(name="sub_category_id")
    private SubCategory subCategory;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    @Column(name="price")
    private Double price;

    @Column(name="discount")
    private Double discount;

    @Column(name="banner_image")
    private String bannerImg;
}
