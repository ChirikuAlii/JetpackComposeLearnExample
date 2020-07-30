package info.chirikualii.examplejetpackcompose.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.Text
import androidx.ui.foundation.clickable
import androidx.ui.foundation.lazy.LazyColumnItems
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.text.TextStyle
import androidx.ui.text.style.TextAlign
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import androidx.ui.unit.sp

class MainActivity : AppCompatActivity() {

    //init var
    val listFeature = listOf(
            ("Display Text"),
            ("Display Styled Text"),
            ("Vertical List Scrollable"),
            ("Horizontal Carousel"),
            ("Load Image"),
            ("Clickable Component"),
            ("Drawer App"),
            ("Buttons"),
            ("State"),
            ("Custom View"),
            ("Custom View Paint"),
            ("Measuring Scale"),
            ("Text Input Components"),
            ("Stack Component"),
            ("View Layout Arrangements Component"),
            ("Material Design")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            composeScaffold(
                listFeature,
                onClickItemList = { index ->
                    when (index) {

                        0 -> {
                            val intent = Intent(this, DisplayTextActivity::class.java)
                            startActivity(intent)
                        }

                        1 -> {
                            val intent =Intent(this, CustomTextActivity::class.java)
                            startActivity(intent)
                        }
                    }
                }
            )
        }
    }
}

@Composable
fun composeScaffold(listFeature: List<String>? = null, onClickItemList: (index: Int) -> Unit) {
    Scaffold(
            topBar = {
                TopAppBar(
                        title = { Text(text = "Fun Jetpack Compose") }
                )
            },
            bodyContent = { padding ->
                listFeature?.let {
                    composeList(
                        List = it,
                        onClick = { index ->
                            onClickItemList(index)
                        })
                }
            }
    )
}

@Composable
fun composeList(List: List<String> = listOf(), onClick: (index: Int) -> Unit) {

    LazyColumnItems(items = List) { data ->
        val index = List.indexOf(data)
        Row(modifier = Modifier.padding(16.dp) + Modifier.fillMaxWidth()
                + Modifier.clickable(onClick = { onClick(index) })) {

            Card(
                    shape = RoundedCornerShape(4.dp),
                    color = Color(0xFF6200EE),
                    modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                        text = data,
                        style = TextStyle(color = Color.White,
                                fontSize = 20.sp,
                                textAlign = TextAlign.Center
                        ),
                        modifier = Modifier.padding(24.dp)
                )
            }

        }
    }

}


@Preview
@Composable
fun composeScaffoldPreview() {
    val listFeature = listOf(
            ("Display Text"),
            ("Display Styled Text"),
            ("Vertical List Scrollable"),
            ("Horizontal Carousel"),
            ("Load Image"),
            ("Clickable Component"),
            ("Drawer App"),
            ("Buttons"),
            ("State"),
            ("Custom View"),
            ("Custom View Paint"),
            ("Measuring Scale"),
            ("Text Input Components"),
            ("Stack Component"),
            ("View Layout Arrangements Component"),
            ("Material Design")
    )
    composeScaffold(
        listFeature,
        onClickItemList = {})
}

@Preview
@Composable
fun composeListPreview() {
    val listFeature = listOf(
            ("Display Text"),
            ("Display Styled Text"),
            ("Vertical List Scrollable"),
            ("Horizontal Carousel"),
            ("Load Image"),
            ("Clickable Component"),
            ("Drawer App"),
            ("Buttons"),
            ("State"),
            ("Custom View"),
            ("Custom View Paint"),
            ("Measuring Scale"),
            ("Text Input Components"),
            ("Stack Component"),
            ("View Layout Arrangements Component"),
            ("Material Design")
    )
    composeList(listFeature) {}
}





