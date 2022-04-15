import java.io.*;
import java.util.ArrayList;

public class MainTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Essay essay = new Essay(new ArrayList<>(), "Story of smth", 23);
        Essay essay1 = new Essay(new ArrayList<>(), "Story of smth else", 54);
        Article article = new Article(new ArrayList<>(), "Global smth research", 33);
        ArrayList<Integer> integers = new ArrayList<>();

        integers.add(23);
        integers.add(33);
        integers.add(54);
        integers.add(87);

        essay.setInformation(integers);
        article.setInformation(integers);

        OutputStream outputStream = new FileOutputStream("out.txt");
        SourceBookWorker.outputSourceBook(article, outputStream);
        SourceBook aa = SourceBookWorker.inputSourceBook(new FileInputStream("out.txt"));
        System.out.println(aa.toString());
        Writer writer = new FileWriter("out1.txt");
        SourceBookWorker.writeSourceBook(essay, writer);
        SourceBookWorker.serializeSourceBook(essay, new ObjectOutputStream(new FileOutputStream("out2.txt")));
        System.out.println(SourceBookWorker.deserializeSourceBook(new ObjectInputStream(new FileInputStream("out2.txt"))));

    }
}
