import java.util.ArrayList;
import java.util.HashMap;

public class GestorAcademico implements ServiciosAcademicosI {
    private ArrayList<Estudiante> estudiantes = new ArrayList<>();
    private ArrayList<Curso> cursos = new ArrayList<>();
    private HashMap<Integer, ArrayList<Estudiante>> inscripciones = new HashMap<>();

    @Override
    public void matricularEstudiante(Estudiante estudiante) {
        if (!estudiantes.contains(estudiante)) {
            estudiantes.add(estudiante);
        }
    }

    @Override
    public void agregarCurso(Curso curso) {
        if (!cursos.contains(curso)) {
            cursos.add(curso);
        }
    }

    @Override
    public void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) throws EstudianteYaInscritoException {
        if (!inscripciones.containsKey(idCurso)) {
            inscripciones.put(idCurso, new ArrayList<>());
        }

        ArrayList<Estudiante> estudiantesInscritos = inscripciones.get(idCurso);
        if (estudiantesInscritos.contains(estudiante)) {
            throw new EstudianteYaInscritoException("El estudiante ya está inscrito en este curso.");
        }

        estudiantesInscritos.add(estudiante);
    }

    @Override
    public void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws EstudianteNoInscritoEnCursoException {
        if (!inscripciones.containsKey(idCurso)) {
            throw new EstudianteNoInscritoEnCursoException("El ID del curso no es válido.");
        }

        ArrayList<Estudiante> estudiantesInscritos = inscripciones.get(idCurso);
        Estudiante estudianteAEliminar = null;
        for (Estudiante estudiante : estudiantesInscritos) {
            if (estudiante.getId() == idEstudiante) {
                estudianteAEliminar = estudiante;
                break;
            }
        }

        if (estudianteAEliminar == null) {
            throw new EstudianteNoInscritoEnCursoException("El estudiante no está inscrito en este curso.");
        }

        estudiantesInscritos.remove(estudianteAEliminar);
    }
}

