# Guion de sustentación máximo 10 minutos

## 0:00 a 0:40 Presentación

Presentar la Tarea 02 y explicar que el objetivo fue comparar las arquitecturas monolítica y de microservicios mediante dos servicios Spring Boot.

## 0:40 a 1:40 Conceptos

Explicar que un monolito agrupa las funciones en una sola aplicación, mientras que los microservicios separan capacidades de negocio desplegables de forma independiente y conectadas por APIs.

## 1:40 a 2:40 Arquitectura

Mostrar el diagrama. `usuarios-service` funciona en el puerto 8081 y administra usuarios. `pedidos-service` funciona en el puerto 8082. Al crear un pedido, Pedidos consulta por REST a Usuarios y solo continúa cuando recibe un usuario válido.

## 2:40 a 4:30 Código

Mostrar `UsuarioController`, `PedidoController` y `UsuarioClient`. Señalar los endpoints, las validaciones y la llamada HTTP con `RestClient`. Explicar que los datos están en memoria porque la actividad se concentra en la comunicación entre servicios.

## 4:30 a 7:30 Demostración

1. Iniciar `usuarios-service` y luego `pedidos-service`.
2. Consultar `GET http://localhost:8081/usuarios/1`.
3. Crear un pedido con `POST http://localhost:8082/pedidos` y el cuerpo incluido en la colección de Postman.
4. Mostrar que la respuesta contiene los datos obtenidos del servicio de Usuarios.
5. Consultar `GET http://localhost:8082/pedidos`.
6. Opcional: intentar crear un pedido con `usuarioId` 99 y mostrar el error controlado.

## 7:30 a 8:40 Pruebas y decisiones

Mostrar las pruebas automatizadas. Explicar que se comprueba la consulta de usuarios, el error 404 y la creación de un pedido utilizando una respuesta simulada del cliente de Usuarios.

## 8:40 a 9:40 Conclusiones

Indicar que la separación permite despliegue y escalamiento independiente, pero agrega fallos de red, más configuración y pruebas de integración. Concluir que conviene usar microservicios cuando el tamaño y las necesidades del sistema justifican esa complejidad.

## Antes de grabar

- Reemplazar las URL pendientes en el PDF.
- Aumentar el tamaño de letra del IDE y Postman.
- Cerrar notificaciones y datos personales.
- Ensayar para no superar 10 minutos.
