package ca.suthakaran.weather.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ca.suthakaran.weather.R





@Composable
fun DisplayVisual(apiData: Pair<Double, String>) {
    WeatherImage(weatherCondition = apiData.second)
    Text(
        text = "Temperature: ${apiData.first} .C",
        fontSize = 34.sp,
        modifier = Modifier.padding(bottom = 18.dp)
    )
}

@Composable
fun DefaultText(campus: String) {
    val campusStringResId = when (campus) {
        "traf" -> R.string.nav_trafs_title
        "davis" -> R.string.nav_davs_title
        "hmc" -> R.string.nav_hmc_title
        else -> R.string.nav_trafs_title
    }

    Text(
        text = stringResource(campusStringResId),
        fontSize = 34.sp,
        modifier = Modifier.padding(bottom = 18.dp)
    )
}

@Composable
fun WeatherImage(weatherCondition: String) {

    val drawableResource = when (weatherCondition) {
        "clear" -> R.drawable.art_clear
        "clouds" -> R.drawable.art_clouds
        "fog" -> R.drawable.art_fog
        "light_clouds" -> R.drawable.art_light_clouds
        "light_rain" -> R.drawable.art_light_rain
        "rain" -> R.drawable.art_rain

        else -> R.drawable.art_clear


    }
    Image(

        painter = painterResource(id = drawableResource),
        contentDescription = null,

        modifier = Modifier.size(300.dp)


    )
}




@Composable
fun DisplayError() {
    Text(
        text = "Error fetching weather data",
        color = Color.Red,
        fontSize = 35.sp,
        modifier = Modifier.padding(bottom = 18.dp)
    )
}