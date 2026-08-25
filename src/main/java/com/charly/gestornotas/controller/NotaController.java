package com.charly.gestornotas.controller;

import com.charly.gestornotas.model.Nota;
import com.charly.gestornotas.service.NotaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notas")
public class NotaController {

    public final NotaService notaService;

    public NotaController(NotaService notaService) {
        this.notaService = notaService;
    }

    @PostMapping
    public Nota crear(@RequestBody Nota nota) {
        return notaService.crear(nota);
    }

    @GetMapping
    public List<Nota> listar() {
        return notaService.listarTodas();
    }

    @GetMapping("/{id}")
    public Nota buscarPorId(@PathVariable Long id) {
        return notaService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Nota actualizar(@PathVariable Long id, @RequestBody Nota nota) {
        return notaService.actualizar(id, nota);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        notaService.eliminar(id);
    }
}