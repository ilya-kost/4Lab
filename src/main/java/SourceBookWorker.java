import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SourceBookWorker {

    public static void outputSourceBook(SourceBook sourceBook, OutputStream outputStream) throws IOException {
        sourceBook.output(outputStream);
    }

    public static SourceBook inputSourceBook(InputStream inputStream) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        List<Integer> information;
        String name;
        int numberInformationPages;
        String nameClass = objectInputStream.readUTF();

        SourceBook result = null;

        if (nameClass.equals("Article")) {
            information = (ArrayList<Integer>) objectInputStream.readObject();
            name = objectInputStream.readUTF();
            numberInformationPages = objectInputStream.readInt();
            result = new Article(information, name, numberInformationPages);
        }
        if (nameClass.equals("Essay")) {
            information = (ArrayList<Integer>) objectInputStream.readObject();
            name = objectInputStream.readUTF();
            numberInformationPages = objectInputStream.readInt();
            result = new Essay(information, name, numberInformationPages);
        }
        objectInputStream.close();
        inputStream.close();
        return result;
    }

    public static void writeSourceBook(SourceBook sourceBook, Writer writer) throws IOException {
        sourceBook.write(writer);
    }

    public static SourceBook readSourceBook(Reader reader) throws IOException {
        List<Integer> information = new ArrayList<>();
        String name;
        Integer numberInformationPages;
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = bufferedReader.readLine();

        SourceBook result = null;

        if (line.equals("Article")) {
            line = bufferedReader.readLine();
            for (char i : line.toCharArray()) {
                if (Character.isDigit(i)) {
                    information.add((int) i);
                }
            }
            name = bufferedReader.readLine();
            numberInformationPages = Integer.valueOf(bufferedReader.readLine());
            bufferedReader.close();
            result = new Article(information, name, numberInformationPages);
        }
        if (line.equals("Essay")) {
            line = bufferedReader.readLine();
            for (char i : line.toCharArray()) {
                if (Character.isDigit(i)) {
                    information.add((int) i);
                }
            }
            name = bufferedReader.readLine();
            numberInformationPages = Integer.valueOf(bufferedReader.readLine());
            bufferedReader.close();
            result = new Essay(information, name, numberInformationPages);
        }
        return result;
    }

    public static void serializeSourceBook(SourceBook sourceBook, ObjectOutputStream objectOutputStream)
            throws IOException {
        objectOutputStream.writeObject(sourceBook);
        objectOutputStream.close();
    }

    public static SourceBook deserializeSourceBook(ObjectInputStream objectInputStream)
            throws IOException, ClassNotFoundException {
        SourceBook sourceBook = (SourceBook) objectInputStream.readObject();
        return sourceBook;
    }

}
