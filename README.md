# **CHALLENGE CPIM**

---

## **Desarrollo de:**

- Hector A. Modinger S.
- [hectormodinger@gmail.com](mailto:hectormodinger@gmail.com)

---

# **API RESTful para Registro de Usuarios**

Este proyecto es una aplicación desarrollada con **Spring Boot** que expone un endpoint para el registro de usuarios. La API valida el formato de los datos de entrada y persiste la información en una base de datos en memoria (**H2**).

## **Requisitos Previos**

Antes de ejecutar el proyecto, asegúrate de tener instalados los siguientes componentes:

- **Java 8** o superior.
- **Maven 3.6** o superior.
- Cliente HTTP como **Postman** o **cURL** (para pruebas).

---

## **Instrucciones para la Ejecución**

### **1. Clonar el repositorio**
Clona el repositorio en tu máquina local:
```bash
git clone <URL_DEL_REPOSITORIO>
cd <NOMBRE_DEL_PROYECTO>
```

### **2. Compilar el proyecto**
Navega al directorio del proyecto y ejecuta el siguiente comando para compilarlo:
```bash
mvn clean install
```

### **3. Ejecutar la aplicación**
Ejecuta la aplicación con el siguiente comando:
```bash
mvn spring-boot:run
```

Por defecto, la API estará disponible en:  
[http://localhost:8080](http://localhost:8080)

---

## **Uso del Endpoint**

### **Endpoint de Registro**
**URL:** `/api/users`  
**Método:** `POST`  
**Content-Type:** `application/json`

#### **JSON de ejemplo:**
```json
{
  "name": "Juan Rodriguez",
  "email": "juan@rodriguez.org",
  "password": "Password1",
  "phones": [
    {
      "number": "1234567",
      "citycode": "1",
      "contrycode": "57"
    }
  ]
}
```

#### **Respuesta de éxito (HTTP 201):**
```json
{
  "id": "34e5f582-8d4e-4b77-a857-1f4e87958baf",
  "name": "Juan Rodriguez",
  "email": "juan@rodriguez.org",
  "password": "Password1",
  "phones": [
    {
      "number": "1234567",
      "citycode": "1",
      "contrycode": "57"
    }
  ],
  "created": "2024-11-19T14:00:00",
  "modified": "2024-11-19T14:00:00",
  "lastLogin": "2024-11-19T14:00:00",
  "token": "97bca2f2-6c72-4e93-8748-345d6bf9e52e",
  "isActive": true
}
```

#### **Errores de Validación (HTTP 400):**
```json
{
  "mensaje": {
    "name": "El nombre es obligatorio",
    "email": "El formato del correo no es válido",
    "password": "La contraseña debe tener al menos 8 caracteres, incluir una letra mayúscula y un número",
    "phones": "Debe incluir al menos un teléfono"
  }
}
```

---

## **Base de Datos en Memoria (H2)**

La base de datos está configurada para ejecutarse en memoria (**H2**).  
Puedes acceder a la consola de H2 para inspeccionar los datos:

**URL:** [http://localhost:8080/h2-console](http://localhost:8080/h2-console)  
**Credenciales de conexión:**
- **JDBC URL:** `jdbc:h2:mem:testdb`
- **Usuario:** `sa`
- **Contraseña:** `password`

---

## **Pruebas Unitarias**

Ejecuta las pruebas unitarias con el siguiente comando:
```bash
mvn test
```

---

## **Documentación Swagger**

La API está documentada automáticamente con Swagger. Puedes acceder a la interfaz en:
[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## **Diagrama de Solución**

A continuación, un diagrama de alto nivel que representa la arquitectura de la solución:

```plaintext
Cliente HTTP (Postman/cURL/Frontend)
           |
           v
   Spring Boot Controller
           |
           v
     Servicio de Usuario
           |
           v
      Repositorio JPA
           |
           v
   Base de Datos en Memoria (H2)
```

---