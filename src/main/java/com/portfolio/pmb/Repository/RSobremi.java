/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.pmb.Repository;

import com.portfolio.pmb.Entity.Educacion;
import com.portfolio.pmb.Entity.Sobremi;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author walmart
 */
@Repository
public interface RSobremi extends JpaRepository<Sobremi, Integer> {
    
    public Optional<Sobremi> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
