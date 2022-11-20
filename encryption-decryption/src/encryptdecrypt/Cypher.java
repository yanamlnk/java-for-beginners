package encryptdecrypt;

abstract class Cypher {

    String mode = "enc";
    String text = "";
    int key = 0;
    String inputFile = "";
    boolean isData = false;
    boolean isOutputFile = false;
    String outputFile = "";

    abstract String encrypt(String textEnc, int keyEnc);

    abstract String decrypt(String textDec, int keyDec);

    public String cypher() {
        switch (mode) {
            case "enc": return encrypt(text, key);
            case "dec": return decrypt(text, key);
        }
        return null;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public String getInputFile() {
        return this.inputFile;
    }

    public void setOutputFile(String outputFile) {
        this.outputFile = outputFile;
    }

    public String getOutputFile() {
        return this.outputFile;
    }

    public void setIsOutputFile(boolean isOutputFile) {
        this.isOutputFile = isOutputFile;
    }

    public boolean getIsOutputFile() {
        return this.isOutputFile;
    }

    public void setIsData(boolean isData) {
        this.isData = isData;
    }

    public boolean getIsData() {
        return this.isData;
    }
}
