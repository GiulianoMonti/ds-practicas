package giulian.array;


import java.util.Arrays;

public class Array {

    private int[] numbers;
    private int length;

    public Array(int length) {
        this.length = length;
        numbers = new int[length];
    }

    public int[] insert(int number, int index) {
        if (index < numbers.length) {
            numbers[index] = number;
        }
        return numbers;
    }

    public int[] append(int number) {
        this.length += 1;
        numbers = Arrays.copyOf(numbers, this.length);// increase the length of the numbers array
        numbers[this.length - 1] = number;
        return numbers;
    }

    public int get(int index) {
        if (index < this.length) {
            return numbers[index];
        }
        return -1;
    }

    public int[] delete(int index) {
        if (index < this.length) {
            for (int i = index; i < this.length - 1; i++) {
                numbers[i] = numbers[i + 1];       // igual al siguiente y borro el ultimo
            }
            this.length -= 1; //decrease the length dps de borrar
        }
        return numbers;
    }

    public void printArray() {
        for (int i = 0; i < this.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Array operations = new Array(3);
        operations.insert(4, 0);
        operations.insert(10, 1);
        operations.insert(12, 2);
        operations.append(30);
        operations.printArray();
        System.out.println(operations.get(1));
        operations.delete(2);
        operations.printArray();
        operations.delete(1);
        operations.printArray();

    }

}
