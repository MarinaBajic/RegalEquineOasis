package com.reo.horse_service.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntityAlreadyExistsException extends RuntimeException {
    private String message;
    private Long idEntity;
}
