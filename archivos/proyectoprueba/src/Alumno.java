public class Alumno {
    public String nombre;
    public String numeroControl;
    public String semestre;

    ///metodo constructor
    public Alumno(String nombre, String numeroControl, String semestre) {
        this.nombre = nombre;
        this.numeroControl = numeroControl;
        this.semestre = semestre;
    }

    ///para get y set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroControl() {
        return numeroControl;
    }

    public void setNumeroControl(String numeroControl) {
        this.numeroControl = numeroControl;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    ///superclase
    @Override
    public String toString() {
        return nombre + "," + numeroControl + "," + semestre;
    }


    public static Alumno fromString(String data) {
        String[] parts = data.split(",");
        return new Alumno(parts[0], parts[1], parts[2]);
    }

}