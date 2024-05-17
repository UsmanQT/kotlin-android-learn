package com.example.articleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.articleapp.ui.theme.ArticleAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArticleAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Column(
//                        horizontalAlignment = Alignment.CenterHorizontally
//                    ) {
//                        WideImage()
//                        AllTexts(textHeading = getString(R.string.jetpack_compose_tutorial),
//                            textBody = getString(R.string.bodytext),
//                            textBody2 = getString(R.string.bodyText2),
//                            modifier = Modifier)
//                    }
                    QuadrantsCheck(
                        "Displays text and follows the recommended Material Design guidelines.",
                        "Text composable",
                        "Creates a composable that lays out and draws a given Painter class object.",
                        "Image composable",
                        "A layout composable that places its children in a horizontal sequence.",
                        "Row composable",
                        "A layout composable that places its children in a vertical sequence.",
                        "Column composable",
                        modifier = Modifier

                    )

                }
            }
        }
    }
}

@Composable
fun WideImage(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)
    Image(
        painter = image,
        contentDescription = null
    )
}

@Composable
fun AllTexts(textHeading: String, textBody: String, textBody2: String, modifier: Modifier) {
    Column(
        modifier =  modifier,
    ) {
        Text(
            text = textHeading,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp),
        )
        Text(
            text = textBody,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = textBody2,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun Quadrants(
    textBody1: String,
    heading1: String,
    textBody2: String,
    heading2: String,
    textBody3: String,
    heading3: String,
    textBody4: String,
    heading4: String,
    modifier: Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = heading1)
                Text(text = textBody1)
            }
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = heading2)
                Text(text = textBody2)
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = heading3)
                Text(text = textBody3)
            }
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = heading4)
                Text(text = textBody4)
            }
        }
    }
}

@Composable
private fun ComposableInfoCard(
    title: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column (
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )  {
        Text(
            text = title,
        )
        Text(
            text = description
        )
    }
}


@Composable
fun QuadrantsCheck(
    textBody1: String,
    heading1: String,
    textBody2: String,
    heading2: String,
    textBody3: String,
    heading3: String,
    textBody4: String,
    heading4: String,
    modifier: Modifier
) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.weight(1f),
        ) {
            Column(
                modifier = Modifier.weight(1f).background(Color(0xFFEADDFF)).fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(heading1)
                Text(textBody1)
            }
            Column (
                modifier = Modifier.weight(1f).background(Color(0xFFD0BCFF)).fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally)
            {
                Text(heading2)
                Text(textBody2)
            }

        }

        Row(
            modifier = Modifier.weight(1f),
        ) {
            Column (
                modifier = Modifier.weight(1f).background(Color(0xFFB69DF8)).fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(heading3)
                Text(textBody3)
            }
            Column (
                modifier = Modifier.weight(1f).background(Color(0xFFF6EDFF)).fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
                ) {
                Text(heading4)
                Text(textBody4)
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArticleAppTheme {
        WideImage()
    }
}