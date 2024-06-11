package com.api.prestamos.Controller;

import com.api.prestamos.Entitys.Prestamo;
import com.api.prestamos.Entitys.Repository.PrestamoRepository;
import com.api.prestamos.Models.RequestPrestamo;
import com.api.prestamos.Models.RequestUpdatePrestamo;
import com.api.prestamos.Services.Prestamos;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/prestamos")
public class PrestamosController {

    @Autowired
    Prestamos prestamosService;


    @PostMapping()
    public ResponseEntity<Prestamo> addPrestamos(@RequestBody RequestPrestamo requestPrestamo){
            return prestamosService.addPrestamos(requestPrestamo);
    }

    @GetMapping("/{idPrestamo}")
    public ResponseEntity<Prestamo> getPrestamos(@PathVariable int idPrestamo){
            return prestamosService.getPrestamo(idPrestamo);
    }

    @PatchMapping("/{idPrestamo}")
    public  ResponseEntity<Prestamo> updatePrestamo(@PathVariable int idPrestamo, @RequestBody RequestUpdatePrestamo requestUpdatePrestamo){
            return prestamosService.updatePrestamo(idPrestamo,requestUpdatePrestamo);
    }
}
