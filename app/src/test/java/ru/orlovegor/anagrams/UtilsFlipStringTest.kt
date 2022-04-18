package ru.orlovegor.anagrams

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class UtilsFlipStringTest(
    private val text: String?,
    private val ignoreSymbol: String?,
    private val expectedParams: String
) {

    @Test
    fun parametrizedTestFlipString() {
        assertEquals(expectedParams, flipString(text, ignoreSymbol))
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun stringArguments() = listOf(
            arrayOf(null, "", ERROR_MESSAGE_NOT_UTF_8_FORMAT_OR_NULL),
            arrayOf(null, null, ERROR_MESSAGE_NOT_UTF_8_FORMAT_OR_NULL),
            arrayOf("", null, ERROR_MESSAGE_NOT_UTF_8_FORMAT_OR_NULL),
            arrayOf("Foxminded cool 24/7", "", "dednimxoF looc 7/42"),
            arrayOf("Foxminded cool 24/7", "xl", "dexdnimoF oocl 7/42"),
            arrayOf("Orlov24 Egor17lili 28d*m", "0123456789/*", "volrO24 ilil17rogE 28m*d"),
            arrayOf("", "", ""),
            arrayOf(
                "Like an activity, a fragment has a lifecycle with events that occur" +
                        " when the fragment’s status changes. For instance, an event happens when " +
                        "the fragment becomes visible and active, or when the fragment becomes unused and is" +
                        " removed. You can also add code and behaviors to callbacks for these events as you would" +
                        " for an activity",
                "az",
                "ekiL an a,ytivitc a tnaemgrf sah a elcycefil htiw stneve that rucco nehw" +
                        " eht s’atnemgrf suatts .saegnhc roF ,ecnatsni an tneve sanepph nehw eht tnaemgrf semoceb" +
                        " elbisiv adn a,evitc ro nehw eht tnaemgrf semoceb desunu adn si .devomer uoY nac aosl add edoc" +
                        " adn sroaivheb ot sakcballc rof eseht stneve as uoy dluow rof an aytivitc"
            )
        )
    }
}