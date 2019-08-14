package com.ustory.relax_business_component.businesscase.wxnews.model

/**
 * Created by qiyue on 2018/7/5.
 */

class WXNewsModel(
    val reason: String,
    val result: ResultModel? = null,
    val error_code: Int
) {


    class ResultModel(
        val totalPage: Int = 0,
        val ps: Int = 0,
        val pno: Int = 0,
        val list: List<ListModel>?=null
    ) {

        override fun toString(): String {
            return "ResultBean{" +
                    "totalPage=" + totalPage +
                    ", ps=" + ps +
                    ", pno=" + pno +
                    ", list=" + list +
                    '}'.toString()
        }

        class ListModel(
            val id: String,
            val title: String,
            val source: String,
            val firstImg: String,
            val mark: String,
            val url: String
        ) {
            /**
             * id : wechat_20180506012503
             * title : 30岁左右，手头有10几20万，这4台合资B级车是首选！
             * source : 有车以后
             * firstImg : http://zxpic.gtimg.com/infonew/0/wechat_pics_-62933322.static/640
             * mark :
             * url : http://v.juhe.cn/weixin/redirect?wid=wechat_20180506012503
             */


            override fun toString(): String {
                return "ListBean{" +
                        "id='" + id + '\''.toString() +
                        ", title='" + title + '\''.toString() +
                        ", source='" + source + '\''.toString() +
                        ", firstImg='" + firstImg + '\''.toString() +
                        ", mark='" + mark + '\''.toString() +
                        ", url='" + url + '\''.toString() +
                        '}'.toString()
            }
        }
    }
}
