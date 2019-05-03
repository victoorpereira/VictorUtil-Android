package br.com.victor.victorutils

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

enum class UtilsMaskFormats(val maskFormat: String) {
    birthdate("##/##/####"),
    cpf("###.###.###-##"),
    creditCardExpiration("##/####"),
    creditCardNumber("#### #### #### ####"),
    cep("#####-###"),
    phone("(##)#####-####"),
    cnpj("##.###.###/####-##"),
    rg("###.###.###"),
    hour("##:##")
}

fun maskInsert(mask: UtilsMaskFormats, editText: EditText) = maskInsert(mask.maskFormat, editText)

fun maskInsert(mask: String, ediTxt: EditText): TextWatcher {
    return object : TextWatcher {
        internal var isUpdating: Boolean = false
        internal var old = ""

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            val str = unmask(s.toString())
            var mascara = ""
            if (isUpdating) {
                old = str
                isUpdating = false
                return
            }

            var index = 0
            for (i in 0 until mask.length) {
                val m = mask[i]
                if (m != '#') {
                    if (index == str.length && str.length < old.length) {
                        continue
                    }
                    mascara += m
                    continue
                }

                try {
                    mascara += str[index]
                } catch (e: Exception) {
                    break
                }

                index++
            }

            if (mascara.length > 0) {
                var last_char = mascara[mascara.length - 1]
                var hadSign = false
                while (isASign(last_char) && str.length == old.length) {
                    mascara = mascara.substring(0, mascara.length - 1)
                    last_char = mascara[mascara.length - 1]
                    hadSign = true
                }

                if (mascara.length > 0 && hadSign) {
                    mascara = mascara.substring(0, mascara.length - 1)
                }
            }

            isUpdating = true
            ediTxt.setText(mascara)
            ediTxt.setSelection(mascara.length)
        }

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

        override fun afterTextChanged(s: Editable) {}
    }
}

fun isASign(c: Char): Boolean {
    return if (c == '.' || c == '-' || c == '/' || c == '(' || c == ')' || c == ',' || c == ' ') {
        true
    } else {
        false
    }
}

fun unmask(s: String): String {
    return s.replace("[.]".toRegex(), "").replace("[-]".toRegex(), "")
            .replace("[/]".toRegex(), "").replace("[(]".toRegex(), "")
            .replace("[)]".toRegex(), "").replace(" ".toRegex(), "")
            .replace(",".toRegex(), "").replace(":","")
}


