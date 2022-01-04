package by.kuzmich.taskwizard.model;

public class User<I extends ID> {

    private I identification;
    private String firstName;
    private String email;
    private String birthDate;
    private int age;

    public User() {
    }

    public static class Builder<I extends ID> {

        private I identification;
        private String firstName;
        private String email;
        private String birthDate;
        private int age;

        private Builder() {
        }

        public static <I extends ID> Builder builder() {
            return new Builder<I>();
        }

        public Builder withIdentification (I identification) {
            this.identification = identification;
            return this;
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

        public User<I> build() {

            User<I> user = new User<I>();
            user.identification = identification;
            user.firstName = firstName;
            user.email = email;
            user.birthDate = birthDate;
            user.age = age;
            return user;
        }

    }

    @Override
    public String toString() {
        return "User: " + "\r\n" +
                "User ID: " + identification + "\r\n" +
                "First name: " + firstName + "\r\n" +
                "Email: " + email + "\r\n" +
                "Date of birth: " + birthDate + "\r\n" +
                "Age: " + age;

    }
}