public class Main {
    public static void main(String[] args) {

        // Problem_2
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};
        int[] mergedArray = problem_2(arr1, arr2);
        System.out.println("Массив после слияния:");
        for (int num : mergedArray) {
            System.out.print(num + " ");
        }
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

}


