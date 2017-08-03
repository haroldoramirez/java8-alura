import java.time.*;
import java.time.format.DateTimeFormatter;

public class Datas {

    public static void main(String[] args) {

        LocalDate hoje = LocalDate.now();

        System.out.println(hoje);

        LocalDate olimpiadasDoRio = LocalDate.of(2019, Month.JUNE, 5);

        int anos = olimpiadasDoRio.getYear() - hoje.getYear();

        System.out.println(anos);

        Period periodo = Period.between(hoje, olimpiadasDoRio);

        System.out.println(periodo.getDays());

        LocalDate proximasOlimpiadas = olimpiadasDoRio.plusYears(4);

        System.out.println(proximasOlimpiadas);

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        DateTimeFormatter formatadorComHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");

        String valorFormatado = proximasOlimpiadas.format(formatador);

        System.out.println(valorFormatado);

        LocalDateTime agora = LocalDateTime.now();

        System.out.println(agora.format(formatadorComHoras));

        LocalTime intervalo = LocalTime.of(15, 30);
        System.out.println(intervalo);

        LocalDate data = LocalDate.of(2099, Month.JANUARY, 29);

        LocalDate now = LocalDate.now();
        LocalDate dataFutura = LocalDate.of(2099, Month.JANUARY, 25);

        Period period = Period.between(now, dataFutura);
    }
}

