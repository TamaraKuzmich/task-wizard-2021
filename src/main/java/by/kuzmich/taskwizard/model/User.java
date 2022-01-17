package by.kuzmich.taskwizard.model;

public class User<I> {

    private I identification;
    private String firstName;
    private String email;
    private String birthDate;
    private int password;

    public static class Builder<I> {

        private I identification;
        private String firstName;
        private String email;
        private String birthDate;
        private int password;



        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder withIdentification(I identification) {
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

        public Builder withPassword(int password) {
            this.password = password;
            return this;
        }

        public User<I> build() {

            User<I> user = new User<>();
            user.identification = identification;
            user.firstName = firstName;
            user.email = email;
            user.birthDate = birthDate;
            user.password = password;
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
                "Age: " + password;

    }


}