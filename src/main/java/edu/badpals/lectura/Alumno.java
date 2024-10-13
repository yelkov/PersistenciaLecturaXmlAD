package edu.badpals.lectura;

import java.util.Objects;

public class Alumno {

    private String dni;
    private String nombre;
    private String edad;
    private Float notaMedia;
    private boolean repite;

    public Alumno(){};

    public Alumno(String dni, String nombre, String edad,Float notaMedia, boolean repite) {
        this.dni = dni;
        this.nombre = nombre;
        this.notaMedia = notaMedia;
        this.edad = edad;
        this.repite = repite;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public Float getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(Float notaMedia) {
        this.notaMedia = notaMedia;
    }

    public void repite(boolean repiteCurso){
        this.repite = repiteCurso;
    }

    public boolean esRepetidor(){
        return this.repite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Alumno alumno)) return false;
        return Objects.equals(dni, alumno.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dni);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nAlumno: ")
                .append("\n\tdni: ").append(dni)
                .append("\n\tnombre: ").append(nombre)
                .append("\n\tedad: ").append(edad)
                .append("\n\tNota media: ").append(notaMedia)
                .append("\n\trepite: ").append(esRepetidor()? "Sí":"No");
        return sb.toString();
    }
}
