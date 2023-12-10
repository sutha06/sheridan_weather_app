package ca.suthakaran.weather.ui.hmc


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import ca.suthakaran.weather.ui.common.DefaultText
import ca.suthakaran.weather.ui.common.DisplayError
import ca.suthakaran.weather.ui.common.DisplayVisual
import ca.suthakaran.weather.ui.common.WeatherBottomBar
import ca.suthakaran.weather.ui.common.WeatherGrabBtn
import ca.suthakaran.weather.ui.common.WeatherTopAppBar
import ca.suthakaran.weather.ui.navigation.HmcDestination

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HmcScreen(
    viewModel: HmcViewModel,
    onTabPressed: (String) -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val apiState = viewModel.apiState.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val errorState by viewModel.errorState.collectAsState()

    Scaffold(modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            WeatherTopAppBar(
                title = stringResource(HmcDestination.titleRes),
                canNavigateBack = true,
                navigateUp = navigateBack,
                scrollBehavior = scrollBehavior
            )
        },
        bottomBar = {
            WeatherBottomBar(
                currentRoute = HmcDestination.route,
                onTabPressed = onTabPressed
            )
        }
    ) { innerPadding ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                if (errorState) {
                    DisplayError()
                } else {
                    val weatherData = apiState.value
                    if (weatherData != null) {
                        DisplayVisual(weatherData)
                    } else {
                        DefaultText("hmc")
                    }
                }
                WeatherGrabBtn(isLoading, viewModel::grabApiData)
            }
        }
    }
}
