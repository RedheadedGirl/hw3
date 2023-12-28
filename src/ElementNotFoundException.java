public class ElementNotFoundException extends RuntimeException {

    public ElementNotFoundException() {
        super("Вы ввели элемент, которого нет в списке: ");
    }
}
