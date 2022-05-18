public class Element {
    private int value;
    private int reflex;
    private Element prev;
    private Element next;

    public Element() {
        this.value = 0;
        this.reflex = 0;
        this.prev = null;
        this.next = null;
    }

    public Element(int value, int reflex) {
        this.value = value;
        this.reflex = reflex;
        this.prev = null;
        this.next = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getReflex() {
        return reflex;
    }

    public void setReflex(int reflex) {
        this.reflex = reflex;
    }

    public Element getPrev() {
        return prev;
    }

    public void setPrev(Element prev) {
        this.prev = prev;
    }

    public Element getNext() {
        return next;
    }

    public void setNext(Element next) {
        this.next = next;
    }

    public void addElementAfter(Element element) {
        this.next.setPrev(element);
        element.setNext(this.next);

        this.next = element;
        element.setPrev(this);
    }

    public void addElementBefore(Element element) {
        this.prev.setNext(element);
        element.setPrev(this.prev);

        this.prev = element;
        element.setNext(this);
    }

}
