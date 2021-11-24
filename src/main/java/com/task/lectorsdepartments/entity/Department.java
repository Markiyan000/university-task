package com.task.lectorsdepartments.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "department")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "head_of_department_id")
    private Lector headOfDepartment;

    @ManyToMany
    @JoinTable(name = "lector_department",
            joinColumns = { @JoinColumn(name = "department_id") },
            inverseJoinColumns = { @JoinColumn(name = "lector_id")})
    private Set<Lector> lectors = new HashSet<>();
}
