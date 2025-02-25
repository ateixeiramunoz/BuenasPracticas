## Modelo Estándar: Estrategia de Branching y Releases Semanales 

A continuación, se presenta el modelo de buenas prácticas que se adoptará de manera obligatoria en los proyectos del curso. Este modelo integra convenciones de nomenclatura, un flujo de trabajo estructurado basado en releases semanales y la integración con Jira y GitHub, asegurando la trazabilidad y la calidad en el desarrollo. Se fundamenta en un modelo de integración continua, con la incorporación futura de funcionalidades DevOps.


### 1. Estructura de Ramas

#### **Ramas Principales**

- **`main`**
    - Contiene el código estable que está en producción.
    - Cada fusión a esta rama debe estar validada y probada.

- **`develop`**
    - Rama de integración continua donde se fusionan todas las nuevas funcionalidades y correcciones durante la semana.
    - Es la base para la creación de la release semanal.

#### **Ramas de Trabajo**

- **Ramas de Funcionalidad:**
    - **Nomenclatura:** `feature/PROJ-<ID>-<descripcion>`
    - **Ejemplo:** `feature/PROJ-101-login`
    - **Uso:** Desarrollo de nuevas funcionalidades. Los commits deben incluir el identificador de Jira para vinculación automática.

- **Ramas de Corrección:**
    - **Nomenclatura:** `bugfix/PROJ-<ID>-<descripcion>`
    - **Ejemplo:** `bugfix/PROJ-102-arreglo-error`
    - **Uso:** Corrección de errores detectados en fases de prueba o en producción.

- **Ramas de Release:**
    - **Nomenclatura:** `release/v<MAJOR>.<MINOR>.<PATCH>`
    - **Ejemplo:** `release/v1.1.0`
    - **Uso:** Cada semana, se crea una rama de release desde `develop` para preparar la versión final. En ella se realizan pruebas finales, ajustes y correcciones puntuales antes de la fusión a `main`.

- **Ramas de Hotfix:**
    - **Nomenclatura:** `hotfix/PROJ-<ID>-<descripcion>`
    - **Ejemplo:** `hotfix/PROJ-105-crash-landing`
    - **Uso:** Correcciones críticas en producción. Una vez validadas, se fusionan tanto en `main` como en `develop` para mantener la coherencia.

---

### 2. Proceso de Releases Semanales

#### **a. Flujo de Trabajo Durante la Semana**

1. **Desarrollo Continuo en `develop`:**
    - Los equipos trabajan en sus respectivas ramas de `feature` y `bugfix`.
    - Se realizan pull requests (PR) que deben ser revisados y aprobados antes de fusionar en `develop`.
    - Todos los commits deben incluir el identificador del ticket de Jira (por ejemplo, `PROJ-101`) para asegurar la trazabilidad.

2. **Actualización y Seguimiento en Jira:**
    - Cada tarea en Jira se asocia a la rama correspondiente y se actualiza automáticamente con los commits y PR.
    - Se utilizan tableros de Jira para visualizar el estado de cada ticket (Por hacer, En curso, En revisión, Completado).

#### **b. Día de Release (por ejemplo, Viernes)**

1. **Creación de la Rama de Release:**
    - Se crea una rama de release desde `develop` con la nomenclatura `release/v<MAJOR>.<MINOR>.<PATCH>`.
    - La versión se determina de acuerdo a las reglas de versionado:
        - **PATCH:** Si solo se han corregido errores o ajustes menores (ej. de v1.0.1 a v1.0.2).
        - **MINOR:** Si se han añadido nuevas funcionalidades compatibles (ej. de v1.0.1 a v1.1.0).
        - **MAJOR:** Si se han introducido cambios incompatibles (como suele pasar - por ejemplo - cuando modificamos el modelo de datos).

2. **Validación y Ajustes en la Rama de Release:**
    - Se ejecutan pruebas finales (manuales y automatizadas) para detectar errores o inconsistencias.
    - Se realizan correcciones puntuales en la misma rama de release.
    - Se genera un **changelog** que documenta todas las novedades, mejoras y correcciones incluidas en la versión.

3. **Fusión a `main` y Etiquetado:**
    - Una vez validada la rama de release, se fusiona en `main`.
    - Se crea un **tag** en Git que marca la versión oficial (por ejemplo, `v1.1.0`).
    - La release se publica en GitHub (utilizando la sección de Releases), lo que facilita la visibilidad y el seguimiento del cambio.

4. **Sincronización de Correcciones:**
    - Cualquier cambio realizado en la rama de release debe ser fusionado nuevamente en `develop` para mantener la coherencia de la línea de desarrollo.

#### **c. Automatización e Integración**

- **Integración con Jira:**
    - Las transiciones de estado se automatizan: por ejemplo, al fusionar un PR relacionado, el ticket correspondiente puede pasar a “En revisión” o “Listo para testeo”.
    - Los reportes semanales en Jira incluirán información de la release y el historial de cambios.

- **Integración Continua (CI/CD):**
    - Configurar pipelines que ejecuten pruebas automáticas en cada PR y antes de la fusión en la rama de release.
    - Automatizar el etiquetado y despliegue de la versión en función de la rama de release.

---

### 3. Beneficios del Modelo

- **Trazabilidad Total:**  
  Cada cambio en el código se asocia a un ticket de Jira, permitiendo un seguimiento detallado desde la idea hasta la producción.

- **Ciclos de Release Predecibles:**  
  El modelo de releases semanales obliga a un ritmo constante de entrega, fomentando la estabilidad y la calidad en cada iteración.

- **Integración Fluida entre Desarrollo y Gestión:**  
  La coordinación entre Jira y GitHub permite que la planificación, el desarrollo y la entrega se sincronicen perfectamente, facilitando la revisión y el control de calidad.

- **Automatización y Eficiencia:**  
  La futura integración con pipelines CI/CD y la automatización en Jira reducen el trabajo manual y aceleran la entrega de software estable y probado.

---
