package com.example.junit

object RegistrationUtils {

    private val existingUser = arrayListOf<String>("Anusha", "Amith")

    /**
     * The input is not valid only if
     * username/password is empty
     * username is already taken
     * password is not matching real password
     * password contains less than 2 characters
     */
    fun validateRegistrationInput(
        userName: String,
        password: String,
        confirmPassword: String
    ): Boolean {
        if (userName.isEmpty() || password.isEmpty()) {
            return false
        }

        if (userName in existingUser) {
            return false
        }

        if (!password.equals(confirmPassword)) {
            return false
        }

        if (password.length < 2) {
            return false
        }
        return true

    }
}