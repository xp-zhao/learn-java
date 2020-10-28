package core;

/**
 * @author xp-zhao
 */
public class Outer {
    private static String NAME = "xp";
    private String name;

    public Outer(String name){
        this.name = NAME;
    }

    static class Inner{
        void hello(){
            System.out.println(Outer.NAME);
        }
    }
}
