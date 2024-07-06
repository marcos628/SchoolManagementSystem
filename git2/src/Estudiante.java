import java.util.Date;

public class Estudiante {
    private int id;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String estado;

    public Estudiante(int id, String nombre, String apellido, Date fechaNacimiento, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void print() {
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Fecha de Nacimiento: " + fechaNacimiento);
        System.out.println("Estado: " + estado);
    }
}
