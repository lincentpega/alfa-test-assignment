package com.lincentpega.alfatestassignment.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "box")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class Box {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id;

    @JsonIgnore
    @ManyToOne(targetEntity = Box.class)
    @JoinColumn(name = "contained_in")
    Box parent;

    @JsonIgnore
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    Set<Box> children;
}