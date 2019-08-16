# Solución Previred - Nivel 3

Solución a problemática presentada en Desafio Uno para Previred

Esta version contempla una respuesta al Nivel 3.

Consume la API llamada "Genersador Datos Desafio Uno" y adiciona un listado de fechas faltantes en su respuesta.

**Current:** 0.0.1-SNAPSHOT

## Topics
- [Desarrolladores](#desarrolladores)
- [Tecnologías Principales](#tecnologias-principales)
- [Instalación](#instalacion)
- [ChangeLog](#changelog)

## Desarrolladores

Lista de Desarrolladores.

* Nicolás Cerda Serey <ncerdaserey@gmail.com>


## Tecnologías Principales

* [Java Spring Boot - versión 2.1.7.Release](https://spring.io/projects/spring-boot).
* [Swagger - versión 2.6.1](https://swagger.io/)

## Instalación

- Clonar el repositorio en una carpeta local
- Ingresar dentro de la carpeta llamada "Nivel 3" y compilar el proyecto ejecutando el siguiente comando Maven:

```
mvn clean spring-boot:run
```
- Inicializar la API Generador_Datos_Desafio_Uno previamente y comprobar su respectivo funcionamiento, para su configuración remitirse a su [Documentación](https://github.com/previred/Generador_Datos_Desafio_Uno)

- Chequear que el puerto 8090 esté disponible, en caso contrario, se debe cambiar desde el archivo application.yml dentro de src/main/resources/application.properties, en la carpeta de la aplicación.

- Se descargarán las librerías necesarias y se iniciará la API en la siguiente dirección:
```
http://localhost:puerto/periodosFaltantes/
```
- En caso de que todo haya sido por defecto, una vez iniciada la aplicación, se podrá consumir invocando la siguiente URL:
```
curl -X GET "http://localhost:8090/periodosFaltantes/fechasFaltantes" -H  "accept: application/json"
```
- Para acceder a la documentación, basta con ingresar a la URL (por defecto):
```
http://localhost:8090/periodosFaltantes/swagger-ui.html
```
- Al ejecutar el método GET, consumirá la API Generador_Datos_Desafio_Uno y posterior a ello, realizará el match para determinar las fechas faltantes, posterior a ello, entregará el JSON de respuesta. EJ:
```
{
  "id": 1,
  "fechaCreacion": "1981-04-01",
  "fechaFin": "2018-03-01",
  "fechas": [
    "1981-04-01",
    "1981-05-01",
    "1981-10-01",
    "1982-01-01",
    "1982-05-01",
    (...)
    "2015-11-01",
    "2017-02-01",
    "2017-07-01",
    "2017-08-01",
    "2017-11-01"

    ],
  "fechasFaltantes": [
    "1981-06-01",
    "1981-07-01",
    "1981-08-01",
    "1981-09-01",
    "1981-11-01",
    (...)
    "2017-06-01",
    "2017-09-01",
    "2017-10-01",
    "2017-12-01",
    "2018-01-01",
    "2018-02-01",
    "2018-03-01"
  ]
}
```

## Changelog
Version 0.0.1-SNAPSHOT

- Primera versión creada.
