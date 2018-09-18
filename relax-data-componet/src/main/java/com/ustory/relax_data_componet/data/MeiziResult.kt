package com.ustory.relax_data_componet.data

/**
 * Created by qiyue on 2018/7/10.
 */

class MeiziResult {
    var showapi_res_error: String? = null
    var showapi_res_code: Int = 0
    var showapi_res_body: ShowapiResBodyBean? = null

    override fun toString(): String {
        return "MeiziResult{" +
                "showapi_res_error='" + showapi_res_error + '\''.toString() +
                ", showapi_res_code=" + showapi_res_code +
                ", showapi_res_body=" + showapi_res_body +
                '}'.toString()
    }

    class ShowapiResBodyBean {

        var ret_code: Int = 0
        var pagebean: PagebeanBean? = null

        override fun toString(): String {
            return "ShowapiResBodyBean{" +
                    "ret_code=" + ret_code +
                    ", pagebean=" + pagebean +
                    '}'.toString()
        }

        class PagebeanBean {


            var allPages: Int = 0
            var currentPage: Int = 0
            var allNum: Int = 0
            var maxResult: Int = 0
            var contentlist: List<ContentlistBean>? = null

            override fun toString(): String {
                return "PagebeanBean{" +
                        "allPages=" + allPages +
                        ", currentPage=" + currentPage +
                        ", allNum=" + allNum +
                        ", maxResult=" + maxResult +
                        ", contentlist=" + contentlist +
                        '}'.toString()
            }

            class ContentlistBean {


                var typeName: String? = null
                var title: String? = null
                var type: Int = 0
                var itemId: String? = null

                var ct: String? = null
                var list: List<ListBean>? = null

                override fun toString(): String {
                    return "ContentlistBean{" +
                            "typeName='" + typeName + '\''.toString() +
                            ", title='" + title + '\''.toString() +
                            ", type=" + type +
                            ", itemId='" + itemId + '\''.toString() +
                            ", ct='" + ct + '\''.toString() +
                            ", list=" + list +
                            '}'.toString()
                }

                class ListBean {
                    /**
                     * big : http://image.tianjimedia.com/uploadImages/2016/072/06/Y6717GU52BOW.jpg
                     * middle : http://image.tianjimedia.com/uploadImages/2016/072/06/Y6717GU52BOW_680x500.jpg
                     * small : http://image.tianjimedia.com/uploadImages/2016/072/06/Y6717GU52BOW_113.jpg
                     */

                    var big: String? = null
                    var middle: String? = null
                    var small: String? = null
                }
            }
        }
    }
}
