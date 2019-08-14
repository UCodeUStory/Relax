package com.ustory.relax_data_componet.data.weather

/**
 * Created by qiyue on 2018/7/3.
 */

class JHWeatherResult {
    /**
     * resultcode : 200
     * reason : 查询成功
     * result : {"sk":{"temp":"28","wind_direction":"西风","wind_strength":"2级","humidity":"92%","time":"13:30"},"today":{"temperature":"25℃~30℃","weather":"中雨","weather_id":{"fa":"08","fb":"08"},"wind":"北风微风","week":"星期二","city":"池州","date_y":"2018年07月03日","dressing_index":"热","dressing_advice":"天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。","uv_index":"弱","comfort_index":"","wash_index":"不宜","travel_index":"较不宜","exercise_index":"较不宜","drying_index":""},"future":{"day_20180703":{"temperature":"25℃~30℃","weather":"中雨","weather_id":{"fa":"08","fb":"08"},"wind":"北风微风","week":"星期二","date":"20180703"},"day_20180704":{"temperature":"27℃~32℃","weather":"雷阵雨转多云","weather_id":{"fa":"04","fb":"01"},"wind":"西南风3-5级","week":"星期三","date":"20180704"},"day_20180705":{"temperature":"26℃~34℃","weather":"雷阵雨转中雨","weather_id":{"fa":"04","fb":"08"},"wind":"南风3-5级","week":"星期四","date":"20180705"},"day_20180706":{"temperature":"24℃~32℃","weather":"中雨转小雨","weather_id":{"fa":"08","fb":"07"},"wind":"西南风微风","week":"星期五","date":"20180706"},"day_20180707":{"temperature":"24℃~28℃","weather":"小雨","weather_id":{"fa":"07","fb":"07"},"wind":"西北风微风","week":"星期六","date":"20180707"},"day_20180708":{"temperature":"27℃~32℃","weather":"雷阵雨转多云","weather_id":{"fa":"04","fb":"01"},"wind":"西南风3-5级","week":"星期日","date":"20180708"},"day_20180709":{"temperature":"24℃~32℃","weather":"中雨转小雨","weather_id":{"fa":"08","fb":"07"},"wind":"西南风微风","week":"星期一","date":"20180709"}}}
     * error_code : 0
     */

    var resultcode: String? = null
    var reason: String? = null
    var result: ResultBean? = null
    var error_code: Int = 0

    class ResultBean {
        /**
         * sk : {"temp":"28","wind_direction":"西风","wind_strength":"2级","humidity":"92%","time":"13:30"}
         * today : {"temperature":"25℃~30℃","weather":"中雨","weather_id":{"fa":"08","fb":"08"},"wind":"北风微风","week":"星期二","city":"池州","date_y":"2018年07月03日","dressing_index":"热","dressing_advice":"天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。","uv_index":"弱","comfort_index":"","wash_index":"不宜","travel_index":"较不宜","exercise_index":"较不宜","drying_index":""}
         * future : {"day_20180703":{"temperature":"25℃~30℃","weather":"中雨","weather_id":{"fa":"08","fb":"08"},"wind":"北风微风","week":"星期二","date":"20180703"},"day_20180704":{"temperature":"27℃~32℃","weather":"雷阵雨转多云","weather_id":{"fa":"04","fb":"01"},"wind":"西南风3-5级","week":"星期三","date":"20180704"},"day_20180705":{"temperature":"26℃~34℃","weather":"雷阵雨转中雨","weather_id":{"fa":"04","fb":"08"},"wind":"南风3-5级","week":"星期四","date":"20180705"},"day_20180706":{"temperature":"24℃~32℃","weather":"中雨转小雨","weather_id":{"fa":"08","fb":"07"},"wind":"西南风微风","week":"星期五","date":"20180706"},"day_20180707":{"temperature":"24℃~28℃","weather":"小雨","weather_id":{"fa":"07","fb":"07"},"wind":"西北风微风","week":"星期六","date":"20180707"},"day_20180708":{"temperature":"27℃~32℃","weather":"雷阵雨转多云","weather_id":{"fa":"04","fb":"01"},"wind":"西南风3-5级","week":"星期日","date":"20180708"},"day_20180709":{"temperature":"24℃~32℃","weather":"中雨转小雨","weather_id":{"fa":"08","fb":"07"},"wind":"西南风微风","week":"星期一","date":"20180709"}}
         */

