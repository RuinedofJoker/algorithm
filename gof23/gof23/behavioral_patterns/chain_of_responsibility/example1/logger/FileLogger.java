package gof23.behavioral_patterns.chain_of_responsibility.example1.logger;

public class FileLogger extends AbstractLogger{
    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("文件记录日志:" + message);
    }
}
