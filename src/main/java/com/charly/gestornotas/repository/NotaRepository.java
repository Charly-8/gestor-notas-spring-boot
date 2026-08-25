package com.charly.gestornotas.repository;

import com.charly.gestornotas.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

/*
Qué está pasando aquí:

JpaRepository<Nota, Long> — el primer parámetro (Nota) le dice a Spring con qué entidad va a trabajar este repository.
El segundo (Long) es el tipo de dato de la llave primaria (id).
Al extender JpaRepository, tu interfaz hereda un montón de métodos ya implementados que no ves, pero existen: save(), findAll(), findById(), deleteById(), count(), entre otros.
No escribes ni una línea de SQL. Spring Data JPA genera esas consultas por ti, por detrás, basándose en la entidad Nota que le pasaste.
 */

public interface NotaRepository extends JpaRepository<Nota, Long> {
}
