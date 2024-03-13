package polymorphPractice;

public class Horse extends Animal{
    @Override
    public void move() {
        System.out.println("Moving like a horse");
    }

    public void bray(){
        System.out.println("braaaayyyy");
    }
}
