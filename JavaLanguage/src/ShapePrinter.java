public class ShapePrinter {
    public void printPyramid(int height) {
        int count = 0;
        int countFull = 0;
        for (int i = 1; i < height + 1; i++) {
            countFull += i;
        }
        String countFullString = countFull + "";

        for (int i = 0; i < height; i++) {


            for (int j = -1; j < i; j++) {
                count++;
                String countString = count + "";
                if (j == -1 && countFullString.length() < 2) {
                    System.out.print(count);
                } else if (j == -1) {
                    for (int k = 0; k < countFullString.length() - countString.length(); k++) {
                        System.out.print(" ");
                    }
                    System.out.print(count);
                } else {
                    for (int k = 0; k < countFullString.length() - countString.length() + 1; k++) {
                        System.out.print(" ");

                    }
                    System.out.print(count);
                }


            }
//            for (int k = i ; k < height - 1; k++) {
//                System.out.printf(" ");
//            }

            System.out.println("");
        }
        // 코드를 입력하세요.
    }
}
