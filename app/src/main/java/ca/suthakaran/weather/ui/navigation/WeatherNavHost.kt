package ca.suthakaran.weather.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import ca.suthakaran.weather.ui.hmc.HmcScreen
import ca.suthakaran.weather.ui.hmc.HmcViewModel
import ca.suthakaran.weather.ui.davis.DavisScreen
import ca.suthakaran.weather.ui.davis.DavisViewModel
import ca.suthakaran.weather.ui.traf.TrafScreen
import ca.suthakaran.weather.ui.traf.TrafViewModel

@Composable
fun WeatherNavHost(navController: NavHostController){
    NavHost(navController, startDestination = HmcDestination.route){
        composable(route = HmcDestination.route){
            val viewModel: HmcViewModel = hiltViewModel()
            HmcScreen(
                viewModel = viewModel,
                onTabPressed = { tabNavigate(navController, it) },
                navigateBack = { navController.popBackStack() }
            )
        }
        composable(route = DavisDestination.route){
            val viewModel: DavisViewModel = hiltViewModel()
            DavisScreen(
                viewModel = viewModel,
                onTabPressed = { tabNavigate(navController, it) },
                navigateBack = { navController.popBackStack() }
            )
        }
        composable(route = TrafDestination.route){
            val viewModel: TrafViewModel = hiltViewModel()
            TrafScreen(
                viewModel = viewModel,
                onTabPressed = { tabNavigate(navController, it) },
                navigateBack = { navController.popBackStack() }
            )
        }
    }
}

private fun tabNavigate(navController: NavHostController, route: String){
    if (route == HmcDestination.route) {
        // pop the stack when returning to the home screen
        navController.popBackStack(
            route = HmcDestination.route, inclusive = false
        )
    } else {
        navController.navigate(route)
    }
}