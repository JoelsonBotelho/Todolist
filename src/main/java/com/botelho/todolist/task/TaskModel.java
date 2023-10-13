package com.botelho.todolist.task;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "tb_tasks")
public class TaskModel {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String description;

    @Column(length = 50)
    private String title;
    private LocalDateTime startDat, endDat;
    private String priority;
    private UUID idUser;
    @CreationTimestamp
    private LocalDateTime createdDat;

    public void setTitle(String title) throws Exception {
        if (title.length() > 50) {
            throw new Exception("A tarefa deve ter no máximo 50 caracteres");
        }
        this.title = title;
    }
}
