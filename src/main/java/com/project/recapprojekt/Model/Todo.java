package com.project.recapprojekt.Model;

import com.project.recapprojekt.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    private String id;
    private String description;
    private Status status;
}
