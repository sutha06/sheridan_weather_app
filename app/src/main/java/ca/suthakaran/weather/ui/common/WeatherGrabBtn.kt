package ca.suthakaran.weather.ui.common

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WeatherGrabBtn(
    isLoading: Boolean,
    onGrabClicked: () -> Unit
) {
    Button(
        onClick = { onGrabClicked() },
        modifier = Modifier.padding(top = 18.dp)
    ) {
        Text(text = if (isLoading) "Loading..." else "Grab Weather")
    }
}