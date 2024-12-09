import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaAlumnos listaAlumnos = new ListaAlumnos("alumnos.txt");
        ///ListaAlumnos listabin = new ListaAlumnos("prueba.bin");
        int op = 0;

        System.out.println("que opcion escoges: \nOpcion1: Agregar Alumno\nOpcion2: Leer Alumno \nOpcion3:Modificar Alumno" +
                " \nOpcion4: Eliminar alumno");
        Scanner scanner = new Scanner(System.in);
        op = scanner.nextInt();

        switch (op) {

            ///Agrega y lee el archivo de texto
            case 1:
                listaAlumnos.agregarAlumno(new Alumno("Aylet Velazquez Garcia", "24120525", "2"));
                listaAlumnos.agregarAlumno(new Alumno("Carlos Calderon vera", "25369658", "7"));

                listaAlumnos.leerAlumnos().forEach(System.out::println);
                break;

            ///solo leer
            case 2:
                listaAlumnos.leerAlumnos().forEach(System.out::println);
                break;

            ///elimina el alumno mediante el numero de control
            case 3:
                listaAlumnos.eliminarAlumno("24120525");

                System.out.println("Lista de alumnos actualizada:");
                listaAlumnos.leerAlumnos().forEach(System.out::println);
                break;

        }
        System.out.println("Ahora se va a guardar un alumno y su edad");
        Persona persona = new Persona("Carlos Calderon Vera", 19);
        try (FileOutputStream fileOut = new FileOutputStream("persona.bin");
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(persona);
            System.out.println("Esto se va a enviar: \nCarlos Calderon Vera \n19 Años");
            System.out.println("El objeto ha sido serializado y guardado en persona.bin");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
