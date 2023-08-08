package gof23.behavioral_patterns.iterator.example1;

import gof23.behavioral_patterns.iterator.example1.container.NameRepository;
import gof23.behavioral_patterns.iterator.example1.iterator.Iterator;

public class IteratorPatternDemo {
    public static void main(String[] args) {
        NameRepository namesRepository = new NameRepository();

        Iterator iterator = namesRepository.getIterator();
        while (iterator.hasNext()) {
            System.out.println("Name : " + iterator.next());
        }
    }
}
