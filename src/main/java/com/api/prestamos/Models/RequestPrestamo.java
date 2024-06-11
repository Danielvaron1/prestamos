package com.api.prestamos.Models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RequestPrestamo {

    private long idBook;
    private LocalDate dateRent;
    private LocalDate dateDelivery;

}
