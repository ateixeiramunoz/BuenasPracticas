package com.eoi.java6.project1.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for managing {@link EntidadPadre} entities.
 * Extends {@link JpaRepository} to provide standard CRUD operations.
 * Custom query methods may be defined as needed.
 */
@Repository
public interface EntidadPadreRepository extends JpaRepository<EntidadPadre, Integer> {

    Optional<EntidadPadre> findByNombre(String jetBrains);

}