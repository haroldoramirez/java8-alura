import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class Curso {
    private String nome;
    private int alunos;

    public Curso(String nome, int alunos) {
        this.nome = nome;
        this.alunos = alunos;
    }

    public String getNome() {
        return nome;
    }

    public int getAlunos() {
        return alunos;
    }
}

public class ExemploCursos {
    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso("Java", 43));
        cursos.add(new Curso("Scala", 13));
        cursos.add(new Curso("Play Framework", 143));
        cursos.add(new Curso("Javascript", 89));
        cursos.add(new Curso("Css", 75));
        cursos.add(new Curso("Css", 123));

        cursos.sort(Comparator.comparing(Curso::getAlunos));

        cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .forEach(c -> System.out.println(c.getNome()));

        cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .map(Curso::getAlunos)
                .forEach(System.out::println);

        //int sum = cursos.stream().filter(c -> c.getAlunos() > 100).mapToInt(Curso::getAlunos).sum();

        // que apenas tenha os nomes dos cursos
        //Stream<String> nomes = cursos.stream().map(Curso::getNome);

        //cursos.forEach(c -> System.out.println(c.getNome()));

        //System.out.println(sum);

        //Optional<Curso> optionalCurso = cursos.stream().filter(c -> c.getAlunos() >= 100).findAny();

        //optionalCurso.ifPresent(c -> System.out.println(c.getNome()));

        //cursos = cursos.stream().filter(c -> c.getAlunos() >= 100).collect(Collectors.toList());

//       cursos.stream()
//               .filter(c -> c.getAlunos() >= 100)
//               .collect(Collectors.toMap(c -> c.getNome(), c -> c.getCursos()));

        cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .collect(Collectors.toMap(Curso::getNome, Curso::getAlunos))
                .forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));


//        recomendado para grandes quantidades de informacoes
        cursos.parallelStream()
                .filter(c -> c.getAlunos() >= 100)
                .collect(Collectors.toMap(Curso::getNome, Curso::getAlunos))
                .forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));

        // busca o primeiro elemento da lista filtrada
        Optional<Curso> primeiro =  cursos.stream().filter(c -> c.getAlunos() > 50).findFirst();

        cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .collect(Collectors.toMap(Curso::getNome, Curso::getAlunos))
                .forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));

        // calcule a media da quantidade de aluno de todos os cursos
        cursos.stream()
                .mapToInt(Curso::getAlunos).average();
    }

}
