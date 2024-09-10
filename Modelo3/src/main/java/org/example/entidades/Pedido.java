package org.example.entidades;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder



public class Pedido {
    private Long id;
    private LocalTime horaEstimadaFinalizacion;
    private double total;
    private double totalCosto;
    private Estado estado;
    private TipoEnvio tipoEnvio;
    private FormaPago formaPago;
    private LocalDate fechaPedido;

    @Builder.Default
    private Set<DetallePedido> detallePedido = new HashSet<>();

    public double calcularTotales(){
        this.total = 0.0;
        this.totalCosto = 0.0;
        for (DetallePedido detallePedido : detallePedido) {
            total += detallePedido.getSubTotal();
            totalCosto += detallePedido.getArticulo().getPrecioCompra() * detallePedido.getCantidad();
        }
        return total;
    }
}
