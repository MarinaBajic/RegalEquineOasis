package com.reo.rider_service.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntityDoesNotExistException extends RuntimeException {
    private String message;
    private Long idEntity;
}
