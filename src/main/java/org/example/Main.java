package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Escuderia seat = new Escuderia("1", "seat", "españa", "www.seat.es");
        Piloto sainz = new Piloto();
        sainz.setDriverid(0);

        try {
            CRUD.crearPiloto(sainz);
            logger.info("Piloto creado: {}", CRUD.leerPiloto(8));

            List<Piloto> pilotos = CRUD.leerPilotos();
            pilotos.forEach(piloto -> logger.info(piloto.toString()));
            CRUD.actualizarPiloto(sainz);

            CRUD.borrarPiloto(sainz);

            CRUD.mostrarPilotosOrdenadosPorEdadDescendente();
            CRUD.mostrarPilotosConEdadMayorQue(28);
        } catch (Exception e) {
            logger.error("Error en la ejecución: ", e);
        }
    }
}
