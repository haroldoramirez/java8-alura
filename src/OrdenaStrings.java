import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class OrdenaStrings {
	public static void main(String[] args) {
		List<String> palavras = new ArrayList<String>();
		palavras.add("alura online");
		palavras.add("editora casa do código");
		palavras.add("cibiogas");
		palavras.add("caelum");

		palavras.sort((s1, s2) -> {
			if (s1.length() < s2.length())
				return -1;
			if (s1.length() > s2.length())
				return 1;
			return 0;

		});

		// lambda consegue ser convertido para uma interface funcional
		// para a expressão lambda encaixar no código precisa uma interface funcional
		// compatível.
		//palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		
		palavras.sort(Comparator.comparing(s -> s.length()));
        palavras.sort(Comparator.comparing(String::length));

		// quebrando o codigo
		Function<String, Integer> funcao = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };

		Comparator<String> comparador = Comparator.comparing(funcao);
		palavras.sort(comparador);

		System.out.println(palavras);

		// Mude o seu comparator usando algum outro critério de comparação no lugar do tamanho(length) da String
        palavras.sort(String.CASE_INSENSITIVE_ORDER);


		// Classes anonimas a classe que não tem nome e serve para pequenas
		// implementações que não serão utilizada em outras partes da implementação
		// lambda
		palavras.forEach(s -> System.out.println(s));

		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Executando um Runnable");
			}

		}).start();

		// exercicio
		// new Thread(run -> System.out.println("Executando um Runnable").start();

		// resposta
		new Thread(() -> System.out.println("Executando um Runnable")).start();

		// consumer é uma interface funcional
		Consumer<String> impressor = System.out::println;
		palavras.forEach(impressor);

		// metodos references que é equivalente ao lambda neste caso especifico
        palavras.forEach(System.out::println);

	}
}
