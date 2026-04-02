public class MainWorkA {

    public static void main(String[] args) {

        Developer dev1 = new Developer("Alice", 80000, "Java");
        Developer dev2 = new Developer("Bob", 85000, "Python");
        Manager mgr1 = new Manager("Charlie", 95000, "Engineering");
        Manager mgr2 = new Manager("Diana", 90000, "Product");

        System.out.println("Developers:");
        System.out.println("===========");
        System.out.println(dev1);
        System.out.println(dev2);

        System.out.println();
        System.out.println("Managers:");
        System.out.println("=========");
        System.out.println(mgr1);
        System.out.println(mgr2);

        Developer dev3 = new Developer("Alice", 80000, "Java");

        System.out.println();
        System.out.println("Equality check:");
        System.out.println("===============");
        System.out.println("dev1 equals dev1: " + dev1.equals(dev1));
        System.out.println("dev1 equals dev2: " + dev1.equals(dev2));
        System.out.println("dev1 equals dev3: " + dev1.equals(dev3));
        System.out.println("mgr1 equals mgr2: " + mgr1.equals(mgr2));
    }
}