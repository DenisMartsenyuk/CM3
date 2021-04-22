import auxiliary.SolutionResult;
import functions.Function;
import functions.FunctionFirst;
import functions.FunctionSecond;
import functions.FunctionThird;
import solutions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Function> functions = new ArrayList<>();
        functions.add(new FunctionFirst());
        functions.add(new FunctionSecond());
        functions.add(new FunctionThird());

        List<Solution> solutions = new ArrayList<>();
        solutions.add(new SolutionRectangleLeft());
        solutions.add(new SolutionRectangleRight());
        solutions.add(new SolutionRectangleMiddle());
        solutions.add(new SolutionTrapezoid());
        solutions.add(new SolutionSimpson());

        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Доступные функции: ");
            for (int i = 0; i < functions.size(); ++i) {
                System.out.println(i + 1 + ": " + functions.get(i).getName());
            }

            System.out.println("Введите номер нужной функции:");
            int functionIndex = scanner.nextInt() - 1;
            if (functionIndex < 0 || functionIndex >= functions.size()) {
                System.out.println("Неверно введен номер функции.");
                return;
            }

            System.out.println("Доступные методы интегрирования: ");
            for (int i = 0; i < solutions.size(); ++i) {
                System.out.println(i + 1 + ": " + solutions.get(i).getName());
            }

            System.out.println("Введите номер нужного метода поиска:");
            int solutionIndex = scanner.nextInt() - 1;
            if (solutionIndex < 0 || solutionIndex >= solutions.size()) {
                System.out.println("Неверно введен номер метода.");
                return;
            }

            System.out.println("Введите a:");
            String line = scanner.next();
            line = line.replace(',', '.');
            double a = Double.parseDouble(line);

            System.out.println("Введите b (b должно быть больше a):");
            line = scanner.next();
            line = line.replace(',', '.');
            double b = Double.parseDouble(line);
            if (b <= a) {
                System.out.println("Некорректное значение b. b должно быть больше a");
                return;
            }

            System.out.println("Введите точность:");
            line = scanner.next();
            line = line.replace(',', '.');
            double accuracy =  Double.parseDouble(line);
            if (accuracy <= 0) {
                System.out.println("Некорректное значение точности. Точность должна быть больше 0.");
                return;
            }

            SolutionResult result = solutions.get(solutionIndex).calc(functions.get(functionIndex), a, b, accuracy);
            System.out.println("Значение интеграла: " + result.getResult());
            System.out.println("Число разбиения: " + result.getN());

        } catch (Exception e) {
            System.out.println("Произошел сбой при чтении данных.");
        }
    }
}
