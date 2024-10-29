package com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Repository;

import org.springframework.stereotype.Repository;
import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Models.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Integer> {

}
