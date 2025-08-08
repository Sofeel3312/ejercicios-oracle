    //Desafíos 1
//alert('Bienvenida y bienvenido a nuestro sitio web');
//let nombre = 'Lua';
//let edad = 25;
//let numeroDeVentas = 50;
//let saldoDisponible = 1000;
//alert("¡Error! Completa todos los campos");
//let mensajeDeError = '¡Error! Completa todos los campos'; alert(mensajeDeError);
//let nombre = prompt('Digite su nombre');
//let edad = prompt('Digite su edad');
//if(edad >= 18) {alert('¡Puedes obtener tu licencia de conducir!');}

    //Desafíos 2
//Pregunta al usuario qué día de la semana es. Si la respuesta es "Sábado" o "Domingo", muestra "¡Buen fin de semana!". De lo contrario, muestra "¡Buena semana!".
/*let diasSemana = prompt('¿Qué día de la semana es?:');
if(diasSemana === 'sábado' || diasSemana === 'domingo') {
    alert('¡Buen fin de semana!');
} else {
    alert('¡Buena semana!');
}
*/

//Verifica si un número ingresado por el usuario es positivo o negativo. Muestra una alerta informativa.
/*/let numero = prompt('Digite un número:');
if(numero >0) {
    alert('El número es positivo');
} else if (numero <0) {
    alert('El número es negativo');
} else {    
    alert('El número es cero');
}
*/

//Crea un sistema de puntuación para un juego. Si la puntuación es mayor o igual a 100, muestra "¡Felicidades, has ganado!". En caso contrario, muestra "Intentalo nuevamente para ganar.".
/*let puntuacion = prompt('Digite un número:');
if(puntuacion >= 100) {
    alert('¡felicidades has ganado!');
} else {
    alert('Intentalo nuevamente para ganar');
}
    */
/*let puntuacion = 105;
if (puntuacion >= 100) {
    console.log('¡Enhorabuena, has ganado!');
} else {
    console.log('Inténtalo de nuevo para ganar.');
}
    */

//Crea un mensaje que informe al usuario sobre el saldo de su cuenta, utilizando un template string para incluir el valor del saldo.
/*let saldo = 100;
alert(`El saldo de su cuenta es: ${saldo}`);
*/

//Pide al usuario que ingrese su nombre mediante un prompt. Luego, muestra una alerta de bienvenida usando ese nombre.
/*let nombre = prompt('Digite su nombre:');
alert(`¡Bienvenida ${nombre}!`);
*/

    //Desafíos 3
//Crea un contador que comience en 1 y vaya hasta 10 usando un bucle 'while'. Muestra cada número.
/*let contador = 1;
while (contador <=10) {
    console.log(contador);
    contador++;
}
    */

//Crea un contador que comience en 10 y vaya hasta 0 usando un bucle 'while'. Muestra cada número.
/*let contador = 10;
while (contador >=0) {
    console.log(contador);
    contador--;
}
    */

//Crea un programa de cuenta regresiva. Pide un número y cuenta desde 0 hasta ese número utilizando un bucle 'while' en la consola del navegador.
/*let numeroSolicitado = prompt('Digite un número:');
while(numeroSolicitado >=0) {
    console.log(numeroSolicitado);
    numeroSolicitado--;
}
    */

//Crea un programa de cuenta progresiva. Pide un número y cuenta desde 0 hasta ese número utilizando un bucle 'while' en la consola del navegador.
/*let numeroSolicitado = prompt('Digite un número:');
let contador = 0;
while(contador <= numeroSolicitado) {
    console.log(contador);
    contador++;
}
    */

    //Desafíos 4
//Crea un programa que utilice console.log para mostrar un mensaje de bienvenida.
//console.log('¡Bienvenido!');

//Crea una variable llamada "nombre" y asígnale tu nombre. Luego, utiliza console.log para mostrar el mensaje "¡Hola, [tu nombre]!" en la consola del navegador.
/*let nombre = 'Fernanda';
console.log(`¡Hola, ${nombre}!`);
*/

