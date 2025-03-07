import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class LSBSteganography {

    public static void main(String[] args) {
        try {
            // Carregue a imagem
            BufferedImage image = ImageIO.read(new File("C:\\TEMP\\gato_suspeito.png"));

            String hiddenMessage = extractMessage(image);
            System.out.println("Mensagem escondida: " + hiddenMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String extractMessage(BufferedImage image) {
        StringBuilder message = new StringBuilder();
        int messageLength = 0;
        int charIndex = 0;
        int bitIndex = 0;

        // Percorra cada pixel da imagem
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int pixel = image.getRGB(x, y);

                // Extraia os canais de cor (R, G, B)
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = pixel & 0xff;

                // Extraia os LSBs de cada canal de cor
                int[] channels = {red, green, blue};
                for (int channel : channels) {
                    if (messageLength == 0 && charIndex == 0) {
                        // O primeiro byte indica o comprimento da mensagem
                        messageLength |= (channel & 1) << (7 - bitIndex);
                        bitIndex++;
                        if (bitIndex == 8) {
                            bitIndex = 0;
                            charIndex++;
                        }
                    } else if (messageLength > 0 && charIndex <= messageLength) {
                        // Extraia os bits da mensagem
                        int bit = channel & 1;
                        message.append(bit);
                        if (message.length() % 8 == 0 && message.length() / 8 == charIndex) {
                            charIndex++;
                        }
                    } else {
                        break;
                    }
                }
            }
        }

        // Converta os bits em caracteres
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < message.length(); i += 8) {
            String byteString = message.substring(i, i + 8);
            result.append((char) Integer.parseInt(byteString, 2));
        }

        return result.toString();
    }
}