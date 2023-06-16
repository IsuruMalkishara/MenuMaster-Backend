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
public class Items {
    @Id
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="sub_category_id")
    private Integer subCategory;

    @Column(name="category_id")
    private int category;

    @Column(name="price")
    private Double price;

    @Column(name="discount")
    private Double discount;

    @Column(name="banner_image")
    private String bannerImg;

    public Items(int id, String name, int category, Double price, Double discount, String bannerImg, Integer subCategory) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.discount = discount;
        this.bannerImg = bannerImg;
        this.subCategory = subCategory;
    }
}
