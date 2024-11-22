package shared.io.output;

public class ConsoleOutputImpl implements Output {
    @Override
    public void print(String s) {
        System.out.println(s);
    }
}
