package topic.generics;

public class Animal {
    private final int id;

    public Animal(int id) {
        this.id = id;
    }

    public void eat(){
        System.out.println("Animal is eating...");
    }

    @Override
    public String toString() {
        return "id=" + id ;
    }
}
