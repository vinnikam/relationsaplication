package co.vinni.ejemplospring.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "propietarios")
@Builder
@ToString
public class Propietario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pro_codigo")
    private int codigo;

    @Column(name = "pro_nombre")
    private String nombre;

    @Column(name = "pro_identificacion", length = 6)
    private long identificacion;



}
