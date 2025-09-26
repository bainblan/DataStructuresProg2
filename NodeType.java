public class NodeType <T extends Comparable <T>> {
    private T info;
    private NodeType <T> next;
    private NodeType <T> back;

    public NodeType() {
        next = null;
        back = null;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NodeType<T> getNext() {
        return next;
    }

    public void setNext(NodeType<T> next) {
        this.next = next;
    }

    public NodeType<T> getBack() {
        return back;
    }

    public void setBack(NodeType<T> back) {
        this.back = back;
    }
}