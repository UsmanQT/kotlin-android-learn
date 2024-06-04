package com.example.gridapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GridAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                ) {
                    GridApp()
                }
            }
        }
    }
}

@Composable
fun GridApp() {
    ItemsList(topicsList = DataSource.topics)
}

@Composable
fun GridItemCard (modifier: Modifier = Modifier, topic: Topic) {
    Card(modifier = modifier) {
        Row {
            Image(
                painter = painterResource(id = topic.topicImage),
                contentDescription = null,
                )
            Column {
                Text(
                    text = stringResource(id = topic.topicId)
                )
                Row {
                    Icon(
                        Icons.Rounded.Add,
                        contentDescription = null
                    )
                    Text(text= topic.numberOfCourses.toString())
                }
            }
        }
    }
}

@Composable
fun ItemsList(topicsList: List<Topic>) {
    LazyColumn {
        items(topicsList) { topic ->
            GridItemCard(
                topic = topic,
                modifier = Modifier.padding(8.dp)
            )

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
