-- ========================================
-- 1. Roles (deben existir antes de los historicos)
-- ========================================
INSERT INTO roles (idRol, rol_asignado) VALUES (1, 'COMITE_TRABAJO_GRADO');
INSERT INTO roles (idRol, rol_asignado) VALUES (2, 'COORDINADOR_TRABAJO_GRADO');
INSERT INTO roles (idRol, rol_asignado) VALUES (3, 'DIRECTOR_TRABAJO_GRADO');

-- ========================================
-- 2. Docentes
-- ========================================
INSERT INTO Docentes (idDocente, nombres_docente, apellidos_docente, nombre_grupo, correo) VALUES (1, 'Juan', 'Perez', 'Grupo1', 'juanperez@unicacua.edu.co');

INSERT INTO Docentes (idDocente, nombres_docente, apellidos_docente, nombre_grupo, correo) VALUES (2, 'Maria', 'Rodriguez', 'Grupo1', 'mariarodriguez@unicacua.edu.co');

INSERT INTO Docentes (idDocente, nombres_docente, apellidos_docente, nombre_grupo, correo) VALUES (3, 'Carlos', 'Sanchez', 'Grupo1', 'carlossanchez@unicacua.edu.co');

INSERT INTO Docentes (idDocente, nombres_docente, apellidos_docente, nombre_grupo, correo) VALUES (4, 'Laura', 'Gonzalez', 'Grupo2', 'lauragonzalez@unicacua.edu.co');

INSERT INTO Docentes (idDocente, nombres_docente, apellidos_docente, nombre_grupo, correo) VALUES (5, 'Francisco', 'Lopez', 'Grupo2', 'franciscolopez@unicacua.edu.co');

INSERT INTO Docentes (idDocente, nombres_docente, apellidos_docente, nombre_grupo, correo) VALUES (6, 'Angela', 'Ramirez', 'Grupo2', 'angelaramirez@unicacua.edu.co');

INSERT INTO Docentes (idDocente, nombres_docente, apellidos_docente, nombre_grupo, correo) VALUES (7, 'Pedro', 'Alvarez', 'Grupo3', 'pedroalvarez@unicacua.edu.co');

INSERT INTO Docentes (idDocente, nombres_docente, apellidos_docente, nombre_grupo, correo) VALUES (8, 'Sofia', 'Alvino', 'Grupo3', 'sofiacastro@unicacua.edu.co');

INSERT INTO Docentes (idDocente, nombres_docente, apellidos_docente, nombre_grupo, correo) VALUES (9, 'Sofia', 'Torres', 'Grupo3', 'camilatorres@unicacua.edu.co');

INSERT INTO Docentes (idDocente, nombres_docente, apellidos_docente, nombre_grupo, correo) VALUES (10, 'Daniel', 'Garcia', 'Grupo4', 'danielgarcia@unicacua.edu.co');

-- ========================================
-- 3. Historicos (asignación de roles)
-- ========================================
-- 3 docentes con COMITE_TRABAJO_GRADO (activos)
INSERT INTO Historicos (idHistorico, activo, fecha_inicio, fecha_fin, idDocente, idRol) VALUES (1, TRUE, '2025-01-10', '2025-07-10', 1, 1);

INSERT INTO Historicos (idHistorico, activo, fecha_inicio, fecha_fin, idDocente, idRol) VALUES (2, TRUE, '2025-02-15', '2025-08-15', 2, 1);

INSERT INTO Historicos (idHistorico, activo, fecha_inicio, fecha_fin, idDocente, idRol) VALUES (3, TRUE, '2025-03-20', '2025-10-20', 3, 1);

-- 1 docente con COMITE_TRABAJO_GRADO (vencido/inactivo)
INSERT INTO Historicos (idHistorico, activo, fecha_inicio, fecha_fin, idDocente, idRol) VALUES (4, FALSE, '2023-05-05', '2024-01-01', 4, 1);

-- 1 coordinador (activo)
INSERT INTO Historicos (idHistorico, activo, fecha_inicio, fecha_fin, idDocente, idRol) VALUES (5, TRUE, '2025-04-01', '2025-09-01', 5, 2);

-- 2 directores (activos)
INSERT INTO Historicos (idHistorico, activo, fecha_inicio, fecha_fin, idDocente, idRol) VALUES (6, TRUE, '2025-01-20', '2025-09-20', 6, 3);

INSERT INTO Historicos (idHistorico, activo, fecha_inicio, fecha_fin, idDocente, idRol) VALUES (7, TRUE, '2024-02-25', '2025-08-25', 7, 3);

-- Los docentes 8, 9 y 10 no tienen historicos aún
