package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonApp(modifier: Modifier = Modifier) {
    var screenNumber by remember { mutableStateOf(1)}
    var squeezeTimes by remember { mutableStateOf(0)}
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Lemonade", fontWeight = FontWeight.Bold)
                }
            )
        },
    ) { innerPadding ->
        when (screenNumber) {
            1 -> Surface(
                modifier = Modifier.padding(innerPadding)
            ) {
                Column(
                    modifier = modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(
                        onClick = {
                            screenNumber = 2
                            squeezeTimes = (2..4).random()
                                  },
                        shape = RoundedCornerShape(40.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)

                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.lemon_tree),
                            contentDescription = "tree"
                        )
                    }
                    Spacer(modifier = modifier.height(20.dp))
                    Text(stringResource(id = R.string.lemon_tree))
                }
            }
            2 -> Surface(
                modifier = Modifier.padding(innerPadding)
            ) {
                Column(
                    modifier = modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(
                        onClick = {
                            squeezeTimes--
                            if(squeezeTimes == 0) {
                                screenNumber = 3
                            } },
                        shape = RoundedCornerShape(40.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.lemon_squeeze),
                            contentDescription = "squeeze"
                        )
                    }
                    Spacer(modifier = modifier.height(20.dp))
                    Text(stringResource(id = R.string.lemon_squeeze))
                }
            }
            3 -> Surface(
                modifier = Modifier.padding(innerPadding)
            ) {
                Column(
                    modifier = modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(
                        onClick = { screenNumber++ },
                        shape = RoundedCornerShape(40.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.lemon_drink),
                            contentDescription = "drink"
                        )
                    }
                    Spacer(modifier = modifier.height(20.dp))
                    Text(stringResource(id = R.string.lemon_drink))
                }
            }
            4 -> Surface(
                modifier = Modifier.padding(innerPadding)
            ) {
                Column(
                    modifier = modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(
                        onClick = { screenNumber = 1 },
                        shape = RoundedCornerShape(40.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
                        ) {
                        Image(
                            painter = painterResource(id = R.drawable.lemon_restart),
                            contentDescription = "restart"
                        )
                    }
                    Spacer(modifier = modifier.height(20.dp))
                    Text(stringResource(id = R.string.lemon_restart))
                }
            }
            else -> Text("error")
        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LemonadeTheme {
        LemonApp()
    }
}