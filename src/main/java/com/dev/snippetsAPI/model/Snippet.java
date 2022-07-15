package com.dev.snippetsAPI.model;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "snippets")
@Getter
@Setter
@Data
@NoArgsConstructor
public class Snippet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotEmpty
    @NotNull(message = "Category field should not be null ! ")
    private String category;

    @NotBlank
    @NotEmpty
    @NotNull(message = "Language field should not be null ! ")
    private String Language;

    @NotBlank
    @NotEmpty
    @NotNull(message = "Name field should not be null ! ")
    private String name;

    @NotBlank
    @NotEmpty
    @NotNull(message = "Description field should not be null ! ")
    private String description;

    @NotBlank
    @NotEmpty
    @NotNull(message = "Code field should not be null ! ")
    private String code;

}
