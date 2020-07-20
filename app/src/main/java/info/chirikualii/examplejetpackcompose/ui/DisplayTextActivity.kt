package info.chirikualii.examplejetpackcompose.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.Box
import androidx.ui.foundation.ContentGravity
import androidx.ui.foundation.Text
import androidx.ui.layout.fillMaxSize
import androidx.ui.tooling.preview.Preview

class DisplayTextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(modifier = Modifier.fillMaxSize(), gravity = ContentGravity.Center, children = {

                SimpleText(text = "Jetpack Compose ,its time to implement declarative ui")

            })
        }
    }
}

@Composable
fun SimpleText(text: String) {
    Text(text = "Hello ${text}")
}

@Preview(showBackground = true)
@Composable
fun SimpleTextPreview() {
    SimpleText(text = "Jetpack Compose ,its time to implement declarative ui")
}