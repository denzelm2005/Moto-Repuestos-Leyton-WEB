package com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Repository;

import org.springframework.stereotype.Repository;
import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ClientesRepository extends JpaRepository<Cliente, Integer> {

}