        var sk: SkBean? = null
        var today: TodayBean? = null
        var future: FutureBean? = null

        class SkBean {
            /**
             * temp : 28
             * wind_direction : 西风
             * wind_strength : 2级
             * humidity : 92%
             * time : 13:30
             */

            var temp: String? = null
            var wind_direction: String? = null
            var wind_strength: String? = null
            var humidity: String? = null
            var time: String? = null
        }

        class TodayBean {
            /**
             * temperature : 25℃~30℃
             * weather : 中雨
             * weather_id : {"fa":"08","fb":"08"}
             * wind : 北风微风
             * week : 星期二
             * city : 池州
             * date_y : 2018年07月03日
             * dressing_index : 热
             * dressing_advice : 天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。
             * uv_index : 弱
             * comfort_index :
             * wash_index : 不宜
             * travel_index : 较不宜
             * exercise_index : 较不宜
             * drying_index :
             */

            var temperature: String? = null
            var weather: String? = null
            var weather_id: WeatherIdBean? = null
            var wind: String? = null
            var week: String? = null
            var city: String? = null
            var date_y: String? = null
            var dressing_index: String? = null
            var dressing_advice: String? = null
            var uv_index: String? = null
            var comfort_index: String? = null
            var wash_index: String? = null
            var travel_index: String? = null
            var exercise_index: String? = null
            var drying_index: String? = null

            class WeatherIdBean {
                /**
                 * fa : 08
                 * fb : 08
                 */

                var fa: String? = null
                var fb: String? = null
            }
        }

        class FutureBean {
            /**
             * day_20180703 : {"temperature":"25℃~30℃","weather":"中雨","weather_id":{"fa":"08","fb":"08"},"wind":"北风微风","week":"星期二","date":"20180703"}
             * day_20180704 : {"temperature":"27℃~32℃","weather":"雷阵雨转多云","weather_id":{"fa":"04","fb":"01"},"wind":"西南风3-5级","week":"星期三","date":"20180704"}
             * day_20180705 : {"temperature":"26℃~34℃","weather":"雷阵雨转中雨","weather_id":{"fa":"04","fb":"08"},"wind":"南风3-5级","week":"星期四","date":"20180705"}
             * day_20180706 : {"temperature":"24℃~32℃","weather":"中雨转小雨","weather_id":{"fa":"08","fb":"07"},"wind":"西南风微风","week":"星期五","date":"20180706"}
             * day_20180707 : {"temperature":"24℃~28℃","weather":"小雨","weather_id":{"fa":"07","fb":"07"},"wind":"西北风微风","week":"星期六","date":"20180707"}
             * day_20180708 : {"temperature":"27℃~32℃","weather":"雷阵雨转多云","weather_id":{"fa":"04","fb":"01"},"wind":"西南风3-5级","week":"星期日","date":"20180708"}
             * day_20180709 : {"temperature":"24℃~32℃","weather":"中雨转小雨","weather_id":{"fa":"08","fb":"07"},"wind":"西南风微风","week":"星期一","date":"20180709"}
             */

            var day_20180703: Day20180703Bean? = null
            var day_20180704: Day20180704Bean? = null
            var day_20180705: Day20180705Bean? = null
            var day_20180706: Day20180706Bean? = null
            var day_20180707: Day20180707Bean? = null
            var day_20180708: Day20180708Bean? = null
            var day_20180709: Day20180709Bean? = null

            class Day20180703Bean {
                /**
                 * temperature : 25℃~30℃
                 * weather : 中雨
                 * weather_id : {"fa":"08","fb":"08"}
                 * wind : 北风微风
                 * week : 星期二
                 * date : 20180703
                 */

                var temperature: String? = null
                var weather: String? = null
                var weather_id: WeatherIdBeanX? = null
                var wind: String? = null
                var week: String? = null
                var date: String? = null

