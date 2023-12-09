package ca.suthakaran.weather.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ca.suthakaran.weather.ui.navigation.WeatherNavHost

@Composable
fun AppScreen(navController: NavHostController = rememberNavController()) {
    WeatherNavHost(navController = navController)
}