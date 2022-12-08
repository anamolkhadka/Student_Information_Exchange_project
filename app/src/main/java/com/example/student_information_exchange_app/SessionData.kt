package com.example.student_information_exchange_app

data class SessionData(var Host:String,var Title: String, var Subject:String,var Start:String, var Price: String, var Location:String, var Duration:String, var Description:String, var Date:String, var Capacity:String){

    constructor() : this("blank","blank", "blank", "blank", "blank","blank","blank","blank","blank","blank")
    ///Empty constructor needed


}