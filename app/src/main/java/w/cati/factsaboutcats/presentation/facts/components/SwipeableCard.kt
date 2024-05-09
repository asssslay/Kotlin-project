package w.cati.factsaboutcats.presentation.facts.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.alexstyl.swipeablecard.Direction
import com.alexstyl.swipeablecard.ExperimentalSwipeableCardApi
import com.alexstyl.swipeablecard.rememberSwipeableCardState
import com.alexstyl.swipeablecard.swipableCard
import w.cati.factsaboutcats.R
import w.cati.factsaboutcats.common.Images
import w.cati.factsaboutcats.domain.model.Fact

@OptIn(ExperimentalSwipeableCardApi::class)
@Composable
fun SwipeableCard(
    modifier: Modifier = Modifier,
    item: Fact,
    image: Int,
    onSwipeRight: () -> Unit,
    onSwipeLeft: () -> Unit,
    onSwipeDown: () -> Unit,
    onSwipeUp: () -> Unit,

    ) {
    val state = rememberSwipeableCardState()

    if (state.swipedDirection == null) {
        Card(
            modifier = modifier.swipableCard(
                state = state,
                blockedDirections = listOf(Direction.Down),
                onSwiped = { direction ->
                    when (direction) {
                        Direction.Right -> {
                            onSwipeRight()
                        }

                        Direction.Left -> {
                            onSwipeLeft()
                        }

                        Direction.Down -> {
                            onSwipeDown()
                        }

                        Direction.Up -> {
                            onSwipeUp()
                        }
                    }
                }
            ),
            shape = RoundedCornerShape(10f),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painterResource(id = image), contentDescription = "",
                    modifier = Modifier.fillMaxWidth().fillMaxHeight(0.4f)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    item.fact,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}