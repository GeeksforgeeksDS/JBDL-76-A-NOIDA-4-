package AccessModifierExample;

public class Test1 {
    public static void main(String[] args) {
        AccessModifier accessModifier= new AccessModifier();

        accessModifier.id=11;
       // accessModifier.id2 --> compile time error

        accessModifier.id3=19;

        accessModifier.id1=19;


    }
}
