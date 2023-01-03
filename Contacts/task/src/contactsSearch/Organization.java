package contactsSearch;

public class Organization extends Record {
    private String organizationName;
    private String address;

    public Organization() {
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationName() {
        return this.organizationName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    @Override
    public String getShortInfo() {
        return getOrganizationName();
    }

    @Override
    public String getFullInfo() {
        return getOrganizationName()+ " " + getAddress() + " " + getNumber();
    }

    @Override
    public void printInfo() {
        System.out.println("Organization name: " + this.getOrganizationName());
        System.out.println("Address: " + this.getAddress());
        System.out.println("Number: " + this.getNumber());
        System.out.println("Time created: " + this.getCreationDate());
        System.out.println("Time last edit: " + this.getEditionDate());
    }

    @Override
    public String getFields() {
        return "name, address, number";
    }

    @Override
    public void setField(String field, String value) {
        switch (field) {
            case "name":
                setOrganizationName(value);
                break;
            case "address":
                setAddress(value);
                break;
            case "number":
                setNumber(value);
                break;
        }
    }

    @Override
    public String getField(String field) {
        switch (field) {
            case "name":
                return getOrganizationName();
            case "address":
                return getAddress();
            case "number":
                return getNumber();
            default:
                return getOrganizationName();
        }
    }
}
