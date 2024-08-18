package com.clovischakrian.todolist.repositories;

import com.clovischakrian.todolist.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ITaskRepository extends JpaRepository<Task, UUID> {
}
