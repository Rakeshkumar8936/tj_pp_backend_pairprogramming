package com.example.demo.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="portal_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PortalItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String icon;

    private Integer count;

    @OneToMany(
            mappedBy ="portalItem",
            cascade = CascadeType.ALL,
            orphanRemoval=true
    )
    private List<PortalSubItem> subItems;

}
