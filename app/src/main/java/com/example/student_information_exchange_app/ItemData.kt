package com.example.student_information_exchange_app

data class ItemData(var ProductName: String, var Price:String,var Description:String, var Image_Uri: String){

    constructor() : this("dummy name", "dummy price", "dummy description", "image")
    ///Empty constructor needed


}