package ru.orlovegor.anagrams

fun flipString(text: String?, ignoreCharacters: String?): String {
    if (text == null || ignoreCharacters == null) {
        return ERROR_MESSAGE_NOT_UTF_8_FORMAT_OR_NULL
    } else {
        var newText = arrayOf<String>()
        for (word in text.split(" ")) {
            val newArray = word.toCharArray()
            var indexR = word.length - 1
            var indexL = 0
            while (indexL < indexR) {
                when {
                    ignoreCharacters.contains(word[indexL]) -> indexL++
                    ignoreCharacters.contains(word[indexR]) -> indexR--
                    else -> {
                        newArray[indexL] = newArray[indexR]
                        newArray[indexR] = word[indexL]
                        indexL++
                        indexR--
                    }
                }
            }
            newText += newArray.joinToString("")
        }
        return newText.joinToString(" ")
    }
}

fun checkingTextForValidCharactersAndNull(expectedText: String?) =
    expectedText?.any {
        Character.getType(it) == Character.SURROGATE.toInt() || Character.getType(it) ==
                Character.OTHER_SYMBOL.toInt()
    } ?: true