package com.api.prestamos.Services.Impl;

import com.api.prestamos.Entitys.Repository.PrestamoRepository;
import com.api.prestamos.Entitys.Prestamo;
import com.api.prestamos.Models.RequestPrestamo;
import com.api.prestamos.Models.RequestUpdatePrestamo;
import com.api.prestamos.Services.Prestamos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PrestamosImpl implements Prestamos {

    @Autowired
    PrestamoRepository prestamoRepository;

    @Override
    @Transactional
    public ResponseEntity<Prestamo> addPrestamos(RequestPrestamo requestPrestamo) {
        try {
            Prestamo prestamo = new Prestamo();
            prestamo.setDateDelivery(requestPrestamo.getDateDelivery());
            prestamo.setIdBook(requestPrestamo.getIdBook());
            prestamo.setDateRent(requestPrestamo.getDateRent());
            //Controlar existencia de libro para prestamos

            Prestamo prestamoSave = prestamoRepository.save(prestamo);
            if (prestamoSave.getCodigoPrestamo()!=0) {
                return ResponseEntity.status(HttpStatus.CREATED).body(prestamoSave);
            }else{
                return ResponseEntity.badRequest().build();
            }
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<Prestamo> getPrestamo(int idPrestamo) {
        try {
            Optional<Prestamo> prestamo = prestamoRepository.findById(idPrestamo);

            if(prestamo.isPresent()){
                return ResponseEntity.ok(prestamo.get());
            }else{
                return ResponseEntity.notFound().build();
            }
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @Transactional
    @Override
    public ResponseEntity<Prestamo> updatePrestamo(int idPrestamo
            , RequestUpdatePrestamo requestUpdatePrestamo) {
        try {
            Optional<Prestamo> prestamoOptional = prestamoRepository.findById(idPrestamo);

            if (prestamoOptional.isPresent()) {
                Prestamo prestamoUpdate = prestamoOptional.get();

                // Verifica y actualiza cada campo solo si no es nulo
                if (requestUpdatePrestamo.getDateDelivery() != null) {
                    prestamoUpdate.setDateDelivery(requestUpdatePrestamo.getDateDelivery());
                }
                if (requestUpdatePrestamo.getDateRent() != null) {
                    prestamoUpdate.setDateRent(requestUpdatePrestamo.getDateRent());
                }
                // Añadir más verificaciones y actualizaciones de campos según sea necesario

                Prestamo prestamoSave = prestamoRepository.save(prestamoUpdate);
                if (prestamoSave != null) {
                    return ResponseEntity.ok(prestamoUpdate);
                } else {
                    return ResponseEntity.badRequest().build();
                }
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
