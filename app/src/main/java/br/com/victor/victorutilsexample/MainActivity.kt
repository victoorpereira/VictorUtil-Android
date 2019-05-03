package br.com.victor.victorutilsexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.victor.victorutils.*
import br.com.victor.victorutilsexample.model.ExampleData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Set Toasts
        setToasts()

        //Set Dialogs
        setDialogs()

        //Set Date Format
        setDateFormat("2019-02-22T10:53:24-03:00")
        dateToFormatTxtView.text = "2019-02-22T10:53:24-03:00"

        //Set system manipulation
        setSystem()

        //Set masks
        setMasks()

        //Set validators
        validateBtn.setOnClickListener {
            setValidators()
            hideKeyboard()
        }

        //Get local data
        getLocalData()

        //Delet local data
        eraseBtn.setOnClickListener {
            deleteLocalData()
        }

        //Set open maps
        setMaps()

        //Set toCurrency
        val valueFloat:Float = 123.123f
        val valueDouble:Double = 321.321
        val valueInt:Int = 213
        setToCurrency(valueFloat, valueDouble, valueInt)
        valueFloatToFormatTxtView.setText(valueFloat.toString())
        valueDoubleToFormatTxtView.setText(valueDouble.toString())
        valueIntToFormatTxtView.setText(valueInt.toString())
    }

    /**
     * Set toast examples
     *
     * @param toast(message:String)
     * or
     * @param toast(message:Int)
     */
    private fun setToasts() {
        toastBtn.setOnClickListener {
            toast("Simple toast test string")
        }

        toastIntBtn.setOnClickListener {
            toast(123456789)
        }

        longtoastBtn.setOnClickListener {
            longToast("Long toast test string")
        }

        longtoastIntBtn.setOnClickListener {
            longToast(987654321)
        }
    }

    /**
     * Set dialog examples
     *
     * @param showDialog(message:String)
     * @param showDialog(title:String, message:String)
     * @param showDialog(title:String, message:String){}
     * @param showDialog(title:String, message:String, positive:String, negative:String){positive:Boolean, negative:Boolean, dialog:DialogInterface}
     * @param showDialog(errors:List<String>)
     * @param showDialog(title:String, errors:List<String>)
     */
    private fun setDialogs() {
        dialogWtoBtn.setOnClickListener {
            showDialog("Dialog message without title")
        }

        dialogWtBtn.setOnClickListener {
            showDialog("Dialog Title", "Dialog message with title")
        }

        dialogSimpleCallBackBtn.setOnClickListener {
            showDialog("Dialog Title", "Dialog message with title and simple callback"){
                toast("Simple Callback")
            }
        }

        dialogMultCallBackBtn.setOnClickListener {
            showDialog("Dialog Title", "Dialog message with title and multiple callbacks", "Positive button", "Negative button"){ positive, negative, dialog ->
                if(positive){
                    toast("You pressed the positive button")
                }

                if(negative){
                    toast("You pressed the negative button")
                }
            }
        }

        val errors: List<String> = listOf("Error number 1", "Error number 2", "Error number 3", "Error number 4")
        dialogListWtoBtn.setOnClickListener {
            showDialog(errors)
        }

        dialogListWtBtn.setOnClickListener {
            showDialog("Dialog Title", errors)
        }
    }

    /**
     * Set ISO date format examples
     *
     * ENUM DATE FORMAT:
     * @param ddMMyyyy("dd/MM/yyyy")
     * @param HHmmss("HH:mm:ss")
     * @param HHmm("HH:mm")
     * @param ddMMyyyyHHmmss("dd/MM/yyyy HH:mm:ss")
     * @param dddeMMMdeyyyy("dd 'de' MMM 'de' yyyy")
     * @param dddeMMMdeyyyyasHHmm("dd 'de' MMM 'de' yyyy 'às' HH:mm")
     * @param ddMMyyyyasHHmm("dd/MM/yyyy 'às' HH:mm")
     *
     * or you can use a custom format by using string instead
     *
     * @param ISOFORMAT(date:String, dateFormat:UtilsDateFormats)
     * @return String
     * @exception Empty string
     *
     * @param ISOFORMAT(date:String, dateFormat:String)
     * @return formatted String
     * @exception Empty string
     *
     * @param ISOFORMATtoDATE(date:String)
     * @return Date
     * @exception null
     *
     */
    private fun setDateFormat(date: String) {
        ddMMyyyyBtn.setOnClickListener {
            dateToFormatTxtView.text = ISOFORMAT(date, UtilsDateFormats.ddMMyyyy)
        }

        HHmmssBtn.setOnClickListener {
            dateToFormatTxtView.text = ISOFORMAT(date, UtilsDateFormats.HHmmss)
        }

        HHmmBtn.setOnClickListener {
            dateToFormatTxtView.text = ISOFORMAT(date, UtilsDateFormats.HHmm)
        }

        ddMMyyyyHHmmssBtn.setOnClickListener {
            dateToFormatTxtView.text = ISOFORMAT(date, UtilsDateFormats.ddMMyyyyHHmmss)
        }

        dddeMMMdeyyyyBtn.setOnClickListener {
            dateToFormatTxtView.text = ISOFORMAT(date, UtilsDateFormats.dddeMMMdeyyyy)
        }

        ddMMyyyyasHHmmBtn.setOnClickListener {
            dateToFormatTxtView.text = ISOFORMAT(date, UtilsDateFormats.ddMMyyyyasHHmm)
        }

        dddeMMMdeyyyyasHHmmBtn.setOnClickListener {
            dateToFormatTxtView.text = ISOFORMAT(date, UtilsDateFormats.dddeMMMdeyyyyasHHmm)
        }

        dateMilliBtn.setOnClickListener {
            if(ISOFORMATtoDATE(date) != null) {
                dateToFormatTxtView.text = ISOFORMATtoDATE(date)?.time.toString()
            }
        }
    }

    /**
     * Set get hash
     */
    private fun setSystem() {
        getHashBtn.setOnClickListener {
            getHash()
        }
    }

    /**
     * Set mask
     *
     * ENUM MASK FORMAT:
     * @param birthdate("##/##/####")
     * @param cpf("###.###.###-##")
     * @param creditCardExpiration("##/####")
     * @param creditCardNumber("#### #### #### ####")
     * @param cep("#####-###")
     * @param phone("(##)#####-####")
     * @param cnpj("##.###.###/####-##")
     * @param rg("###.###.###")
     * @param hour("##:##")
     *
     * or you can use a custom format by using string instead
     *
     * @param EditText.addTextChangedListener(maskInsert(mask:UtilsMaskFormat, EditText)
     * @return Masked field
     *
     * @param EditText.addTextChangedListener(maskInsert(mask:String, EditText)
     * @return Masked field
     */
    private fun setMasks() {
        telefoneInputEdit.addTextChangedListener(maskInsert(UtilsMaskFormats.phone, telefoneInputEdit))
        cpfInputEdit.addTextChangedListener(maskInsert(UtilsMaskFormats.cpf, cpfInputEdit))
        cnpjInputEdit.addTextChangedListener(maskInsert(UtilsMaskFormats.cnpj, cnpjInputEdit))
        birthDateInputEdit.addTextChangedListener(maskInsert(UtilsMaskFormats.birthdate, birthDateInputEdit))
    }

    /**
     * Set validator
     *
     * @param EditText.cleanError()
     *
     * @param String.isPhone()
     * @return Boolean
     *
     * @param String.isCPF()
     * @return Boolean
     *
     * @param String.isCNPJ()
     * @return Boolean
     *
     * @param String.isEmail()
     * @return Boolean
     *
     * @param String.isBirthdate()
     * @return Boolean
     *
     * @param LocalDBimplement.save
     * To save data in local storage
     */
    private fun setValidators() {

        var error = false

        telefoneInputEdit.cleanError()
        cpfInputEdit.cleanError()
        cnpjInputEdit.cleanError()
        emailInputEdit.cleanError()
        birthDateInputEdit.cleanError()

        if(!telefoneInputEdit.text.toString().trim().isPhone()){
            telefoneInputEdit.error = "Invalid phone"
            error = true
        }

        if(!cpfInputEdit.text.toString().trim().isCPF()){
            cpfInputEdit.error = "Invalid CPF"
            error = true
        }

        if(!cnpjInputEdit.text.toString().trim().isCNPJ()){
            cnpjInputEdit.error = "Invalid CNPJ"
            error = true
        }

        if(!emailInputEdit.text.toString().trim().isEmail()){
            emailInputEdit.error = "Invalid e-mail"
            error = true
        }

        if(!birthDateInputEdit.text.toString().trim().isBirthdate()){
            birthDateInputEdit.error = "Invalid birthdate"
            error = true
        }

        if(!error){
            val exampleData = ExampleData()
            exampleData.telefone = telefoneInputEdit.text.toString().trim()
            exampleData.cpf = cpfInputEdit.text.toString().trim()
            exampleData.cnpj = cnpjInputEdit.text.toString().trim()
            exampleData.email = emailInputEdit.text.toString().trim()
            exampleData.birthdate = birthDateInputEdit.text.toString().trim()

            LocalDbImplement<ExampleData>(this@MainActivity).save(exampleData)
            toast("Saved local data!")
        }
    }

    /**
     * Get data from local database
     *
     * @param LocalDBimplement.getDefault
     * To get data in local storage
     */
    private fun getLocalData() {
        if(LocalDbImplement<ExampleData>(this@MainActivity).getDefault(ExampleData::class.java) != null){
            LocalDbImplement<ExampleData>(this@MainActivity).getDefault(ExampleData::class.java).let {
                telefoneInputEdit.setText(it?.telefone)
                cpfInputEdit.setText(it?.cpf)
                cnpjInputEdit.setText(it?.cnpj)
                emailInputEdit.setText(it?.email)
                birthDateInputEdit.setText(it?.birthdate)

                toast("Fill with local data!")
            }
        }
    }

    /**
     * Erase data from local database
     *
     * @param LocalDBimplement.getDefault
     * To get data in local storage
     *
     * @param LocalDBimplement.clearObject
     * To erase data in local storage
     */
    private fun deleteLocalData() {
        if(LocalDbImplement<ExampleData>(this@MainActivity).getDefault(ExampleData::class.java) != null){
            LocalDbImplement<ExampleData>(this@MainActivity).clearObject(ExampleData::class.java)
            toast("Data erased")
            telefoneInputEdit.setText("")
            cpfInputEdit.setText("")
            cnpjInputEdit.setText("")
            emailInputEdit.setText("")
        }else{
            toast("There's nothing to be deleted!")
        }
    }

    /**
     * Set open maps
     *
     * @param openMaps(latitude:String, longitude:String)
     * @param openWaze(latitude:String, longitude:String)
     * @param openGoogleMaps(latitude:String, longitude:String)
     * @param openGoogleMaps(latitude:String, longitude:String, query:String)
     * @param openStreetView(latitude:String, longitude:String)
     *
     */
    private fun setMaps() {
        openMapsChoiceBtn.setOnClickListener {
            openMaps("-25.4341219", "-49.284506")
        }

        openWazeBtn.setOnClickListener {
            openWaze("-25.4341219", "-49.284506")
        }

        openMapsBtn.setOnClickListener {
            openGoogleMaps("-25.4341219", "-49.284506")
        }

        openMapsQueryBtn.setOnClickListener {
            openGoogleMaps("-25.4341219", "-49.284506", "DevMaker Mobile Apps")
        }

        openStreetView.setOnClickListener {
            openGoogleStreetView("-25.433973", "-49.282382")
        }
    }

    /**
     * Set currency and animations
     *
     * @param Float.toCurrency()
     * @return String formatted
     *
     * @param Double.toCurrency()
     * @return String formatted
     *
     * @param Int.toCurrency()
     * @return String formatted
     *
     * @param ConstraintLayout.slideAnimation()
     * @param ConstraintLayout.landingAnimation()
     * @param ConstraintLayout.FadeInAnimation()
     * @param ConstraintLayout.FadeOutAnimation()
     *
     * @param TextView.slideAnimation()
     * @param TextView.landingAnimation()
     * @param TextView.FadeInAnimation()
     * @param TextView.FadeOutAnimation()
     *
     * @param EditText.slideAnimation()
     * @param EditText.landingAnimation()
     * @param EditText.FadeInAnimation()
     * @param EditText.FadeOutAnimation()
     *
     * @param Button.slideAnimation()
     * @param Button.landingAnimation()
     * @param Button.FadeInAnimation()
     * @param Button.FadeOutAnimation()
     *
     */
    private fun setToCurrency(valueFloat: Float, valueDouble: Double, valueInt: Int) {
        floatBtn.setOnClickListener {
            valueFloatToFormatTxtView.text = valueFloat.toCurrency()
            floatBtn.slideAnimation()
            valueFloatToFormatTxtView.slideAnimation()
        }

        doubleBtn.setOnClickListener {
            valueDoubleToFormatTxtView.text = valueDouble.toCurrency()
            doubleBtn.landingAnimation()
            valueDoubleToFormatTxtView.landingAnimation()
        }

        intBtn.setOnClickListener {
            valueIntToFormatTxtView.text = valueInt.toCurrency()
            intBtn.fadeInAnimation()
            valueIntToFormatTxtView.fadeInAnimation()
        }
    }
}
