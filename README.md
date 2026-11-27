# GymApp

GymApp es un proyecto de que gestiona usarios de tipo aprediz, entrenador y datos asociados a los entrenamientos.
Este es una aplicación de solo Spring Framework construida con el gestor de dependencias Maven.

## Tecnologías Usadas

| **Nombre de Tecnologias** | **Version** |
|-------------|---------|
|OpenJDK | 25.0.5.1 |
|Apache Maven|  3.8.7|
|spring-context| 7.0.11|
| JUnit| 5.11.0 |

## Pasos para correr el proyecto

Para poder correr el proyecto es necesario tener lo siguiente instalado

1. Instalar la version del java OpenJDK  25.0.5.1
2. Instalar la versión de Maven 3.8.7

Una vez tenga lo anterior instalado debe de ejecutar los siguientes comandos 
dentro de la carpeta del proyecto:


1. Este comando instala las dependencias del proyecto

```console
user:~$/GymApp mvn install
```
2. El siguiente comando se encarga de ejecutar el proyecto

```console
user:~$/GymApp mvn compile exec:java
```