//Crea una variable llamada "nombre" y asígnale tu nombre. Luego, utiliza alert para mostrar el mensaje "¡Hola, [tu nombre]!".
/*let nombre = 'Fernanda';
alert(`¡Hola, ${nombre}!`);
*/

//Utiliza prompt y haz la siguiente pregunta: ¿Cuál es el lenguaje de programación que más te gusta?. Luego, almacena la respuesta en una variable y muestra la respuesta en la consola del navegador.
/*let lenguaje = prompt('¿Cuál es el lenguaje de programación que más te gusta?');
console.log(lenguaje);
*/

//Crea una variable llamada "valor1" y otra llamada "valor2", asignándoles valores numéricos de tu elección. Luego, realiza la suma de estos dos valores y almacena el resultado en una tercera variable llamada "resultado". Utiliza console.log para mostrar el mensaje "La suma de [valor1] y [valor2] es igual a [resultado]." en la consola.
/*let valor1 = 8;
let valor2 = 2;
let resultado = valor1 + valor2;
console.log(`La suma de ${valor1} y ${valor2} es igual a ${resultado}`);
*/

//Crea una variable llamada "valor1" y otra llamada "valor2", asignándoles valores numéricos de tu elección. Luego, realiza la resta de estos dos valores y almacena el resultado en una tercera variable llamada "resultado". Utiliza console.log para mostrar el mensaje "La diferencia entre [valor1] y [valor2] es igual a [resultado]." en la consola.
/*let valor1 = 12;
let valor2 = 2;
let resultado = valor1 - valor2;
console.log(`La diferencia entre ${valor1} y ${valor2} es igual a ${resultado}`);
*/

//Pide al usuario que ingrese su edad con prompt. Con base en la edad ingresada, utiliza un if para verificar si la persona es mayor o menor de edad y muestra un mensaje apropiado en la consola.
/*let edad = prompt('Digite su edad:');
if(edad >=18) {
    alert('Es mayor de edad');
} else {
    alert('Es menor de edad');
}
*/

//Crea una variable "numero" y solicita un valor con prompt. Luego, verifica si es positivo, negativo o cero utilizando un if-else y muestra el mensaje correspondiente.
/*let numero = prompt('Digite un número');
if(numero >0) {
    alert('El número es positivo');
} else if (numero <0) {
    alert('El número es negativo');
} else {
    alert('El número es cero');
}
*/

//Utiliza un bucle while para mostrar los números del 1 al 10 en la consola.
/*let contador = 1;
while(contador <= 10);
    console.log(contador);
    contador++;
*/

//Crea una variable "nota" y asígnale un valor numérico. Utiliza un if-else para determinar si la nota es mayor o igual a 7 y muestra "Aprobado" o "Reprobado" en la consola.
/*let nota = 3;
if(nota >= 7){
    console.log('Aprobado');
} else {
    console.log('Reprobado');
}
    */

//Utiliza Math.random para generar cualquier número aleatorio y muestra ese número en la consola.
/*numeroAleatorio = Math.random();
console.log(numeroAleatorio);
*/

//Utiliza Math.random para generar un número entero entre 1 y 10 y muestra ese número en la consola.
/*numeroAleatorio = Math.floor((Math.random()*10)+1);
console.log(numeroAleatorio);
*/

//Utiliza Math.random para generar un número entero entre 1 y 1000 y muestra ese número en la consola.
/*numeroAleatorio = Math.floor((Math.random()*1000)+1);
console.log(numeroAleatorio);
*/

    //Desafíos 5
//Crear una función que muestre "¡Hola, mundo!" en la consola.
/*function mensaje(){
console.log ('¡Hola mundo!');
}
mensaje();
*/

//Crear una función que reciba un nombre como parámetro y muestre "¡Hola, [nombre]!" en la consola.
/*function mostrarNombre(nombre) {
    console.log(`¡Hola, ${nombre}!`);
}
mostrarNombre('Fernanda');
*/

