package contactsSearch;

public class Person extends Record {
    private String name;
    private String surname;
    private String birthDate;
    private String gender;

    public Person() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setBirthDate(String birthDate) {
        if (birthDate == null || birthDate.equals("")) {
            System.out.println("Bad birth date!");
            this.birthDate = "[no data]";
        } else {
            this.birthDate = birthDate;
        }
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public void setGender(String gender) {
        if (gender.equals("M") || gender.equals("F")) {
            this.gender = gender;
        } else {
            System.out.println("Bad gender!");
            this.gender = "[no data]";
        }
    }

    public String getGender() {
        return this.gender;
    }

    @Override
    public String getShortInfo() {
        return getName()+ " " + getSurname();
    }

    @Override
    public String getFullInfo() {
        return getName()+ " " + getSurname() + " " + getBirthDate() + " " + getGender() + " " + getNumber();
    }

    @Override
    public void printInfo() {
        System.out.println("Name: " + this.getName());
        System.out.println("Surname: " + this.getSurname());
        System.out.println("Birth date: " + this.getBirthDate());
        System.out.println("Gender: " + this.getGender());
        System.out.println("Number: " + this.getNumber());
        System.out.println("Time created: " + this.getCreationDate());
        System.out.println("Time last edit: " + this.getEditionDate());
    }

    @Override
    public String getFields() {
        return "name, surname, birth, gender, number";
    }

    @Override
    public void setField(String field, String value) {
        switch (field) {
            case "name":
                setName(value);
                break;
            case "surname":
                setSurname(value);
                break;
            case "birth":
                setBirthDate(value);
                break;
            case "gender":
                setGender(value);
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
                return getName();
            case "surname":
                return getSurname();
            case "birth":
                return getBirthDate();
            case "gender":
                return getGender();
            case "number":
                return getNumber();
            default:
                return getName();
        }
    }
}
