package gof23.behavioral_patterns.iterator.example1.iterator;

import gof23.behavioral_patterns.iterator.example1.container.NameRepository;

public class NameIterator implements Iterator{
    private int index;

    public NameIterator(NameRepository data) {
        this.data = data;
    }

    private NameRepository data;

    @Override
    public boolean hasNext() {
        if (index < data.names.length) {
            return true;
        }
        return false;
    }

    @Override
    public Object next() {
        if (hasNext()) {
            return data.names[index++];
        }
        return null;
    }
}
