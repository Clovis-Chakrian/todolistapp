package com.clovischakrian.todolist.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class NewTaskDto {
    @NotBlank(message = "O título da tarefa é uma informação obrigatória.")
    private String title;

    private String description;
}
