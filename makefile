# En JFLAGS pondremos las flags con las que queremos ejecutar el codigo, aqui algunos ejemplos
# -g -> Compila con informacion de debugging, puede ser util si utilizan un debugger
# -Xlint:all -> Muestra los warnings al compilar, recomiendo utilizarlo, si su codigo genera warnings posiblemente se traduzca en errores de ejecucion a largo plazo. Similar a -Wall en C
JFLAGS = -g -Xlint:all

# Indicar el compilador de java a utilizar
JC = javac

# Indicar la maquina virtual para ejecutar codigos de java
JVM = java

# Nombre de la clase que contiene la funcion main
MAIN = JavaQuest

# En JAVAS se indican los archivos .java, en este caso se estan indicando:
# $(wildcard estructuras/*.java) -> todos los archivos .java dentro del directorio estructuras/
# $(wildcard *.java) -> todos los archivos .java que no estan en un directorio
#
# Se debe cambiar los contenidos de esta linea para que se adapten a la estructura de su proyecto
JAVAS := $(wildcard GraphGenerator/*.java) $(wildcard *.java)

# CLASSES son los nombres de los archivos ya compilados, corresponde a los JAVAS pero remplazando el .java por .class
CLASSES := $(JAVAS:.java=.class)

# Indica que al ejecutar el comando make o make all se quieren compilar todos los .java
all: $(CLASSES)

# Permite que se pueda ejecutar:
# make all
# make clean
# make run
.PHONY: all clean run

# Compila un archivo .java para generar su correspondiente .class, utilizando el JC y JFLAGS definidos anteriormente
%.class: %.java
	$(JC) $(JFLAGS) $^

# Ejecuta el main. Si las clases no se encuentran compiladas, entonces las compila.
run: $(CLASSES)
	$(JVM) $(MAIN)

# Elimina todos los archivos compilados
clean:
	rm -rf $(CLASSES)