                class WeatherIdBeanX {
                    /**
                     * fa : 08
                     * fb : 08
                     */

                    var fa: String? = null
                    var fb: String? = null
                }
            }

            class Day20180704Bean {
                /**
                 * temperature : 27℃~32℃
                 * weather : 雷阵雨转多云
                 * weather_id : {"fa":"04","fb":"01"}
                 * wind : 西南风3-5级
                 * week : 星期三
                 * date : 20180704
                 */

                var temperature: String? = null
                var weather: String? = null
                var weather_id: WeatherIdBeanXX? = null
                var wind: String? = null
                var week: String? = null
                var date: String? = null

                class WeatherIdBeanXX {
                    /**
                     * fa : 04
                     * fb : 01
                     */

                    var fa: String? = null
                    var fb: String? = null
                }
            }

            class Day20180705Bean {
                /**
                 * temperature : 26℃~34℃
                 * weather : 雷阵雨转中雨
                 * weather_id : {"fa":"04","fb":"08"}
                 * wind : 南风3-5级
                 * week : 星期四
                 * date : 20180705
                 */

                var temperature: String? = null
                var weather: String? = null
                var weather_id: WeatherIdBeanXXX? = null
                var wind: String? = null
                var week: String? = null
                var date: String? = null

                class WeatherIdBeanXXX {
                    /**
                     * fa : 04
                     * fb : 08
                     */

                    var fa: String? = null
                    var fb: String? = null
                }
            }

            class Day20180706Bean {
                /**
                 * temperature : 24℃~32℃
                 * weather : 中雨转小雨
                 * weather_id : {"fa":"08","fb":"07"}
                 * wind : 西南风微风
                 * week : 星期五
                 * date : 20180706
                 */

                var temperature: String? = null
                var weather: String? = null
                var weather_id: WeatherIdBeanXXXX? = null
                var wind: String? = null
                var week: String? = null
                var date: String? = null

                class WeatherIdBeanXXXX {
                    /**
                     * fa : 08
                     * fb : 07
                     */

                    var fa: String? = null
                    var fb: String? = null
                }
            }

            class Day20180707Bean {
                /**
                 * temperature : 24℃~28℃
                 * weather : 小雨
                 * weather_id : {"fa":"07","fb":"07"}
                 * wind : 西北风微风
                 * week : 星期六
                 * date : 20180707
                 */

                var temperature: String? = null
                var weather: String? = null
                var weather_id: WeatherIdBeanXXXXX? = null
                var wind: String? = null
                var week: String? = null
                var date: String? = null

                class WeatherIdBeanXXXXX {
                    /**
                     * fa : 07
                     * fb : 07
                     */

                    var fa: String? = null
                    var fb: String? = null
                }
            }

            class Day20180708Bean {
                /**
                 * temperature : 27℃~32℃
                 * weather : 雷阵雨转多云
                 * weather_id : {"fa":"04","fb":"01"}
                 * wind : 西南风3-5级
                 * week : 星期日
                 * date : 20180708
                 */

                var temperature: String? = null
                var weather: String? = null
                var weather_id: WeatherIdBeanXXXXXX? = null
                var wind: String? = null
                var week: String? = null
                var date: String? = null

                class WeatherIdBeanXXXXXX {
                    /**
                     * fa : 04
                     * fb : 01
                     */

                    var fa: String? = null
                    var fb: String? = null
                }
            }

            class Day20180709Bean {
                /**
                 * temperature : 24℃~32℃
                 * weather : 中雨转小雨
                 * weather_id : {"fa":"08","fb":"07"}
                 * wind : 西南风微风
                 * week : 星期一
                 * date : 20180709
                 */

                var temperature: String? = null
                var weather: String? = null
                var weather_id: WeatherIdBeanXXXXXXX? = null
                var wind: String? = null
                var week: String? = null
                var date: String? = null

                class WeatherIdBeanXXXXXXX {
                    /**
                     * fa : 08
                     * fb : 07
                     */

                    var fa: String? = null
                    var fb: String? = null
                }
            }
        }
    }
}
