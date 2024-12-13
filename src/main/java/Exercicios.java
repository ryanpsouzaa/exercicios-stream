import java.util.*;
import java.util.stream.Collectors;

public class Exercicios {
    public static void main(String[]args){
        //filtre os números pares
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println("exercicio 1");
        numeros.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);
        System.out.println("////////////////////");

        //Transforme tudo para letras maiúsculas
        List<String> palavras = Arrays.asList("java", "stream", "lambda");
        System.out.println("exercicio 2");

        palavras.stream()
                .map(String :: toUpperCase)
                        .forEach(System.out::println);

        System.out.println("////////////////////");



        //filtre os ímpares, multiplique-os por 2 e exiba
        List<Integer> numeros3 = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println("exercício 3");

        List<Integer> numerosImpares = numeros3.stream()
                .filter(n -> n % 2 != 0)
                .map(n -> n * 2)
                .collect(Collectors.toList());

        numerosImpares.forEach(System.out::println);

        System.out.println("////////////////////");

        //exclua os dados duplicados
        List<String> palavras4 = Arrays.asList("apple", "banana", "apple", "orange", "banana");

        System.out.println("exercício 4");
        List<String> palavrasUnicas = palavras4.stream().distinct()
                .collect(Collectors.toList());
        palavrasUnicas.forEach(System.out::println);

        System.out.println("////////////////////");

        //extraia os números primos e ordene-os de forma crescente
        List<List<Integer>> listaDeNumeros = Arrays.asList(
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(5, 6, 7, 8),
                Arrays.asList(9, 10, 11, 12)
        );
        System.out.println("exercicio 5");

        List<Integer> numerosPrimos = listaDeNumeros.stream()
                .flatMap(List :: stream)
                .filter(Exercicios::ehPrimo)
                .sorted()
                .collect(Collectors.toList());

        numerosPrimos.forEach(System.out::println);

        System.out.println("////////////////////");

        //filtre as pessoas com mais de 18 anos e imprima em ordem alfabetica
        List<Pessoa> pessoas = Arrays.asList(
                new Pessoa("Alice", 22),
                new Pessoa("Bob", 17),
                new Pessoa("Charlie", 19)
        );
        System.out.println("exercicio 6");

        pessoas.stream().filter(p -> p.getIdade() > 18)
                .map(Pessoa :: getNome)
                .sorted()
                .forEach(System.out::println);


        System.out.println("////////////////////");

        //filtre todos os produtos da categoria ELETRONICOS com preço menor que 1000
        //ordene-os pelo preço em ordem crescente e coloque o resultado em uma nova
        //lista

        List<Produto> produtos = Arrays.asList(
                new Produto("Smartphone", 800.0, "Eletrônicos"),
                new Produto("Notebook", 1500.0, "Eletrônicos"),
                new Produto("Teclado", 200.0, "Eletrônicos"),
                new Produto("Cadeira", 300.0, "Móveis"),
                new Produto("Monitor", 900.0, "Eletrônicos"),
                new Produto("Mesa", 700.0, "Móveis")
        );

        System.out.println("exercicio 7");

        List<Produto> listaOrdenada = produtos.stream()
                .filter(p -> p.getCategoria().equalsIgnoreCase("Eletrônicos")
                && p.getPreco() < 1000)
                .sorted(Comparator.comparing(Produto :: getPreco))
                .collect(Collectors.toList());

        listaOrdenada.forEach(System.out::println);

        System.out.println("////////////////////");

        //tomando o código do exercicio anterior, modifique o código para que a saída
        //mostre os tres produtos mais baratos da categoria eletronicos

        System.out.println("exercicio 8");

        List<Produto> listaTopBaratos = produtos.stream()
                .filter(p -> p.getCategoria().equalsIgnoreCase("Eletrônicos"))
                .sorted(Comparator.comparing(Produto :: getPreco))
                .limit(3)
                .collect(Collectors.toList());

        listaTopBaratos.forEach(System.out::println);





    }

    public static boolean ehPrimo(Integer numero){
        for(int i = 2; i < numero; i++){
            if(numero % i == 0){
                return false;
            }
        }
        return true;
    }
}
