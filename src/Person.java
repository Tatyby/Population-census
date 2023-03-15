public class Person {   //содержащий информацию об имени, возрасте, поле и образовании человека:
    private String name;
    private String family;
    private Integer age;
    private Sex sex;
    private Education education;

    public Person(String name, String family, Integer age, Sex sex, Education education) {
        this.name = name;
        this.family = family;
        this.age = age;
        this.sex = sex;
        this.education = education;
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public Integer getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public Education getEducation() {
        return education;
    }

    @Override
    public String toString() {
        return "Person{" +
                "Имя='" + name + '\'' +
                ", фамилия='" + family + '\'' +
                ", возраст=" + age +
                ", Пол=" + sex +
                ", образование=" + education +
                '}';
    }
}
