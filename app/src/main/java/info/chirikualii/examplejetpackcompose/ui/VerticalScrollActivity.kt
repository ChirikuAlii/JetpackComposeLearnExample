package info.chirikualii.examplejetpackcompose.ui

import android.os.Bundle
import android.text.TextUtils.indexOf
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.Text
import androidx.ui.foundation.clickable
import androidx.ui.foundation.lazy.LazyColumnItems
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.Row
import androidx.ui.layout.fillMaxWidth
import androidx.ui.layout.padding
import androidx.ui.material.Card
import androidx.ui.text.TextStyle
import androidx.ui.text.style.TextAlign
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import androidx.ui.unit.sp


class VerticalScrollActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumnItems(items = listPerson) { data ->
                val index = listPerson.indexOf(data)
                composeItemListPerson(data = data, index = index, onClick = {
                    Toast.makeText(this, "$data and $index", Toast.LENGTH_SHORT).show()
                })
            }
        }
    }
}

@Composable
fun composeItemListPerson(data: String, index: Int, onClick: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth() +
                Modifier.padding(16.dp) +
                Modifier.clickable(onClick = { onClick() })
    ) {
        Card(shape = RoundedCornerShape(4.dp), color = colors[index % colors.size]) {

            Text(
                text = data,
                style = TextStyle(
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.fillMaxWidth() + Modifier.padding(16.dp)
            )
        }

    }
}

@Composable
@Preview
fun composeItemListPersonPreview() {

    Row(modifier = Modifier.fillMaxWidth() + Modifier.padding(16.dp)) {
        Card(shape = RoundedCornerShape(4.dp), color = colors[1]) {

            Text(
                text = "Ali Rahmat",
                style = TextStyle(
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.fillMaxWidth() + Modifier.padding(16.dp)
            )
        }

    }
}