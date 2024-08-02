package com.recommendation.stock.dto

import java.io.Serializable
import java.util.*

data class FormInput (
    val input_type: String,
    val key: String,
    val label: String?,
    val is_compulsory: Boolean,
    val error: String?,
    val hint: String?,
    val list_inputs: ArrayList<FormInput>?,
    val line_count: Int=0,
    val number_of_columns: Int=0,
    val value: Any?=null,
    val option_list: MutableList<OptionList> = mutableListOf(),
    val radio_display_option: String?=null,
    val drop_down_display_option : String?=null,
    val minimum_value : Long?=null,
    val maximum_value : Long?=null,
)

data class OptionList(
    val id: String,
    val display_text: String?,
    val order: Int,
    //val icon_images : Image?,
    //val default_images : Image?,
    val key: String,
) : Serializable