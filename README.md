Desafío del Pokedex API
Este es un proyecto de desafío destinado a construir una API REST para el Pokedex, que permite a los usuarios acceder a información detallada sobre los Pokémon. La API utiliza Java Spring Boot para su implementación y consume datos de la PokeAPI externa.

Requisitos del Proyecto
Construir una API REST utilizando Java Spring Boot
Consumir el servicio externo PokeAPI (https://pokeapi.co/) para obtener la información de los Pokémon.
Exponer los endpoints necesarios para montar un frontend.
Implementar Swagger para probar los endpoints de la API.
Opcionalmente, desarrollar un frontend que haga uso de la API.
Desplegar la aplicación en AWS, Azure, GCP o Heroku.
Mantener un código limpio, ordenado y de calidad.
Funcionalidades
Lista de Pokémon Básica
Descripción: Retorna una lista de Pokémon con información básica.
Endpoint: /api/pokemon
Método HTTP: GET
Parámetros: Ninguno
Respuesta Exitosa: Código de estado 200 OK y una lista de Pokémon con sus respectivos nombres, tipos, pesos y habilidades.
Respuesta de Error: Código de estado y mensaje de error en caso de falla.
Detalles de un Pokémon
Descripción: Retorna información detallada de un Pokémon específico.
Endpoint: /api/pokemon/{id}
Método HTTP: GET
Parámetros: ID del Pokémon
Respuesta Exitosa: Código de estado 200 OK y detalles completos del Pokémon, incluyendo su nombre, tipo, peso, habilidades, descripción y movimientos.
Respuesta de Error: Código de estado y mensaje de error en caso de que el Pokémon no sea encontrado.
Swagger UI
Descripción: Permite probar los endpoints de la API a través de una interfaz gráfica.
URL: /swagger-ui.html
Despliegue
La aplicación se encuentra desplegada en Plataforma de Despliegue. https://pokeapi-kprk.onrender.com/doc/swagger-ui/index.html