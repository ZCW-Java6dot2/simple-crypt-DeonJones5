import java.io.*;

public class ROT13  {
    private Character charStart;
    private Character charFinish;
    private Integer shift;

    ROT13(Character charStart, Character charFinish) {
        this.charStart = charStart;
        this.charFinish = charFinish;
        this.shift = charFinish - charStart;

    }

    ROT13() {
        this.shift = 13;
    }


    public String crypt(String text) throws UnsupportedOperationException {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'm'){
                ch += this.shift;
            } else if (ch >= 'A' && ch <= 'M'){
                ch += this.shift;
            } else if (ch >= 'n' && ch <= 'z'){
                ch -= (26 - this.shift);
            } else if (ch >= 'N' && ch <= 'Z'){
                ch -= (26 - this.shift);
            }
                sb.append(ch);
            }

            return sb.toString();
        }


    public String encryptNDecrypt(String text) {

        return crypt(text);
    }

    public static String rotate(String s, Character c) {
        StringBuilder sb = new StringBuilder();
        int ch = s.indexOf(c);
        String backSplice = s.substring(ch);
        String frontSplice = s.substring(0, ch);
        sb.append(backSplice).append(frontSplice);
        return sb.toString();
    }


    public void encryptSonnet(File file){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter("sonnet18.enc"));
            String line;

            while ((line = reader.readLine()) != null){
                writer.write(encryptNDecrypt(line) + "\n");
            }
            writer.close();
            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deryptSonnet(File file){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter("sonnet18.dec"));
            String line;

            while ((line = reader.readLine()) != null){
                writer.write(encryptNDecrypt(line) + "\n");
            }
            writer.close();
            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    }





