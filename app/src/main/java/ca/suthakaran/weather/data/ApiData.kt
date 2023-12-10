package ca.suthakaran.weather.data
data class ApiData(
    val main: Main,
    val weather: List<Weather>
)
data class Main(
    val temperature: Double
)
data class Weather(
    val main: String
)
