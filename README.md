# 📘 **Plataforma Digital Educativa** – Gestión Académica 🚀

**Proyecto del Grupo 5**  
![Java](https://img.shields.io/badge/Java-17%2B-blue?style=flat&logo=java) ![Swing](https://img.shields.io/badge/Swing-GUI-orange?style=flat&logo=swing)

## 📌 **Descripción**
La **Plataforma Digital Educativa** es un sistema completo desarrollado en **Java** con **Swing** para gestionar estudiantes, docentes, asignaturas, matrículas y notas en un instituto educativo.  

Este proyecto fue desarrollado como trabajo académico del **Grupo 5**. Ofrece una interfaz gráfica intuitiva, moderna y responsive. Automatiza procesos manuales, mejorando la organización académica.

## 🎯 **Funcionalidades Principales**
| Categoría | Descripción |
|-----------|-------------|
| 👤 **Estudiantes** | Registrar, códigos únicos, carrera |
| 👨‍🏫 **Docentes** | Registrar, departamento, email |
| 📚 **Asignaturas** | Créditos, asignar docente |
| 📝 **Matrículas** | Matricular sin duplicados |
| ✏️ **Notas** | Tipos (Parcial/Final), promedio simple, estado (APROBADO ≥11) |
| 📊 **Reportes** | Detallado por estudiante con promedios |

## 🎨 **Interfaz Gráfica (Swing)**
- **Menú lateral** con botones estilizados (azules).
- **Logs interactivos** en área de texto.
- **Diálogos** intuitivos para inputs.

## 🛠️ **Tecnologías**
| Tecnología | Uso |
|------------|-----|
| [Java SE 17+](https://openjdk.org/) | Lógica del sistema |
| [Swing](https://docs.oracle.com/javase/tutorial/uiswing/) | UI Gráfica |
| [VS Code](https://code.visualstudio.com/) | IDE |

## 📦 **Estructura del Proyecto**
```
PlataformaNotasApp.java     ← Main
VentanaPrincipal.java       ← UI Principal
GestorAcademico.java        ← Controlador Central
└── Modelos:
    ├── Usuario.java
    ├── Estudiante.java
    ├── Docente.java
    ├── Asignatura.java
    ├── Matricula.java
    └── Nota.java
```

### 🔗 **Diagrama UML de Clases**
![Diagrama UML de Clases](https://i.ibb.co/1GbG5hPX/imagen-2025-11-25-130747962.png)

## ▶️ **Cómo Ejecutar**
1. **JDK 17+** instalado.
2. Abrir en **VS Code**.
3. Abre una terminal (cmd) en la carpeta raíz del proyecto y ejecuta:
   ```
   java PlataformaNotasApp
   ```

## 📄 **Licencia**
Proyecto académico del **Grupo 5**. Uso educativo libre! :)

**¡Gracias por explorar!** 😊