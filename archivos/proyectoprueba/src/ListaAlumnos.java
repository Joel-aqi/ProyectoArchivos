import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListaAlumnos {
    ///Nombre del archivo
    private String nameA;

    ///Metodo Construtor
    public ListaAlumnos(String nameA) {
        this.nameA = nameA;
    }

    ///La lista para leer alumnos
    public List<Alumno> leerAlumnos() {
        List<Alumno> alumnos = new ArrayList<>();
        File file = new File(nameA);

        if (!file.exists()) {
            System.out.println("Se esta creando");
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("Error al crear el archivo: " + e.getMessage());
            }
            return alumnos;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                alumnos.add(Alumno.fromString(line));
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return alumnos;
    }

    ///  Se usa BufferedWriter para escribir cada objeto en el archivo, agregando un salto de línea después de cada entrada.
    public void guardarAlumnos(List<Alumno> alumnos) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nameA))) {
            for (Alumno alumno : alumnos) {
                bw.write(alumno.toString());
                bw.newLine();
            }
            System.out.println("Lista de alumnos guardada correctamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    ///Agrega al usuario con alumnos.add(alumno)
    public void agregarAlumno(Alumno alumno) {
        List<Alumno> alumnos = leerAlumnos();
        alumnos.add(alumno);
        guardarAlumnos(alumnos);
    }

    ///getNumero porque es privado si no seria cambiarlo a public
    public void eliminarAlumno(String numeroControl) {
        List<Alumno> alumnos = leerAlumnos();
        boolean eliminado = alumnos.removeIf(alumno -> alumno.getNumeroControl().equals(numeroControl));
        if (eliminado) {
            guardarAlumnos(alumnos);
            System.out.println("Alumno eliminado correctamente.");
        }
        else {
            System.out.println("Alumno no encontrado.");
        }
    }
}
