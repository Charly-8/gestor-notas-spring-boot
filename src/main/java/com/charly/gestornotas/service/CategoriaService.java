package com.charly.gestornotas.service;

import com.charly.gestornotas.exception.CategoriaNoEncontradaException;
import com.charly.gestornotas.model.Categoria;
import com.charly.gestornotas.repository.CategoriaRepository;
import org.hibernate.sql.exec.ExecutionException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    // Create
    public Categoria crear(Categoria categoria) {
        categoria.setFechaCreacion(LocalDateTime.now());
        return categoriaRepository.save(categoria);
    }

    // Read
    public List<Categoria> listarTodas() {
        return categoriaRepository.findAll();
    }

    public Categoria buscarPorId(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new CategoriaNoEncontradaException("Categoria no encontrada: ID - " + id));
    }

    // Update
    public Categoria actualizar(Long id, Categoria categoriaActualizada) {
        Categoria categoriaSeleccionada = buscarPorId(id);

        categoriaSeleccionada.setNombre(categoriaActualizada.getNombre());
        return categoriaRepository.save(categoriaSeleccionada);
    }

    // Delete
    public void eliminar(Long id) {
        categoriaRepository.deleteById(id);
    }
}