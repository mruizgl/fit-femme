package es.fitfemme.negocio.entities;

import java.util.Objects;

public class Usuario {
    private int id_usuario;
    private String nombre;
    private String email;
    private String contrasenia;
    private String direccion;

    public Usuario() {
    }

    public Usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Usuario(int id_usuario, String nombre, String email, String contrasenia, String direccion) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.email = email;
        this.contrasenia = contrasenia;
        this.direccion = direccion;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id_usuario == usuario.id_usuario;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id_usuario);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id_usuario=" + id_usuario +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
