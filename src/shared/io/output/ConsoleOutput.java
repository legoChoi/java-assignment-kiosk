package shared.io.output;

public class ConsoleOutput implements Output {
    @Override
    public void print(String s) {
        System.out.println(s);
    }
}
