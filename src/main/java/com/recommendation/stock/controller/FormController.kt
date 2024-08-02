package com.recommendation.stock.controller

import com.recommendation.stock.common.CommonUtility
import com.recommendation.stock.dto.FormInput
import com.recommendation.stock.dto.OptionList
import com.recommendation.stock.extentions.convertToOptionList
import com.recommendation.stock.service.AdviserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.io.IOException
import java.util.*

@RestController
//@RequestMapping("/form")
class FormController {
    @Autowired
    private val adviserService: AdviserService? = null

    @GetMapping( "form/stock_entry")
    @kotlin.Throws(IOException::class)
    fun getStockEntryForm(): ResponseEntity<List<FormInput>> {
        val inputList= ArrayList<FormInput>()
        val stockNameIdList = ArrayList<FormInput>()
        stockNameIdList.add(FormInput("drop_down","shareName","Stock Name",true,"please Select One"
            ,"Share Name",null,0,0,null, CommonUtility.getStockList().convertToOptionList()
        ))
        stockNameIdList.add(FormInput("string","nseId","nseId",false,""
            ,"NSE Id",null,1,0,null, mutableListOf()
        ))

        val advisorTypeOptionList = mutableListOf<OptionList>()
        advisorTypeOptionList.add(OptionList("SHORT","Short",1,"timePeriod"))
        advisorTypeOptionList.add(OptionList("MEDIUM","Medium",2,"timePeriod"))
        advisorTypeOptionList.add(OptionList("LONG","Long",3,"timePeriod"))

        inputList.add(FormInput("radio_box_group","timePeriod","Time period",true,"please select one"
            ,null,null,1,3,null,advisorTypeOptionList))
        inputList.add(FormInput(
            "group","shareNameId","",true,""
            ,"",stockNameIdList,2,1,null, mutableListOf()
        ))
        inputList.add(FormInput("drop_down","adviserId","Adviser Name",true,"please Select One"
            ,"Adviser Name",null,0,0,null, getAllAdvisersList()
        ))

        return ResponseEntity<List<FormInput>>(
            inputList, HttpHeaders(), HttpStatus.OK
        )
    }

    private fun getAllAdvisersList(): MutableList<OptionList> {
        val list = adviserService!!.allAdvisers
        val adviserNameIdList: MutableList<OptionList> = mutableListOf()
        list.forEachIndexed { index,item ->
            adviserNameIdList.add(OptionList(item.id.toString(), item.name, index, "adviserId"))
        }
        return adviserNameIdList
    }
}