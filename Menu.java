import java.util.Scanner;

public class Menu {
    // public static void main(String[] args) {
        protected Scanner scan = new Scanner(System.in);
        protected Boolean loop = true;
        protected int choice;

        public Menu()
        {
            System.out.println("|*-----------------------------------------*|");
            System.out.println("|*Option 1:                                *|");
            System.out.println("|*Option 2:                                *|");
            System.out.println("|*Option 3:                                *|");
            System.out.println("|*Option 4: Thoat.                         *|");
            System.out.println("|*-----------------------------------------*|");

        do {
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Chon 1");
                    break;
            
                case 2:
                    System.out.println("Chon 2");
                    break;
                
                case 3:
                    System.out.println("Chon 3");
                    break;

                case 4:
                    loop = false;
                    System.out.println("Thoat");
                    break;

                default:
                    System.out.println("Chon lai");
                    break;
            }
        } while (loop);
        scan.close();
    }
}