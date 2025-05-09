
package com.biblioteca.service.impl;

import com.biblioteca.entity.Libro;
import jakarta.annotation.PostConstruct;
import com.biblioteca.entity.Libro;
import com.biblioteca.repository.LibroRepository;
import com.biblioteca.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServiceImpl implements LibroService {

    @Autowired
    private LibroRepository libroRepository;
    
    @PostConstruct
    public void cargarLibroDePrueba() {
        if (libroRepository.count() == 0) {
            Libro libro = new Libro();
            libro.setTitulo("Cien años de soledad");
            libro.setAutor("Gabriel García Márquez");
            libro.setGenero("Realismo mágico");
            libro.setDisponible(true);
            libroRepository.save(libro);
        }
    }

    @Override
    public List<Libro> listar() {
        return libroRepository.findAll();
    }

    @Override
    public Libro guardar(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public Libro actualizar(Long id, Libro libro) {
        libro.setId(id);
        return libroRepository.save(libro);
    }

    @Override
    public void eliminar(Long id) {
        libroRepository.deleteById(id);
    }
    
    
}
