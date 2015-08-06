# Introduction #

Describo los formatos de los ficheros usados para cargar los datos en el juego.


# Details #

## Formato del tablero ##

El fichero _boardcfg.txt_ se divide en dos partes:

En la primera se cargan las ciudades con el siguiente formato:

C,nombre de la ciudad (String),¿Es canada? (Booleano)

En la segunda, se cargan las vias del tren con el siguiente formato:

R,ciudad de origen (String),ciudad de destino (String)

## Formato de las Performances ##

El fichero es _performancecfg.txt_ y es como sigue:

El primer caracter de cada linea es el tipo de perfomance (D: demanda de actuación, B: Circo en bancarrota y V:Puntos de victoria)

### Formato para demanda de actuación ###

D,color (G,Y,R),dos semanas (boolean),numero rojo,acrobatas,caballos,payasos,felinos,elefantes,hombres bala,monstruos de feria

### Formato para puntos de victoria ###
V,color (G,Y,R),puntos de victoria

### Formato para circo en bancarrota ###
B,color (G,Y,R),talento 1,talento 2,talento 3 (si el tercero no existe, se deja vacío)