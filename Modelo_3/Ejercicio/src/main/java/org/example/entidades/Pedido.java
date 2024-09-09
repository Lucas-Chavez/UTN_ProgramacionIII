package org.example.entidades;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Pedido {
    private Long id;
    private LocalTime horaEstimadaFinalizacion;
    private Double total;
    private Double totalCosto;
    private Estado estado;
    private TipoEnvio tipoEnvio;
    private FormaPago formaPago;
    private LocalDate fechaPedido;

    @Builder.Default
    private Set<DetallePedido> detalles = new HashSet<>();  // Relación unidireccional a DetallePedido

    public enum Estado {
        PENDIENTE,
        EN_PROCESO,
        COMPLETADO,
        CANCELADO,
        ENTREGADO
    }

    public enum TipoEnvio {
        DELIVERY,
        RETIRO_EN_LOCAL,
        ENVIO_A_DOMICILIO,
        ENVIO_EXPRESS
    }

    public enum FormaPago {
        EFECTIVO,
        TARJETA_CREDITO,
        TARJETA_DEBITO,
        TRANSFERENCIA_BANCARIA,
        PAYPAL,
        MERCADO_PAGO
    }
}
