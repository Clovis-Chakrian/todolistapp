package com.clovischakrian.todolist.entities;

import com.clovischakrian.todolist.dtos.NewTaskDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.Date;
import java.util.UUID;

@Entity(name = "tasks")
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "taskId")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID taskId;

    @Column(nullable = false)
    public String title;

    public String description;

    public boolean done = false;

    public Date doneAt;

    @Column(nullable = false)
    public Date createdAt;

    @Column(nullable = false)
    public Date updatedAt;

    @PrePersist()
    public void onPersist() {
        Date date = new Date();
        this.createdAt = date;
        this.updatedAt = date;
    }

    @PreUpdate()
    public void onUpdate() {
        this.updatedAt = new Date();
    }

    public Task(NewTaskDto newTaskDto) {
        this.title = newTaskDto.getTitle();
        this.description = newTaskDto.getDescription();
    }

    public void doneTask() {
        this.done = true;
        this.doneAt = new Date();
    }

    public void undoneTask() {
        this.done = false;
        this.doneAt = null;
    }
}
