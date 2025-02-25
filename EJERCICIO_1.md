Aquí tienes la versión actualizada del documento, incluyendo una sección detallada sobre cómo conectar Jira con GitHub para asegurar que la integración funcione correctamente:

---

# Ejercicio: Flujo Básico en Git – Preparación, Solución e Integración con Jira

Este ejercicio tiene como objetivo poner en práctica los conceptos básicos de Git, desde la clonación del repositorio hasta la resolución de conflictos, y demostrar la integración con Jira. Se explica cómo crear tareas en Jira, vincularlas mediante la nomenclatura en Git, y cómo conectar ambas herramientas para que los commits y acciones se registren en el ticket correspondiente.

---

## 1. Requisitos Previos

- **Instalación de Git:** Asegúrate de tener Git instalado en tu sistema.
- **Acceso a un Repositorio de Ejemplo que hayamos creado:** Usaremos un repositorio de GitHub creado por nosotros (por ejemplo, `https://github.com/usuario/proyecto-ejemplo.git`).
- **Acceso a Jira:** Cuenta activa en Jira para crear y gestionar tareas (por ejemplo, en el proyecto "PROJ").
- **Editor de Texto o IDE (IntelliJ):** Para editar archivos y visualizar los cambios.
- **Conexión a Internet:** Para clonar el repositorio, sincronizar los cambios y gestionar tickets en Jira.

---

## 2. Conexión de Jira con GitHub

Para que Jira registre de forma automática la actividad realizada en GitHub, se debe configurar la integración entre ambas herramientas. A continuación, se describe el proceso general:

### 2.1 Configuración de la Conexión (para Jira Cloud)

1. **Acceder a la Administración de Jira:**
    - En Jira Cloud, ve a la sección **"Settings" (Configuración)** y selecciona **"Applications" (Aplicaciones)**.

2. **Agregar una Cuenta DVCS:**
    - Dentro de la configuración de aplicaciones, busca la opción **"DVCS accounts"**.
    - Haz clic en **"Link GitHub account"** (o "Add account" si ya tienes alguna vinculada).

3. **Autorizar el Acceso:**
    - Ingresa tus credenciales de GitHub y otorga permisos para que Jira pueda acceder a los repositorios.
    - Selecciona los repositorios que deseas vincular. Asegúrate de incluir el repositorio de ejemplo que se usará en el ejercicio.

4. **Verificar la Integración:**
    - Una vez completado el proceso, Jira comenzará a recibir información de los commits y pull requests que incluyan identificadores de tareas (por ejemplo, `PROJ-101`).

### 2.2 Beneficios de la Integración

- **Vinculación Automática:**  
  Cada commit o pull request que incluya el identificador del ticket (por ejemplo, `PROJ-101`) se asociará automáticamente con la tarea en Jira.

- **Actualización de Estados:**  
  Algunas configuraciones avanzadas permiten que, al cerrar un pull request o fusionar una rama, el ticket en Jira se actualice automáticamente (por ejemplo, pasando a "En revisión" o "Listo para testeo").

- **Trazabilidad y Reportes:**  
  La integración mejora la visibilidad del flujo de trabajo, permitiendo que se vea el historial completo de cambios y que se generen reportes de actividad directamente en Jira.

---

## 3. Preparación del Entorno

### 3.1 Clonado del Repositorio

1. Abre la terminal y clona el repositorio de ejemplo:

   ```bash
   git clone https://github.com/usuario/proyecto-ejemplo.git
   cd proyecto-ejemplo
   ```

### 3.2 Creación de la Tarea en Jira y Vinculación

1. **Accede a Jira:** Ingresa al panel de tu proyecto (por ejemplo, "PROJ").
2. **Crea una Nueva Tarea:**
    - Selecciona **"Crear"** y elige el tipo de incidencia (por ejemplo, "Historia de Usuario" o "Tarea").
    - Completa los campos relevantes:
        - **Título:** Implementar funcionalidad de ejemplo en Git.
        - **Descripción:** Ejercicio para practicar el flujo básico en Git, incluyendo la creación de ramas, commits incrementales y resolución de conflictos.
    - Guarda la tarea y toma nota del identificador asignado (por ejemplo, `PROJ-101`).

3. **Vinculación en Git:**  
   Utiliza el identificador `PROJ-101` en el nombre de la rama y en los mensajes de commit para que la integración se realice correctamente.

---

## 4. Desarrollo en Git

### 4.1 Creación de una Rama de Funcionalidad

Crea una nueva rama a partir de la tarea en Jira:
```bash
  git checkout -b feature/PROJ-101-agregar-funcionalidad
```

