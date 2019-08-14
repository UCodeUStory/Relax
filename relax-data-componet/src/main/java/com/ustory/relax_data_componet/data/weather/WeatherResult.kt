package com.ustory.relax_data_componet.data.weather

class WeatherResult {

    var weatherinfo: WeatherinfoBean? = null

    class WeatherinfoBean {
        var city: String? = null
        var cityid: String? = null
        var temp: String? = null
        var wd: String? = null

        var ws: String? = null
        var sd: String? = null
        var wse: String? = null
        var time: String? = null
        var radar: String? = null
        var njd: String? = null
        var qy: String? = null



        override fun toString(): String {
            return "WeatherinfoBean{" +
                    "city='" + city + '\''.toString() +
                    ", cityid='" + cityid + '\''.toString() +
                    ", temp='" + temp + '\''.toString() +
                    ", WD='" + wd + '\''.toString() +
                    ", WS='" + ws + '\''.toString() +
                    ", SD='" + sd + '\''.toString() +
                    ", WSE='" + wse + '\''.toString() +
                    ", time='" + time + '\''.toString() +
                    ", Radar='" + radar + '\''.toString() +
                    ", njd='" + njd + '\''.toString() +
                    ", qy='" + qy + '\''.toString() +
                    '}'.toString()
        }
    }
}
