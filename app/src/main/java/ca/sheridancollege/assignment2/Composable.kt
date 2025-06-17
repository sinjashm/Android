package ca.sheridancollege.assignment2

import ca.sheridancollege.assignment2.data.Flower
import ca.sheridancollege.assignment2.network.FlowerApi

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage


@Composable
fun LoadingScreen() =
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }

@Composable
fun ErrorScreen(msg: String) =
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(msg)
    }

/* ---------- list of flowers ---------- */

@Composable
fun FlowerList(flowers: List<Flower>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        items(flowers) { flower -> FlowerCard(flower) }
    }
}

@Composable
private fun FlowerCard(flower: Flower) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(Modifier.padding(16.dp)) {
            AsyncImage(
                model = FlowerApi.IMAGE_BASE + flower.image,
                contentDescription = flower.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(96.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(Modifier.width(16.dp))
            Column {
                Text(flower.name, style = MaterialTheme.typography.titleMedium)
                Text(
                    flower.description,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}