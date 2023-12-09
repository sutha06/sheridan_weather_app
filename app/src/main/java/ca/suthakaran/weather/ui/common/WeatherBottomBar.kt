package ca.suthakaran.weather.ui.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import ca.suthakaran.weather.R
import ca.suthakaran.weather.ui.navigation.DavisDestination
import ca.suthakaran.weather.ui.navigation.TrafDestination
import ca.suthakaran.weather.ui.navigation.HmcDestination


private data class NavigationItemContent(
    val route: String,
    val icon: ImageVector,
    val text: String
)

@Composable
fun WeatherBottomBar(
    currentRoute: String,
    onTabPressed: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val navigationItemContentList = listOf(
        NavigationItemContent(
            route = HmcDestination.route,
            icon = Icons.Default.Home,
            text = stringResource(id = R.string.hmc)
        ),
        NavigationItemContent(
            route = TrafDestination.route,
            icon = Icons.Default.List,
            text = stringResource(id = R.string.traf)
        ),
        NavigationItemContent(
            route = DavisDestination.route,
            icon = Icons.Default.Settings,
            text = stringResource(id = R.string.davis)
        )
    )

    NavigationBar(modifier = modifier) {
        for (navItem in navigationItemContentList) {
            NavigationBarItem(
                selected = currentRoute == navItem.route,
                onClick = { onTabPressed(navItem.route) },
                icon = {
                    Icon(
                        imageVector = navItem.icon,
                        contentDescription = navItem.text
                    )
                },
                label = { Text(text = navItem.text) }
            )
        }
    }
}

