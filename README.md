# Gestion\_FormatosA-Arquitectura\_Hexagonal\_JPA

Este repositorio contiene una implementación de la Arquitectura Hexagonal (Ports & Adapters) para la gestión de **Formatos A** en un entorno académico, utilizando JPA, Spring Boot y el patrón Estado.

## 🚀 Características

* **Arquitectura Hexagonal**: Separación clara entre dominio, aplicación e infraestructura.
* **JPA / Hibernate**: Mapeo de entidades con relaciones (`@OneToOne`, `@OneToMany`, `@ManyToOne`).
* **Patrón Estado**: Control de estados de Formato A (p.ej. "En formulación", "Corregido").
* **DTOs y Mappers**: Objetos de transferencia para capa REST, mapeo con MapStruct.
* **Validaciones Automáticas**:

  * Anotaciones estándar (`@NotNull`, `@Size`, `@Email`, `@Pattern`, `@Min`).
  * Anotación personalizada para que los objetivos inicien con un verbo en infinitivo.
  * Mensajes en español en `ValidationMessages_es.properties`.
* **Consultas Avanzadas**:

  * Keywords dinámicas (`ignoreCase`, orden ascendente).
  * JPQL para joins y filtros por fecha.
  * SQL nativo para verificar existencia y recuperar última evaluación.
* **Servicios REST**:

  * Endpoints para Formato A y Observación.
  * Listar Observaciones, miembros de comité, formatos por docente.
  * Transacciones con `@Transactional(readOnly=true)` para consultas.
* **Manejo de Errores**:

  * Controlador global de excepciones con códigos HTTP personalizados.

## 📁 Estructura del Proyecto

```
src/main/java/co/edu/unicauca/taller_final_back/
├── aplicacion
│   ├── input        # Interfaces (Ports) para casos de uso
│   └── output       # Interfaces de acceso a datos (Gateways)
├── dominio
│   ├── enums        # Enumeraciones de negocio
│   ├── models       # Entidades: FormatoA, Docente, Estado, Observación
│   ├── states       # Implementación del Patrón Estado
│   └── usecases     # Lógica de casos de uso (Adapters)
├── infraestructura
│   ├── configuration # Configuración de Spring y Beans
│   ├── input        # Controladores REST, DTOs y Mappers
│   └── output       # Repositorios JPA y adaptadores de infraestructura
└── resources
    ├── application.properties
    ├── application-dev.properties
    ├── import.sql               # Datos iniciales
    └── ValidationMessages_es.properties # Mensajes de validación
```

## 🛠️ Instalación y Uso

### Endpoints Disponibles

#### 📄 Docente

* **Listar Comité**: Obtiene todos los docentes que pertenecen al comité.

  * `GET /api/docente/listar/comite`
* **Listar por Grupo y Patrón**: Obtiene docentes filtrados por grupo y patrón.

  * `GET /api/docente/listar/grupo?grupo={grupo}&patron={patron}`

#### 📝 Estado de Formato A

* **Enviar para Evaluación**: Cambia el estado a "En evaluación".

  * `POST /api/estado/formato_a/enviar_para_evaluacion/{idFormatoA}`
* **Aprobar Formato**: Cambia el estado a "Aprobado".

  * `POST /api/estado/formato_a/aprobar/{idFormatoA}`
* **Rechazar Formato**: Cambia el estado a "Rechazado".

  * `POST /api/estado/formato_a/rechazar/{idFormatoA}`

#### 🗃️ Formato A

* **Crear Formato A**: Registra un nuevo formato asociado a un docente.

  * `POST /api/formato_a/docente/{idDocente}`
* **Listar Formatos de un Docente**: Devuelve todos los formatos creados por un docente.

  * `GET /api/formato_a/docente?correoDocente={correo}`
* **Listar Formatos en Rango de Fechas**: Obtiene formatos creados en un rango dado.

  * `GET /api/formato_a/docente/{idDocente}/rango` (requiere rango de fechas en el cuerpo)

#### 🗒️ Observaciones

* **Crear Observación**: Registra una nueva observación en un formato específico.

  * `POST /api/observacion/formato_a/{idFormatoA}?idsDocentes={ids}`
* **Listar Observaciones por Formato**: Obtiene todas las observaciones de un formato.

  * `GET /api/observacion/formato_a/{idFormatoA}`

1. **Clona el repositorio**

   ```bash
   git clone https://github.com/contrerasdaniel142/Gestion_FormatosA-Arquitectura_Hexagonal_JPA.git
   cd Gestion_FormatosA-Arquitectura_Hexagonal_JPA
   ```

2. **Configura la base de datos**

   * Crea una base de datos (MySQL) llamada `bdFormatos`.
   * Ajusta las credenciales y la URL en `src/main/resources/application-dev.properties`:

     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/bdFormatos
     spring.datasource.username=<tu_usuario>
     spring.datasource.password=<tu_contraseña>
     ```

3. **Define el puerto del servidor** (opcional):
   Por defecto, la aplicación usa el puerto `9090`. Para cambiarlo, edita:

   ```properties
   server.port=9090
   ```

4. **Ejecuta la aplicación**
   Con Maven:

   ```bash
   mvn clean spring-boot:run
   ```

5. **Prueba los endpoints**

   * Base: `http://localhost:9090/api`
   * Ejemplos:

     * `GET /formatosA` → Listar formatos
     * `POST /formatosA` → Crear formato
     * `GET /formatosA/{id}/observaciones` → Observaciones de un formato

## 🤝 Contribuciones

¡Las contribuciones son bienvenidas! Abre un *issue* o envía un *pull request* para sugerir mejoras o reportar errores.

## 📄 Licencia

Este proyecto está bajo la licencia MIT. Consulta el archivo [LICENSE](LICENSE) para más detalles.
