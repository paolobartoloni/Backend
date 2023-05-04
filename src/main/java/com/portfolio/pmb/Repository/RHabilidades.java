/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.pmb.Repository;

import com.portfolio.pmb.Entity.Habilidades;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author walmart
 */
public interface RHabilidades extends JpaRepository<Habilidades, Integer>{
     public Optional<Habilidades> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
