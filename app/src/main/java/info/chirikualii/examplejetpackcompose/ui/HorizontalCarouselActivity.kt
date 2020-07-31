package info.chirikualii.examplejetpackcompose.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.compose.Composable
import androidx.ui.core.ContextAmbient
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.*
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.layout.*
import androidx.ui.material.Card
import androidx.ui.text.TextStyle
import androidx.ui.text.style.TextAlign
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import androidx.ui.unit.sp


class HorizontalCarouselActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {

                Text(
                        text = "Horizontal Scrollable Carousel",
                        style = TextStyle(fontSize = 20.sp),
                        modifier = Modifier.padding(16.dp)
                )

                HorizontalScroller(modifier = Modifier.fillMaxWidth()) {

                    for ((index, person) in listPerson.withIndex()) {

                        composeItemHorizontal(
                                data = person,
                                index = index,
                                onClick = {
                                    Toast.makeText(
                                            this@HorizontalCarouselActivity,
                                            "$person and $index",
                                            Toast.LENGTH_SHORT
                                    ).show()
                                })
                    }

                }

                Text(
                        text = "Horizontal Scrollable Carousel where each item occupies the width of the screen",
                        style = TextStyle(fontSize = 20.sp),
                        modifier = Modifier.padding(16.dp)
                )

                HorizontalScroller(modifier = Modifier.fillMaxWidth()) {

                    for ((index, person) in listPerson.withIndex()) {

                        composeItemHorizontalCustomWidth(
                                data = person,
                                index = index,
                                onClick = {
                                    Toast.makeText(
                                            this@HorizontalCarouselActivity,
                                            "$person and $index",
                                            Toast.LENGTH_SHORT
                                    ).show()
                                })
                    }


                }
            }
        }
    }
}

@Composable
fun composeItemHorizontal(data: String, index: Int, onClick: () -> Unit) {

    Row(
            modifier = Modifier.padding(16.dp) +
                    Modifier.fillMaxWidth() +
                    Modifier.clickable(onClick = onClick)
    ) {
        Card(
                shape = RoundedCornerShape(4.dp),
                color = colors[index % colors.size],
                modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                    text = data,
                    style = TextStyle(textAlign = TextAlign.Center, fontSize = 20.sp),
                    modifier = Modifier.padding(16.dp)
            )

        }
    }
}

@Composable
fun composeItemHorizontalCustomWidth(data: String, index: Int, onClick: () -> Unit) {
    val context = ContextAmbient.current
    val resources = context.resources
    val displayMetrics = resources.displayMetrics
    val screenWidth = displayMetrics.widthPixels / displayMetrics.density
    Row(modifier = Modifier.padding(16.dp)) {

        Card(
                shape = RoundedCornerShape(4.dp),
                color = colors[index % colors.size],
                modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                    modifier = Modifier.preferredWidth(screenWidth.dp - 32.dp),
                    gravity = ContentGravity.Center
            ) {
                Text(
                        text = data,
                        style = TextStyle(textAlign = TextAlign.Center, fontSize = 20.sp),
                        modifier = Modifier.padding(16.dp)
                )
            }


        }
    }
}

@Composable
@Preview
fun composeListHorizontalPreview() {

    HorizontalScroller(modifier = Modifier.fillMaxWidth()) {

        for ((index, person) in listPerson.withIndex()) {
            Row(
                    modifier = Modifier.padding(16.dp) +
                            Modifier.fillMaxWidth()
            ) {
                Card(
                        shape = RoundedCornerShape(4.dp),
                        color = colors[index % colors.size],
                        modifier = Modifier.fillMaxWidth()
                ) {

                    Text(
                            text = person,
                            style = TextStyle(textAlign = TextAlign.Center, fontSize = 20.sp),
                            modifier = Modifier.padding(16.dp)
                    )

                }
            }
        }


    }
}

@Preview
@Composable
fun composeItemHorizontalPreview() {
    Row(modifier = Modifier.padding(16.dp) + Modifier.fillMaxWidth()) {
        Card(
                shape = RoundedCornerShape(4.dp),
                color = colors[1],
                modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                    text = "Ali Rahmat",
                    style = TextStyle(textAlign = TextAlign.Center, fontSize = 20.sp),
                    modifier = Modifier.padding(16.dp)
            )

        }
    }
}
