import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<SourceBook> sourceBooks = new ArrayList<>();
        int optionNumber = scanner.nextInt();

        while (optionNumber != 0) {
            System.out.println("Что вы хотите сделать?\n1 - Вывести всю информацию\n" +
                    "2 - Создать объект\n0 - Завершить работу");
            optionNumber = scanner.nextInt();

            if (optionNumber == 1) {
                System.out.println(sourceBooks.toString());
            }
            if (optionNumber == 2) {
                int choiceNumber;
                System.out.println("Выберите тип объекта:\n 1 - Article\n 2 - Essay");
                choiceNumber = scanner.nextInt();
                if (choiceNumber == 1) {
                    sourceBooks.add(createArticle());
                } else if (choiceNumber == 2) {
                    sourceBooks.add(createEssay());
                } else {
                    System.out.println("Вы не указали нужный тип объекта");
                }
            } else {
                System.out.println("Введите верный пункт меню");
            }
        }
    }

    public static Article createArticle() {
        System.out.println("Введите название: ");
        String name = scanner.next();
        System.out.println("Введите количество страниц: ");
        int numberInformationPages = scanner.nextInt();
        System.out.println("Введите количество сборников: ");
        int numberOfElements = scanner.nextInt();
        int pages;
        List<Integer> information = new ArrayList<>();
        for (int i = 0; i < numberOfElements; i++) {
            System.out.println("Введите количество страниц: ");
            pages = scanner.nextInt();
            information.add(pages);
        }
        Article result = new Article(information, name, numberInformationPages);
        System.out.println("Выполнено");
        return result;
    }

    public static Essay createEssay() {
        System.out.println("Введите название: ");
        String name = scanner.next();
        System.out.println("Введите количество страниц: ");
        int numberInformationPages = scanner.nextInt();
        System.out.println("Введите количество сборников: ");
        int numberOfElements = scanner.nextInt();
        int pages;
        List<Integer> information = new ArrayList<>();
        for (int i = 0; i < numberOfElements; i++) {
            System.out.println("Введите количество страниц: ");
            pages = scanner.nextInt();
            information.add(pages);
        }
        Essay result = new Essay(information, name, numberInformationPages);
        System.out.println("Выполнено");
        return result;
    }

}
