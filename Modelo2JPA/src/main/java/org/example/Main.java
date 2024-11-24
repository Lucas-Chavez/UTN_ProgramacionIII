package org.example;

import org.example.Entidades.*;
//import lombok.*;
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
        System.out.println("Inicio de Programa");


        try {

            entityManager.getTransaction().begin();
            //crear unidades de medida
            UnidadMedida ochoPorciones = UnidadMedida.builder().denominacion("8 Porciones").build();
            UnidadMedida cuatroPorciones = UnidadMedida.builder().denominacion("4 Porciones").build();
            UnidadMedida litro = UnidadMedida.builder().denominacion("1 litro").build();

            entityManager.persist(ochoPorciones);
            entityManager.persist(cuatroPorciones);
            entityManager.persist(litro);



            //crear imagenes
            Imagen imagen1 = Imagen.builder().denominacion("Pizza grande Hawaiana").build();
            Imagen imagen2 = Imagen.builder().denominacion("Pizza grande Napolitana").build();
            Imagen imagen3 = Imagen.builder().denominacion("Pizza grande Muzza").build();
            Imagen imagen4 = Imagen.builder().denominacion("Pizza chica Hawaiana").build();
            Imagen imagen5 = Imagen.builder().denominacion("Pizza chica Napolitana").build();
            Imagen imagen6 = Imagen.builder().denominacion("Pizza chica Muzza").build();


            Imagen imahappy1 = Imagen.builder().denominacion("Imagen 1 Happy Hour").build();
            Imagen imahappy2 = Imagen.builder().denominacion("Imagen 2 Happy Hour").build();
            Imagen verano1 = Imagen.builder().denominacion("Imagen 1 Verano").build();
            Imagen verano2 = Imagen.builder().denominacion("Imagen 2 Verano").build();
            Imagen invierno1 = Imagen.builder().denominacion("Imagen 1 Invierno").build();
            Imagen invierno2 = Imagen.builder().denominacion("Imagen 2 Invierno").build();
            Imagen cerveza1 = Imagen.builder().denominacion("Cerveza Andes").build();
            Imagen cerveza2 = Imagen.builder().denominacion("Cerveza Quilmes").build();

            entityManager.persist(imagen1);
            entityManager.persist(imagen2);
            entityManager.persist(imagen3);
            entityManager.persist(imagen4);
            entityManager.persist(imagen5);
            entityManager.persist(imagen6);
            entityManager.persist(imahappy1);
            entityManager.persist(imahappy2);
            entityManager.persist(verano1);
            entityManager.persist(verano2);
            entityManager.persist(invierno1);
            entityManager.persist(invierno2);
            entityManager.persist(cerveza1);
            entityManager.persist(cerveza2);


            //crear articulos
            Articulo hawaianaGrande = Articulo.builder()
                    .denominacion("Pizza Hawaiana Grande")
                    .precioCompra(10.0)
                    .precioVenta(20.0)
                    .stockActual(30)
                    .stockMaximo(50)
                    .imagen(imagen1)
                    .unidadMedida(ochoPorciones)
                    .build();
            Articulo hawaianaChica = Articulo.builder()
                    .denominacion("Pizza Hawaiana Chica")
                    .precioCompra(8.0)
                    .precioVenta(16.0)
                    .stockActual(40)
                    .stockMaximo(60)
                    .imagen(imagen4)
                    .unidadMedida(cuatroPorciones)
                    .build();
            Articulo napolitanaGrande = Articulo.builder()
                    .denominacion("Pizza Napolitana Grande")
                    .precioCompra(9.0)
                    .precioVenta(18.0)
                    .stockActual(50)
                    .stockMaximo(90)
                    .imagen(imagen2)
                    .unidadMedida(ochoPorciones)
                    .build();
            Articulo napolitanaChica = Articulo.builder()
                    .denominacion("Pizza Napolitana Chica")
                    .precioCompra(7.0)
                    .precioVenta(14.0)
                    .stockActual(70)
                    .stockMaximo(120)
                    .imagen(imagen5)
                    .unidadMedida(cuatroPorciones)
                    .build();
            Articulo muzzaGrande = Articulo.builder()
                    .denominacion("Pizza muzza Grande")
                    .precioCompra(7.0)
                    .precioVenta(14.0)
                    .stockActual(80)
                    .stockMaximo(120)
                    .imagen(imagen3)
                    .unidadMedida(ochoPorciones)
                    .build();
            Articulo muzzaChica = Articulo.builder()
                    .denominacion("Pizza muzza Chica")
                    .precioCompra(7.0)
                    .precioVenta(14.0)
                    .stockActual(80)
                    .stockMaximo(130)
                    .imagen(imagen6)
                    .unidadMedida(cuatroPorciones)
                    .build();


            Articulo andes = Articulo.builder()
                    .denominacion("Cerveza Andes")
                    .precioCompra(5.0)
                    .precioVenta(9.0)
                    .stockActual(80)
                    .stockMaximo(130)
                    .imagen(cerveza1)
                    .unidadMedida(litro)
                    .build();

            Articulo quilmes = Articulo.builder()
                    .denominacion("Cerveza Quilmes")
                    .precioCompra(4.0)
                    .precioVenta(8.0)
                    .stockActual(60)
                    .stockMaximo(100)
                    .imagen(cerveza2)
                    .unidadMedida(litro)
                    .build();

            entityManager.persist(hawaianaChica);
            entityManager.persist(hawaianaGrande);
            entityManager.persist(napolitanaChica);
            entityManager.persist(napolitanaGrande);
            entityManager.persist(muzzaGrande);
            entityManager.persist(muzzaChica);
            entityManager.persist(andes);
            entityManager.persist(quilmes);

            //creo promociones
            Promocion happyHour = Promocion.builder()
                    .denominacion("Promocion Happy Hour")
                    .articulos(new HashSet<>(Set.of(hawaianaGrande, muzzaGrande, quilmes)))
                    .HoraDesde(LocalTime.of(19, 00, 0))
                    .HoraHasta(LocalTime.of(21, 00, 0))
                    .FechaDesde(LocalDate.of(2024, 9, 2))
                    .FechaHasta(LocalDate.of(2024, 11, 2))
                    .descripcionDescuento("20% de descuento realizando la compra entre las 19 y las 21 horas. Valida desde el 2 de Septiembre hasta el dia 2 de Noviembre")
                    .precioPromocional((hawaianaGrande.getPrecioVenta() + muzzaGrande.getPrecioVenta() + quilmes.getPrecioVenta()) * 0.8)
                    .tipoPromocion(TipoPromocion.happyHour)
                    .promoImagen(new HashSet<>(Set.of(imahappy1, imahappy2)))
                    .build();


            Promocion verano = Promocion.builder()
                    .denominacion("Promocion Verano 2025")
                    .articulos(new HashSet<>(Set.of(hawaianaChica, napolitanaGrande, andes, quilmes)))
                    .HoraDesde(LocalTime.of(19, 30, 0))
                    .HoraHasta(LocalTime.of(21, 30, 0))
                    .FechaDesde(LocalDate.of(2024, 12, 21))
                    .FechaHasta(LocalDate.of(2025, 3, 20))
                    .descripcionDescuento("15% de descuento en esta promocion valida en todo el verano 2024-2025 en pedidos realizados entre las 19:30 y las 21:30")
                    .precioPromocional((hawaianaChica.getPrecioVenta() + napolitanaGrande.getPrecioVenta() + andes.getPrecioVenta() + quilmes.getPrecioVenta()) * 0.85) //precio original de 51
                    .promoImagen(new HashSet<>(Set.of(verano1, verano2)))
                    .tipoPromocion(TipoPromocion.Verano)
                    .build();

            Promocion invierno = Promocion.builder()
                    .denominacion("Promocion Invierno 2025")
                    .articulos(new HashSet<>(Set.of(hawaianaGrande, muzzaChica, quilmes)))
                    .HoraDesde(LocalTime.of(19, 30, 0))
                    .HoraHasta(LocalTime.of(21, 30, 0))
                    .FechaDesde(LocalDate.of(2025, 6, 21))
                    .FechaHasta(LocalDate.of(2025, 9, 20))
                    .descripcionDescuento("Promocion valida en todo el invierno 2025 en pedidos realizados entre las 19:30 y las 21:30")
                    .precioPromocional((hawaianaGrande.getPrecioVenta() + muzzaChica.getPrecioVenta() + quilmes.getPrecioVenta()) * 0.85) //precio original de 51
                    .promoImagen(new HashSet<>(Set.of(verano1, verano2)))
                    .tipoPromocion(TipoPromocion.Invierno)
                    .build();

            entityManager.persist(happyHour);
            entityManager.persist(verano);
            entityManager.persist(invierno);


            entityManager.flush();

            entityManager.getTransaction().commit();





    }catch (Exception e){

            entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
            System.out.println("No se pudo grabar la promo Invierno");}

        // Cerrar el EntityManager y el EntityManagerFactory
        entityManager.close();
        entityManagerFactory.close();
    }
    }
