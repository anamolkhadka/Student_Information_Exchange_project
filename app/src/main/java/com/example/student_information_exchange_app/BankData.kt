package com.example.student_information_exchange_app

data class BankData(var Host:String,var Provider: String, var Type:String,var Routing:String, var Account: String){

    constructor() : this("blank","blank", "blank", "blank", "blank")
    ///Empty constructor needed


}