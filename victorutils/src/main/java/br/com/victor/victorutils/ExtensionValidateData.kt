package br.com.victor.victorutils

import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.widget.EditText
import java.text.Normalizer
import java.text.SimpleDateFormat
import java.util.*


fun EditText.cleanError(){
    val ed = this
    this.addTextChangedListener(object: TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            ed.error = null
        }
    })
}

fun String.isPhone(): Boolean {
    var phone = this
    phone = unmask(phone)

    return phone.length == 10 || phone.length == 11
}

fun String.isCPF(): Boolean {
    var CPF = this

    CPF = unmask(CPF)

    // considera-se erro CPF's formados por uma sequencia de numeros iguais
    if (CPF == "00000000000" || CPF == "11111111111" || CPF == "22222222222" || CPF == "33333333333" || CPF == "44444444444" || CPF == "55555555555" || CPF == "66666666666" || CPF == "77777777777" || CPF == "88888888888" || CPF == "99999999999" || CPF.length != 11)
        return false

    val dig10: Char
    val dig11: Char
    var sm: Int
    var i: Int
    var r: Int
    var num: Int
    var peso: Int

    // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
    try {
        // Calculo do 1o. Digito Verificador
        sm = 0
        peso = 10
        i = 0
        while (i < 9) {
            // converte o i-esimo caractere do CPF em um numero:
            // por exemplo, transforma o caractere '0' no inteiro 0
            // (48 eh a posicao de '0' na tabela ASCII)
            num = CPF[i].toInt() - 48
            sm = sm + num * peso
            peso = peso - 1
            i++
        }

        r = 11 - sm % 11
        if (r == 10 || r == 11)
            dig10 = '0'
        else
            dig10 = (r + 48).toChar() // converte no respectivo caractere numerico

        // Calculo do 2o. Digito Verificador
        sm = 0
        peso = 11
        i = 0
        while (i < 10) {
            num = CPF[i].toInt() - 48
            sm = sm + num * peso
            peso = peso - 1
            i++
        }

        r = 11 - sm % 11
        if (r == 10 || r == 11)
            dig11 = '0'
        else
            dig11 = (r + 48).toChar()

        // Verifica se os digitos calculados conferem com os digitos informados.
        return if (dig10 == CPF[9] && dig11 == CPF[10])
            true
        else
            false
    } catch (erro: InputMismatchException) {
        return false
    }

}

fun String.isCNPJ(): Boolean {
    var CNPJ = this

    CNPJ = unmask(CNPJ)

    // considera-se erro CNPJ's formados por uma sequencia de numeros iguais
    if (CNPJ == "00000000000000" || CNPJ == "11111111111111" || CNPJ == "22222222222222" || CNPJ == "33333333333333" || CNPJ == "44444444444444" || CNPJ == "55555555555555" || CNPJ == "66666666666666" || CNPJ == "77777777777777" || CNPJ == "88888888888888" || CNPJ == "99999999999999" || CNPJ.length != 14)
        return false

    val dig13: Char
    val dig14: Char
    var sm: Int
    var i: Int
    var r: Int
    var num: Int
    var peso: Int

    // "try" - protege o código para eventuais erros de conversao de tipo (int)
    try {
        // Calculo do 1o. Digito Verificador
        sm = 0
        peso = 2
        i = 11
        while (i >= 0) {
            // converte o i-ésimo caractere do CNPJ em um número:
            // por exemplo, transforma o caractere '0' no inteiro 0
            // (48 eh a posição de '0' na tabela ASCII)
            num = CNPJ[i].toInt() - 48
            sm = sm + num * peso
            peso = peso + 1
            if (peso == 10)
                peso = 2
            i--
        }

        r = sm % 11
        if (r == 0 || r == 1)
            dig13 = '0'
        else
            dig13 = (11 - r + 48).toChar()

        // Calculo do 2o. Digito Verificador
        sm = 0
        peso = 2
        i = 12
        while (i >= 0) {
            num = CNPJ[i].toInt() - 48
            sm = sm + num * peso
            peso = peso + 1
            if (peso == 10)
                peso = 2
            i--
        }

        r = sm % 11
        if (r == 0 || r == 1)
            dig14 = '0'
        else
            dig14 = (11 - r + 48).toChar()

        // Verifica se os dígitos calculados conferem com os dígitos informados.
        return if (dig13 == CNPJ[12] && dig14 == CNPJ[13])
            true
        else
            false
    } catch (erro: InputMismatchException) {
        return false
    }
}

fun String.isEmail(): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun String.isBirthdate(): Boolean {
    try {
        var date = this
        date = unmask(date)

        if(date.length == 8) {
            val toISO = SimpleDateFormat("ddMMyyyy", Locale.getDefault())
            val isoDate = toISO.parse(date)

            return isoDate.time < Calendar.getInstance().timeInMillis
        }else{
            return false
        }
    } catch (e: Exception) {
        return false
    }

}