### 4.2 Realización de Commits Incrementales

Modifica un archivo (por ejemplo, `app.txt`) y realiza commits pequeños para simular el desarrollo incremental:

1. **Agregar la Primera Línea:**
    - Edita `app.txt` y añade:
      ```
      Línea 1: Funcionalidad inicial.
      ```
    - Guarda el archivo, añade los cambios y realiza el commit:
      ```bash
      git add app.txt
      git commit -m "PROJ-101: Agrega Línea 1 en app.txt"
      ```

2. **Agregar una Segunda Línea:**
    - Edita `app.txt` para agregar:
      ```
      Línea 2: Continuación de la funcionalidad.
      ```
    - Confirma los cambios:
      ```bash
      git add app.txt
      git commit -m "PROJ-101: Agrega Línea 2 en app.txt"
      ```

Repite estos pasos según sea necesario para simular el desarrollo incremental vinculado a la tarea `PROJ-101`.

---

## 5. Simulación y Resolución de un Conflicto

Para simular un conflicto, se introducirán cambios en el mismo archivo en la rama principal.

### 5.1 Simulación del Conflicto

#### Paso 1: Modificar el Archivo en la Rama Principal

1. Cambia a la rama `main`:
   ```bash
   git checkout main
   ```
2. Edita el archivo `app.txt` y añade una línea que modifique la misma sección:
   ```
   Cambio en main: Modificación para simular conflicto.
   ```
3. Confirma los cambios:
   ```bash
   git add app.txt
   git commit -m "PROJ-101: Modifica app.txt en main para simular conflicto"
   ```

#### Paso 2: Fusionar la Rama Principal en la Rama de Funcionalidad

1. Vuelve a la rama de funcionalidad:
   ```bash
   git checkout feature/PROJ-101-agregar-funcionalidad
   ```
2. Fusiona la rama `main` en la de funcionalidad:
   ```bash
   git merge main
   ```
   Git detectará conflictos en `app.txt` y los marcará para su resolución.

### 5.2 Resolución del Conflicto

#### Paso 1: Identificar el Conflicto

Abre `app.txt` en tu editor. Deberías ver algo similar a:
```plaintext
<<<<<<< HEAD
Línea 1: Funcionalidad inicial.
Línea 2: Continuación de la funcionalidad.
=======
Cambio en main: Modificación para simular conflicto.
>>>>>>> main
```

#### Paso 2: Editar y Resolver el Conflicto

Decide cómo combinar los cambios. Por ejemplo, podrías mantener ambos cambios:
```plaintext
Línea 1: Funcionalidad inicial.
Línea 2: Continuación de la funcionalidad.
Cambio en main: Modificación para simular conflicto.
```
Elimina las marcas de conflicto (`<<<<<<<`, `=======`, `>>>>>>>`) y guarda el archivo.

#### Paso 3: Confirmar la Resolución

Añade el archivo resuelto y confirma la fusión:
```bash
git add app.txt
git commit -m "PROJ-101: Resuelve conflicto en app.txt tras merge de main"
```

---

## 6. Verificación de la Integración con Jira

Una vez completados los pasos anteriores, verifica lo siguiente:

- **Identificador en Nombres y Commits:**  
  Los nombres de las ramas y los mensajes de commit deben incluir el identificador `PROJ-101`.

- **Actualización Automática en Jira:**  
  Revisa que el ticket `PROJ-101` se actualice con la actividad correspondiente (commits, merges, cambios de estado), lo que confirmará la integración entre Jira y GitHub.

- **Historial del Ticket en Jira:**  
  Comprueba en el ticket que se registre todo el historial de cambios, lo que garantiza la trazabilidad de la tarea.

---

## 7. Conclusión

En este ejercicio se han practicado y verificado los siguientes conceptos:

- **Clonación del repositorio y preparación del entorno:** Configuración inicial y conexión con el repositorio.
- **Creación y vinculación de tareas en Jira:** Uso del identificador `PROJ-101` para asegurar la integración con GitHub.
- **Desarrollo en Git:** Creación de ramas de funcionalidad y realización de commits incrementales siguiendo buenas prácticas.
- **Simulación y resolución de conflictos:** Fusión de cambios y resolución manual de conflictos.
- **Verificación de la integración:** Confirmación de que la actividad en Git se refleja automáticamente en Jira.

Esta guía refuerza las buenas prácticas definidas para el curso, asegurando un flujo de trabajo coordinado y la integración efectiva entre Jira y GitHub.

---

¿Te parece que esta versión reestructurada, con las indicaciones para conectar Jira con GitHub, cumple con tus expectativas o deseas realizar algún ajuste adicional?