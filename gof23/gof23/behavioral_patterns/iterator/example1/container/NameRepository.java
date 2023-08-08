package gof23.behavioral_patterns.iterator.example1.container;

import gof23.behavioral_patterns.iterator.example1.iterator.Iterator;
import gof23.behavioral_patterns.iterator.example1.iterator.NameIterator;

public class NameRepository implements Container{
    public String[] names = {"Robert" , "John" ,"Julie" , "Lora"};

    @Override
    public Iterator getIterator() {
        return new NameIterator(this);
    }
}
