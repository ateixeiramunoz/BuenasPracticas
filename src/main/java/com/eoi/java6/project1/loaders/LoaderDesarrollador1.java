package com.eoi.java6.project1.loaders;

import com.eoi.java6.project1.entities.EntidadHijaRepository;
import com.eoi.java6.project1.entities.EntidadPadreRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
@Configuration
@Log4j2
@Profile("local-desarrollador1")
public class LoaderDesarrollador1 {

    private final EntidadPadreRepository repository;
    private final EntidadHijaRepository entidadHijaRepository;

    public LoaderDesarrollador1(EntidadPadreRepository repository, EntidadHijaRepository entidadHijaRepository) {
        this.repository = repository;
        this.entidadHijaRepository = entidadHijaRepository;
    }

    @PostConstruct
    public void loadDataLocalDesarrollador1() {
        log.info("Iniciando la carga de datos para el perfil de desarrollador local 1.");

    }




}
