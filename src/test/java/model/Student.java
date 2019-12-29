package model;

public class Student {
    private long id; // потому что int очень быстро заполнится в случае успешности сервися
    private String name;
    private Integer age;
    private int sexID;
    private String phoneNr; // можно делать int, тогда только цифры и + и ( нельзя
    //Alt+Insert ("Getter and Setter" -> Ctr A - > Enter)


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }
    public String getAgeAsString(){
        return String.valueOf(age); //альтернативный метод, который берет возраст как стринг и делает из него Integer
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public void setAge(String age) {
        this.age = Integer.valueOf(age); //альтернативный метод, который берет возраст как стринг и делает из него Integer
    }

    public int getSexID() {
        return sexID;
    }

    public void setSexID(int sexID) {
        this.sexID = sexID;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }
}

