package w.cati.factsaboutcats.presentation.facts.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import w.cati.factsaboutcats.common.Images
import w.cati.factsaboutcats.presentation.facts.components.SwipeableCard
import w.cati.factsaboutcats.presentation.facts.viewmodel.FactsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FactsScreen(
    navController: NavController,
    viewModel: FactsViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                ),
                title = {
                    Text(
                        text = "Facts about cats",
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("favorite_screen") }) {
                        Icon(
                            imageVector = Icons.Default.Favorite, contentDescription = "Favorite",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box {
                Text(text = "Wait a little bit")
                state.facts
                    .reversed()
                    .forEach {
                        SwipeableCard(
                            modifier = Modifier.size(400.dp),
                            item = it,
                            image = it.image!!,
                            onSwipeRight = { viewModel.onSwipeRight(it) },
                            onSwipeLeft = { viewModel.onSwipeLeft(it) },
                            onSwipeDown = { /*TODO*/ },
                            onSwipeUp = { viewModel.onSwipeLeft(it) })
                    }
            }
        }

    }
}