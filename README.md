# DoctorPaws

## Contexto

El propósito central de este proyecto es digitalizar las operaciones de una clínica veterinaria especializada en la atención y hospitalización de perros. Este aplicativo permitirá a los dueños de las mascotas mantenerse informados sobre el estado de salud de sus animales y facilitará al personal médico el registro y seguimiento de los tratamientos realizados.

## Funcionalidades Principales

### **1. Diagrama de Clases y Entidades del Sistema (Feature 01)**
- Creación de modelos y entidades basados en la información de los componentes.
- Generación de repositorios para los modelos.

### **2. Diagrama de Navegación (Feature 02)**
- Representación gráfica del flujo de navegación completo del sistema.

### **3. Landing Page (Feature 03)**
- Exhibición de los principales servicios ofrecidos por la clínica.
- Portal de acceso para veterinarios para registrar y actualizar información de mascotas, dueños y tratamientos.

### **4. Registro de Mascotas y Dueños (Feature 03)**
- Capacidad de crear, leer y actualizar información tanto del dueño como de la mascota.
- Posibilidad de buscar mascotas y dueños y ver información detallada.

### **5. Registro de Veterinarios (Feature 04)**
- Creación, lectura y actualización de perfiles de veterinarios.
- Opción para desactivar veterinarios.

### **6. Carga de Medicamentos (Feature 05)**
- Importación de información sobre medicamentos desde un archivo al inicio del programa.

### **7. Administración de Tratamientos (Feature 06)**
- Creación de tratamientos para mascotas especificando mascota, veterinario, medicamento y fecha.

### **8. Historial Médico (Feature 07)**
- Consulta de la lista de tratamientos administrados a una mascota específica.

### **9. Creación de Roles (Feature 08)**
- Definición de roles de usuario: Administrador, Veterinario y Dueño.
- Asignación de permisos y restricciones basados en roles.

### **10. Control de Acceso basado en Roles (Feature 09)**
- Implementación de restricciones y permisos de acceso según las funcionalidades y el tipo de usuario.

## Especificaciones Adicionales

- Se puede registrar una mascota con un campo de enfermedad como "vacío" hasta que sea atendida.
- Una mascota puede ser tratada por múltiples veterinarios y viceversa.
- Un dueño puede tener múltiples mascotas hospitalizadas.
- La información de las mascotas no se elimina del sistema una vez que son dadas de alta.
- Aunque una mascota puede sufrir múltiples enfermedades durante su vida, en el sistema solo se registra una enfermedad a la vez.
- No se usará herencia en el diseño del sistema.
- No es esencial rastrear cambios en el estado de la mascota (como peso o enfermedad), pero es vital rastrear tratamientos realizados.

## Desarrollo y Contribución

Este proyecto está en constante evolución. Si estás interesado en contribuir, por favor consulta las directrices de contribución y sigue el código de conducta.

## Licencia

Este proyecto está bajo licencia [MIT License]. Consulta el archivo `LICENSE` para más detalles. 
