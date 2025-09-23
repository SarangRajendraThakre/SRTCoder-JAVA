public class Patterns {
    


    
        public static void main(String[] args) {
         
                invokePattern(7);
        
        }
    
        static void invokePattern(int n) {
            switch (n) {
                case 1 -> pattern1();
                case 2 -> pattern2();
                case 3 -> pattern3();
                case 4 -> pattern4();
                case 5 -> pattern5();
                case 6 -> pattern6();
                case 7 -> pattern7();
                case 8 -> pattern8();
                case 9 -> pattern9();
                case 10 -> pattern10();
                case 11 -> pattern11();
                case 12 -> pattern12();
                
            }
        }
    
        static void pattern1() {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }

       
        
        static void pattern2() {
            for (int i = 1; i <= 5; i++) {
                for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
        
        static void pattern3() {
            for (int i = 5; i >= 1; i--) {
                for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
        
        static void pattern4() {
            for (int i = 1; i <= 5; i++) {
                for (int j = 1; j <= i; j++) {
                    System.out.print(j + " ");
                }
                System.out.println();
            }
        }
        
        static void pattern5() {
            for (int i = 1; i <= 5; i++) {
                for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
            for (int i = 4; i >= 1; i--) {
                for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
        
        static void pattern6() {
            for (int i = 1; i <= 5; i++) {
                for (int j = 1; j <= 5 - i; j++) {
                    System.out.print(" ");
                }
                for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
        
        static void pattern7() {
            for (int i = 5; i >= 1; i--) {
                for (int j = 1; j <= 5 - i; j++) {
                    System.out.print(" ");
                }
                for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
        
        static void pattern8() {
            for (int i = 1; i <= 5; i++) {
                for (int j = 1; j <= 5 - i; j++) {
                    System.out.print(" ");
                }
                for (int j = 1; j <= (2 * i - 1); j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
        
        static void pattern9() {
            for (int i = 5; i >= 1; i--) {
                for (int j = 1; j <= 5 - i; j++) {
                    System.out.print(" ");
                }
                for (int j = 1; j <= (2 * i - 1); j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
        
        static void pattern10() {
            for (int i = 1; i <= 5; i++) {
                for (int j = 1; j <= 5 - i; j++) {
                    System.out.print(" ");
                }
                for (int j = 1; j <= i; j++) {
                    System.out.print("* ");
                }
                System.out.println();
            }
        }
        
        static void pattern11() {
            for (int i = 1; i <= 5; i++) {
                for (int j = 1; j <= i; j++) {
                    System.out.print(j);
                }
                System.out.println();
            }
        }
        
        static void pattern12() {
            for (int i = 1; i <= 5; i++) {
                for (int j = 1; j <= i; j++) {
                    System.out.print(i);
                }
                System.out.println();
            }
        }
    }
    