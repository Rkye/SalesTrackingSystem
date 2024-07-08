package com.example.demo.core;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass //Alt klasların database tablosuna buradaki kolonları eklemek için kullanılır.
@SuperBuilder
public class Base {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(name = "last_modified")
    private LocalDateTime lastModified;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @PrePersist
    protected void beforeCreate() {
        createdDate = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        isDeleted = false;
    }

    @PreUpdate
    protected void beforeUpdate() {
        lastModified = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
    }


}
