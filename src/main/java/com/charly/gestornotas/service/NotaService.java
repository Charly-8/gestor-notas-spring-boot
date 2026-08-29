package com.charly.gestornotas.service;

import com.charly.gestornotas.exception.NotaNoEncontradaException;
import com.charly.gestornotas.model.Nota;
import com.charly.gestornotas.repository.NotaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotaService {
    private final NotaRepository notaRepository;

    public NotaService(NotaRepository notaRepository) {
        this.notaRepository = notaRepository;
    }

    // Create
    public Nota crear(Nota nota) {
        nota.setFechaCreacion(LocalDateTime.now());
        return notaRepository.save(nota);
    }

    public List<Nota> listarTodas() {
        return notaRepository.findAll();
    }

    // Read
    public Nota buscarPorId(Long id) {
        return notaRepository.findById(id)
                .orElseThrow(() -> new NotaNoEncontradaException("Nota no encontrada: ID - " + id));
    }

    // Update
    public Nota actualizar(Long id, Nota notaActualizada) {
        Nota nota =  buscarPorId(id);

        nota.setTitulo(notaActualizada.getTitulo());
        nota.setContenido(notaActualizada.getContenido());
        nota.setCategoria(notaActualizada.getCategoria());

        return notaRepository.save(nota);
    }

    // Delete

    public void eliminar(Long id) {
        notaRepository.deleteById(id);
    }
}
