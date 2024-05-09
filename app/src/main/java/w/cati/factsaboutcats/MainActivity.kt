package w.cati.factsaboutcats

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import w.cati.factsaboutcats.presentation.facts.screen.FactsScreen
import w.cati.factsaboutcats.presentation.favorite.screen.FavoriteScreen
import w.cati.factsaboutcats.presentation.ui.theme.FactsaboutcatsTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            FactsaboutcatsTheme {
                NavHost(navController = navController, startDestination = "main_screen") {
                    composable("main_screen") {
                        FactsScreen(navController)
                    }
                    composable("favorite_screen") {
                        FavoriteScreen(navController = navController)
                    }
                }
            }
        }
    }
}

