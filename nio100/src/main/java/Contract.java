public class Contract {
    private String name;
    private String isin;

    public Contract() {
    }

    public Contract(String name, String isin) {
        this.name = name;
        this.isin = isin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "name='" + name + '\'' +
                ", isin='" + isin + '\'' +
                '}';
    }
}
