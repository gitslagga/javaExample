package jean.runoob;

class EncapTest {
    private String name;
    private String idNum;
    private int age;

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getIdNum(){
        return idNum;
    }
    public void setAge(int newAge){
        age = newAge;
    }
    public void setName(String newName){
        name = newName;
    }
    public void setIdNum(String newId){
        idNum = newId;
    }
}
public class RunEncap {
    public static void main(String[] args) {
        EncapTest encapTest = new EncapTest();
        encapTest.setName("James");
        encapTest.setAge(20);
        encapTest.setIdNum("12343ms");

        System.out.println("Name: " + encapTest.getName() + " Age : " + encapTest.getAge());
    }
}
