package com.example.gridapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gridapp.data.DataSource
import com.example.gridapp.data.Topic
import com.example.gridapp.ui.theme.GridAppTheme
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.ui.Alignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GridAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .statusBarsPadding(),
                ) {
                    GridApp()
                }
            }
        }
    }
}

@Composable
fun GridApp() {
    ItemsList(
        topicsList = DataSource.topics,
        modifier = Modifier.padding(
            start = 16.dp,
            top = 16.dp,
            end = 16.dp,
        )
    )
}

@Composable
fun GridItemCard (modifier: Modifier = Modifier, topic: Topic) {
    Card {
        Row {
            Box {
                Image(
                    painter = painterResource(id = topic.topicImage),
                    contentDescription = null,
                    modifier = Modifier
                        .size(width = 68.dp, height = 68.dp)
                        .aspectRatio(1f),
                    contentScale = ContentScale.Crop
                )
            }
            Column{
                Text(
                    text = stringResource(id = topic.topicId),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(
                        start = 10.dp,
                        top = 10.dp,
                        end = 10.dp,
                        bottom = 5.dp
                    )
                )
                Row (verticalAlignment = Alignment.CenterVertically){
                    Icon(
                        Icons.Rounded.Add,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = 10.dp)
                    )
                    Text(
                        text= topic.numberOfCourses.toString(),
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier.padding(start = 5.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun ItemsList(topicsList: List<Topic>,modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        modifier = modifier
    ) {
        items(topicsList) { topic ->
            GridItemCard(modifier, topic)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GridAppTheme {
        GridApp()
    }
}
