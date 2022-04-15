import java.io.*;
import java.util.List;
import java.util.Objects;

public class Essay implements Serializable, SourceBook {

    private List<Integer> information;
    private String name;
    private Integer numberInformationPages;

    public Essay() {
    }

    public Essay(List<Integer> information, String name, Integer numberInformationPages) {
        this.information = information;
        this.name = name;
        this.numberInformationPages = numberInformationPages;
    }

    public List<Integer> getInformation() {
        return information;
    }

    public void setInformation(List<Integer> information) {
        this.information = information;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberInformationPages() {
        return numberInformationPages;
    }

    public void setNumberInformationPages(Integer numberInformationPages) {
        this.numberInformationPages = numberInformationPages;
    }

    public Integer getInformationElement(Integer index) {
        return information.get(index);
    }

    @Override
    public void removeInformationElement(Integer index) {
        information.remove(index);
    }

    @Override
    public int getSumOfInformationElements() {
        int result = -1;
        try {
            result = information.stream().mapToInt(i -> i).sum();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void output(OutputStream outputStream) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeUTF("Essay");
        objectOutputStream.writeObject(information);
        objectOutputStream.writeUTF(name);
        objectOutputStream.writeInt(numberInformationPages);
        objectOutputStream.close();
    }

    @Override
    public void write(Writer writer) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write("Essay");
        bufferedWriter.newLine();
        bufferedWriter.write(information.toString());
        bufferedWriter.newLine();
        bufferedWriter.write(name);
        bufferedWriter.newLine();
        bufferedWriter.write(numberInformationPages.toString());
        bufferedWriter.close();
        writer.close();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Essay)) return false;
        Essay essay = (Essay) o;
        return information.equals(essay.information)
                && name.equals(essay.name) && numberInformationPages.equals(essay.numberInformationPages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(information, name, numberInformationPages);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Essay{");
        sb.append("information=").append(information);
        sb.append(", name='").append(name).append('\'');
        sb.append(", numberInformationPages=").append(numberInformationPages);
        sb.append('}');
        return sb.toString();
    }
}
