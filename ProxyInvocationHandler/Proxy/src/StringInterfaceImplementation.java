public class StringInterfaceImplementation implements StringInterface {

    private String monString;

    public StringInterfaceImplementation(String monString) {
        this.monString = monString;
    }

    public String getString() {
        return monString;
    }

    public void setMonString(String monString) {
        this.monString = monString;
    }

    @Override
    public String substring(int start) {
        return monString.trim().substring(start);
    }

    @Override
    public int hashCode() {
        return monString.hashCode();
    }

    @Override
    public String toString() {
        return monString;
    }
}
