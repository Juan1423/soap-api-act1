# SOAP-API-ACT1

Este proyecto implementa una API SOAP. Este `README.md` te guiará a través de los pasos necesarios para desplegar y probar la API localmente.

## Requisitos Previos

Antes de comenzar, asegúrate de tener instalados los siguientes componentes:

* **Java Development Kit (JDK) 17 o superior**: Necesario para compilar y ejecutar el proyecto Spring Boot.
* **Maven**: Para la gestión de dependencias y la construcción del proyecto.
* **PostgreSQL**: La base de datos relacional utilizada por la aplicación.
* **Postman (o similar)**: Una herramienta para probar APIs, realizando solicitudes SOAP.

## Despliegue del Proyecto

Sigue estos pasos para obtener el código y preparar la aplicación:

1.  **Clonar el repositorio:**
    Primero, clona este repositorio en tu máquina local:
    ```bash
    git clone [https://github.com/Juan1423/soap-api-act1.git](https://github.com/Juan1423/soap-api-act1.git)
    ```

2.  **Navegar al directorio del proyecto:**
    Una vez clonado, entra al directorio del proyecto:
    ```bash
    cd soap-api-act1
    ```

3.  **Construir el proyecto (opcional, pero recomendado):**
    En la raíz del proyecto, ejecuta el comando Maven para construir el proyecto y descargar las dependencias. Esto también verifica que todo esté en orden.
    ```bash
    mvn clean install
    ```

## Configuración de la Base de Datos

El proyecto utiliza una base de datos PostgreSQL. Sigue estos pasos para configurarla:

1.  **Tener PostgreSQL instalado y en ejecución.**
    * Si no lo tienes, puedes descargarlo e instalarlo desde el sitio oficial de [PostgreSQL](https://www.postgresql.org/download/).
    * Asegúrate de que el servicio de PostgreSQL esté activo.

2.  **Crear la base de datos `soap_api_act1`:**
    Abre una terminal o un cliente de base de datos (como `psql`, pgAdmin, DBeaver) y ejecuta el siguiente comando SQL:
    ```sql
    CREATE DATABASE soap_api_act1;
    ```

3.  **Cambiar la contraseña de la base de datos en el código:**
    Localiza el archivo `src/main/resources/application.properties` dentro de tu proyecto clonado.
    Dentro de este archivo, busca las líneas que definen las credenciales de la base de datos y actualízalas con la información de tu usuario de PostgreSQL:

    ```properties
    spring.application.name=soap-api-act1

    spring.datasource.url=jdbc:postgresql://localhost:5432/soap_api_act1
    spring.datasource.username=tu_usuario_postgres
    spring.datasource.password=tu_contraseña_de_postgres <--- Cambia esta línea

    ```
    Reemplaza `tu_usuario_postgres` y `tu_contraseña_de_postgres` con tus credenciales reales.

## Ejecución del Proyecto

Con la base de datos configurada y el código actualizado, puedes iniciar la aplicación:

1.  **Ejecutar el proyecto:**
    Puedes ejecutar la aplicación Spring Boot desde tu IDE (como IntelliJ IDEA o VS Code) o desde la línea de comandos.

    * **Desde un IDE:**
        Abre el proyecto en tu IDE preferido. Navega hasta el archivo principal de la aplicación: `src/main/java/com/example/soapapiact1/SoapApiAct1Application.java`.
        Haz clic derecho en este archivo y selecciona "Run 'SoapApiAct1Application.main()'" o una opción similar.

    * **Desde la línea de comandos:**
        En la raíz del proyecto (donde está el `pom.xml`), ejecuta:
        ```bash
        mvn spring-boot:run
        ```
        La API debería iniciarse en el puerto `8080` por defecto (o el puerto configurado en `application.properties`).

## Pruebas de la API con Postman

Una vez que la API está en ejecución, puedes usar Postman para enviar solicitudes SOAP y probarla.

1.  **Abrir Postman.**

2.  **Crear una nueva solicitud:**
    Haz clic en el botón `+` para crear una nueva pestaña de solicitud.

3.  **Configurar el método y la URL:**
    * Selecciona el método `POST`.
    * Ingresa la URL de tu servicio SOAP (reemplaza `tu-puerto` si no es 8080):
        ```
        http://localhost:8080/ # Ajusta la URL de tu servicio específico
        ```

4.  **Configurar el encabezado (Header):**
    Ve a la pestaña `Headers` y añade el siguiente encabezado:
    * **Key:** `Content-Type`
    * **Value:** `text/xml` (o `application/soap+xml` dependiendo de la versión SOAP que utilice tu servicio).

5.  **Configurar el cuerpo de la solicitud (Body):**
    Ve a la pestaña `Body`, selecciona la opción `raw` y elige `XML` en el desplegable.

    Aquí deberás pegar el XML de la solicitud SOAP que quieres enviar. En este caso, para la operacion `getPackageStatus`:
    Puedes usar este ejemplo para probar.

    ```xml
    <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:seg="http://miservicio.tracking">
        <soapenv:Header/>
        <soapenv:Body>
            <seg:GetTrackingStatusRequest>
                <seg:trackingNumber>CO1122334455</seg:trackingNumber>
            </seg:GetTrackingStatusRequest>
        </soapenv:Body>
    </soapenv:Envelope>
    ```

6.  **Enviar la solicitud:**
    Haz clic en el botón `Send`. Postman mostrará la respuesta de la API en la sección de respuesta.

---