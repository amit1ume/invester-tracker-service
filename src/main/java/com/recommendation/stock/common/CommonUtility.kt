package com.recommendation.stock.common

import com.recommendation.stock.dto.StockList

object CommonUtility {
    fun getStockList():MutableList<StockList> {
        val stocksList = mutableListOf<StockList>()
        with(stocksList) {
            add(StockList("360 ONE WAM Ltd.", "Financial Services", "360ONE"))
            add(StockList("3M India Ltd.", "Diversified", "3MINDIA"))
            add(StockList("ABB India Ltd.", "Capital Goods", "ABB"))
            add(StockList("ACC Ltd.", "Construction Materials", "ACC"))
            add(StockList("AIA Engineering Ltd.", "Capital Goods", "AIAENG"))
            add(StockList("APL Apollo Tubes Ltd.", "Capital Goods", "APLAPOLLO"))
            add(StockList("AU Small Finance Bank Ltd.", "Financial Services", "AUBANK"))
            add(StockList("Aarti Industries Ltd.", "Chemicals", "AARTIIND"))
            add(StockList("Aavas Financiers Ltd.", "Financial Services", "AAVAS"))
            add(StockList("Abbott India Ltd.", "Healthcare", "ABBOTINDIA"))
            add(StockList("Action Construction Equipment Ltd.", "Capital Goods", "ACE"))
            add(StockList("Adani Energy Solutions Ltd.", "Power", "ADANIENSOL"))
            add(StockList("Adani Enterprises Ltd.", "Metals & Mining", "ADANIENT"))
            add(StockList("Adani Green Energy Ltd.", "Power", "ADANIGREEN"))
        }
        return stocksList
    }
}