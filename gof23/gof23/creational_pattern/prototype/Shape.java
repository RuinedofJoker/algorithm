package gof23.creational_pattern.prototype;

public abstract class Shape implements Cloneable {
    private String id;
    protected String type;

    abstract void draw();

    public String getType(){
        return type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object cloneObj = null;
        try {
            cloneObj = super.clone();
        }catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return cloneObj;
    }
}
