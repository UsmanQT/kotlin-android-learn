package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceLayout()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceLayout(modifier: Modifier = Modifier) {
    var count by remember {
        mutableStateOf(0)
    }

    val listOfArtPieces = listOf<ArtPiece>(
        ArtPiece(id = 1, image = R.drawable.aucuepbu_screenshot_2023_10_18_at_12_47_26_pm_811x1024, text= "Text 1"),
        ArtPiece(id = 2, image = R.drawable.aucuepbu_screenshot_2023_10_18_at_12_47_26_pm_811x1024, text= "Text 2"),
        ArtPiece(id = 3, image = R.drawable.aucuepbu_screenshot_2023_10_18_at_12_47_26_pm_811x1024, text= "Text 3"),
        ArtPiece(id = 4, image = R.drawable.aucuepbu_screenshot_2023_10_18_at_12_47_26_pm_811x1024, text= "Text 4")
    )

    Column (
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()

    ) {
        ImageWithText(listOfArtPieces[count], modifier = modifier)
        Row (
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Button(
                modifier = modifier
                    .weight(1f)
                    .padding(horizontal = 20.dp, vertical = 20.dp)
                ,
                onClick = { /*TODO*/ },
            ) {
                Text(text = "Previous")
            }
            Spacer(modifier = modifier.size(20.dp))
            Button(
                modifier = modifier
                    .weight(1f)
                    .padding(horizontal = 20.dp, vertical = 20.dp)
                ,
                onClick = { count++ },
            ) {
                Text(text = "Next")
            }
        }

    }
}

@Composable
fun ImageWithText(item: ArtPiece, modifier: Modifier) {
    val image = painterResource(id = item.image)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(painter = image, contentDescription = null)
        Text(text = item.text)
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceAppTheme {
        ArtSpaceLayout()
    }
}