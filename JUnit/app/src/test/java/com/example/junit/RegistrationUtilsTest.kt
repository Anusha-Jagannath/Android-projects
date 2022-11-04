package com.example.junit


import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilsTest {

    @Test
    fun `emptyUserNameReturnsFalse`() {
        val result = RegistrationUtils.validateRegistrationInput("","123","123")
        assertThat(result).isFalse()
    }

    @Test
    fun `emptyPasswordReturnsFalse`() {
        val result = RegistrationUtils.validateRegistrationInput("anusha"," ","123")
        assertThat(result).isFalse()
    }

    @Test
    fun `userNameAlreadyTakenReturnsFalse`() {
        val result = RegistrationUtils.validateRegistrationInput("Anusha"," ","123")
        assertThat(result).isFalse()
    }

    @Test
    fun `passwordAndConfirmPasswordMismatchReturnsFalse`() {
        val result = RegistrationUtils.validateRegistrationInput("Anusha","123","123")
        assertThat(result).isFalse()
    }

    @Test
    fun `passwordLengthLessThanTwoCharactersReturnsFalse`() {
        val result = RegistrationUtils.validateRegistrationInput("Anusha","g","g")
        assertThat(result).isFalse()
    }

    @Test
    fun `username already exists returns false`() {
        val result = RegistrationUtils.validateRegistrationInput("Anusha","1234","1234")
        assertThat(result).isFalse()
    }
}