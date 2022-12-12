package com.vf.nach.msprueba.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseDTO<T> implements Serializable {
    @JsonProperty
    private T data;
    @JsonProperty
    private Boolean success;
}
