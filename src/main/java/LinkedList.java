public class LinkedList<T> {

    private int size;
    private Element<T> element;

    public class Element<T> {

        private T dataOfElement;
        private Element<T>  nextElement;
        private Element<T>  previousElement;

        public Element(T dataGiven) {
            this.dataOfElement = dataGiven;
            this.nextElement = null;
            this.previousElement = null;
        }
    }

    public LinkedList() {
        size = 0;
        element = null;
    }



    private boolean isEmpty() {
        if (size == 0) {
            return (true);
        } else {
            return (false);
        }
    }

    private void goToPositionnedElementWithPosition(int positionGiven) {
        for (int i = 1; i < positionGiven && this.element.nextElement != null; i++) {
            this.element = this.element.nextElement;
        }
    }

    private void goToPositionnedElementWithData(T dataGiven) {
        for (int i = 1; i < numberTotalOfElements() && this.element.nextElement != null; i++) {
            if (!(this.element.dataOfElement.equals(dataGiven))) {
                this.element = this.element.nextElement;
            }
        }
    }

    private void comeBackToFirstElement() {
        while (this.element.previousElement != null) {
            this.element = this.element.previousElement;
        }
    }


    public void showAllContentOfElements() {
        for (int i = 1; i < numberTotalOfElements() && this.element.nextElement != null; i++) {
            System.out.println(this.element.dataOfElement);
            this.element = this.element.nextElement;
        }
    }

    public int numberTotalOfElements() {
        return (this.size);
    }

    public void addTheFirstData(T dataToPlace) {
        this.element = new Element<>(dataToPlace);
        this.size++;
    }

    public void addAtFirstPosition(T dataToPlace) {
        if (isEmpty()) {
            addTheFirstData(dataToPlace);
        } else {
            Element<T> newElementToAdd = new Element<>(dataToPlace);
            newElementToAdd.nextElement = this.element;
            this.element.previousElement = newElementToAdd;
            this.size++;
        }
    }

    public void addAtLastPosition(T dataToPlace) {
        if (isEmpty()) {
            addTheFirstData(dataToPlace);
        } else {
            Element<T> newElementToAdd = new Element<>(dataToPlace);
            Element<T> actualLastElement = giveLastElement();
            actualLastElement.nextElement = newElementToAdd;
            newElementToAdd.previousElement = actualLastElement;
            comeBackToFirstElement();
            this.size++;
        }
    }

    public void addAtGivenPosition(T dataToPlace, int positionGiven) {
        if (isEmpty()) {
            addTheFirstData(dataToPlace);
        } else {
            if (positionGiven == 0) {
                addAtFirstPosition(dataToPlace);
            } else if (positionGiven == numberTotalOfElements()) {
                addAtLastPosition(dataToPlace);
            } else {
                goToPositionnedElementWithPosition(positionGiven);
                Element<T> newElementToAdd = new Element<>(dataToPlace);
                newElementToAdd.previousElement = this.element;
                if (this.element.nextElement != null) {
                    newElementToAdd.nextElement = this.element.nextElement;
                    this.element.nextElement.previousElement = newElementToAdd;
                }
                this.element.nextElement = newElementToAdd;
            }
            comeBackToFirstElement();
        }
    }

    public void removeAtGivenPosition(int positionGiven) {
        goToPositionnedElementWithPosition(positionGiven);
        this.element.previousElement.nextElement = this.element.nextElement;
        this.element.nextElement.previousElement = this.element.previousElement;
        comeBackToFirstElement();
    }

    public void removeAtGivenElement(T dataToRemove) {
        goToPositionnedElementWithData(dataToRemove);
        this.element.previousElement.nextElement = this.element.nextElement;
        this.element.nextElement.previousElement = this.element.previousElement;
        comeBackToFirstElement();
    }

    public Element<T> giveElementAsked(T dataAsked) {
        goToPositionnedElementWithData(dataAsked);
        Element<T> elementFound = this.element;
        comeBackToFirstElement();
        return (elementFound);
    }

    public Element<T> giveFirstElement() {
        comeBackToFirstElement();
        return (this.element);
    }

    public Element<T> giveLastElement() {
        while (this.element.nextElement != null) {
            this.element = this.element.nextElement;
        }
        Element<T> lastElement = this.element;
        comeBackToFirstElement();
        return (lastElement);
    }


}
