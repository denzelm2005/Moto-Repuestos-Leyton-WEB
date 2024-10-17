package com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Repository;


import org.springframework.stereotype.Repository;
import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Models.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {

}
