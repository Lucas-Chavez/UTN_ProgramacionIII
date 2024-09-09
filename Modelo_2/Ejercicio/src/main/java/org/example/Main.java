package org.example;

import org.example.entidades.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Crear unidades de medida
        UnidadMedida porciones8 = UnidadMedida.builder().id(1L).denominacion("8 Porciones").build();
        UnidadMedida porciones4 = UnidadMedida.builder().id(2L).denominacion("4 Porciones").build();
        UnidadMedida litro1 = UnidadMedida.builder().id(3L).denominacion("1 Litro").build();

        // Crear imágenes
        Imagen imagen1 = Imagen.builder().id(1L).denominacion("Pizza grande Hawaiana").build();
        Imagen imagen2 = Imagen.builder().id(2L).denominacion("Pizza grande Napolitana").build();
        Imagen imagen3 = Imagen.builder().id(3L).denominacion("Pizza grande Muzza").build();
        Imagen imagen4 = Imagen.builder().id(4L).denominacion("Pizza chica Hawaiana").build();
        Imagen imagen5 = Imagen.builder().id(5L).denominacion("Pizza chica Napolitana").build();
        Imagen imagen6 = Imagen.builder().id(6L).denominacion("Pizza chica Muzza").build();
        Imagen imagen7 = Imagen.builder().id(7L).denominacion("Cerveza Andes").build();
        Imagen imagen8 = Imagen.builder().id(8L).denominacion("Cerveza Quilmes").build();
        Imagen imahappy1 = Imagen.builder().id(9L).denominacion("Promoción Happy Hour 1").build();
        Imagen imahappy2 = Imagen.builder().id(10L).denominacion("Promoción Happy Hour 2").build();
        Imagen verano1 = Imagen.builder().id(11L).denominacion("Promoción Verano 1").build();
        Imagen verano2 = Imagen.builder().id(12L).denominacion("Promoción Verano 2").build();
        Imagen invierno1 = Imagen.builder().id(13L).denominacion("Promoción Invierno 1").build();
        Imagen invierno2 = Imagen.builder().id(14L).denominacion("Promoción Invierno 2").build();

        // Crear artículos
        Articulo pizzaGrandeHawaiana = Articulo.builder()
                .id(1L).denominacion("Pizza grande Hawaiana")
                .precioVenta(1500.0)
                .imagen(imagen1)
                .unidadMedida(porciones8)
                .build();

        Articulo pizzaChicaHawaiana = Articulo.builder()
                .id(2L).denominacion("Pizza chica Hawaiana")
                .precioVenta(800.0)
                .imagen(imagen4)
                .unidadMedida(porciones4)
                .build();

        Articulo pizzaGrandeNapolitana = Articulo.builder()
                .id(3L).denominacion("Pizza grande Napolitana")
                .precioVenta(1400.0)
                .imagen(imagen2)
                .unidadMedida(porciones8)
                .build();

        Articulo pizzaChicaNapolitana = Articulo.builder()
                .id(4L).denominacion("Pizza chica Napolitana")
                .precioVenta(700.0)
                .imagen(imagen5)
                .unidadMedida(porciones4)
                .build();

        Articulo pizzaGrandeMuzza = Articulo.builder()
                .id(5L).denominacion("Pizza grande Muzza")
                .precioVenta(1300.0)
                .imagen(imagen3)
                .unidadMedida(porciones8)
                .build();

        Articulo pizzaChicaMuzza = Articulo.builder()
                .id(6L).denominacion("Pizza chica Muzza")
                .precioVenta(650.0)
                .imagen(imagen6)
                .unidadMedida(porciones4)
                .build();

        Articulo cervezaAndes = Articulo.builder()
                .id(7L).denominacion("Cerveza Andes")
                .precioVenta(500.0)
                .imagen(imagen7)
                .unidadMedida(litro1)
                .build();

        Articulo cervezaQuilmes = Articulo.builder()
                .id(8L).denominacion("Cerveza Quilmes")
                .precioVenta(550.0)
                .imagen(imagen8)
                .unidadMedida(litro1)
                .build();

        // Crear promociones
        Promocion happyHour = Promocion.builder()
                .id(1L)
                .denominacion("Happy Hour")
                .fechaDesde(LocalDate.of(2024, 8, 26))
                .fechaHasta(LocalDate.of(2024, 9, 26))
                .horaDesde(LocalTime.of(18, 0))
                .horaHasta(LocalTime.of(20, 0))
                .tipoPromocion(TipoPromocion.HAPPY_HOUR)
                .promociones(new HashSet<>(Set.of(pizzaGrandeHawaiana, pizzaGrandeMuzza, cervezaQuilmes)))
                .promoImagen(new HashSet<>(Set.of(imahappy1, imahappy2)))
                .build();

        Promocion verano = Promocion.builder()
                .id(2L)
                .denominacion("Verano")
                .fechaDesde(LocalDate.of(2024, 12, 1))
                .fechaHasta(LocalDate.of(2025, 2, 28))
                .horaDesde(LocalTime.of(12, 0))
                .horaHasta(LocalTime.of(23, 0))
                .tipoPromocion(TipoPromocion.VERANO)
                .promociones(new HashSet<>(Set.of(pizzaChicaHawaiana, pizzaGrandeNapolitana, cervezaQuilmes, cervezaAndes)))
                .promoImagen(new HashSet<>(Set.of(verano1, verano2)))
                .build();

        Promocion invierno = Promocion.builder()
                .id(3L)
                .denominacion("Invierno")
                .fechaDesde(LocalDate.of(2024, 6, 1))
                .fechaHasta(LocalDate.of(2024, 8, 31))
                .horaDesde(LocalTime.of(10, 0))
                .horaHasta(LocalTime.of(22, 0))
                .tipoPromocion(TipoPromocion.INVIERNO)
                .promociones(new HashSet<>(Set.of(pizzaGrandeHawaiana, pizzaChicaMuzza, cervezaQuilmes)))
                .promoImagen(new HashSet<>(Set.of(invierno1, invierno2)))
                .build();

        // a. Mostrar todas las promociones
        System.out.println("Todas las promociones:");
        System.out.println(happyHour);
        System.out.println(verano);
        System.out.println(invierno);

        // b. Mostrar todos los Artículos
        System.out.println("\nTodos los Artículos:");
        Set<Articulo> articulos = Set.of(
                pizzaGrandeHawaiana, pizzaChicaHawaiana, pizzaGrandeNapolitana, pizzaChicaNapolitana,
                pizzaGrandeMuzza, pizzaChicaMuzza, cervezaAndes, cervezaQuilmes
        );
        articulos.forEach(System.out::println);

        // c. Mostrar cada promoción por separado y los artículos relacionados y el precio de venta.
        System.out.println("\nDetalles de cada promoción:");
        mostrarDetallePromocion(happyHour);
        mostrarDetallePromocion(verano);
        mostrarDetallePromocion(invierno);

        // d. Mostrar el día y horario de la promoción Verano
        System.out.println("\nPromoción Verano:");
        System.out.println("Fecha Desde: " + verano.getFechaDesde() + ", Fecha Hasta: " + verano.getFechaHasta());
        System.out.println("Hora Desde: " + verano.getHoraDesde() + ", Hora Hasta: " + verano.getHoraHasta());

        // e. Mostrar cuál es la promoción más económica de las 3
        Promocion[] promociones = {happyHour, verano, invierno};
        Promocion promocionMasEconomica = encontrarPromocionMasEconomica(promociones);
        System.out.println("\nLa promoción más económica es: " + promocionMasEconomica.getDenominacion());
    }

    // Método para mostrar detalle de una promoción
    private static void mostrarDetallePromocion(Promocion promocion) {
        System.out.println("\nPromoción: " + promocion.getDenominacion());
        System.out.println("Artículos relacionados y precios de venta:");
        promocion.getPromociones().forEach(articulo ->
                System.out.println(" - " + articulo.getDenominacion() + ": $" + articulo.getPrecioVenta()));


    }

    // Método para encontrar la promoción más económica basada en la suma de precios de venta de los artículos
    private static Promocion encontrarPromocionMasEconomica(Promocion[] promociones) {
        Promocion promocionMasEconomica = null;
        double costoMasBajo = Double.MAX_VALUE;

        for (Promocion promocion : promociones) {
            double costoTotal = 0.0;
            Set<Articulo> articulos = promocion.getPromociones();
            for (Articulo articulo: articulos) {
                costoTotal += articulo.getPrecioVenta();
            }

            if (costoTotal < costoMasBajo) {
                costoMasBajo = costoTotal;
                promocionMasEconomica = promocion;
            }
        }

        return promocionMasEconomica;
    }
}
