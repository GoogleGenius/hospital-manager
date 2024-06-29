class Record {
    private String name;

    public Record(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printData() {
        System.out.println("Record:");
        System.out.println("Name: " + name);
    }

    public String toString() {
        return "Record: " + name;
    }
}
