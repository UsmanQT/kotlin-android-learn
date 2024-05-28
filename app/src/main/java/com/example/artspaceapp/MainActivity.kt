package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.graphics.Color

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
        ArtPiece(id = 1, image = R.drawable.aucuepbu_screenshot_2023_10_18_at_12_47_26_pm_811x1024, text= "Halima Aziz"),
        ArtPiece(id = 2, image = R.drawable._87270127_860870888552554_7430350949524679136_n, text= "Shirien Damra"),
        ArtPiece(id = 3, image = R.drawable.mcxrqc3y_screenshot_2023_10_18_at_1_38_01_pm_781x1024, text= "Bint Quds"),
        ArtPiece(id = 4, image = R.drawable._e7tycwm_screenshot_2023_10_17_at_7_15_15_pm_993x1024, text= "Narmeen Hamadeh")
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
            if (count > 0) {
                Button(
                    modifier = modifier
                        .weight(1f)
                        .padding(all = 20.dp),
                    onClick = {
                        count--
                    }
                ) {
                    Text(text = "Previous")
                }
            }
            if (count != 0 && count != listOfArtPieces.size -1 ) {
                Spacer(modifier = modifier.size(20.dp))
            }
            if (count < listOfArtPieces.size - 1) {
                Button(
                    modifier = modifier
                        .weight(1f)
                        .padding(all = 20.dp),
                    onClick = {
                        count++
                    }
                ) {
                    Text(text = "Next")
                }
            }
        }

    }
}

@Composable
fun ImageWithText(item: ArtPiece, modifier: Modifier) {
    val image = painterResource(id = item.image)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding( vertical = 30.dp)
    ) {
        Image(painter = image, contentDescription = null)
        Spacer(modifier = modifier.size(30.dp))
        Box (
            modifier = modifier.background(color = Color.LightGray).padding(all = 30.dp)
        ){
            Text(text = item.text)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceAppTheme {
        ArtSpaceLayout()
    }
}