package jean.runoob;

interface Animal1{
    public void eat();
    public void travel();
}
public class MammalInt implements Animal1 {
    public void eat(){
        System.out.println("Mammal eats");
    }
    public void travel(){
        System.out.println("Mammal travels");
    }
    public int noOfLegs(){
        return 0;
    }

    public static void main(String[] args) {
        MammalInt mammalInt = new MammalInt();
        mammalInt.eat();
        mammalInt.travel();
    }
}
