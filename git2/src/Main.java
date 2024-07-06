import java.util.Date;

public class Main {
    public static void main(String[] args) {
        GestorAcademico gestor = new GestorAcademico();

        Estudiante estudiante1 = new Estudiante(1, "Juan", "Perez", new Date(), "matriculado");
        Estudiante estudiante2 = new Estudiante(2, "Maria", "Lopez", new Date(), "matriculado");

        Curso curso1 = new Curso(1, "Matemáticas", "Curso de matemáticas básicas", 4, "1.0");
        Curso curso2 = new Curso(2, "Historia", "Curso de historia mundial", 3, "1.0");

        gestor.matricularEstudiante(estudiante1);
        gestor.matricularEstudiante(estudiante2);

        gestor.agregarCurso(curso1);
        gestor.agregarCurso(curso2);

        try {
            gestor.inscribirEstudianteCurso(estudiante1, 1);
            gestor.inscribirEstudianteCurso(estudiante2, 2);
            gestor.inscribirEstudianteCurso(estudiante1, 2);

            gestor.desinscribirEstudianteCurso(1, 2);
        } catch (EstudianteYaInscritoException | EstudianteNoInscritoEnCursoException e) {
            e.printStackTrace();
        }

        estudiante1.print();
        estudiante2.print();
        curso1.print();
        curso2.print();
    }
}
