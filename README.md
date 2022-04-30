# backend-fizzbuzz
API REST la cual devuelve en formato JSON una lista con las características propias de cada número incluido en el rango consultado, a través del endpoint /fizzbuzz/{min}/{max}.

Api rest utilizando spring boot con Java 11. Frontend en angular versión 9.

La api rest almacena los datos en una BD postgres. Se asume que solamente se quiere persistir las operaciones exitosas (por eso se optó por una sola tabla). El script para la creación de la tabla es:

CREATE TABLE public.operations ( operation_id SERIAL PRIMARY KEY, "timestamp" TIMESTAMP NOT NULL, min_value smallint NOT NULL, max_value smallint NOT NULL, list text NOT NULL, has_three_multiple boolean NOT NULL, has_five_multiple boolean NOT NULL )

Se asume que el valor mínimo ingresado permite es -50 y el valor máximo permitido es 50.

Los datos de conexión se configuran en el archivo application.properties (spring.datasource.url, spring.datasource.username y spring.datasource.password). La api se levanta en el puerto 8089. Para la estructura del proyecto se utiliza como referencia la siguiente guía: https://medium.com/the-resonant-web/spring-boot-2-0-starter-kit-part-1-23ddff0c7da2 Los tests automatizados se encuentra en el paquet scr/test/java.
