SELECT * FROM universidad.notas;

SELECT max(calificacion) NotaMasAlta FROM universidad.notas;

SELECT alu.nombre FROM universidad.notas inner join universidad.alumnos alu on notas.alumno = alu.id where notas.calificacion=(SELECT max(calificacion) NotaMasAlta FROM universidad.notas);

SELECT asig.descripcion FROM universidad.notas inner join universidad.asignaturas asig on notas.asignatura = asig.id where notas.calificacion=15;

Select nombre from universidad.alumnos where id =(SELECT alumno from universidad.notas group by alumno order by count(alumno) desc limit 1);

SELECT descripcion from universidad.asignaturas where id= (SELECT asignatura from universidad.notas group by asignatura order by count(asignatura) desc limit 1);

SELECT prof.nombre from profesores prof inner join asignaturas asig on prof.id=asig.profesor group by prof.nombre;

-- SELECT asignaturas.profesor SELECT asignatura from universidad.notas group by asignatura

SELECT asignatura, count(alumno) alu, asig.descripcion, prof.nombre from notasuniversidad.notas
inner join asignaturas asig on asignatura = asig.id
inner join profesores prof on profesor = prof.id
group by prof.nombre 
having count(*) = (
SELECT max(maximo) from (
SELECT count(alumno) maximo from universidad.notas
inner join asignaturas asig on asignatura = asig.id
inner join profesores prof on profesor = prof.id
group by prof.nombre)T)
order by count(alumno) desc;

SELECT asignaturas.id, descripcion, nombre, apellidos FROM asignaturas inner join alumnos_has_asignaturas on asignaturas.id = asignatura inner join profesores on asignaturas.profesor = profesores.id where alumno=6;

SELECT *, avg(calificacion) media
FROM asignaturas
inner join alumnos_has_asignaturas on asignaturas.id = alumnos_has_asignaturas.asignatura 
inner join profesores on asignaturas.profesor = profesores.id 
inner join alumnos on alumnos_has_asignaturas.alumno = alumnos.id
left join notas on asignaturas.id = notas.asignatura and alumnos.id = notas.alumno
where alumnos.id=6
group by asignaturas.id;

SELECT *, avg(calificacion) media
FROM alumnos
inner join alumnos_has_asignaturas on alumnos_has_asignaturas.alumno = alumnos.id
inner join asignaturas on asignaturas.id = alumnos_has_asignaturas.asignatura
inner join profesores on asignaturas.profesor = profesores.id
left join notas on notas.alumno = alumnos.id and notas.asignatura = asignaturas.id
WHERE alumnos.id=6
GROUP BY asignaturas.id;

SELECT *, avg(calificacion) media 
FROM asignaturas 
inner join alumnos_has_asignaturas on asignaturas.id = alumnos_has_asignaturas.asignatura 
inner join profesores on asignaturas.profesor = profesores.id 
left join notas on asignaturas.id = notas.asignatura and alumnos_has_asignaturas.alumno = notas.alumno 
where alumnos_has_asignaturas.alumno=6
group by asignaturas.descripcion;


INSERT INTO alumnos_has_asignaturas(alumno, asignatura) values (149,40);