package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class Workshop {

    static int indexOfElement(String[] array, String element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(element)) {
                return i;
            }
        }
        return 0;
    }

    static boolean checkElement(String[] array, String element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    static void setElementFields(Cypher element, String[] array) {
        if (Workshop.checkElement(array, "-key")) {
            element.setKey(Integer.parseInt(array[1 + Workshop.indexOfElement(array, "-key")]));
        }
        if (Workshop.checkElement(array, "-mode")) {
            element.setMode(array[1 + Workshop.indexOfElement(array, "-mode")]);
        }
        if (Workshop.checkElement(array, "-data")) {
            element.setText(array[1 + Workshop.indexOfElement(array, "-data")]);
            element.setIsData(true);
        }
        if (Workshop.checkElement(array, "-in")) {
            element.setInputFile(array[1 + Workshop.indexOfElement(array, "-in")]);
            try {
                if (!element.getIsData()) {
                    element.setText(Workshop.readFile(element.getInputFile()));
                }
            } catch (IOException e) {
                System.out.printf("Error: %s", e.getMessage());
            }
        }
        if (Workshop.checkElement(array, "-out")) {
            element.setOutputFile(array[1 + Workshop.indexOfElement(array, "-out")]);
            element.setIsOutputFile(true);
        }
    }

    static String readFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    static void outputResults (Cypher element) {
        if (element.getIsOutputFile()) {
            File fileOutput = new File(element.getOutputFile());
            try (FileWriter writer = new FileWriter(fileOutput)) {
                writer.write(element.cypher());
            } catch (IOException e) {
                System.out.printf("Error: %s", e.getMessage());
            }
        } else {
            System.out.println(element.cypher());
        }
    }
}
