## Análisis de ADN para descubrir mutantes
El ejercicio consiste en analizar un ADN enviado al endpoint "/mutant" y verificar si pertenece a un mutante. El ADN será pasado como un arreglo de tipo String[], que contendrá únicamente los caracteres "A", "C", "T", y "G", las cuales representa cada base nitrogenada del ADN. Se considera que un ADN es de mutante si se detectan más de una secuencia de cuatro caracteres consecutivos en dirección vertical, horizontal o diagonal.

![image](https://github.com/user-attachments/assets/12ddcc6c-0965-48ae-97e3-ef7299a85c58)

Puedes realizar las pruebas mediante un enlace de render obteniéndolo [aquí](https://parcial-backend-api-mutantes-fernanda.onrender.com/).

La arquitectura actual utiliza un modelo cliente-servidor. El cliente interactúa con el servidor a través de endpoints, adjuntando un cuerpo a la solicitud cuando es necesario. Esta solución podría escalarse mediante el uso de Redis para almacenar en caché las solicitudes, lo que incrementaría la capacidad del servidor. Al almacenar en memoria los datos en un formato de clave-valor, Redis permite que las solicitudes recurrentes se sirvan rápidamente, mejorando así la velocidad de acceso.

## Ejecución del proyecto
1. Clonar el repositorio.
```sh
git clone https://github.com/FMSane/Parcial-BackEnd-API-Mutantes---Fernanda-Mu-oz---3k9.git
cd parcial-desarrollo-mercadolibre
```
2. Contruir el proyecto. Para armar el proyecto, instalar las dependencias requeridas:
```sh
./gradlew build
```
3. Correr el proyecto

## Endpoints 
### POST `/mutant`
Este endpoint recibe en el cuerpo de la petición un ADN y devuelve si es mutante o no. El formato de la petición debe seguir el siguiente esquema:

```json
{
    "dna": [
        "ATGCGA",
        "AATAAA",
        "TCATGT",
        "ATCAAT",
        "CCATCA",
        "TCTCTT"
    ]
}

```
Ejemplo de una petición que devuelve "true", lo que significa que el ADN corresponde al de un mutante:

```json
{
    "dna": [
        "ATGCGA",
        "ATGTCA",
        "TCTAGA",
        "ATCTAA",
        "CCATTA",
        "TCTCTT"
    ]
}
```

Las posibles respuestas se listan a continuación:
```json
//Es mutante - 200 OK
true
//No es mutante - 403 Forbidden
{
  "error":"Not a mutant"
}

//Formato inválido - 403 Forbidden
{
  "error":"invalid dna format"
}
```

### GET `/stats`
Este endpoint recopila las estadísticas de los análisis de ADN almacenados en la base de datos y calcula el cociente (ratio) de mutantes sobre humanos. Si la cantidad de humanos es 0, el ratio será igual a la cantidad de mutantes.

$$
ratio = \frac{cantMutantes}{cantHumanos}
$$
