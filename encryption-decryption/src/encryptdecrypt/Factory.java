package encryptdecrypt;

class Factory {

    public Cypher createObject (String[] array) {
        Cypher element;
        if ("unicode".equals(array[1 + Workshop.indexOfElement(array, "-alg")])) {
            element = new Unicode();
        } else {
            element = new Shift();
        }
        Workshop.setElementFields(element, array);
        return element;
    }
}
