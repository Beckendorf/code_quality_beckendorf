package com.company;

public class LinkedList<T> {

    int size;
    LinkedListElement<T> element;

    public class LinkedListElement<T> {

        public LinkedListElement(T data) {
            this.data = data;
            this.previous = null;
            this.next = null;
        }

        T data;
        LinkedListElement<T> previous;
        LinkedListElement<T> next;
    }

    public LinkedList() {
        size = 0;
        element = null;
    }

    public void stdoutDisplay() {
        if (element != null) {
            System.out.println(element.data);
            element = element.next;
        }
        while (element != null && element.next != null) {
            System.out.println(element.data);
            element = element.next;
        }
        if (element != null)
            System.out.println(element.data);
        resetHead();
    }

    public Boolean isEmpty() {
        if (size == 0) {
            return (true);
        } else {
            return (false);
        }
    }

    public void addFront(T data) {
        if (isEmpty()) {
            this.element = new LinkedListElement<>(data);
            size++;
        } else {
            LinkedListElement<T> newElement = new LinkedListElement<>(data);
            newElement.next = element;
            element.previous = newElement;
            element = newElement;
            size++;
        }
    }

    public void addLast(T data) {
        if (isEmpty()) {
            this.element = new LinkedListElement<>(data);
            size++;
        } else {
            LinkedListElement<T> newElement = new LinkedListElement<>(data);
            LinkedListElement<T> lastElement = getLastElement();
            lastElement.next = new LinkedListElement<>(data);;
            newElement.previous = lastElement;
            resetHead();
            size++;
        }
    }

    public void addAtPos(T data, int pos) {
        if (isEmpty()) {
            this.element = new LinkedListElement<>(data);
            size++;
        } else {
            if (pos == 0) {
                LinkedListElement<T> newElement = new LinkedListElement<>(data);
                newElement.next = element;
                element.previous = newElement;
            } else {
                goToPos(pos);
                LinkedListElement<T> newElement = new LinkedListElement<>(data);
                newElement.previous = element;
                if (element.next != null) {
                    newElement.next = element.next;
                    element.next.previous = newElement;
                }
                element.next = newElement;
            }
            resetHead();
        }
    }

    public void removeAtPos(int pos) {
        element = goToPos(pos);
        removeCurrentElement();
        resetHead();
    }

    private void removeCurrentElement() {
        if (element.previous != null && element.next != null) {
            element.previous.next = element.next;
            element.next.previous = element.previous;
        }
    }

    public void removeElementFromValue(T elementToRemove) {
        element = findElement(elementToRemove);
        removeCurrentElement();
        resetHead();
    }

    private LinkedListElement<T> findElement(T elementToRemove) {
        Boolean found = false;

        while (element.next != null) {
            if (element.data.equals(elementToRemove)){
                found = true;
                break;
            }
            element = element.next;
        }
        return (element);
    }

    private LinkedListElement<T> goToPos(int pos) {
        for (int i = 0; i < pos && element.next != null; i++) {
            element = element.next;
        }
        return (element);
    }

    private void resetHead() {
        while (element.previous != null) {
            element = element.previous;
        }
    }

    private LinkedListElement<T> getLastElement() {
        while (element.next != null) {
            element = element.next;
        }
        return (element);
    }
}
