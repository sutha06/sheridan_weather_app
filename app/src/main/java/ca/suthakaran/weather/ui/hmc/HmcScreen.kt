package ca.suthakaran.weather.ui.hmc

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ca.suthakaran.weather.ui.common.WeatherBottomBar
import ca.suthakaran.weather.ui.common.WeatherTopAppBar
import ca.suthakaran.weather.ui.navigation.HmcDestination
import ca.suthakaran.weather.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HmcScreen(
    viewModel: HmcViewModel,
    onTabPressed: (String) -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
){
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

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
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .padding(innerPadding)
                .fillMaxWidth()
                .padding(top = 56.dp)
        ){
            Text(
                text = stringResource(R.string.nav_hmc_title),
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )

        }
    }

}