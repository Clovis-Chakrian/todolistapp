package com.clovischakrian.todolist.dtos;

import java.util.List;

public record ApiResponse<T> (boolean success, T data, List<String> errors) {
}
