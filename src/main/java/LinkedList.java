public class LinkedList<TypeOfData> {

    private int size;
    private Element<TypeOfData> element;

    public class Element<TypeOfData> {

        private TypeOfData dataOfElement;
        private Element<TypeOfData>  nextElement;
        private Element<TypeOfData>  previousElement;

        public Element(TypeOfData dataGiven) {
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

    private void goToPositionnedElementWithData(TypeOfData dataGiven) {
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

    public void addTheFirstData(TypeOfData dataToPlace) {
        this.element = new Element<>(dataToPlace);
        this.size++;
    }

    public void addAtFirstPosition(TypeOfData dataToPlace) {
        if (isEmpty()) {
            addTheFirstData(dataToPlace);
        } else {
            Element<TypeOfData> newElementToAdd = new Element<>(dataToPlace);
            newElementToAdd.nextElement = this.element;
            this.element.previousElement = newElementToAdd;
            this.size++;
        }
    }

    public void addAtLastPosition(TypeOfData dataToPlace) {
        if (isEmpty()) {
            addTheFirstData(dataToPlace);
        } else {
            Element<TypeOfData> newElementToAdd = new Element<>(dataToPlace);
            Element<TypeOfData> actualLastElement = giveLastElement();
            actualLastElement.nextElement = newElementToAdd;
            newElementToAdd.previousElement = actualLastElement;
            comeBackToFirstElement();
            this.size++;
        }
    }

    public void addAtGivenPosition(TypeOfData dataToPlace, int positionGiven) {
        if (isEmpty()) {
            addTheFirstData(dataToPlace);
        } else {
            if (positionGiven == 0) {
                addAtFirstPosition(dataToPlace);
            } else if (positionGiven == numberTotalOfElements()) {
                addAtLastPosition(dataToPlace);
            } else {
                goToPositionnedElementWithPosition(positionGiven);
                Element<TypeOfData> newElementToAdd = new Element<>(dataToPlace);
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

    public void removeAtGivenElement(TypeOfData dataToRemove) {
        goToPositionnedElementWithData(dataToRemove);
        this.element.previousElement.nextElement = this.element.nextElement;
        this.element.nextElement.previousElement = this.element.previousElement;
        comeBackToFirstElement();
    }

    public Element<TypeOfData> giveElementAsked(TypeOfData dataAsked) {
        goToPositionnedElementWithData(dataAsked);
        Element<TypeOfData> elementFound = this.element;
        comeBackToFirstElement();
        return (elementFound);
    }

    public Element<TypeOfData> giveFirstElement() {
        comeBackToFirstElement();
        return (this.element);
    }

    public Element<TypeOfData> giveLastElement() {
        while (this.element.nextElement != null) {
            this.element = this.element.nextElement;
        }
        Element<TypeOfData> lastElement = this.element;
        comeBackToFirstElement();
        return (lastElement);
    }


}