//Crear una función que reciba un número como parámetro y devuelva el doble de ese número.
/*function calcularDoble(numero) {
    return numero * 2;
  }
  let resultadoDoble = calcularDoble(5);
  console.log(resultadoDoble);
  */

//Crear una función que reciba tres números como parámetros y devuelva su promedio.
  /*function calcularPromedio (a, b, c) {
    return (a + b + c) / 3;
  }
  let promedio = calcularPromedio(4,7,10);
  console.log(promedio);
  */

//Crear una función que reciba dos números como parámetros y devuelva el mayor de ellos.
  /*function numeroMayor(a, b) {
    return a > b ? a : b;
  }
  let mayor = numeroMayor(15,7);
  console.log(mayor);
  */

//Crear una función que reciba un número como parámetro y devuelva el resultado de multiplicar ese número por sí mismo.
  /*function numeroMultiplicado (numero) {
    return numero * numero;
  }
  let resultado = numeroMultiplicado(5);
  console.log(resultado);
  */

      //Desafíos 6
//Crea una función que calcule el índice de masa corporal (IMC) de una persona a partir de su altura en metros y peso en kilogramos, que se recibirán como parámetros.
/*function calcularIMC (altura, peso) {
let IMC = peso / (altura*altura);
return IMC; 
}
*/

//Crea una función que calcule el valor del factorial de un número pasado como parámetro.
/*
function calcularFactorial(numero) {
  if (numero === 0 || numero === 1) {
    return 1;
  } else {
    return numero * calcularFactorial(numero - 1);
  }
}
// Ejemplo de uso
let numero = 5;
let resultado = calcularFactorial(numero);
console.log(`El factorial de ${numero} es ${resultado}`);
*/

//Crea una función que convierta un valor en dólares, pasado como parámetro, y devuelva el valor equivalente en reales. Para esto, considere la cotización del dólar igual a R$4,80.
/*function convertirDolaresAReales(dolares) {
    var cotizacionDolar = 4.80;
    var reales = dolares * cotizacionDolar;
    return reales;
  }
  // Ejemplo de uso
  let valorEnDolar = 50;
  let valorEnReales = convertirDolaresAReales(valorEnDolar);
  console.log(`${valorEnDolar} dólares  es R$ ${valorEnReales}`);
  */

  //Crea una función que muestre en pantalla el área y el perímetro de una sala rectangular, utilizando la altura y la anchura que se proporcionarán como parámetros.
  /*function calcularAreaYPerimetroRectangular(altura, anchura) {
    var area = altura * anchura;
    var perimetro = 2 * (altura + anchura);
    console.log("Área: " + area);
    console.log("Perímetro: " + perimetro);
  }
  // Ejemplo de uso
  let altura = 3; // en metros
  let anchura = 5; // en metros
  calcularAreaYPerimetroRectangular(altura, anchura);
  */

  //Cree una función que muestre en pantalla el área y el perímetro de una sala circular, utilizando su radio que se proporcionará como parámetro. Considere Pi = 3,14.
  /*function calcularAreaYPerimetroCircular(radio) {
    var pi = 3.14;
    var area = pi * radio * radio;
    var perimetro = 2 * pi * radio;
    console.log("Área: " + area);
    console.log("Perímetro: " + perimetro);
  }
  // Ejemplo de uso
  let radio = 4; // en metros
  calcularAreaYPerimetroCircular(radio);
  */

  //Cree una función que muestre en pantalla la tabla de multiplicar de un número dado como parámetro.
  /*function mostrarTablaDeMultiplicar(numero) {
    for (var i = 1; i <= 10; i++) {
      var resultado = numero * i;
      console.log(numero + " x " + i + " = " + resultado);
    }
  }
  // Ejemplo de uso
  let numero = 7;
  mostrarTablaDeMultiplicar(numero);
  */

    //Desafíos 7
