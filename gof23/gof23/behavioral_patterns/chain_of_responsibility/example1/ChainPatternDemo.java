package gof23.behavioral_patterns.chain_of_responsibility.example1;

import gof23.behavioral_patterns.chain_of_responsibility.example1.logger.AbstractLogger;
import gof23.behavioral_patterns.chain_of_responsibility.example1.logger.ConsoleLogger;
import gof23.behavioral_patterns.chain_of_responsibility.example1.logger.FileLogger;

public class ChainPatternDemo {
    public static void main(String[] args) {
        AbstractLogger consoleInfoLogger = new ConsoleLogger(AbstractLogger.INFO);
        AbstractLogger consoleDebugLogger = new ConsoleLogger(AbstractLogger.DEBUG);
        AbstractLogger fileErrorLogger = new FileLogger(AbstractLogger.ERROR);

        consoleInfoLogger.setNextLogger(consoleDebugLogger);
        consoleDebugLogger.setNextLogger(fileErrorLogger);

        consoleInfoLogger.logMessage(AbstractLogger.ERROR, "调用user模块接口网络超时");
        System.out.println("------------------------------------");
        consoleInfoLogger.logMessage(AbstractLogger.INFO, "查询订单");
    }
}
