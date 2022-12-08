package com.example.student_information_exchange_app

data class CardData(var Host:String,var Provider: String, var Type:String,var Num:String, var Csv: String, var Expiry:String,var Medium:String){

    constructor() : this("blank","blank", "blank", "blank", "blank","blank","blank")
    ///Empty constructor needed


}