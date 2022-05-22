# Preparar el entorno
  1. Descargar eclipseIDE (nosotros seguimos el sgte tutorual) : https://www.solvetic.com/tutoriales/article/8578-como-instalar-eclipse-ide-windows-10/
  2. una vez se tenga listo el IDE se puede pasar al sgte paso
# Importar el proyecto en el IDE
  1. Podemos descargar o clonar el repositorio
  2. Una vez abierto el IDE eclipse
  3. Ir a File->Import :
    ![image](https://user-images.githubusercontent.com/56198487/169717640-4a2dc82e-fc1d-4df1-8b16-be6569b2c69a.png)
  4. Seleccionar General>Existing Proyects into Workspace y hacer click en Next : 
    ![image](https://user-images.githubusercontent.com/56198487/169717708-f460e490-eded-477f-bbf3-6ff0c0a1c8e5.png)
  5. Seleccionar el proyecto dando click en Browse y hacer click en Finish: 
    ![image](https://user-images.githubusercontent.com/56198487/169717821-2bdb00c8-46c6-46dd-ba11-0dea704d92ee.png)
  6. El proyecto se abra cargado con exito.
# Configurar Java Build Path
  1. Descargar el archivo sqlite-jdbc-3.30.1.jar de la carpeta principal del proyecto
  2. En el proyecto cargado en eclipse click derecho en proyecto arquitectura->Build Path->Configure Build Path:
    ![image](https://user-images.githubusercontent.com/56198487/169718064-4b6bce5d-7a4d-4c69-9238-2da75eb20967.png)
  3. Selecciona la vista libraries en esa ventana:
    ![image](https://user-images.githubusercontent.com/56198487/169718187-efe28230-66ea-4f24-b106-ffadd64f870c.png)
  4. Seleccionar la oopcion sqlite-jdbc y hacer click en la opcion edit de la lista de opciones a la derecha 
    ![image](https://user-images.githubusercontent.com/56198487/169718272-843b5b6c-9adb-4279-807d-d0126b4d1c3b.png)
  5. Seleccionar el archivo descargado en el paso 1
  6. Hacer click en Apply and close
  7. El proyecto esta listo para ejecutar las pruebas
# Ejecucion de pruebas
  1. Click derecho en Proyecto arquitectura-> Coveraje As-> JUnit Test:
    ![image](https://user-images.githubusercontent.com/56198487/169718430-c3e773bd-9b9b-4fcd-82de-5518da0c71d7.png)

  
