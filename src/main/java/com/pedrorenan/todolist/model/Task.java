package com.pedrorenan.todolist.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "tasks")
@NoArgsConstructor
@Setter
@Getter
@ToString

public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//tipo de geração do id, identity gera uma sequencia 1,2,3, ...
    private Long id;
    @Column(nullable = false) // não permite deixar nulo
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Date deadLine;

    @CreationTimestamp
    @Column(name = "creadt_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
