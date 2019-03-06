package com.formation.demo.entities;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "project name is required")
    private String projectName;
    @NotBlank(message = "project description is required")
    private String description;
    @NotBlank(message = "Project identifier is required")
    @Size(min = 4, max = 5, message = "the project identifer should be 4 or 5 characters")
    @Column(updatable = false, unique = true)
    private String projectIdentifier;
    //@JsonFormat(pattern = "yyyy-mm-dd")
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate startDate;
    //@JsonFormat(pattern = "yyyy-mm-dd")
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate endDate;

    private LocalDate createdAt;
    private LocalDate updatedAt;

    @PrePersist
    protected void onCreate(){
        this.createdAt = LocalDate.now();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = LocalDate.now();
    }
}
