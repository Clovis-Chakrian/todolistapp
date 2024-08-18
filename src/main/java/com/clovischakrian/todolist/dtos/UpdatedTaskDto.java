package com.clovischakrian.todolist.dtos;

import jakarta.validation.constraints.NotBlank;

public class UpdatedTaskDto {
    @NotBlank(message = "O título da tarefa é uma informação obrigatória.")
    private String title;

    private String description;
}
