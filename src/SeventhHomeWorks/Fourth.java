package SeventhHomeWorks;

import java.util.Comparator;

public class Fourth {

    public static class Man{
        private int age;

        public Man(int age) {
            this.age = age;
        }

        public int getAge(){
            return age;
        }
    }

    public static void main(String[] args) {

        Man man1 = new Man(5);
        Man man2 = new Man(3);

        Comparator<Man> byAge =
                (Man o1, Man o2)->o1.getAge() - o2.getAge();

        int result = byAge.compare(man1,man2);
        System.out.println(result);
    }
}
