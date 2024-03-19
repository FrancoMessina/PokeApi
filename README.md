# Desafío del Pokedex API

Este proyecto de desafío tiene como objetivo construir una API REST para el Pokedex, que permite a los usuarios acceder a información detallada sobre los Pokémon. La implementación de la API se realiza utilizando Java Spring Boot y se consume datos de la PokeAPI externa.

## Requisitos del Proyecto

- Construir una API REST utilizando Java Spring Boot.
- Consumir el servicio externo PokeAPI (https://pokeapi.co/) para obtener la información de los Pokémon.
- Exponer los endpoints necesarios para montar un frontend.
- Implementar Swagger para probar los endpoints de la API.
- Opcionalmente, desarrollar un frontend que haga uso de la API.
- Desplegar la aplicación en AWS, Azure, GCP o Heroku.
- Mantener un código limpio, ordenado y de calidad.

## Funcionalidades

### Obtener Detalles de un Pokémon por Nombre

- **Método HTTP:** GET
- **Endpoint:** `/pokemon/details/{name}`
- **Descripción:** Obtiene los detalles de un Pokémon específico por su nombre.
- **Respuesta Exitosa:** Retorna los detalles del Pokémon si se encuentra.
- **Respuesta de Error:** Retorna un mensaje de error si el Pokémon no se encuentra.

### Obtener un Pokémon por Nombre

- **Método HTTP:** GET
- **Endpoint:** `/pokemon/{name}`
- **Descripción:** Obtiene un Pokémon específico por su nombre.
- **Respuesta Exitosa:** Retorna el Pokémon si se encuentra.
- **Respuesta de Error:** Retorna un mensaje de error si el Pokémon no se encuentra.

### Obtener Todos los Detalles de los Pokémon

- **Método HTTP:** GET
- **Endpoint:** `/pokemon/details/all`
- **Descripción:** Obtiene todos los detalles de los Pokémon paginados.
- **Respuesta Exitosa:** Retorna una página de detalles de Pokémon.

### Obtener Todos los Pokémon

- **Método HTTP:** GET
- **Endpoint:** `/pokemon/all`
- **Descripción:** Obtiene todos los Pokémon paginados.
- **Respuesta Exitosa:** Retorna una página de Pokémon.

## Swagger UI

- **Descripción:** Permite probar los endpoints de la API a través de una interfaz gráfica.
- **URL:** [Swagger UI](https://pokeapi-kprk.onrender.com/doc/swagger-ui/index.html)

## Despliegue

La aplicación se encuentra desplegada en [Plataforma de Despliegue](https://pokeapi-kprk.onrender.com).

¡Gracias por revisar el desafío del Pokedex API! Si tienes alguna pregunta o comentario, no dudes en hacérmelo saber.
