package by.kuzmich.taskwizard.model;

public class User<I extends ID> {

    private I identification;
    private String firstName;
    private String email;
    private String birthDate;
    private int age;

    public User() {

    }

    public static class Builder {


        private String firstName;
        private String email;
        private String birthDate;
        private int age;

        private Builder() {

        }

        public static Builder builder() {
            return new Builder();
        }


        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withBirthDate(String birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public Builder withAge(int age) {
            this.age = age;
            return this;
        }

        public User build() {

            User User = new User();
            User.firstName = firstName;
            User.email = email;
            User.birthDate = birthDate;
            User.age = age;
            return User;
        }

    }
}