package com.lincentpega.alfatestassignment.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "item")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Box.class)
    @JoinColumn(name = "contained_in")
    Box containedIn;

    @Column(name = "color", length = 100)
    String color;
}