package com.api.prestamos.Services;

import com.api.prestamos.Entitys.Prestamo;
import com.api.prestamos.Models.RequestPrestamo;
import com.api.prestamos.Models.RequestUpdatePrestamo;
import org.springframework.http.ResponseEntity;

public interface Prestamos {

    ResponseEntity<Prestamo> addPrestamos(RequestPrestamo requestPrestamo);

    ResponseEntity<Prestamo> getPrestamo(int idPrestamo);

    ResponseEntity<Prestamo> updatePrestamo(int idPrestamo, RequestUpdatePrestamo requestUpdatePrestamo);
}
