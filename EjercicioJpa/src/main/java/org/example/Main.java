package org.example;

import org.example.entidades.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Iniciar transacción
        entityManager.getTransaction().begin();

        // Crear objetos y persistirlos en la base de datos

        // Unidades de medida
        UnidadMedida ochoPorciones = UnidadMedida.builder().denominacion("8 Porciones").build();
        UnidadMedida cuatroPorciones = UnidadMedida.builder().denominacion("4 Porciones").build();
        UnidadMedida litro = UnidadMedida.builder().denominacion("Litro").build();

        // Persistir unidades de medida
        entityManager.persist(ochoPorciones);
        entityManager.persist(cuatroPorciones);
        entityManager.persist(litro);

        // Imágenes
        Imagen imagen1 = Imagen.builder().denominacion("Imagen grande Hawaiana").build();
        Imagen imagen2 = Imagen.builder().denominacion("Imagen grande Napolitana").build();
        Imagen imagen3 = Imagen.builder().denominacion("Imagen grande Muzza").build();
        Imagen imagen4 = Imagen.builder().denominacion("Imagen chica Hawaiana").build();
        Imagen imagen5 = Imagen.builder().denominacion("Imagen chica Napolitana").build();
        Imagen imagen6 = Imagen.builder().denominacion("Imagen chica Muzza").build();
        Imagen imagenCerveza1 = Imagen.builder().denominacion("Imagen Andes").build();
        Imagen imagenCerveza2 = Imagen.builder().denominacion("Imagen Quilmes").build();
        Imagen imaHappy1 = Imagen.builder().denominacion("Imagen Promo1 Happyhour").build();
        Imagen imaHappy2 = Imagen.builder().denominacion("Imagen Promo2 Happyhour").build();
        Imagen verano1 = Imagen.builder().denominacion("Imagen Promo1 Verano").build();
        Imagen verano2 = Imagen.builder().denominacion("Imagen Promo2 Verano").build();
        Imagen invierno1 = Imagen.builder().denominacion("Imagen Promo1 Invierno").build();
        Imagen invierno2 = Imagen.builder().denominacion("Imagen Promo2 Invierno").build();

        // Persistir imágenes
        entityManager.persist(imagen1);
        entityManager.persist(imagen2);
        entityManager.persist(imagen3);
        entityManager.persist(imagen4);
        entityManager.persist(imagen5);
        entityManager.persist(imagen6);
        entityManager.persist(imagenCerveza1);
        entityManager.persist(imagenCerveza2);
        entityManager.persist(imaHappy1);
        entityManager.persist(imaHappy2);
        entityManager.persist(verano1);
        entityManager.persist(verano2);
        entityManager.persist(invierno1);
        entityManager.persist(invierno2);

        // Artículos
        Articulo pizza1 = Articulo.builder()
                .denominacion("Pizza grande Hawaiana")
                .imagen(imagen1)
                .precioCompra(20.0)
                .precioVenta(35.0)
                .stockActual(40)
                .stockMaximo(50)
                .unidadMedida(ochoPorciones)
                .build();

        Articulo pizza2 = Articulo.builder()
                .denominacion("Pizza grande Napolitana")
                .imagen(imagen2)
                .precioCompra(16.0)
                .precioVenta(30.0)
                .stockActual(14)
                .stockMaximo(70)
                .unidadMedida(ochoPorciones)
                .build();

        Articulo pizza3 = Articulo.builder()
                .denominacion("Pizza grande Muzza")
                .imagen(imagen3)
                .precioCompra(18.0)
                .precioVenta(32.0)
                .stockActual(21)
                .stockMaximo(90)
                .unidadMedida(ochoPorciones)
                .build();

        Articulo pizza4 = Articulo.builder()
                .denominacion("Pizza chica Hawaiana")
                .imagen(imagen4)
                .precioCompra(10.0)
                .precioVenta(21.0)
                .stockActual(9)
                .stockMaximo(70)
                .unidadMedida(cuatroPorciones)
                .build();

        Articulo pizza5 = Articulo.builder()
                .denominacion("Pizza chica Napolitana")
                .imagen(imagen1)
                .precioCompra(8.0)
                .precioVenta(16.0)
                .stockActual(23)
                .stockMaximo(100)
                .unidadMedida(cuatroPorciones)
                .build();

        Articulo pizza6 = Articulo.builder()
                .denominacion("Pizza chica Muzza")
                .imagen(imagen6)
                .precioCompra(9.0)
                .precioVenta(19.0)
                .stockActual(81)
                .stockMaximo(120)
                .unidadMedida(cuatroPorciones)
                .build();

        Articulo cerveza1 = Articulo.builder()
                .denominacion("Cerveza Andes")
                .imagen(imagenCerveza1)
                .precioCompra(2.5)
                .precioVenta(6.0)
                .stockActual(40)
                .stockMaximo(200)
                .unidadMedida(litro)
                .build();

        Articulo cerveza2 = Articulo.builder()
                .denominacion("Cerveza Quilmes")
                .imagen(imagenCerveza2)
                .precioCompra(3.0)
                .precioVenta(7.5)
                .stockActual(80)
                .stockMaximo(200)
                .unidadMedida(litro)
                .build();

        // Persistir artículos
        entityManager.persist(pizza1);
        entityManager.persist(pizza2);
        entityManager.persist(pizza3);
        entityManager.persist(pizza4);
        entityManager.persist(pizza5);
        entityManager.persist(pizza6);
        entityManager.persist(cerveza1);
        entityManager.persist(cerveza2);


        // Promociones
        TipoPromocion promocionHappyHour = TipoPromocion.happyHour;
        double precioSinRedondear = (pizza1.getPrecioCompra() + pizza3.getPrecioCompra() + cerveza2.getPrecioCompra()) *0.8;
        double precioRedondeado = Math.round(precioSinRedondear * 100.0) / 100.0;
        Promocion promo1 = Promocion.builder()
                .denominacion("Happy hour")
                .articulos(new HashSet<>(Set.of(pizza1, pizza3, cerveza2)))
                .imagenesPromo(new HashSet<>(Set.of(imaHappy1, imaHappy2)))
                .fechaDesde(LocalDate.of(2024, 9, 10))
                .fechaHasta(LocalDate.of(2024,9,20))
                .horaDesde(LocalTime.of(18,30,0))
                .horaHasta(LocalTime.of(22,0,0))
                .tipoPromocion(promocionHappyHour)
                .descripcionDescuento("Promocion especial 1 (20% descuento)")
                .precioPromocional(precioRedondeado)
                .build();

        TipoPromocion promocionVverano = TipoPromocion.Verano;
        double precioSinRedondear2 = (pizza4.getPrecioCompra() + pizza2.getPrecioCompra() + cerveza2.getPrecioCompra() + cerveza1.getPrecioCompra()) *0.65;
        double precioRedondeado2 = Math.round(precioSinRedondear2 * 100.0) / 100.0;
        Promocion promo2 = Promocion.builder()
                .denominacion("Promocion de verano")
                .articulos(new HashSet<>(Set.of(pizza4, pizza2, cerveza2, cerveza1)))
                .imagenesPromo(new HashSet<>(Set.of(verano1, verano2)))
                .fechaDesde(LocalDate.of(2024, 11, 1))
                .fechaHasta(LocalDate.of(2024,2,28))
                .horaDesde(LocalTime.of(14,0,0))
                .horaHasta(LocalTime.of(20,30,0))
                .tipoPromocion(promocionVverano)
                .descripcionDescuento("Promocion especial 2 (35% descuento)")
                .precioPromocional(precioRedondeado2)
                .build();

        TipoPromocion promocionInvierno = TipoPromocion.Invierno;
        double precioSinRedondear3 = (pizza1.getPrecioCompra() + pizza6.getPrecioCompra() + cerveza2.getPrecioCompra()) *0.9;
        double precioRedondeado3 = Math.round(precioSinRedondear3 * 100.0) / 100.0;
        Promocion promo3 = Promocion.builder()
                .denominacion("Happy hour")
                .articulos(new HashSet<>(Set.of(pizza1, pizza6, cerveza2)))
                .imagenesPromo(new HashSet<>(Set.of(invierno1, invierno2)))
                .fechaDesde(LocalDate.of(2024, 5, 1))
                .fechaHasta(LocalDate.of(2024,7,10))
                .horaDesde(LocalTime.of(15,30,0))
                .horaHasta(LocalTime.of(19,0,0))
                .tipoPromocion(promocionInvierno)
                .descripcionDescuento("Promocion especial 3 (10% descuento)")
                .precioPromocional(precioRedondeado3)
                .build();


        // Persistir promoción
        entityManager.persist(promo1);
        entityManager.persist(promo2);
        entityManager.persist(promo3);

        // Commit de la transacción
        entityManager.getTransaction().commit();

        // Cerrar el EntityManager y el EntityManagerFactory
        entityManager.close();
        entityManagerFactory.close();
    }
}
