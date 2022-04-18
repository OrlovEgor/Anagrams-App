package ru.orlovegor.anagrams

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class UtilsCheckSpecialCharacterTest(
    private val text: String?,
    private val expectedParams: Boolean
) {

    @Test
    fun parametrizedTestCheckString() {
        Assert.assertEquals(expectedParams, checkingTextForValidCharactersAndNull(text))
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun stringArguments() = listOf(
            arrayOf("Normal UTF String", false),
            arrayOf("", false),
            arrayOf("௸", true),
            arrayOf("new ༗symbol", true),
            arrayOf(null, true)
        )
    }
}