package com.backend.integrador.test;
import java.util.ArrayList;
import java.util.List;

import com.backend.integrador.dao.impl.OdontologoDaoEnMemoria;
import com.backend.integrador.dao.impl.OdontologoDaoH2;
import com.backend.integrador.entity.Odontologo;
import com.backend.integrador.service.OdontologoService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoServiceTest {
    OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());
    OdontologoService odontologoServiceMemoria = new OdontologoService(new OdontologoDaoEnMemoria(new ArrayList<>()));
    @Test
    void registrarOdontologo_debeCrearUnRegistroOdontologoEnH2() {
        Odontologo odontologo = new Odontologo(1, "Pedro", "Picapiedra");

        Odontologo ondontologoInsertado = odontologoService.registrarOdontologo(odontologo);

        assertNotNull(ondontologoInsertado.getId());
    }

    @Test
    void listarTodosLosOdontologos_debeTraerUnalistaNoVacia() {
        List<Odontologo> odontologos = odontologoService.listarTodosLosOdontologos();
        assertFalse(odontologos.isEmpty());
        assertTrue(odontologos.size() >= 1);
    }

   @Test
   void registrarOdontologo_debeCrearUnRegistroOdontologoEnMemoria() {
       Odontologo odontologo = new Odontologo(1, "Pedro", "Picapiedra");
       Odontologo ondontologoInsertado = odontologoServiceMemoria.registrarOdontologo(odontologo);

       assertNotNull(ondontologoInsertado.getId());
   }
    @Test
    void ListarOdontologos_debeListaraOdontologosEnMemoria() {
        List<Odontologo> listaOdontologos = odontologoServiceMemoria.listarTodosLosOdontologos();
        Odontologo odontologo = new Odontologo(2, "juan", "Picapiedra");
        Odontologo ondontologoInsertado = odontologoServiceMemoria.registrarOdontologo(odontologo);

        assertFalse(listaOdontologos.isEmpty());
    }


}