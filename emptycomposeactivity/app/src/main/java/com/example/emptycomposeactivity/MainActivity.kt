package com.example.emptycomposeactivity

import android.content.Context
import android.graphics.Paint
import android.os.Bundle
import android.provider.CalendarContract
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.textInputServiceFactory
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.emptycomposeactivity.ui.theme.EmptycomposeActivityTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EmptycomposeActivityTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                   SimpleButtonComponent(this)
                    SimpleBoxComponent()
                    spinnerm()
                }
            }
        }
    }
}

@Composable
fun SimpleButtonComponent(context : Context) {
    Button(
        modifier = Modifier.padding(16.dp),
        onClick = {
            Toast.makeText(context, "Thanks for clicking!", Toast.LENGTH_LONG).show()
        },
    ) {
        Text("Click Me")
    }
}
@Composable
fun SimpleBoxComponent() {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Text(
            modifier = Modifier.padding(start = 16.dp, top = 16.dp),
            text = "I am a text over Image",
            fontSize = 16.sp,
            color = Color.Red
        )
    }
}
@Composable
fun spinnerm() {
    var expanded by remember { mutableStateOf(false) }
    val suggestions = listOf("Item1", "Item2", "Item3")

    Button(onClick = { expanded = !expanded }) {
        Text("DropDown")
        Icon(
            imageVector = Icons.Filled.ArrowDropDown,
            contentDescription = null,
        )
    }
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false },
    ) {
        suggestions.forEach { label ->
            DropdownMenuItem(onClick = {
                expanded = false
                //do something ...
            }) {
                Text(text = label)
            }

        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EmptycomposeActivityTheme {
    }
}