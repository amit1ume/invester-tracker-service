package com.recommendation.stock.extentions

import com.recommendation.stock.dto.OptionList
import com.recommendation.stock.dto.StockList

fun MutableList<StockList>.convertToOptionList():MutableList<OptionList>{
    val optionList = mutableListOf<OptionList>()
    var id=0
    this.forEach {
        optionList.add(OptionList(it.nseId,it.name,++id,it.industry))
    }
    return optionList
}