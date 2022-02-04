public class TwoDimensionalArray {
    public static char symbol = 'X';

    public static char[][] getTwoDimensionalArray(int size) {
        char[][] field = new char[size][size];
        for(int i = 0; i < field.length; i++){
            for(int j = 0; j < field[i].length; j++){
                if(i == j || (field.length - 1 - i) == j){
                    field[i][j] = symbol;
                } else {
                    field[i][j] = ' ';
                }
            }
        }
        return field;
    }

    public static String toString(char[][] arr){
        StringBuilder builder = new StringBuilder();
        for (char[] chars : arr) {
            builder.append(chars).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
