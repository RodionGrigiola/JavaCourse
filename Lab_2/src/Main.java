import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // Problem_1
        String s = "abcabcbbcabccabdacsfv";
        String longest = problem_1(s);
        System.out.println("Наибольшая подстрока с уникальными символами: " + longest);

        // Problem_2
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};
        int[] mergedArray = problem_2(arr1, arr2);
        System.out.print("Массив после слияния: ");
        for (int num : mergedArray) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Problem_3
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSum = problem_3(nums);
        System.out.println("Максимальная сумма подмассива: " + maxSum);

        // Problem_4
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Исходная матрица:");
        printMatrix(matrix);

        int[][] resultMatrix = problem_4(matrix);

        System.out.println("\nМатрица, повернутая на 90 градусов по часовой стрелке:");
        printMatrix(resultMatrix);

        // Problem_5
        int[] nums_2 = {3, 12, 52, 11, 9, 18};
        int target = 20;
        int[] result = problem_5(nums_2, target);

        if (result != null) {
            System.out.println("Пара элементов, сумма которых равна " + target + ": " + result[0] + ", " + result[1]);
        } else {
            System.out.println("Такая пара не существует.");
        }

        // Problem_6
        int totalSum = problem_6(matrix);
        System.out.println("Сумма всех элементов в двумерном массиве: " + totalSum);

        // Problem_7
        int[] maxElementsInMatrixRows = problem_7(matrix);

        System.out.print("Максимальные элементы в каждой строке: ");
        for (int maxElement : maxElementsInMatrixRows) {
            System.out.print(maxElement + " ");
        }
    }

    static String problem_1(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int end; // Конечный индекс подстроки
        int maxLength = 0; // Максимальная длина подстроки
        int currentStart = 0; // Начальный индекс текущей подстроки
        int currentLength = 0; // Текущая длина подстроки
        String longestSubstring = ""; // Наибольшая подстрока без повторяющихся символов

        for (end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            // Проверяем, если текущий символ повторяется в текущей подстроке
            for (int i = currentStart; i < end; i++) {
                if (s.charAt(i) == currentChar) {
                    currentStart = i + 1; // Обновляем начальный индекс текущей подстроки
                    break;
                }
            }

            currentLength = end - currentStart + 1;

            if (currentLength > maxLength) {
                maxLength = currentLength;
                longestSubstring = s.substring(currentStart, end + 1);
            }
            System.out.println(longestSubstring);
        }

        return longestSubstring;
    }


    static int[] problem_2(int[] arr1, int[] arr2) {
        int[] mergedArray = new int[arr1.length + arr2.length];
        int index1 = 0; // Индекс для массива arr1
        int index2 = 0; // Индекс для массива arr2
        int mergedIndex = 0; // Индекс для объединенного массива

        while (index1 < arr1.length && index2 < arr2.length) {
            if (arr1[index1] < arr2[index2]) {
                mergedArray[mergedIndex++] = arr1[index1++];
            } else {
                mergedArray[mergedIndex++] = arr2[index2++];
            }
        }

        // Если остались элементы в одном из массивов, добавляем их в объединенный массив
        while (index1 < arr1.length) {
            mergedArray[mergedIndex++] = arr1[index1++];
        }

        while (index2 < arr2.length) {
            mergedArray[mergedIndex++] = arr2[index2++];
        }

        return mergedArray;
    }

    static int problem_3(int[] nums) {
        if (nums == null || nums.length == 0) throw new IllegalArgumentException("Пустой массив.");

        int maxSum = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    static int[][] problem_4(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix.length != matrix[0].length) {
            throw new IllegalArgumentException("Ошибка при создании матрицы");
        }

        int n = matrix.length;
        int[][] rotatedMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotatedMatrix[i][j] = matrix[n - 1 - j][i];
            }
        }

        return rotatedMatrix;
    }

    public static int[] problem_5(int[] nums, int target) {
        // Сначала отсортируем массив
        Arrays.sort(nums);

        int left = 0; // Указатель на начало массива
        int right = nums.length - 1; // Указатель на конец массива

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{nums[left], nums[right]};
            } else if (sum < target) {
                left++; // Увеличиваем указатель на начало массива, чтобы увеличить сумму
            } else {
                right--; // Уменьшаем указатель на конец массива, чтобы уменьшить сумму
            }
        }

        return null;
    }

    static int problem_6(int[][] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
            }
        }

        return sum;
    }

    static int[] problem_7(int[][] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Ошибка при создании матрицы");
        }

        int numRows = arr.length;
        int[] maxElements = new int[numRows];

        for (int i = 0; i < numRows; i++) {
            int max = Integer.MIN_VALUE;

            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }

            maxElements[i] = max;
        }

        return maxElements;
    }

    static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }


}


