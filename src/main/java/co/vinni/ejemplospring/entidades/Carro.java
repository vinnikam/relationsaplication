package co.vinni.ejemplospring.entidades;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "carros")
@Builder
@ToString
public class Carro {
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
