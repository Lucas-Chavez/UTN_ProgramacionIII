package org.example;
import org.example.entidades.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;





public class Main {
    public static void main(String[] args) {

        //crear clientes
        Cliente cliente1 = Cliente.builder()
                .id(1L)
                .nombre("Geronimo")
                .apellido("Crescitelli")
                .telefono("2618463254")
                .email("geromail@gmail.com")
                .fechaNacimiento(LocalDate.of(2000, 1, 29))
                .build();

        Cliente cliente2 = Cliente.builder()
                .id(2L)
                .nombre("Luca")
                .apellido("Crescitelli")
                .telefono("2618444444")
                .email("lucamail@gmail.com")
                .fechaNacimiento(LocalDate.of(2005, 11, 24))
                .build();

        Cliente cliente3 = Cliente.builder()
                .id(3L)
                .nombre("Federico")
                .apellido("Crescitelli")
                .telefono("2612555555")
                .email("fedemail@gmail.com")
                .fechaNacimiento(LocalDate.of(1976, 1, 17))
                .build();

        //crear unidades de medida
        UnidadMedida ochoPorciones = UnidadMedida.builder().id(1L).denominacion("8 Porciones").build();
        UnidadMedida cuatroPorciones = UnidadMedida.builder().id(2L).denominacion("4 Porciones").build();
        UnidadMedida litro = UnidadMedida.builder().id(3L).denominacion("1 litro").build();


        //crear imagenes
        Imagen imagen1 = Imagen.builder().id(1L).denominacion("Pizza grande Hawaiana").url("urlimagen1").build();
        Imagen imagen2 = Imagen.builder().id(2L).denominacion("Pizza grande Napolitana").url("urlimagen2").build();
        Imagen imagen3 = Imagen.builder().id(3L).denominacion("Pizza grande Muzza").url("urlimagen3").build();
        Imagen imagen4 = Imagen.builder().id(4L).denominacion("Pizza chica Hawaiana").url("urlimagen4").build();
        Imagen imagen5 = Imagen.builder().id(5L).denominacion("Pizza chica Napolitana").url("urlimagen5").build();
        Imagen imagen6 = Imagen.builder().id(6L).denominacion("Pizza chica Muzza").url("urlimagen6").build();
        Imagen imagen7 = Imagen.builder().id(7L).denominacion("Carveza Andes").url("urlimagen7").build();
        Imagen imagen8 = Imagen.builder().id(8L).denominacion("Cerveza Quilmes").url("urlimagen8").build();

        //crear articulos
        Articulo hawaianaGrande = Articulo.builder()
                .id(1L)
                .denominacion("Pizza Hawaiana Grande")
                .precioCompra(10.0)
                .precioVenta(20.0)
                .stockActual(30)
                .stockMaximo(50)
                .imagen(imagen1)
                .unidadMedida(ochoPorciones)
                .tiempoEstimadoMinutos(25)
                .build();
        Articulo hawaianaChica = Articulo.builder()
                .id(2L)
                .denominacion("Pizza Hawaiana Chica")
                .precioCompra(8.0)
                .precioVenta(16.0)
                .stockActual(40)
                .stockMaximo(60)
                .imagen(imagen4)
                .unidadMedida(cuatroPorciones)
                .tiempoEstimadoMinutos(20)
                .build();
        Articulo napolitanaGrande = Articulo.builder()
                .id(3L)
                .denominacion("Pizza Napolitana Grande")
                .precioCompra(9.0)
                .precioVenta(18.0)
                .stockActual(50)
                .stockMaximo(90)
                .imagen(imagen2)
                .unidadMedida(ochoPorciones)
                .tiempoEstimadoMinutos(25)
                .build();
        Articulo napolitanaChica = Articulo.builder()
                .id(4L)
                .denominacion("Pizza Napolitana Chica")
                .precioCompra(7.0)
                .precioVenta(14.0)
                .stockActual(70)
                .stockMaximo(120)
                .imagen(imagen5)
                .unidadMedida(cuatroPorciones)
                .tiempoEstimadoMinutos(20)
                .build();
        Articulo muzzaGrande = Articulo.builder()
                .id(5L)
                .denominacion("Pizza muzza Grande")
                .precioCompra(7.0)
                .precioVenta(14.0)
                .stockActual(80)
                .stockMaximo(120)
                .imagen(imagen3)
                .unidadMedida(ochoPorciones)
                .tiempoEstimadoMinutos(25)
                .build();
        Articulo muzzaChica = Articulo.builder()
                .id(6L)
                .denominacion("Pizza muzza Chica")
                .precioCompra(7.0)
                .precioVenta(14.0)
                .stockActual(80)
                .stockMaximo(130)
                .imagen(imagen6)
                .unidadMedida(cuatroPorciones)
                .tiempoEstimadoMinutos(20)
                .build();

        Articulo andes = Articulo.builder()
                .id(7L)
                .denominacion("Cerveza Andes")
                .precioCompra(5.0)
                .precioVenta(9.0)
                .stockActual(80)
                .stockMaximo(130)
                .imagen(imagen7)
                .unidadMedida(litro)
                .tiempoEstimadoMinutos(0)
                .build();

        Articulo quilmes = Articulo.builder()
                .id(8L)
                .denominacion("Cerveza Quilmes")
                .precioCompra(4.0)
                .precioVenta(8.0)
                .stockActual(60)
                .stockMaximo(100)
                .imagen(imagen8)
                .unidadMedida(litro)
                .tiempoEstimadoMinutos(0)
                .build();


        //-	El cliente1, realiza un pedido de una Pizza grande hawaiana y una cerveza Quilmes.

        DetallePedido det1cliente1 = DetallePedido.builder().id(1L).articulo(hawaianaGrande).cantidad(1).build();
        det1cliente1.calcularSubTotal();

        DetallePedido det2cliente1 = DetallePedido.builder().id(2L).articulo(quilmes).cantidad(1).build();
        det2cliente1.calcularSubTotal();

        Pedido pedido1cliente1 = Pedido.builder()
                .id(1L)
                .horaEstimadaFinalizacion(LocalTime.now().plusMinutes(det1cliente1.getArticulo().getTiempoEstimadoMinutos()))
                .detallePedido(Set.of(det1cliente1, det2cliente1))
                .estado(Estado.EN_PREPARACION)
                .tipoEnvio(TipoEnvio.RETIRO)
                .formaPago(FormaPago.EFECTIVO)
                .fechaPedido(LocalDate.of(2024, 9, 6))
                .build();
        pedido1cliente1.calcularTotales();

        cliente1.getPedidos().add(pedido1cliente1);
        mostrarPedido(cliente1, pedido1cliente1);

        //PEDIDO CLIENTE 2 | realiza la compra de 3 cervezas Quilmes y una Pizza Hawaiana chica.
        DetallePedido det1cliente2 = DetallePedido.builder().id(1L).articulo(quilmes).cantidad(3).build();
        det1cliente2.calcularSubTotal();

        DetallePedido det2cliente2 = DetallePedido.builder().id(2L).articulo(hawaianaChica).cantidad(1).build();
        det2cliente2.calcularSubTotal();

        Pedido pedido1cliente2 = Pedido.builder()
                .id(2L)
                .horaEstimadaFinalizacion(LocalTime.now().plusMinutes(det2cliente2.getArticulo().getTiempoEstimadoMinutos()))
                .detallePedido(Set.of(det1cliente2, det2cliente2))
                .estado(Estado.LISTO)
                .tipoEnvio(TipoEnvio.DELIVERY)
                .formaPago(FormaPago.TARJETA)
                .fechaPedido(LocalDate.of(2024, 9, 8))
                .build();
        pedido1cliente2.calcularTotales();

        cliente2.getPedidos().add(pedido1cliente2);
        mostrarPedido(cliente2, pedido1cliente2);


        //PEDIDO CLIENTE 3 | compra 1 Pizza grande Hawaiana , 1 pizza chica Muzza , 1 grande Napolitana y 2 cervezas Andes.
        DetallePedido det1cliente3 = DetallePedido.builder().id(1L).articulo(hawaianaGrande).cantidad(1).build();
        det1cliente3.calcularSubTotal();

        DetallePedido det2cliente3 = DetallePedido.builder().id(2L).articulo(napolitanaGrande).cantidad(1).build();
        det2cliente3.calcularSubTotal();

        DetallePedido det3cliente3 = DetallePedido.builder().id(3L).articulo(andes).cantidad(2).build();
        det3cliente3.calcularSubTotal();

        Pedido pedido1cliente3 = Pedido.builder()
                .id(3L)
                .horaEstimadaFinalizacion(LocalTime.now().plusMinutes(det1cliente3.getArticulo().getTiempoEstimadoMinutos() + det2cliente3.getArticulo().getTiempoEstimadoMinutos()))
                .detallePedido(Set.of(det1cliente3, det2cliente3, det3cliente3))
                .estado(Estado.EN_PREPARACION)
                .tipoEnvio(TipoEnvio.DELIVERY)
                .formaPago(FormaPago.EFECTIVO)
                .fechaPedido(LocalDate.of(2024, 9, 7))
                .build();
        pedido1cliente3.calcularTotales();

        cliente3.getPedidos().add(pedido1cliente3);
        mostrarPedido(cliente3, pedido1cliente3);

        //PEDIDO 2 CLIENTE 1 | realiza un pedido de 1 muzza chica y una cerveza Andes.
        DetallePedido det3cliente1 = DetallePedido.builder().id(6L).articulo(muzzaChica).cantidad(1).build();
        det3cliente1.calcularSubTotal();

        DetallePedido det4cliente1 = DetallePedido.builder().id(7L).articulo(andes).cantidad(1).build();
        det4cliente1.calcularSubTotal();

        Pedido pedido2cliente1 = Pedido.builder()
                .id(4L)
                .horaEstimadaFinalizacion(LocalTime.now().plusMinutes(det3cliente1.getArticulo().getTiempoEstimadoMinutos()))
                .detallePedido(Set.of(det3cliente1, det4cliente1))
                .estado(Estado.LISTO)
                .tipoEnvio(TipoEnvio.RETIRO)
                .formaPago(FormaPago.TARJETA)
                .fechaPedido(LocalDate.of(2024, 9, 8))
                .build();
        pedido2cliente1.calcularTotales();

        cliente1.getPedidos().add(pedido2cliente1);

        //-	Mostrar por consola el pedido realizado por el cliente1 y el total de la compra
        mostrarPedido(cliente1,pedido2cliente1);

        //-	Mostrar por consola la cantidad de veces que el cliente 1 compró en el local.
        System.out.println("EL CLIENTE 1 HA COMPRADO EN EL LOCAL " + cliente1.getPedidos().size() + " VECES");


        //-	Mostrar todos los artículos que comercializa el negocio
        System.out.println("ARTÍCULOS:");
        HashSet<Articulo> todosLosArticulos = new HashSet<>(Set.of(hawaianaGrande, napolitanaGrande, muzzaGrande, hawaianaChica, napolitanaChica, muzzaChica, andes, quilmes));
        for (Articulo art : todosLosArticulos) {
            System.out.println(art.getDenominacion());
        }



        }
    private static void mostrarPedido (Cliente cliente, Pedido pedido){
        System.out.println("Pedido realizado por: " + cliente.getNombre() + " " + cliente.getApellido());
        for (DetallePedido detalle : pedido.getDetallePedido()) {
            System.out.println("Artículo: " + detalle.getArticulo().getDenominacion() + ", Cantidad: " + detalle.getCantidad() + ", Subtotal: $" + detalle.getSubTotal());
        }
    }
    }

