package com.project.recapprojekt.dto;

import com.project.recapprojekt.Enum.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {
    private String description;
    private Status status;

}
