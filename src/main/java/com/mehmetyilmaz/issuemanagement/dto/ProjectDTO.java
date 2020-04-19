package com.mehmetyilmaz.issuemanagement.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Project Data Transfer Object") // swagger ile dokumantasyonda gorulmesi icin kullanilan anotation. dto'lari tanimlar.
public class ProjectDTO {

    @ApiModelProperty(value = "Project ID")
    private Long id;

    @NotNull
    @ApiModelProperty(value = "Name of Project", required = true) // swagger ile dokumantasyonda gorulmesi icin kullanilan anotation. field'lari tanimlar.
    private String projectName;

    @NotNull
    @ApiModelProperty(value = "Code of Project", required = true)
    private String projectCode;
}