//Crea una lista vacía llamada "listaGenerica".
/*let listaGenerica = [];*/

//Crea una lista de lenguajes de programación llamada "lenguagesDeProgramacion con los siguientes elementos: 'JavaScript', 'C', 'C++', 'Kotlin' y 'Python'.
/*let lenguajesProgramacion = ['JavaScript', 'C', 'C++', 'Kotlin', 'Python'] ;
//Agrega a la lista "lenguagesDeProgramacion los siguientes elementos: 'Java', 'Ruby' y 'GoLang'.
lenguajesProgramacion.push('Java', 'Ruby', 'GoLang');
console.log(lenguajesProgramacion);
//Crea una función que muestre en la consola todos los elementos de la lista "lenguagesDeProgramacion.
function mostrarLenguajesSeparadamente() {
    for (let i = 0; i < lenguajesProgramacion.length; i++) {
      console.log(lenguajesProgramacion[i]);
    }
  }
  mostrarLenguajesSeparadamente();
//Crea una función que muestre en la consola todos los elementos de la lista "lenguagesDeProgramacion en orden inverso.
function mostrarLenguajesReversoSeparadamente() {
    for (let i = lenguajesProgramacion.length - 1; i >= 0; i--) {
      console.log(lenguajesProgramacion[i]);
    }
  }
  
  mostrarLenguajesReversoSeparadamente();
*/

//Crea una función que calcule la media de los elementos en una lista de números.
/*function calcularMedia(lista) {
    let suma = 0;
    for (let i = 0; i < lista.length; i++) {
      suma += lista[i];
    }
    return suma / lista.length;
  }
  
  let numeros = [10, 20, 30, 40, 50];
  let media = calcularMedia(numeros);
  console.log('Média:', media);
  */

//Crea una función que calcule el promedio de los elementos en una lista de números.
/*function encontrarMayorMenor(lista) {
    let mayor = lista[0];
    let menor = lista[0];  
    for (let i = 1; i < lista.length; i++) {
      if (lista[i] > mayor) {
        mayor = lista[i];
      }
      if (lista[i] < menor) {
        menor = lista[i];
      }
    }  
    console.log('Mayor:', mayor);
    console.log('Menor:', menor);
  }  
  let numeros = [15, 8, 25, 5, 12];
  encontrarMayorMenor(numeros);
*/

//Crea una función que retorne la suma de todos los elementos en una lista.
/*function calcularSuma(lista) {
    let suma = 0;
    for (let i = 0; i < lista.length; i++) {
      suma += lista[i];
    }
    return suma;
  }
  
  let numeros = [15, 8, 25, 5, 12];
  let suma = calcularSuma(numeros);
  console.log('Suma:', suma);
  */

  //Crea una función que reciba una lista como parámetro y retorne el índice de un elemento también pasado como parámetro. Si ese elemento no existe en la lista, retorna -1.
  /*function encontrarIndiceElemento(lista, elemento) {
    for (let i = 0; i < lista.length; i++) {
      if (lista[i] === elemento) {
        return i; // Retorna el índice del elemento encontrado
      }
    }
    return -1; // Retorna -1 si el elemento no se encuentra en la lista
  }
  */

//Crea una función que reciba dos listas de números del mismo tamaño y devuelva una nueva lista con la suma de los elementos uno a uno.
/*function sumarListas(lista1, lista2) {
    return lista1.map((num, index) => num + lista2[index]);
}

const lista1 = [1, 2, 3];
const lista2 = [4, 5, 6];
const resultado = sumarListas(lista1, lista2);
console.log(resultado);  
*/

//Crea una función que reciba una lista de números y devuelva una nueva lista con el cuadrado de cada número.
/*function cuadradoLista(lista) {
    return lista.map(num => num ** 2);
}

const lista = [2, 3, 4];
const resultado = cuadradoLista(lista);
console.log(resultado);  
*/



