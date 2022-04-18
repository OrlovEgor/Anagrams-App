package ru.orlovegor.anagrams

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.orlovegor.anagrams.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setButtonClick()
        initTextWatcher()
    }

    private fun getSpecialCharacters() = binding.ignoredCharactersEdittext.text.toString()

    private fun getStringToFlip() = binding.textForAnagramEdittext.text.toString()

    private fun setButtonClick() {
        binding.getAnagramButton.setOnClickListener {
            if (!checkingTextForValidCharactersAndNull(getStringToFlip()) &&
                !checkingTextForValidCharactersAndNull(getSpecialCharacters())
            )
                binding.resultAnagramText.text =
                    flipString(getStringToFlip(), getSpecialCharacters())
            else binding.resultAnagramText.text = ERROR_MESSAGE_NOT_UTF_8_FORMAT_OR_NULL
        }
    }

    private fun initTextWatcher() {
        binding.textForAnagramEdittext.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.getAnagramButton.isEnabled =
                    !p0.isNullOrBlank()
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
    }
}