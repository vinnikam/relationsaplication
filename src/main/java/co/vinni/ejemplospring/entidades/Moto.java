package co.vinni.ejemplospring.entidades;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "motos")
@Builder
@ToString
/**
 * author : Vinni
 * version 1.0
 */

public class Moto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "car_codigo")
    private int codigo;

    @Column(name = "car_modelo")
    private int modelo;

    @Column(name = "car_placa", length = 6)
    private String placa;

    @ManyToOne
    @JoinColumn(name = "pro_codigo")
    private Propietario propietario;

}
