package ca.suthakaran.weather.ui.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
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
            icon = ImageVector.vectorResource(R.drawable.square_h_svgrepo_com),
            text = stringResource(id = R.string.hmc)
        ),
        NavigationItemContent(
            route = TrafDestination.route,
            icon = ImageVector.vectorResource(R.drawable.square_t_svgrepo_com),
            text = stringResource(id = R.string.trafalgar)
        ),
        NavigationItemContent(
            route = DavisDestination.route,
            icon = ImageVector.vectorResource(R.drawable.square_d_svgrepo_com),
            text = stringResource(id = R.string.davis)
        )
    )

    NavigationBar(modifier = modifier) {
        for (navItem in navigationItemContentList) {
            NavigationBarItem(
                selected = currentRoute == navItem.route,
                onClick = { onTabPressed(navItem.route) },
                icon = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = navItem.icon,
                            contentDescription = navItem.text,
                            modifier = Modifier.height(32.dp) // Adjust the size as needed
                        )
                        Spacer(modifier = Modifier.height(4.dp)) // Adjust spacing between icon and text
                        Text(
                            text = navItem.text,
                            fontWeight = FontWeight.Bold // Make text bold
                        )
                    }
                }
            )
        }
    }
}