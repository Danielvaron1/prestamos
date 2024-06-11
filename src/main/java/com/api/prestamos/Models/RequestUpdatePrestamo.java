package com.api.prestamos.Models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RequestUpdatePrestamo {
    private LocalDate dateDelivery;
}
