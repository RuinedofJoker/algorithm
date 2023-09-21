package test;

public class JuliusCaesarEncoder {

    public static void main(String[] args) {
        JuliusCaesarEncoder encoder = new JuliusCaesarEncoder(3);
        String encode = encoder.encode("abc");
        System.out.println(encode);
        System.out.println(encoder.decode(encode));
    }
    private int offset;

    public JuliusCaesarEncoder(int offset) {
        this.offset = offset;
    }

    public String encode(String rawWord) {
        StringBuilder builder = new StringBuilder();
        for (char c : rawWord.toCharArray()) {
            builder.append(getCharInCipherTable(c, true));
        }
        return builder.toString();
    }

    public String decode(String rawWord) {
        StringBuilder builder = new StringBuilder();
        for (char c : rawWord.toCharArray()) {
            builder.append(getCharInCipherTable(c, false));
        }
        return builder.toString();
    }

    private char getCharInCipherTable(char c, boolean isBackward) {
        if (isBackward) {
            if (c >= 'a' && c <= 'z') {
                c = (char) (((c - 'a' + offset) % 26) + 'a');
            }else if (c >= 'A' && c <= 'Z') {
                c = (char) (((c - 'A' + offset) % 26) + 'A');
            }
        }else {
            if (c >= 'a' && c <= 'z') {
                c = (char) (((c - 'a' - offset) % 26) + 'a');
            }else if (c >= 'A' && c <= 'Z') {
                c = (char) (((c - 'A' - offset) % 26) + 'A');
            }
        }
        return c;
    }
}
