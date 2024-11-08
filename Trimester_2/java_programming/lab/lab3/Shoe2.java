abstract class Shoe {
    protected String brand;


    public Shoe(String brand) {
        this.brand = brand;
    }


    public abstract void display();


    public Shoe setBrand(String brand) {
        this.brand = brand;
        return this;
    }
}


class Sneaker extends Shoe {
    private String color;


    public Sneaker(String brand, String color) {
        super(brand);
        this.color = color;
    }


    @Override
    public void display() {
        System.out.println("Brand: " + brand);
        System.out.println("Color: " + color);
    }
}

class MyString extends Shoe {
    private String value;
    
    public MyString(String brand, String value) {
        super(brand);
        this.value = value;
    }
    
    @Override
    public void display() {
        System.out.println("Brand: " + brand);
        System.out.println("Value: " + value);
    }
}

class StringBuffer extends Shoe {
    private StringBuilder buffer;
    
    public StringBuffer(String brand) {
        super(brand);
        this.buffer = new StringBuilder();
    }
    
    public StringBuffer append(String str) {
        buffer.append(str);
        return this;
    }
    
    public StringBuffer reverse() {
        buffer.reverse();
        return this;
    }
    
    @Override
    public void display() {
        System.out.println("Brand: " + brand);
        System.out.println("Buffer: " + buffer.toString());
    }
}

public class Shoe2 {
    public static void main(String[] args) {
        Sneaker sneaker = new Sneaker("Nike", "Red");

        sneaker.setBrand("Adidas").display();
        
        MyString myString = new MyString("Anjaney", "Mitra");
        myString.display();
        
        StringBuffer stringBuffer = new StringBuffer("StringBuffer");
        stringBuffer.append("Hello").append("World").reverse().display();
    }
}
