package com.example.businesscard

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Intro("Usman Tahir Qureshi", "Software Developer")
                }
            }
        }
    }
}

@Composable
fun Intro(name: String, position: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.dsc_0016)
    Column (
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(color = Color(0xFFb9d29e))
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f)
        ) {
            Image(painter = image, contentDescription = null, modifier = Modifier.size(150.dp))
            Text(
                text = name,
                fontSize = 30.sp,
            )
            Text(
                text = position,
                fontSize = 20.sp,
                color = Color(0xFF016204)
            )
        }
        ContactDetails()
    }
}




@Composable
fun ContactDetails() {
    Column (
       horizontalAlignment = Alignment.Start,
        modifier = Modifier.padding(bottom = 20.dp)
    ){
        Row (
            modifier = Modifier.padding(vertical = 5.dp)
        ) {
            Icon(Icons.Rounded.Phone, tint = Color(0xFF016204), contentDescription = "cell number", modifier = Modifier.padding(horizontal = 10.dp))
            Text("+1 616 (333) 2660")
        }
        Row (
            modifier = Modifier.padding(vertical = 5.dp
            ))
        {
            Icon(Icons.Rounded.Share, tint = Color(0xFF016204), contentDescription = "Share profile", modifier = Modifier.padding(horizontal = 10.dp))
            Text("@SoftwareDev")
        }
        Row(modifier = Modifier.padding(vertical = 5.dp)) {
            Icon(Icons.Rounded.Email, tint = Color(0xFF016204), contentDescription = "email address", modifier = Modifier.padding(horizontal = 10.dp))
            Text("usman@yahoo.com")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        Intro("Usman Tahir Qureshi", "Software Developer")
    }
}