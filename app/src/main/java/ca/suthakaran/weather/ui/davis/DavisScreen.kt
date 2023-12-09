package ca.suthakaran.weather.ui.davis

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ca.suthakaran.weather.R
import ca.suthakaran.weather.ui.common.WeatherBottomBar
import ca.suthakaran.weather.ui.common.WeatherTopAppBar
import ca.suthakaran.weather.ui.navigation.DavisDestination


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DavisScreen(
    viewModel: DavisViewModel,
    onTabPressed: (String) -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
){
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            WeatherTopAppBar(
                title = stringResource(DavisDestination.titleRes),
                canNavigateBack = true,
                navigateUp = navigateBack,
                scrollBehavior = scrollBehavior
            )
        },
        bottomBar = {
            WeatherBottomBar(
                currentRoute = DavisDestination.route,
                onTabPressed = onTabPressed
            )
        }
    ) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .padding(innerPadding)
                .fillMaxWidth()
                .padding(top = 56.dp)
        ){
            Text(
                text = stringResource(R.string.current_weather),
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )

        }
    }

}