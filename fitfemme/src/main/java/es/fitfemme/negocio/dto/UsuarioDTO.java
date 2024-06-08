package es.fitfemme.negocio.dto;

import java.util.Objects;

public class UsuarioDTO {
    private int id_usuario;
    private String nombre;
    private String email;
    private String direccion;

    public UsuarioDTO() {
    }

    public UsuarioDTO(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public UsuarioDTO(int id_usuario, String nombre, String email, String direccion) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.email = email;
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
        UsuarioDTO that = (UsuarioDTO) o;
        return id_usuario == that.id_usuario;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id_usuario);
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "id_usuario=" + id_usuario +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
