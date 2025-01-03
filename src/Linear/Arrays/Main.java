package Linear.Arrays;

public class Main {
    public static void main(String[] args) {
        Array numbers = new Array(6);
        numbers.insert(1); //0
        numbers.insert(2); //1
        numbers.insert(3); //2
        numbers.insert(4); //3
        numbers.insert(5); //4

        numbers.insertAt(-7, 11);

        numbers.print();
    }
}
