package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "portal_sub_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PortalSubItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Integer count;

    @ManyToOne
    @JoinColumn(name = "portal_item_id")
    @JsonIgnore
    private PortalItem portalItem;
}