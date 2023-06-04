package dto;

public class Person {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }



        @Override
        public int hashCode() {
            int result = firstName == null ? 0 : firstName.hashCode();
            result = 31 * result + (lastName == null ? 0 : lastName.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Person person = (Person) obj;
            if ((firstName == null && person.firstName != null) || (firstName != null && person.firstName == null) ||
                    (lastName == null && person.lastName != null) || (lastName != null && person.lastName == null))
                return false;

            return  firstName.equals(person.firstName) && lastName.equals(person.lastName);

        }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
