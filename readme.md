# Guess The Number Game

## Índice

* [1. Definición del Producto](#1-definicion-del-producto)
* [2. Funcionalidades y estructura de la página](#2-funcionalidades)
* [3. Tecnologías usadas](#3-historias-de-usuario)
* [4. Tests desarrollados](#5-tests)

***

## 1. 🎮  Definición del Producto 🎮

**Guess The Number Game** es un juego interactivo que se debe ejecutar en la consola del ordenador 🖥️. Consiste en que dos jugadores (un humano y una computadora) intenten adivinar un número random entre 0 y 100
El juego permite que el jugador humano inserte su nombre, así como el primer intento, ese número y su nombre serán reflejados en la consola. Posteriormente, se comparará ese intento con el número generado por la computadora, y si no es correcto, será ahora el turno de la computadora. 
La partida continuará hasta que alguno de los jugadores acerte al número generado, una vez que acerte la consola mandará un mensaje revelando el número correcto, así como el historial de intentos que el jugador ganador tuvo
Posterior a eso, preguntará si se gusta jugar otra partida, si la respuesta es sí, borrará el historial de intentos, generará un nuevo targetNumber.

## 2. 🔧 Funcionalidades y Estructura:
La página sigue el paradigma de OOP y la estructura de clases propias de Java. Cada una de las clases a su vez tienen sus propios métodos que se reparten las funcionalidades del juego
### 🕹️ **GuessTheNumberGame** 🕹️
Encargada de la mayor parte de la funcionalidad del juego. Tiene los atributos __Random__, __Scanner__ y __targetNumber__
Asimismo, tiene distintos métodos, el primero es el método __Main__ el cual se encarga de la distribución de los turnos de cada jugador, y da la orden de que si el jugador no adivina el número, se dé el paso al siguiente
Por su parte el método __checkGuess__ se encarga de comparar el número ingresado por la computadora y el jugador humano con el targetNumber generado al inicio. Asimismo, da un feedback a cada jugador, indicando si el número ingresado es menor o mayor al targetNumber
Por último el método __playAgain__ tiene como principal función preguntar si se quiere generar ua nueva partida, si la respuesta es sí, genera un nuevo targetNumber y llama a los métodos .reset de cada jugador para limpiar el historial de intentos.
### **Player**
Clase abstracta, por lo que no cuenta con objetos, tiene los métodos setName, así como getName y getGuesses. Tiene el método abstracto makeGuess, el cual será detallado en las subclasses HumanPlayer y CompueterPlayer
### **HumanPlayer**
subclase de Player que hereda sus métodos, cuenta con un constructor que toma como parámetro el userName y el scanner (el cual será el imput que el usuario ponga al realizar su intento). La subclase igualmente cuenta con el método makeGuess, encargado de pedir el intento al usuario, leer el input y guardarlo en un array
### **ComputerPlayer** 👾
subclase de Player que hereda sus métodos, cuenta con un constructor sin parámetros y un método makeGuess que genera un número random para el intento de la computadora y lo añade al historial de intentos.

## 3. Tecnologías usadas:
El proyecto se desarrolló mediante Java ☕
- Se usó IntelliJ para la escritura del código y para correrlo
- Se usaron las librerias de mockito y JUnit 🍸
- Se usó GitHub para almacenar el repositorio y se creó GitHub projects e Issues para la organización del proyecto en dos sprints
- Se usó GitBash como principal terminal para los commits.

## 4. Tests Desarrollados: 🕵️
Mediante el ambiente de trabajo IntelliJ y la libreria de Mockito se crearon distintos tests, teniendo en cuenta el nivel de criticidad de cada uno de los métodos.
- __ComputerPlayer__: Se comprobó que el número lanzado por la computadora sea entre 0 y 100.
- __GuessTheNumberGame__: Se realizaron distintos mocks para comprender si los métodos llamados eran los correctos, y si los mensajes en la consola estaban siendo leídos y arrojados de manera correcta cada que los jugadores fallaban o adivinaban


Coded by Alhelí De Vicente García❤️