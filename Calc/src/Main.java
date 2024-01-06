import java.util.Scanner;

class Main extends Roman {
    static String calc(String input) throws Exception {
        int num1 = 0;
        int num2 = 0;
        String result;
        boolean one = false;
        boolean two = false;

        String[] chars = input.split( " ");
        if (chars.length > 3 ) throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        else if (chars.length <= 1) throw new Exception("Строка не является математической операцией");

        for (int e = 0; e < errRomanBox.length; e++) {
            if (errRomanBox[e].equals(chars[0]) || errRomanBox[e].equals(chars[2])){
                throw new Exception("В римской системе исчесления отсутствуют отрицательные числа");
            }
        }

        for (int i = 0 ; i < romanBox.length; i++){
            if (romanBox[i].equals(chars[0])) {
                num1 = i;
                one = true;
            }
            if (romanBox[i].equals(chars[2])) {
                num2 = i;
                two = true;
            }
        }

        if (!one && !two) {
            num1 = Integer.parseInt(chars[0]);
            num2 = Integer.parseInt(chars[2]);
        }

        if ((num1 > 10 || num1 < 0) || (num2 > 10 || num2 < 0)) {
            throw new Exception("Значения на вход должны быть  от 1 до 10 или от I до X ");
        }
        if ((one == true && two == false) || (one == false && two == true)) {
            throw new Exception("Используются одновременно разные системы счисления");
        }
        if ((0 > num1 || num1 > 10) || ((0 > num2 || num2 > 10))) {
            throw new Exception("Значения на вход должны быть  от 1 до 10 или от I до X ");
        }

        if (chars[1].equals("-")) {
            if (one && two && num1 < num2) {
                throw new Exception("В римской системе исчесления отсутствуют отрицательные числа");
            }
            result = String.valueOf(num1 - num2);
        }else if (chars[1].equals("*")) result = String.valueOf(num1 * num2);
        else if (chars[1].equals("+")) result = String.valueOf(num1 + num2);
        else if (chars[1].equals("/")) result = String.valueOf(num1 / num2);
        else throw new Exception("Неподдерживаемая математическая операция. Пример возможных операций: +,-,/,* ");

        if (one == true && two == true) {
            return romanBox[Integer.parseInt(result)];
        } else return result;
    }

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите выражение, примеры: 2 + 2; I + II");
        String input = sc.nextLine();

        System.out.println(calc(input));
    }
}