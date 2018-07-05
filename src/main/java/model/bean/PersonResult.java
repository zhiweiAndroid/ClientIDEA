package model.bean;



/**
 * Created by zitan on 2018/6/6.
 */

public class PersonResult extends HttpResult<PersonResult.Person> {

    public class Person {
        private String name;
        private Integer age;
        private String gender;
        public Person(String name, Integer age, String gender) {
            super();
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public String getName() {
            return name == null ? "" : name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getGender() {
            return gender == null ? "" : gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person [name=" + name + ", age=" + age + ", gender=" + gender + "]";
        }
    }

}
