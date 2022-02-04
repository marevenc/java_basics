public class Main {

    public static void main(String[] args) {

    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {
        int firstDiamondIndex, lastDiamondIndex;
        StringBuilder builder = new StringBuilder();
        int indexOfRemaining = 0;
        firstDiamondIndex = text.indexOf('<');
        lastDiamondIndex = text.indexOf('>');

        if(firstDiamondIndex == -1 || lastDiamondIndex == -1){
            return text;
        }

        if(text.indexOf('<') != text.lastIndexOf('<')
                && text.indexOf('>') != text.lastIndexOf('>')){
            for(int i = 0; i < text.length(); i++){
                if(text.charAt(i) == '<'){
                    builder.append(text.substring(indexOfRemaining, i));
                    builder.append(placeholder);
                }
                if(text.charAt(i) == '>'){
                    indexOfRemaining = i + 1;
                }
            }
            builder.append(text.substring(indexOfRemaining));
        } else {
            builder.append(text.substring(0, firstDiamondIndex));
            builder.append(placeholder);
            builder.append(text.substring(lastDiamondIndex + 1));
        }

        return builder.toString();
    }

}