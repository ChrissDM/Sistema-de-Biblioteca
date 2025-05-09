
package com.biblioteca.service;

import com.biblioteca.entity.Libro;

import java.util.List;

public interface LibroService {
    List<Libro> listar();
    Libro guardar(Libro libro);
    Libro actualizar(Long id, Libro libro);
    void eliminar(Long id);
}
