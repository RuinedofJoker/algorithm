package gof23.behavioral_patterns.chain_of_responsibility.example1.logger;

public class ConsoleLogger extends AbstractLogger{
    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("控制台打印:" + message);
    }
}
