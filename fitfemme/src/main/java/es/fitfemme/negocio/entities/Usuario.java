package es.fitfemme.negocio.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int idUsuario;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "email")
    private String email;

    @Column(name = "contraseña")
    private String contrasenia;

    @Column(name = "direccion")
    private String direccion;

    public Usuario() {
    }

    public Usuario(int id_usuario) {
        this.idUsuario = id_usuario;
    }

    public Usuario(int id_usuario, String nombre, String email, String contrasenia, String direccion) {
        this.idUsuario = id_usuario;
        this.nombre = nombre;
        this.email = email;
        this.contrasenia = contrasenia;
        this.direccion = direccion;
    }

    public int getId_usuario() {
        return idUsuario;
    }

    public void setId_usuario(int id_usuario) {
        this.idUsuario = id_usuario;
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
        return idUsuario == usuario.idUsuario;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idUsuario);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id_usuario=" + idUsuario +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
