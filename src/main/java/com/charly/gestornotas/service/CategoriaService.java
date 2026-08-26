package com.charly.gestornotas.service;

import com.charly.gestornotas.model.Categoria;
import com.charly.gestornotas.repository.CategoriaRepository;

import java.time.LocalDateTime;
import java.util.List;

public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    // crear - listarTodas - buscarPorId - actualizar - eliminar

    // Create
    public Categoria crear(Categoria categoria) {
        categoria.setFechaCreacion(LocalDateTime.now());
        return categoriaRepository.save(categoria);
    }
}