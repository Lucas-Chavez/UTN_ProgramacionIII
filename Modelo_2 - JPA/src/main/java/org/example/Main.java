package org.example;
import org.example.entidades.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            // Crear unidades de medida
            UnidadMedida porciones8 = UnidadMedida.builder().denominacion("8 Porciones").build();
            UnidadMedida porciones4 = UnidadMedida.builder().denominacion("4 Porciones").build();
            UnidadMedida litro1 = UnidadMedida.builder().denominacion("1 Litro").build();
            em.persist(porciones8);
            em.persist(porciones4);
            em.persist(litro1);
            // Crear imágenes
            Imagen imagen1 = Imagen.builder().denominacion("Pizza grande Hawaiana").build();
            Imagen imagen2 = Imagen.builder().denominacion("Pizza grande Napolitana").build();
            Imagen imagen3 = Imagen.builder().denominacion("Pizza grande Muzza").build();
            Imagen imagen4 = Imagen.builder().denominacion("Pizza chica Hawaiana").build();
            Imagen imagen5 = Imagen.builder().denominacion("Pizza chica Napolitana").build();
            Imagen imagen6 = Imagen.builder().denominacion("Pizza chica Muzza").build();
            Imagen imagen7 = Imagen.builder().denominacion("Cerveza Andes").build();
            Imagen imagen8 = Imagen.builder().denominacion("Cerveza Quilmes").build();
            Imagen imahappy1 = Imagen.builder().denominacion("Promoción Happy Hour 1").build();
            Imagen imahappy2 = Imagen.builder().denominacion("Promoción Happy Hour 2").build();
            Imagen verano1 = Imagen.builder().denominacion("Promoción Verano 1").build();
            Imagen verano2 = Imagen.builder().denominacion("Promoción Verano 2").build();
            Imagen invierno1 = Imagen.builder().denominacion("Promoción Invierno 1").build();
            Imagen invierno2 = Imagen.builder().denominacion("Promoción Invierno 2").build();
            // Persistir imágenes
            em.persist(imagen1);
            em.persist(imagen2);
            em.persist(imagen3);
            em.persist(imagen4);
            em.persist(imagen5);
            em.persist(imagen6);
            em.persist(imagen7);
            em.persist(imagen8);
            em.persist(imahappy1);
            em.persist(imahappy2);
            em.persist(verano1);
            em.persist(verano2);
            em.persist(invierno1);
            em.persist(invierno2);
            // Crear artículos
            Articulo pizzaGrandeHawaiana = Articulo.builder()
                    .denominacion("Pizza grande Hawaiana")
                    .precioVenta(1500.0)
                    .precioCompra(1000.0)
                    .stockActual(50)
                    .stockMaximo(100)
                    .imagen(imagen1)
                    .unidadMedida(porciones8)
                    .build();
            Articulo pizzaChicaHawaiana = Articulo.builder()
                    .denominacion("Pizza chica Hawaiana")
                    .precioVenta(800.0)
                    .precioCompra(500.0)
                    .stockActual(60)
                    .stockMaximo(120)
                    .imagen(imagen4)
                    .unidadMedida(porciones4)
                    .build();
            Articulo pizzaGrandeNapolitana = Articulo.builder()
                    .denominacion("Pizza grande Napolitana")
                    .precioVenta(1400.0)
                    .precioCompra(900.0)
                    .stockActual(55)
                    .stockMaximo(110)
                    .imagen(imagen2)
                    .unidadMedida(porciones8)
                    .build();
            Articulo pizzaChicaNapolitana = Articulo.builder()
                    .denominacion("Pizza chica Napolitana")
                    .precioVenta(700.0)
                    .precioCompra(450.0)
                    .stockActual(65)
                    .stockMaximo(130)
                    .imagen(imagen5)
                    .unidadMedida(porciones4)
                    .build();
            Articulo pizzaGrandeMuzza = Articulo.builder()
                    .denominacion("Pizza grande Muzza")
                    .precioVenta(1300.0)
                    .precioCompra(850.0)
                    .stockActual(70)
                    .stockMaximo(140)
                    .imagen(imagen3)
                    .unidadMedida(porciones8)
                    .build();
            Articulo pizzaChicaMuzza = Articulo.builder()
                    .denominacion("Pizza chica Muzza")
                    .precioVenta(650.0)
                    .precioCompra(400.0)
                    .stockActual(75)
                    .stockMaximo(150)
                    .imagen(imagen6)
                    .unidadMedida(porciones4)
                    .build();
            Articulo cervezaAndes = Articulo.builder()
                    .denominacion("Cerveza Andes")
                    .precioVenta(500.0)
                    .precioCompra(300.0)
                    .stockActual(100)
                    .stockMaximo(200)
                    .imagen(imagen7)
                    .unidadMedida(litro1)
                    .build();
            Articulo cervezaQuilmes = Articulo.builder()
                    .denominacion("Cerveza Quilmes")
                    .precioVenta(550.0)
                    .precioCompra(350.0)
                    .stockActual(90)
                    .stockMaximo(180)
                    .imagen(imagen8)
                    .unidadMedida(litro1)
                    .build();
            // Persistir artículos
            em.persist(pizzaGrandeHawaiana);
            em.persist(pizzaChicaHawaiana);
            em.persist(pizzaGrandeNapolitana);
            em.persist(pizzaChicaNapolitana);
            em.persist(pizzaGrandeMuzza);
            em.persist(pizzaChicaMuzza);
            em.persist(cervezaAndes);
            em.persist(cervezaQuilmes);

            // Calcular precios promocionales
            double precioHappyHour = calcularPrecioPromocional(new HashSet<>(Set.of(pizzaGrandeHawaiana, pizzaGrandeMuzza, cervezaQuilmes)), 0.20);
            double precioVerano = calcularPrecioPromocional(new HashSet<>(Set.of(pizzaChicaHawaiana, pizzaGrandeNapolitana, cervezaQuilmes, cervezaAndes)), 0.15);
            double precioInvierno = calcularPrecioPromocional(new HashSet<>(Set.of(pizzaGrandeHawaiana, pizzaChicaMuzza, cervezaQuilmes)), 0.10);

            // Crear promociones
            Promocion happyHour = Promocion.builder()
                    .denominacion("Happy Hour")
                    .fechaDesde(LocalDate.of(2024, 8, 26))
                    .fechaHasta(LocalDate.of(2024, 9, 26))
                    .horaDesde(LocalTime.of(18, 0))
                    .horaHasta(LocalTime.of(20, 0))
                    .descripcionDescuento("20% de descuento en pizzas grandes y cervezas")
                    .precioPromocional(precioHappyHour)
                    .tipoPromocion(TipoPromocion.HAPPY_HOUR)
                    .articulos(new HashSet<>(Set.of(pizzaGrandeHawaiana, pizzaGrandeMuzza, cervezaQuilmes)))
                    .promoImagen(new HashSet<>(Set.of(imahappy1, imahappy2)))
                    .build();
            Promocion verano = Promocion.builder()
                    .denominacion("Verano")
                    .fechaDesde(LocalDate.of(2024, 12, 1))
                    .fechaHasta(LocalDate.of(2025, 2, 28))
                    .horaDesde(LocalTime.of(12, 0))
                    .horaHasta(LocalTime.of(23, 0))
                    .descripcionDescuento("15% de descuento en pizzas chicas y cervezas")
                    .precioPromocional(precioVerano)
                    .tipoPromocion(TipoPromocion.VERANO)
                    .articulos(new HashSet<>(Set.of(pizzaChicaHawaiana, pizzaGrandeNapolitana, cervezaQuilmes, cervezaAndes)))
                    .promoImagen(new HashSet<>(Set.of(verano1, verano2)))
                    .build();
            Promocion invierno = Promocion.builder()
                    .denominacion("Invierno")
                    .fechaDesde(LocalDate.of(2024, 6, 1))
                    .fechaHasta(LocalDate.of(2024, 8, 31))
                    .horaDesde(LocalTime.of(10, 0))
                    .horaHasta(LocalTime.of(22, 0))
                    .descripcionDescuento("10% de descuento en pizzas grandes y chicas")
                    .precioPromocional(precioInvierno)
                    .tipoPromocion(TipoPromocion.INVIERNO)
                    .articulos(new HashSet<>(Set.of(pizzaGrandeHawaiana, pizzaChicaMuzza, cervezaQuilmes)))
                    .promoImagen(new HashSet<>(Set.of(invierno1, invierno2)))
                    .build();
            // Persistir promociones
            em.persist(happyHour);
            em.persist(verano);
            em.persist(invierno);
            tx.commit();

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

        } catch (Exception e) {
            e.printStackTrace();
            if (tx.isActive()) {
                tx.rollback();
            }
        } finally {
            em.close();
            emf.close();
        }
    }

    // Método para mostrar detalle de una promoción
    private static void mostrarDetallePromocion(Promocion promocion) {
        System.out.println("\nPromoción: " + promocion.getDenominacion());
        System.out.println("Artículos relacionados y precios de venta:");
        promocion.getArticulos().forEach(articulo ->
                System.out.println(" - " + articulo.getDenominacion() + ": $" + articulo.getPrecioVenta()));


    }

    // Método para encontrar la promoción más económica basada en la suma de precios de venta de los artículos
    private static Promocion encontrarPromocionMasEconomica(Promocion[] promociones) {
        Promocion promocionMasEconomica = null;
        double costoMasBajo = Double.MAX_VALUE;

        for (Promocion promocion : promociones) {
            double costoTotal = 0.0;
            Set<Articulo> articulos = promocion.getArticulos();
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

    private static double calcularPrecioPromocional(Set<Articulo> articulos, double descuento) {
        double precioTotal = 0.0;
        for (Articulo articulo : articulos) {
            double v = articulo.getPrecioVenta() * (1 - descuento);
            precioTotal += v;
        }
        return Math.round(precioTotal * 100.0) / 100.0; // Redondear a 2 decimales
    }
}