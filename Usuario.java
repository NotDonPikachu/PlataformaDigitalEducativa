public abstract class Usuario {
    protected int id;
    protected String nombre;
    protected String email;

    public Usuario(int id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }

    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre + " | Email: " + email;
    }
}