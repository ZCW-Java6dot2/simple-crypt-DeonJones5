public class CaesarCipher extends ROT13 {
    private Integer shift;

    public String encrpyt(String text, Integer shift) throws UnsupportedOperationException {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))){
                char ch = (char) (((int) text.charAt(i) + shift - 65) % 26 + 65);
                sb.append(ch);
            } else if (Character.isUpperCase(text.charAt(i))){
                char ch = (char) (((int) text.charAt(i) + shift - 97) % 26 + 97);
                sb.append(ch);
            } else {
                sb.append(text.charAt(i));
            }

        }
        return sb.toString();
    }
}
